/*-------------------------------------------------------
 * This file was automatically generated by XpeCodeGen
 *
 * Dont make changes to this file
 *-------------------------------------------------------*/
package com.badlogic.gdx.physics.bullet.collision;

/** @author xpenatan */
public class btPairCachingGhostObject extends btGhostObject {

    protected void create() {
        resetObj(createNative(), true);
    }

    private static long createNative() {
		com.dragome.commons.javascript.ScriptHelper.evalNoResult("var cobj=new Bullet.btPairCachingGhostObject();",null);
		return com.dragome.commons.javascript.ScriptHelper.evalLong("Bullet.getPointer(cobj);",null);
    }

	protected void cacheObj() {
		com.dragome.commons.javascript.ScriptHelper.evalNoResult("this.$$$jsObj=Bullet.wrapPointer(this.$$$cPointer,Bullet.btPairCachingGhostObject);",this);
	}
}
