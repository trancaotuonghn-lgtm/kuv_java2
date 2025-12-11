package chap14_ex;
import javax.swing.*;
import java.awt.*;

public class JBookQuote extends JFrame {
    public JBookQuote() {
        super("Book Quote");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel quote = new JLabel("<html><center>\"And, when you want something, all the universe <br>conspires in helping you to achieve it.\"</center></html>");
        quote.setFont(new Font("Serif", Font.ITALIC, 16));
        
        add(quote);
    }

    public static void main(String[] args) {
        JBookQuote frame = new JBookQuote();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
