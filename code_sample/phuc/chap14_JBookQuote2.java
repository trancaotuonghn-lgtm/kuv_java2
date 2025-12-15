package chap14;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class JBookQuote2 
{
    public static void main(String[] args) 
    {
        JFrame frame = new JFrame("Book Quote");
        frame.setLayout(new FlowLayout());
        JLabel quoteLabel = new JLabel("<html><p style='width:300px'>\"Shall we begin the experiment?\"</p></html>");
        JButton button = new JButton("Show Book Title");
        JLabel titleLabel = new JLabel("");
        button.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                titleLabel.setText("Kamen Rider Build");
            }
        });

        frame.add(quoteLabel);
        frame.add(button);
        frame.add(titleLabel);
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}