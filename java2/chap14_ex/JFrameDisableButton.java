package chap14_ex;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JFrameDisableButton extends JFrame implements ActionListener {

	JButton button = new JButton("Click me!");
	
	public JFrameDisableButton() {
		super("Disable Button");
		setSize(300, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(button);
		button.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		button.setEnabled(false);
		button.setText("Disabled");
	}
	
	public static void main(String[] args) {
		JFrameDisableButton frame = new JFrameDisableButton();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
	
}
