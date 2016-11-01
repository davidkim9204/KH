package java0804_jdbc;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class WinUser extends Frame{
	public WinUser(){
	
		setSize(300,400); //300 가로크기, 400세로크기
		setVisible(true);
//		this.addWindowListener(new UserAdapter());
//익명클래스로 더 편하게 하는 법
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
				//여기서만 사용할 목적으로 익명클래스로 구현 불필요한 
			}
		});
	}
	
	class UserAdapter extends WindowAdapter{
		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			System.exit(0);
		}
		
	}
	
}//end WinUser

//오버라이드 해주느라 불편하기때문에 이것을 대신해주는 클래스가 있는데 이를 adapter라고 부른다.
public class Java202_gui {
	public static void main(String[] args) {
		WinUser wn =
		
	}//end main()	

}//end class
