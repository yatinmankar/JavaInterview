package com.easylearning.algos;
interface Interface1{
	
	public void method1();
}

interface Interface2{
	
	public void method2(int a);
}

interface Interface3{
	
	public void method3(int a, int b);
}


interface Interface4{
	
	public int method4(int a, int b);
}


public class PrintStat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int printLength=5;
		
		new Thread(()->{System.out.println("test thread 0 ");}).start();
		Interface1 i1=()->{System.out.println("test thread 1");};
		i1.method1();
		
		Interface2 i2=(a)->{System.out.println("test thread 2"+a);};
		i2.method2(5);
		
		Interface3 i3=(a,b)->{System.out.println("test thread 3 "+(a+b));};
		i3.method3(5,10);
		
		Interface4 i4=(a,b)->{System.out.println("test thread 4"+(a+b));
											return a+b;};
		System.out.println(i4.method4(5,15));
		
		
	}
	
	public void drawPattern(int length){
		
	}

}
