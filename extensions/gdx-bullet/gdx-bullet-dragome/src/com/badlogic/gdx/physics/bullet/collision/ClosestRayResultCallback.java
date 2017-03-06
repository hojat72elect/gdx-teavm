/*-------------------------------------------------------
 * This file was generated by XpeCodeGen
 * Version 1.0.0
 *
 * Do not make changes to this file
 *-------------------------------------------------------*/
package com.badlogic.gdx.physics.bullet.collision;

import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.bullet.linearmath.btVector3;
import com.dragome.commons.compiler.annotations.MethodAlias;

/** @author xpenatan */
public class ClosestRayResultCallback extends RayResultCallback {

    public ClosestRayResultCallback(Vector3 rayFromWorld, Vector3 rayToWorld) {
        resetObj(createNative(rayFromWorld.x, rayFromWorld.y, rayFromWorld.z, rayToWorld.x, rayToWorld.y, rayToWorld.z, false), true);
    }

    private long createNative(float x1, float y1, float z1, float x2, float y2, float z2, boolean overriden) {
		com.dragome.commons.javascript.ScriptHelper.put("overriden",overriden,this);
		com.dragome.commons.javascript.ScriptHelper.put("z2",z2,this);
		com.dragome.commons.javascript.ScriptHelper.put("y2",y2,this);
		com.dragome.commons.javascript.ScriptHelper.put("x2",x2,this);
		com.dragome.commons.javascript.ScriptHelper.put("z1",z1,this);
		com.dragome.commons.javascript.ScriptHelper.put("y1",y1,this);
		com.dragome.commons.javascript.ScriptHelper.put("x1",x1,this);
		com.dragome.commons.javascript.ScriptHelper.evalNoResult("var from=new Bullet.btVector3(x1,y1,z1);var to=new Bullet.btVector3(x2,y2,z2);var cobj=new Bullet.MyClosestRayResultCallback(from,to);var self=this;cobj.addSingleResult=this.addSR;",this);
		return com.dragome.commons.javascript.ScriptHelper.evalLong("Bullet.getPointer(cobj);",this);
    }

	protected void cacheObj() {
		com.dragome.commons.javascript.ScriptHelper.put("addr",this.cPointer,this);
		this.jsObj = com.dragome.commons.javascript.ScriptHelper.eval("Bullet.wrapPointer(addr,Bullet.MyClosestRayResultCallback);",this);
	}

	@MethodAlias(local_alias= "addSR")
	private float addSingleR(long rayResult, boolean normalInWorldSpace) {
		com.dragome.commons.javascript.ScriptHelper.put("normalInWorldSpace",normalInWorldSpace,this);
		com.dragome.commons.javascript.ScriptHelper.put("rayResult",rayResult,this);
		LocalRayResult tmpLocal = RayResultCallback.tmpLocalRes;
		tmpLocal.resetObj(rayResult, false);
		ClosestRayResultCallback callback = (ClosestRayResultCallback)com.dragome.commons.javascript.ScriptHelper.eval("this.self",this);
		return callback.addSingleResult(tmpLocal, normalInWorldSpace);
	}

    public float addSingleResult(LocalRayResult rayResult, boolean normalInWorldSpace) {
		com.dragome.commons.javascript.ScriptHelper.put("normalInWorldSpace",normalInWorldSpace,this);
		checkPointer();
		com.dragome.commons.javascript.ScriptHelper.put("jsObj",this.jsObj,this);
		com.dragome.commons.javascript.ScriptHelper.put("rObj",rayResult.jsObj,this);
		return com.dragome.commons.javascript.ScriptHelper.evalFloat("jsObj.addSingleResultSuper(rObj,normalInWorldSpace);",this);
    }

    public void getRayFromWorld(Vector3 out) {
		checkPointer();
		com.dragome.commons.javascript.ScriptHelper.put("jsObj",this.jsObj,this);
		com.dragome.commons.javascript.ScriptHelper.evalNoResult("var vec=jsObj.get_m_rayFromWorld();",this);
		out.x = com.dragome.commons.javascript.ScriptHelper.evalFloat("vec.x();",this);
		out.z = com.dragome.commons.javascript.ScriptHelper.evalFloat("vec.y();",this);
		out.y = com.dragome.commons.javascript.ScriptHelper.evalFloat("vec.z();",this);
    }

