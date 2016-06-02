/*******************************************************************************
 * Copyright 2016 Natan Guilherme.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

package com.badlogic.gdx.backends.dragome.js.typedarrays;

import com.dragome.commons.DelegateCode;
import com.dragome.commons.javascript.ScriptHelper;

/** @author xpenatan */
public interface Uint8ClampedArray extends Uint8Array {

	@DelegateCode(ignore = true)
	public static Uint8ClampedArray createClamped (ArrayBuffer buffer) {
		Uint8ClampedArray node = ScriptHelper.evalCasting("new Uint8ClampedArray(buffer.node)", Uint8ClampedArray.class, null);
		return node;
	}

	@DelegateCode(ignore = true)
	public static Uint8ClampedArray createClamped (ArrayBuffer buffer, int byteOffset) {
		Uint8ClampedArray node = ScriptHelper.evalCasting("new Uint8ClampedArray(buffer.node, byteOffset)", Uint8ClampedArray.class, null);
		return node;
	};

	@DelegateCode(ignore = true)
	public static Uint8ClampedArray createClamped (ArrayBuffer buffer, int byteOffset, int length) {
		Uint8ClampedArray node = ScriptHelper.evalCasting("new Uint8ClampedArray(buffer.node, byteOffset, length)", Uint8ClampedArray.class, null);
		return node;
	};

	@DelegateCode(ignore = true)
	public static Uint8ClampedArray createClamped (int length) {
		Uint8ClampedArray node = ScriptHelper.evalCasting("new Uint8ClampedArray(length)", Uint8ClampedArray.class, null);
		return node;
	};

	public static Uint8ClampedArray createClamped (short[] array) {
		return null;
	}

	Uint8ClampedArray subarray (int begin);
	Uint8ClampedArray subarray (int begin, int end);
}
