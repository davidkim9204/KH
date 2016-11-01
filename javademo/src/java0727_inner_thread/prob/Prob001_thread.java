package java0727_inner_thread.prob;

import java0727_inner_thread.Washroom;

/*
 * [출력화면]
생산자 : 음료수 No. 1 자판기에 넣기
소비자 : 음료수 No. 1 꺼내먹음
 
생산자 : 음료수 No. 2 자판기에 넣기
소비자 : 음료수 No. 2 꺼내먹음

생산자 : 음료수 No. 3 자판기에 넣기
소비자 : 음료수 No. 3 꺼내먹음
        :
        
생산자 : 음료수 No. 10 자판기에 넣기
소비자 : 음료수 No. 10 꺼내먹음 
 
 */

//공유자원
class VendingMachine {

	synchronized public String getDrink() {
		for (int i=0; i<50; i++){
			if (i%10==0){
				Thread.sleep(2000);
				System.out.println(" : 음료수 NO."+i/10 +"꺼내먹음");
			}
		}
		
	retu

	}

	synchronized public void putDrink(String drink) {

	}

}

class Producer extends Thread { // 생산자
	private VendingMachine vm;
	String pd;

	Producer(VendingMachine vm) {
	}
	
	@Override
	public void run(){
		
		vm.getDrink(pd);
		
		
	}
	

}

class Consumer extends Thread { // 소비자
	private VendingMachine vm;
	String cm;

	Consumer(VendingMachine vm) {
		super(vm);
	}
}

public class Prob001_thread {

	public static void main(String[] args) {

		VendingMachine vm = new VendingMachine();

		Producer p = new Producer(vm);
		Consumer c = new Consumer(vm);

		Thread t1 = new Thread(p, "생산자");
		Thread t2 = new Thread(c, "소비자");

		t1.start();
		t2.start();

	}

}
