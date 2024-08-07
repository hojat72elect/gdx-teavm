package com.github.xpenatan.gdx.backends.teavm.assetloader;

import com.badlogic.gdx.utils.GdxRuntimeException;
import com.github.xpenatan.gdx.backends.teavm.assetloader.AssetDownloader.AssetDownload;
import com.github.xpenatan.gdx.backends.teavm.dom.LocationWrapper;
import com.github.xpenatan.gdx.backends.teavm.dom.impl.TeaWindow;
import com.github.xpenatan.gdx.backends.teavm.dom.typedarray.ArrayBufferWrapper;
import com.github.xpenatan.gdx.backends.teavm.dom.typedarray.Int8ArrayWrapper;
import com.github.xpenatan.gdx.backends.teavm.dom.typedarray.TypedArrays;
import org.teavm.jso.ajax.XMLHttpRequest;
import org.teavm.jso.browser.Window;
import org.teavm.jso.dom.html.HTMLDocument;
import org.teavm.jso.dom.html.HTMLScriptElement;
import org.teavm.jso.typedarrays.ArrayBuffer;
import org.teavm.jso.typedarrays.Int8Array;

public class AssetDownloadImpl implements AssetDownload {

    private static final int MAX_DOWNLOAD_ATTEMPT = 3;

    private int queue;
    private final boolean showLogs;
    private boolean showDownloadProgress;

    public AssetDownloadImpl(boolean showDownloadLogs) {
        showLogs = showDownloadLogs;
    }

    @Override
    public String getHostPageBaseURL() {
        TeaWindow currentWindow = TeaWindow.get();
        LocationWrapper location = currentWindow.getLocation();
        String href = location.getHref();
        return href;
    }

    @Override
    public int getQueue() {
        return queue;
    }

    @Override
    public void subtractQueue() {
        queue--;
    }

    @Override
    public void addQueue() {
        queue++;
    }

    @Override
    public void load(boolean async, String url, AssetType type, AssetLoaderListener<?> listener) {
        switch(type) {
            case Binary:
                loadBinary(async, url, (AssetLoaderListener<Blob>)listener, 0, showLogs);
                break;
            case Directory:
                listener.onSuccess(url, null);
                break;
            default:
                throw new GdxRuntimeException("Unsupported asset type " + type);
        }
    }

    @Override
    public void loadScript(boolean async, String url, AssetLoaderListener<String> listener) {
        if(showLogs) {
            System.out.println("Loading script : " + url);
        }

        loadBinary(async, url, new AssetLoaderListener<>() {
            @Override
            public void onSuccess(String url, Blob result) {
                Int8ArrayWrapper data = (Int8ArrayWrapper)result.getData();
                byte[] byteArray = TypedArrays.toByteArray(data);
                String script = new String(byteArray);
                Window current = Window.current();
                HTMLDocument document = current.getDocument();
                HTMLScriptElement scriptElement = (HTMLScriptElement)document.createElement("script");
                scriptElement.setText(script);
                document.getBody().appendChild(scriptElement);

                if(showLogs) {
                    System.out.println("Script loaded: " + url);
                }
                if(listener != null) {
                    listener.onSuccess(url, script);
                }
            }

            @Override
            public void onFailure(String url) {
                if(listener != null) {
                    listener.onFailure(url);
                }
            }
        }, 0, false);
    }

    private void loadBinary(boolean async, final String url, final AssetLoaderListener<Blob> listener, int count, boolean showLogs) {
        if(showLogs) {
            System.out.println("Loading asset: " + url);
        }
        if(count == MAX_DOWNLOAD_ATTEMPT) {
            if(listener != null) {
                listener.onFailure(url);
            }
            return;
        }

        // don't load on main thread
        addQueue();
        new Thread() {
            public void run() {
                XMLHttpRequest request = new XMLHttpRequest();
                request.setOnReadyStateChange(evt -> {
                    if(request.getReadyState() == XMLHttpRequest.DONE) {
                        int status = request.getStatus();
                        if(status == 0) {
                            if(listener != null) {
                                listener.onFailure(url);
                            }
                        }
                        else if(status != 200) {
                            if ((status != 404) && (status != 403)) {
                                // re-try: e.g. failure due to ERR_HTTP2_SERVER_REFUSED_STREAM (too many requests)
                                try {
                                    Thread.sleep(100);
                                }
                                catch (Throwable e) {
                                    // ignored
                                }
                                int newCount = count + 1;
                                loadBinary(async, url, listener, newCount, showLogs);
                            }
                            else {
                                if(listener != null) {
                                    listener.onFailure(url);
                                }
                            }
                        }
                        else {
                            if(showLogs) {
                                System.out.println("Asset loaded: " + url);
                            }

                            ArrayBufferWrapper response = (ArrayBufferWrapper)request.getResponse();
                            Int8Array data = (Int8Array)TypedArrays.createInt8Array(response);
                            if(listener != null) {
                                listener.onSuccess(url, new Blob((ArrayBuffer)response, data));
                            }
                        }
                        subtractQueue();
                    }
                });

                setOnProgress(request, url, listener);
                request.open("GET", url, async);
                if(async) {
                    request.setResponseType("arraybuffer");
                }
                request.send();
            }
        }.start();
    }

    private void setOnProgress(XMLHttpRequest req, String url, final AssetLoaderListener<?> listener) {
        req.onProgress(evt -> {
            int loaded = evt.getLoaded();
            int total = evt.getTotal();
            double percent = (double)loaded / total;
            if(showDownloadProgress) {
                System.out.println("Total: " + total + " loaded: " + loaded + " URL: " + url);
            }
            if(listener != null) {
                listener.onProgress(loaded);
            }
        });
    }
}