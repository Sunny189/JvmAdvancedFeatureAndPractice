package ch3;

/**
 * VM������  -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution
 * 
 * @author XK
 *
 */
public class MaxTenuringThreshold {
	private static final int _1MB = 1024 * 1024;
	
	public static void main(String[] args) {
//		testTenuringThreshold();
		
		testTenuringThreshold2();
	}
	
	public static void testTenuringThreshold() {
		byte[] allocation1, allocation2, allocation3;
		allocation1 = new byte[_1MB / 4]; // ʲôʱ����������������XX:MaxTenuringThreshold����
		allocation2 = new byte[4 * _1MB];
		allocation3 = new byte[4 * _1MB];
		allocation3 = null;
		allocation3 = new byte[4 * _1MB];
	}
	
	public static void testTenuringThreshold2() {
		byte[] allocation1, allocation2, allocation3, allocation4;
		allocation1 = new byte[_1MB / 4]; // allocation1+allocation2����survivo�ռ�һ��
		allocation2 = new byte[_1MB / 4];
		allocation3 = new byte[4 * _1MB];
		allocation4 = new byte[4 * _1MB];
		allocation4 = null;
		allocation4 = new byte[4 * _1MB];
	}
}
