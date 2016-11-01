package java0725_collection.prob;

import java.util.ArrayList;
import java.util.Vector;

/*
 * 2 10 4 6
 */
public class Prob004_ArrayList {

	public static void main(String[] args) {
		int[] arr = { 5, 9, 3, 2, 7 };
		int[] num = { 1, 10, 15, 4, 6 };
		ArrayList<Integer> v = merge(arr, num);
		for (Integer it : v)
			System.out.println(it);
	}// end main()

	public static ArrayList<Integer> merge(int[] arr, int[] num) {
		// arr,num배열을 병합한후 2의 배수만 리턴하는 프로그램을 구현하시오.
		ArrayList<Integer> vt=new ArrayList<Integer>();
		
		
		int[] nwa=new int[arr.length+num.length];
		
		System.arraycopy(arr, 0, nwa, 0, arr.length);
		System.arraycopy(num, 0, nwa, arr.length, num.length);
		
		
		
		for(int i=0;i<nwa.length;i++){
			if(nwa[i]%2==0){
				vt.add(nwa[i]);
			}
		
		}
		return vt;

	}// end merge();

}






