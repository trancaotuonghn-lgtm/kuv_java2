package chap14_ex;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JBookQuote2 extends JFrame implements ActionListener {
    JLabel quote = new JLabel("<html><center>\"And, when you want something, all the universe <br>conspires in helping you to achieve it.\"</center></html>");
    JButton button = new JButton("See Book Title");
    JLabel title = new JLabel(""); 

    public JBookQuote2() {
        super("Book Quote 2");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        quote.setFont(new Font("Serif", Font.ITALIC, 16));
        title.setFont(new Font("Arial", Font.BOLD, 14));

        add(quote);
        add(button);
        add(title);

        button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        title.setText("— The Alchemist (Paulo Coelho)");
        validate();
    }

    public static void main(String[] args) {
        JBookQuote2 frame = new JBookQuote2();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
