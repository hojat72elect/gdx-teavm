package com.badlogic.gdx.utils.reflect;

import com.github.xpenatan.gdx.backends.web.emu.Emulate;

@Emulate(Field.class)
public final class FieldEmu extends FieldGen{
    public FieldEmu(java.lang.reflect.Field field) {
        super(field);
    }
}
