package java0708_method;
//3. 리턴값은 있으나 매개변수는 없다.
public class Java050_method {
	static int[] num = new int[] { 3, 5, 9 };

	public static void main(String[] args) {
		/*int data=process(); //1 
		System.out.println(data); //5 */
		System.out.println(process()); //->메쏘드의 리턴타입이 존재할 때만 가능. void일 때는 리턴 값이 없어서 출력값이 없으니 불가능.

	}// end main

	public static int process() {
		int sum = 0; //2

		for (int i = 0; i < num.length; i++) { //3
			sum += num[i];
		} // end process()
		return sum; //4
	}

}// end class
