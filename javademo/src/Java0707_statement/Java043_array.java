package Java0707_statement;

public class Java043_array {

	public static void main(String[] args) {
		int[] data1=new int[3];//0
		long[] data2=new long[3];//0L
		float[] data3=new float[3];//0.0F
		double[] data4=new double[3];//0.0
		char[] data5=new char[3];//\u0000
		boolean data6=new boolean[3];//false
		String[] data7=new String[3];//타입이 클래스 null이 저장된다.
				
				
		for(int i=0; i<data1.length; i++){
			System.out.println(data1[i]);
				}
		
		
		
		System.out.println();
	}
}
