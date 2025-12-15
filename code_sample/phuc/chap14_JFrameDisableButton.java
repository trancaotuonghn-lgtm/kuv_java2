package chap14;
import javax.swing.*;
import java.awt.event.*;
public class JFrameDisableButton 
{
    public static void main(String[] args) 
    {
        JFrame frame = new JFrame("Disable Button");
        JButton button = new JButton("Click Me");
        button.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                button.setEnabled(false);
            }
        });
        frame.add(button);
        frame.setSize(200, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}