package com.atguigu.jdkproxy.juni;

import org.junit.Test;

import com.atguigu.jdkproxy.i.Calculate;
import com.atguigu.jdkproxy.m.MyCalculate;
import com.atguigu.jdkproxy.proxy.ProxyPrivader;

public class TestProxy {

	@Test
	public void test1(){
		Calculate proxyObject = (Calculate) new ProxyPrivader(new MyCalculate()).getProxyObject();
		proxyObject.add(5,6);
	}
	
}
