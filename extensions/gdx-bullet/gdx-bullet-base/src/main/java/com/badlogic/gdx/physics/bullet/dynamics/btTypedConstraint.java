package com.badlogic.gdx.physics.bullet.dynamics;

import com.badlogic.gdx.physics.bullet.linearmath.btTypedObject;

/**
 * @author xpenatan
 */
public class btTypedConstraint extends btTypedObject {

    public btRigidBody getRigidBodyA() {
        int pointer = getRigidBodyANATIVE((int) cPointer);
        btRigidBody.WRAPPER_GEN_01.setPointer(pointer);
        return btRigidBody.WRAPPER_GEN_01;
    }

    /*[-teaVM;-NATIVE]
        var jsObj = Bullet.wrapPointer(addr, Bullet.btTypedConstraint);
        var returnedJSObj = jsObj.getRigidBodyA();
        return Bullet.getPointer(returnedJSObj);
    */
    private static native int getRigidBodyANATIVE(int addr);

    public btRigidBody getRigidBodyB() {
        int pointer = getRigidBodyBNATIVE((int) cPointer);
        btRigidBody.WRAPPER_GEN_02.setPointer(pointer);
        return btRigidBody.WRAPPER_GEN_02;
    }

    /*[-teaVM;-NATIVE]
        var jsObj = Bullet.wrapPointer(addr, Bullet.btTypedConstraint);
        var returnedJSObj = jsObj.getRigidBodyB();
        return Bullet.getPointer(returnedJSObj);
    */
    private static native int getRigidBodyBNATIVE(int addr);
}