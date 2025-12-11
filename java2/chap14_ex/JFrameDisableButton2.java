package chap14_ex;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JFrameDisableButton2 extends JFrame implements ActionListener {
	JButton button = new JButton("Click me!");
	JButton resetButton = new JButton("Reset");
	JLabel message = new JLabel("");
	int count = 0;
	
	public JFrameDisableButton2() {
		super("Disable Button 2");
		setSize(350,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());

        add(button);
        add(resetButton);
        add(message);
        
        button.addActionListener(this);
        resetButton.addActionListener(this);
        
        resetButton.setVisible(false);
	}

	@Override
    public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
            count++;
            
            if (count >= 8) {
                button.setEnabled(false); 
                message.setText("That's enough!");
                resetButton.setVisible(true);
            } else {
                message.setText("Clicks: " + count);
            }
        } 
        else if (e.getSource() == resetButton) {
            count = 0;
            button.setEnabled(true);
            button.setText("Click Me!");
            message.setText("Clicks: 0");
            resetButton.setVisible(false); 
        }
    }

    public static void main(String[] args) {
        JFrameDisableButton2 frame = new JFrameDisableButton2();
        frame.setVisible(true);
    }
}
