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
import com.dragome.web.enhancers.jsdelegate.JsDelegateFactory;

/** @author xpenatan */
public interface Uint32Array extends ArrayBufferView {

	final int BYTES_PER_ELEMENT = 4;

	@DelegateCode(ignore = true)
	public static Uint32Array create (ArrayBuffer buffer) {
		ScriptHelper.put("buffer", buffer, null);
		Object instance = ScriptHelper.eval("new Uint32Array(buffer.node);", null);
		Uint32Array node = JsDelegateFactory.createFrom(instance, Uint32Array.class);
		return node;
	}

	@DelegateCode(ignore = true)
	public static Uint32Array create (ArrayBuffer buffer, int byteOffset) {
		ScriptHelper.put("buffer", buffer, null);
		ScriptHelper.put("byteOffset", byteOffset, null);
		Object instance = ScriptHelper.eval("new Uint32Array(buffer.node, byteOffset);", null);
		Uint32Array node = JsDelegateFactory.createFrom(instance, Uint32Array.class);
		return node;
	};

	@DelegateCode(ignore = true)
	public static Uint32Array create (ArrayBuffer buffer, int byteOffset, int length) {
		ScriptHelper.put("buffer", buffer, null);
		ScriptHelper.put("byteOffset", byteOffset, null);
		ScriptHelper.put("length", length, null);
		Object instance = ScriptHelper.eval("new Uint32Array(buffer.node, byteOffset, length);", null);
		Uint32Array node = JsDelegateFactory.createFrom(instance, Uint32Array.class);
		return node;
	};

	@DelegateCode(ignore = true)
	public static Uint32Array create (int length) {
		ScriptHelper.put("length", length, null);
		Object instance = ScriptHelper.eval("new Uint32Array(length);", null);
		Uint32Array node = JsDelegateFactory.createFrom(instance, Uint32Array.class);
		return node;
	};

	int get_length ();

	@DelegateCode(eval = "this.node[$1]")
	long get (int index);

	@DelegateCode(eval = "this.node[$1]")
	double getAsDouble (int index);

	@DelegateCode(eval = "this.node[$1] = $2")
	void set (int index, long value);

	@DelegateCode(eval = "this.node[$1] = $2")
	void set (int index, double value);

	void set (Uint32Array array, int offset);

	void set (long[] array, int offset);

	void set (double[] array, int offset);

	Uint32Array subarray (int begin);

	Uint32Array subarray (int begin, int end);
}
