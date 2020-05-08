package ch3;

/**
 * VM������ -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728
 * 
 * @author XK
 *
 */
public class PretenureSizeThreshold {
	private static final int _1MB = 1024 * 1024;
	
	public static void main(String[] args) {
		testPretenureSizeThreshold();
	}
	
	public static void testPretenureSizeThreshold() {
		byte[] allocation;
		allocation = new byte[4 * _1MB]; //ֱ�ӷ������������
	}
}
