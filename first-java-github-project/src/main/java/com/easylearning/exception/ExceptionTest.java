package com.easylearning.exception;

public class ExceptionTest {
	
	public static int getInt(int a) throws Exception{
		try{
			a=a/0;
			return 1;
		}catch(Exception e){
			e.printStackTrace();
			return 2;
		}finally{
			return 3;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println(ExceptionTest.getInt(5));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}

	}

}
