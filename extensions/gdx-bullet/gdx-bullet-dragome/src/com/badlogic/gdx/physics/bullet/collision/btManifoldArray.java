/*-------------------------------------------------------
 * This file was automatically generated by XpeCodeGen
 *
 * Dont make changes to this file
 *-------------------------------------------------------*/
package com.badlogic.gdx.physics.bullet.collision;

import com.badlogic.gdx.physics.bullet.BulletBase;

/** @author xpenatan */
public class btManifoldArray extends BulletBase {

    btPersistentManifold tmp = new btPersistentManifold(0, false);

    public btManifoldArray() {
        resetObj(createNative(), true);
    }

    private static long createNative() {
		com.dragome.commons.javascript.ScriptHelper.evalNoResult("var cobj=new Bullet.btManifoldArray();",null);
		return com.dragome.commons.javascript.ScriptHelper.evalLong("Bullet.getPointer(cobj);",null);
    }

    @Override
    protected void delete() {
		long addr = cPointer;
		com.dragome.commons.javascript.ScriptHelper.evalNoResult("var cobj=Bullet.wrapPointer(addr,Bullet.btManifoldArray);Bullet.destroy(cobj);",this);
    }

    public btManifoldArray(long cPtr, boolean cMemoryOwn) {
        resetObj(cPtr, cMemoryOwn);
    }

	protected void cacheObj() {
		com.dragome.commons.javascript.ScriptHelper.evalNoResult("this.$$$jsObj=Bullet.wrapPointer(this.$$$cPointer,Bullet.btManifoldArray);",this);
	}

    public int size() {
		checkPointer();
		return com.dragome.commons.javascript.ScriptHelper.evalInt("this.$$$jsObj.size();",this);
    }

    /**
	 * Dont keep a reference of any object.
	 */
    public btPersistentManifold at(int n) {
		checkPointer();
		long addr = 0;
		com.dragome.commons.javascript.ScriptHelper.evalNoResult("addr=Bullet.getPointer(this.$$$jsObj.at(n));",this);
		tmp.resetObj(addr, false);
		return tmp;
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
