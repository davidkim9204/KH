package qwetrd;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class b22 extends JFrame {
    JScrollPane scrollPane;
    ImageIcon icon;
 
    public b22() {
        icon = new ImageIcon("c:\\back.png");
       
        //배경 Panel 생성후 컨텐츠페인으로 지정     
        /////////////////
        JPanel background = new JPanel() {
        	
            public void paintComponent(Graphics g) {
                // Approach 1: Dispaly image at at full size
                g.drawImage(icon.getImage(), 0, 0, null);
                // Approach 2: Scale image to size of component
                // Dimension d = getSize();
                // g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
                // Approach 3: Fix the image position in the scroll pane
                // Point p = scrollPane.getViewport().getViewPosition();
                // g.drawImage(icon.getImage(), p.x, p.y, null);
                setOpaque(false); //그림을 표시하게 설정,투명하게 조절
                super.paintComponent(g);
            }
        };//이미지 부분
       ////////////////////////

       
//        JButton button = new JButton("버튼");
//        background.add(button);
        scrollPane = new JScrollPane(background);
        setContentPane(scrollPane);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setVisible(true);
    }
 
    public static void main(String[] args) {
        b22 frame = new b22();
       
    }
}


//background = new ImageIcon("C:\\Users\\user1\\Desktop\\javagraphics\\background.jpg");



setLayout(new BorderLayout());
setContentPane(new JLabel(background));
//setLayout(new BorderLayout());
setLayout(new FlowLayout());
