//Chapter 14- Ex 2(a)
//JFrame that contains JButton
//Disable the JButton when the clicks it
import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 
public class JFrameDisableButton extends JFrame implements ActionListener {
    
    private JButton clickButton = new JButton("Click Me to Disable");
  
    private final int WIDTH = 300; 
    private final int HEIGHT = 100; 

    public JFrameDisableButton() {
        super("Disable Button");
        
        setLayout(new FlowLayout());
        
        add(clickButton);
        clickButton.addActionListener(this);
        
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        clickButton.setEnabled(false); 
    }

    public static void main(String[] args) {
        new JFrameDisableButton();
    }
}
