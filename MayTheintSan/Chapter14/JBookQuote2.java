// Chapter 14 - EX1b
// JFrame with Quote and display the title of book when the user clicks the button
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;    

public class JBookQuote2 extends JFrame implements ActionListener{
 
    private JLabel quoteLabel = new JLabel("Life is a long lesson in humility");
    
    private final String BOOK_TITLE = "The Little Minister";
    private final String AUTHOR = "James M. Barrie";

    private final int WIDTH = 450; 
    private final int HEIGHT = 200;  
    
    JPanel line1 = new JPanel(new FlowLayout(FlowLayout.CENTER)); 
    JPanel line2 = new JPanel(new FlowLayout(FlowLayout.CENTER)); 
    JPanel line3 = new JPanel(new FlowLayout(FlowLayout.CENTER)); 
    
    JButton pressMe = new JButton("Show Book Title"); 
    JLabel showTitle = new JLabel(""); 
    private Font bigFont = new Font("Arial", Font.BOLD, 14); 

    public JBookQuote2() {
        super("Favorite Book Quote");
       
        setLayout(new GridLayout(3, 1, 10, 10));
        
        quoteLabel.setFont(bigFont);
        line1.add(quoteLabel);
        
        pressMe.setFont(bigFont);
        line2.add(pressMe);

        showTitle.setFont(bigFont);
        line3.add(showTitle);
        
        add(line1);
        add(line2);
        add(line3);
        
        setSize(WIDTH, HEIGHT); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        pressMe.addActionListener(this); 
        setVisible(true);       
    }

    public static void main(String[] args) {
        new JBookQuote2(); 
    }
    
    @Override 
    public void actionPerformed(ActionEvent e)
    {
        
        String greet = "Title: " + BOOK_TITLE + " is by " + AUTHOR;
        
        showTitle.setText(greet);
    }
}
