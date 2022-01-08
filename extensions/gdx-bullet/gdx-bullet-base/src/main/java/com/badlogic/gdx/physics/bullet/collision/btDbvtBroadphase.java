package com.badlogic.gdx.physics.bullet.collision;

/**
 * @author xpenatan
 */
public class btDbvtBroadphase extends btBroadphaseInterface {

    public btDbvtBroadphase() {
        initObject(createNative(), true);
    }

    @Override
    protected void deleteNative() {
        deleteNative(cPointer);
    }

    /*[-C++;-NATIVE]
        return (jlong)new btDbvtBroadphase();
     */
    /*[-teaVM;-NATIVE]
        var jsObj = new Bullet.btDbvtBroadphase();
        return Bullet.getPointer(jsObj);
     */
    private static native long createNative();

    /*[-teaVM;-NATIVE]
        var jsObj = Bullet.wrapPointer(addr, Bullet.btDbvtBroadphase);
        Bullet.destroy(jsObj);
     */
    private static native void deleteNative(long addr);
}