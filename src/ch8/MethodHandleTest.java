package ch8;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class MethodHandleTest {
	static class ClassA {
		public void println(String s) {
			System.out.println(s);
		}
	}
	
	public static void main(String[] args) throws Throwable {
		Object obj = System.currentTimeMillis() % 2 == 0 ? System.out : new ClassA();
		System.out.println(obj.getClass());
		getPrintlnMH(obj).invokeExact("Hello World");
	}

	private static MethodHandle getPrintlnMH(Object obj) throws NoSuchMethodException, IllegalAccessException {
		// MethodType：代表“方法类型”，包含了方法的返回值（methodType()的第一个参数）和具体参数（methodType()第二个及以后的参数）。
		MethodType mt = MethodType.methodType(void.class, String.class);
		
		// 在指定类中查找符合给定的方法名称、方法类型，并且符合调用权限的方法句柄。
		// 这里调用的是一个虚方法，按照Java语言的规则，方法第一个参数是隐式的，代表该方法的接收者，也即this指向的对象，这个参数以前是放在参数列表中进行传递，现在提供了bindTo()方法来完成这件事情。
		return MethodHandles.lookup().findVirtual(obj.getClass(), "println", mt).bindTo(obj);
	}
	
	
}
