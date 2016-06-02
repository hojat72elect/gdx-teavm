package com.badlogic.gdx.physics.bullet.collision;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.utils.Array;

/** @author xpenatan */
public class btCompoundShape extends btCollisionShape {
	
	/*JNI
		#include <src/bullet/BulletCollision/CollisionShapes/btCollisionShape.h>
		#include <src/bullet/BulletCollision/CollisionShapes/btCompoundShape.h>
	*/
	
	protected Array<btCollisionShape> children = new Array<btCollisionShape>();
	
	public btCompoundShape() {
		resetObj(createNative(), true);
	}
	
	
	/*[0;X;F;L]
		protected void cacheObj() {
			this.$$$jsObj = Bullet.wrapPointer(this.$$$cPointer, Bullet.btCompoundShape);
		}
	*/
	
	public static native long createNative(); /*
		return (jlong)new btCompoundShape();
	*/
	/*[0;X;L]
		return Bullet.getPointer(new Bullet.btCompoundShape());
	*/
	
	@Override
	protected void delete() {
		deletePointer(cPointer);
		children.clear();
	}
	/*[0;X;L]
		long addr = cPointer;  #J
		var vec = Bullet.wrapPointer(addr, Bullet.btCompoundShape);
		Bullet.destroy(vec);
		children.clear(); #J
	*/
	
	private static native void deletePointer(long addr); /*
		btCompoundShape * cobj = (btCompoundShape *)addr;
		delete cobj;
	*/
	/*[0;X;D]*/
	
	public void addChildShape(Matrix4 localTransform, btCollisionShape shape) {
		checkPointer();
		addChildShape(cPointer, localTransform.val, shape.cPointer);
		children.add(shape);
	}
	/*[0;X;L]
		checkPointer();  #J
		float [] value = localTransform.val; #J
		var tran = Bullet.MyTemp.prototype.btTran();
		tran.setFromOpenGLMatrix(value);
		this.$$$jsObj.addChildShape(tran, shape.$$$jsObj);
		children.add(shape); #J
	*/
	
	private static native void addChildShape(long addr, float [] value, long shapeAddr); /*
		btCompoundShape * cobj = (btCompoundShape *)addr;
		btCollisionShape * shape = (btCollisionShape *)shapeAddr;
		btTransform tran;
		tran.setFromOpenGLMatrix(value);
		cobj->addChildShape(tran, shape);
	 */
	/*[0;X;D]*/
	
	public void removeChildShape(btCollisionShape shape) {
		checkPointer();
		removeChildShape(cPointer, shape.cPointer);
		children.removeValue(shape, true);
	}
	/*[0;X;L]
		checkPointer();  #J
		this.$$$jsObj.removeChildShape(shape.$$$jsObj);
		children.removeValue(shape, true); #J
	*/
	
	private static native void removeChildShape(long addr, long shapeAddr); /*
		btCompoundShape * cobj = (btCompoundShape *)addr;
		btCollisionShape * shape = (btCollisionShape *)shapeAddr;
		cobj->removeChildShape(shape);
	 */
	/*[0;X;D]*/
	
	
	public int getNumChildShapes() {
		return children.size;
	}
	
	public btCollisionShape getChildShape(int index) {
		return children.get(index);
	}
}
