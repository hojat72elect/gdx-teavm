/*-------------------------------------------------------
 * This file was automatically generated by XpeCodeGen
 *
 * Dont make changes to this file
 *-------------------------------------------------------*/
package com.badlogic.gdx.physics.bullet.linearmath;

import com.badlogic.gdx.physics.bullet.BulletBase;

/** @author xpenatan */
public class btScalarArray extends BulletBase {

    public btScalarArray(long cPtr, boolean cMemoryOwn) {
        resetObj(cPtr, cMemoryOwn);
    }

	protected void cacheObj() {
		com.dragome.commons.javascript.ScriptHelper.evalNoResult("this.$$$jsObj=Bullet.wrapPointer(this.$$$cPointer,Bullet.MyScalarArray);",this);
	}

    public int size() {
		checkPointer();
		return com.dragome.commons.javascript.ScriptHelper.evalInt("this.$$$jsObj.size();",this);
    }

    public float at(int n) {
		checkPointer();
		return com.dragome.commons.javascript.ScriptHelper.evalFloat("this.$$$jsObj.at(n);",this);
    }

    public int capacity() {
		checkPointer();
		return com.dragome.commons.javascript.ScriptHelper.evalInt("this.$$$jsObj.capacity();",this);
    }

    public void resize(int newsize) {
		checkPointer();
		com.dragome.commons.javascript.ScriptHelper.evalNoResult("this.$$$jsObj.resize(newsize);",this);
    }
}
