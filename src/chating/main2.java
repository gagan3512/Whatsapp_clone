package chating;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class main2 extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	//.................................................................
	JPanel p1;
	JPanel p2;
	JPanel p3;
	JPanel p0;
	
    JTextField t1;
	JButton b1;
	static JTextArea a1;
	
	static Socket s;
	static DataInputStream din;
	static DataOutputStream dout;
//................................................................................................	
	
	main2(){
		
		p0 = new JPanel();
		p0.setLayout(null);
		p0.setBackground(Color.green);
		p0.setBounds(0,0,440,75);
		add(p0);
		
		p1 = new JPanel();
		p1.setLayout(null);
		p1.setBackground(new Color(0,0,153));
		p1.setBounds(0,0,440,75);
		p0.add(p1);
		
		
		p2 = new JPanel();
		p2.setLayout(null);
		p2.setBackground(new Color(0,0,153));
		p2.setBounds(0,500,435,60);
		add(p2);
		
		p3 = new JPanel();
		p3.setLayout(null);
		p3.setBackground(Color.green);
		p3.setBounds(5,300,400,400);
		add(p3);
		
		ImageIcon img =new ImageIcon("C://Users//vikas//OneDrive//Desktop//Projects//Calculator_application//a2itlobo.jpg");
		Image img2 = img.getImage().getScaledInstance(430, 65, Image.SCALE_DEFAULT);
		ImageIcon img3 = new ImageIcon(img2);
		JLabel l1 = new JLabel(img3);
		l1.setBounds(5,5,425,65);
		p1.add(l1);
		
		t1 = new JTextField();
		t1.setBounds(10,15,300,30);
		t1.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
		p2.add(t1);
		
		b1 = new JButton("Send");
		b1.setBounds(320,15,100,30);
		b1.setBackground(Color.blue);
		b1.setForeground(Color.white);
		b1.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
		b1.addActionListener(this);
		p2.add(b1);
		
		a1 = new JTextArea();
		a1.setBounds(5,80,424,415);
		a1.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
		a1.setEditable(false);
		a1.setLineWrap(true);
		a1.setWrapStyleWord(true);
		p3.add(a1);
		
//.............................................................................................
		//getContentPane().setBackground(Color.black);
		setSize(450,600);
		setLocation(800,100);
		setVisible(true);
	}
//.......................................................................................................

//......................................................
	public static void main(String[] args) {
		new main2().setVisible(true); 
		try {
			s = new Socket("127.0.0.1",6001);
			din = new DataInputStream(s.getInputStream());
			dout = new DataOutputStream(s.getOutputStream());
			String msginput ="";
			msginput = din.readUTF();
			a1.setText(a1.getText()+"\n"+"  "+msginput);
			
			
		}catch(Exception e) {}
			
			
		}
		
//..............................................................
	public void actionPerformed(ActionEvent es) {
		String out = t1.getText(); 
		try {
			a1.setText(a1.getText()+"\n"+"  "+out);
			dout.writeUTF(out);
			t1.setText("");
			}catch(Exception e){
				System.out.println(e);
			}
		
	}


}
