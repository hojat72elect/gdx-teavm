package com.github.xpenatan.gdx.backends.teavm.assetloader;

/**
 * @author xpenatan
 */
public enum AssetType {
    Binary("b"), Directory("d");

    public final String code;

    AssetType(String code) {
        this.code = code;
    }
}