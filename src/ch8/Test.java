package ch8;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;

public class Test {
	class GrandFather {
		void thinking() {
			System.out.println("i am grandfather");
		}
	}

	class Father extends GrandFather {
		void thinking() {
			System.out.println("i am father");
		}
	}
	
	class Son extends Father {
		void thinking() {
			try {
//				MethodType mt = MethodType.methodType(void.class);
//				MethodHandle mh = MethodHandles.lookup().findSpecial(GrandFather.class, "thinking", mt, getClass());
//				mh.invoke(this);
				
				MethodType mt = MethodType.methodType(void.class);
				Field lookupImpl = MethodHandles.Lookup.class.getDeclaredField("IMPL_LOOKUP");
				lookupImpl.setAccessible(true);
				MethodHandles.Lookup lookup = (MethodHandles.Lookup) lookupImpl.get(null);
				
				Field modeField = MethodHandles.Lookup.class.getDeclaredField("allowedModes");
				modeField.setAccessible(true);
				System.out.println(modeField.get(lookup));				
				
				MethodHandle mh = lookup.findSpecial(GrandFather.class, "thinking", mt, getClass());
				mh.invoke(this);
			} catch (Throwable e) {
			}
		}
	}
	
	public static void main(String[] args) {
		(new Test().new Son()).thinking();
	}
}
