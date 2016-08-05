package com.atguigu.jdkproxy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;

public class ProxyPrivader {
	private Object targetObject;

	public ProxyPrivader(Object targetObject) {
		this.targetObject = targetObject;
	}
	
	public Object getProxyObject(){
		
		ClassLoader loader = targetObject.getClass().getClassLoader();
		Class<?>[] interfaces = targetObject.getClass().getInterfaces();
		InvocationHandler h = new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				String name = method.getName();
				List<Object> list = Arrays.asList(args);
				Object result = null;
				try {
					System.out.println(name+"方法即将开始执行了，参数是："+list);
					result = method.invoke(targetObject, args);
					System.out.println(name+"方法执行结束了，参数是："+list+", 结果是："+result);
				} catch (Exception e) {
					System.out.println(name+"方法执行出现异常了！参数是："+list);
					e.printStackTrace();
				}finally{
					System.out.println(name+"方法最终结束了，参数是："+list);
				}
				return result;
			}
		};
 
		return Proxy.newProxyInstance(loader, interfaces, h);
	}
	
	
}
