package ch7;

public class FieldResolution {
	
	interface Interface0 {
		int A = 0;
	}
	
	interface Interface1 extends Interface0 {
		int A = 1;
	}
	
	interface Interface2 {
		int A = 2;
	}
	
	static class Parent implements Interface1 {
		public static int A = 3;
	}
	
	static class Sub extends Parent implements Interface2 {
		public static int A = 4; //if not exist, Oracle javac will not compile this code, the error is: The	field Sub.A is ambiguous
	}
	
	public static void main(String[] args) {
		System.out.println(Interface0.A);
		System.out.println(Interface1.A);
		System.out.println(Interface2.A);
		System.out.println(Parent.A);
		System.out.println(Sub.A);
	}

}
