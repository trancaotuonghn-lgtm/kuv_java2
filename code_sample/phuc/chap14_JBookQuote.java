package chap14;
import javax.swing.*;
public class JBookQuote 
{
    public static void main(String[] args) 
    {
        JFrame frame = new JFrame("Book Quote");
        JLabel quoteLabel = new JLabel("<html><p style='width:300px'>\"Walking the path of Heaven, the man who'll rule everything.\"</p></html>");
        frame.add(quoteLabel);
        frame.setSize(350, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}