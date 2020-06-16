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
		// MethodType�������������͡��������˷����ķ���ֵ��methodType()�ĵ�һ���������;��������methodType()�ڶ������Ժ�Ĳ�������
		MethodType mt = MethodType.methodType(void.class, String.class);
		
		// ��ָ�����в��ҷ��ϸ����ķ������ơ��������ͣ����ҷ��ϵ���Ȩ�޵ķ��������
		// ������õ���һ���鷽��������Java���ԵĹ��򣬷�����һ����������ʽ�ģ�����÷����Ľ����ߣ�Ҳ��thisָ��Ķ������������ǰ�Ƿ��ڲ����б��н��д��ݣ������ṩ��bindTo()���������������顣
		return MethodHandles.lookup().findVirtual(obj.getClass(), "println", mt).bindTo(obj);
	}
	
	
}
