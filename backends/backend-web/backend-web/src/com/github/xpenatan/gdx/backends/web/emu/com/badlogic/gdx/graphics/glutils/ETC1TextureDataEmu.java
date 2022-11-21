package com.github.xpenatan.gdx.backends.web.emu.com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.glutils.ETC1TextureData;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.github.xpenatan.gdx.backends.web.emu.Emulate;
import com.github.xpenatan.gdx.backends.web.emu.com.badlogic.gdx.graphics.TextureDataEmu;
import com.github.xpenatan.gdx.backends.web.emu.graphics.PixmapEmu;

@Emulate(ETC1TextureData.class)
public class ETC1TextureDataEmu implements TextureDataEmu {
    public ETC1TextureDataEmu(FileHandle file) {
        throw new GdxRuntimeException("ETC1TextureData not supported in Dragome backend");
    }

    public ETC1TextureDataEmu(FileHandle file, boolean useMipMaps) {
        throw new GdxRuntimeException("ETC1TextureData not supported in Dragome backend");
    }

    @Override
    public TextureDataTypeEmu getType() {
        return null;
    }

    @Override
    public boolean isPrepared() {
        return false;
    }

    @Override
    public void prepare() {
    }

    @Override
    public PixmapEmu consumePixmap() {
        return null;
    }

    @Override
    public boolean disposePixmap() {
        return false;
    }

    @Override
    public void consumeCustomData(int target) {

    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public PixmapEmu.FormatEmu getFormat() {
        return null;
    }

    @Override
    public boolean useMipMaps() {
        return false;
    }

    @Override
    public boolean isManaged() {
        return false;
    }
}