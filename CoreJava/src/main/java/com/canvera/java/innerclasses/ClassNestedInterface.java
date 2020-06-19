package com.canvera.java.innerclasses;

import com.canvera.java.innerclasses.ClassNestedInterface.ClassNestedInterfaceDemo;

public class ClassNestedInterface {

	interface ClassNestedInterfaceDemo{
		public int getSomeThing();
	}
}


class Abc implements ClassNestedInterfaceDemo{

	@Override
	public int getSomeThing() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}