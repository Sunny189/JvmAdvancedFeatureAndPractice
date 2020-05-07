package ch2;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * VM Args for JDK 7£º-XX:PermSize=10M -XX:MaxPermSize=10M
 * VM Args for JDK 8£º-XX:MaxMetaspaceSize=10M
 * 
 * @author XK
 *
 */
public class JavaMethodAreaOOM {
	
	static class OOMObject {
	}
	
	public static void main(String[] args) {
		while (true) {
			Enhancer enhancer = new Enhancer();
			enhancer.setSuperclass(OOMObject.class);
			enhancer.setUseCache(false);			
			enhancer.setCallback(new MethodInterceptor() {
				public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
					return proxy.invokeSuper(obj, args);
				}
			});
			enhancer.create();
		}
	}
}
