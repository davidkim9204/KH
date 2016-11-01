package java0804_jdbc;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class WinView extends Frame {

	public WinView() {

		setSize(300, 400); // 300 가로크기, 400세로크기
		setVisible(true);
		// 이벤트가 발생된 컴포넌트.addWindowListener(이벤트리스너);
		this.addWindowListener(new CloseWin());
	}

	class CloseWin implements WindowListener {

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			System.exit(0);// 시스템 종료
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub

		}

	}
}// end WinView

/*
 * Window 컴포넌트에서 이벤트 발생 WindowEvent-> WindowListener -> addWindowListener()
 * 
 * Button컴포넌트에서 이벤트 발생 ActionEvent -> ActionListener-> addActionListener()
 * 
 */

public class java201_gui {

	public static void main(String[] args) {
		WinView wn = new WinView();

	}// end main()
}// end class
