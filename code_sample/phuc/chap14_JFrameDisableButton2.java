package chap14;
import javax.swing.*;
import java.awt.event.*;
public class JFrameDisableButton2 
{
    public static void main(String[] args) 
    {
        JFrame frame = new JFrame("Disable After 8 Clicks");
        JButton button = new JButton("Click Me");
        JLabel label = new JLabel("");
        final int[] clickCount = {0};
        button.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                clickCount[0]++;
                if (clickCount[0] >= 8)
                {
                    button.setEnabled(false);
                    label.setText("That's enough!");
                }
            }
        });
        frame.setLayout(new java.awt.FlowLayout());
        frame.add(button);
        frame.add(label);
        frame.setSize(250, 120);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}