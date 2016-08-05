package com.atguigu.jdkproxy.m;

import com.atguigu.jdkproxy.i.Calculate;

public class MyCalculate implements Calculate {

	@Override
	public int add(int i, int j) {
		return i+j;
	}

	@Override
	public int div(int i, int j) {
		return i/j;
	}

	@Override
	public int cut(int i, int j) {
		return i-j;
	}

	@Override
	public int ride(int i, int j) {
		return i*j;
	}

}
