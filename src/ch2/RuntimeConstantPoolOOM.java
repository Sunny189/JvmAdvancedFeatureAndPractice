package ch2;

import java.util.HashSet;
import java.util.Set;

/**
 * VM Args for JDK 6��-XX:PermSize=6M -XX:MaxPermSize=6M
 * VM Args for JDK 7��-Xmx6M
 * 
 * @author XK
 *
 */
public class RuntimeConstantPoolOOM {
	
	public static void main(String[] args) {
		// ʹ��Set�����ų��������ã�����Full GC���ճ�������Ϊ
		Set<String> set = new HashSet<String>();
		
		// ��short��Χ��������6MB��PermSize����OOM��
		short i = 0;
		
		while (true) {
			set.add(String.valueOf(i++).intern());
		}
	}
}