    public void setRayFromWorld(Vector3 value) {
		checkPointer();
		com.dragome.commons.javascript.ScriptHelper.put("jsObj",this.jsObj,this);
		com.dragome.commons.javascript.ScriptHelper.put("x",value.x,this);
		com.dragome.commons.javascript.ScriptHelper.put("y",value.y,this);
		com.dragome.commons.javascript.ScriptHelper.put("z",value.z,this);
		com.dragome.commons.javascript.ScriptHelper.evalNoResult("var vec=Bullet.MyTemp.prototype.btVec3_1(x,y,z);jsObj.set_m_rayFromWorld(vec);",this);
    }

    public void getRayToWorld(Vector3 out) {
		checkPointer();
		com.dragome.commons.javascript.ScriptHelper.put("jsObj",this.jsObj,this);
		com.dragome.commons.javascript.ScriptHelper.evalNoResult("var vec=jsObj.get_m_rayToWorld();",this);
		out.x = com.dragome.commons.javascript.ScriptHelper.evalFloat("vec.x();",this);
		out.z = com.dragome.commons.javascript.ScriptHelper.evalFloat("vec.y();",this);
		out.y = com.dragome.commons.javascript.ScriptHelper.evalFloat("vec.z();",this);
    }

    public void setRayToWorld(Vector3 value) {
		checkPointer();
		com.dragome.commons.javascript.ScriptHelper.put("jsObj",this.jsObj,this);
		com.dragome.commons.javascript.ScriptHelper.put("x",value.x,this);
		com.dragome.commons.javascript.ScriptHelper.put("y",value.y,this);
		com.dragome.commons.javascript.ScriptHelper.put("z",value.z,this);
		com.dragome.commons.javascript.ScriptHelper.evalNoResult("var vec=Bullet.MyTemp.prototype.btVec3_1(x,y,z);jsObj.set_m_rayToWorld(vec);",this);
    }

    public void getHitNormalWorld(Vector3 out) {
		checkPointer();
		com.dragome.commons.javascript.ScriptHelper.put("jsObj",this.jsObj,this);
		com.dragome.commons.javascript.ScriptHelper.evalNoResult("var vec=jsObj.get_m_hitNormalWorld();",this);
		out.x = com.dragome.commons.javascript.ScriptHelper.evalFloat("vec.x();",this);
		out.z = com.dragome.commons.javascript.ScriptHelper.evalFloat("vec.y();",this);
		out.y = com.dragome.commons.javascript.ScriptHelper.evalFloat("vec.z();",this);
    }

    public void setHitNormalWorld(Vector3 value) {
		checkPointer();
		com.dragome.commons.javascript.ScriptHelper.put("jsObj",this.jsObj,this);
		com.dragome.commons.javascript.ScriptHelper.put("x",value.x,this);
		com.dragome.commons.javascript.ScriptHelper.put("y",value.y,this);
		com.dragome.commons.javascript.ScriptHelper.put("z",value.z,this);
		com.dragome.commons.javascript.ScriptHelper.evalNoResult("var vec=Bullet.MyTemp.prototype.btVec3_1(x,y,z);jsObj.set_m_hitNormalWorld(vec);",this);
    }

    public void getHitPointWorld(Vector3 out) {
		checkPointer();
		com.dragome.commons.javascript.ScriptHelper.put("jsObj",this.jsObj,this);
		com.dragome.commons.javascript.ScriptHelper.evalNoResult("var vec=jsObj.get_m_hitPointWorld();",this);
		out.x = com.dragome.commons.javascript.ScriptHelper.evalFloat("vec.x();",this);
		out.z = com.dragome.commons.javascript.ScriptHelper.evalFloat("vec.y();",this);
		out.y = com.dragome.commons.javascript.ScriptHelper.evalFloat("vec.z();",this);
    }

    public void setHitPointWorld(Vector3 value) {
		checkPointer();
		com.dragome.commons.javascript.ScriptHelper.put("jsObj",this.jsObj,this);
		com.dragome.commons.javascript.ScriptHelper.put("x",value.x,this);
		com.dragome.commons.javascript.ScriptHelper.put("y",value.y,this);
		com.dragome.commons.javascript.ScriptHelper.put("z",value.z,this);
		com.dragome.commons.javascript.ScriptHelper.evalNoResult("var vec=Bullet.MyTemp.prototype.btVec3_1(x,y,z);jsObj.set_m_hitPointWorld(vec);",this);
    }
}
