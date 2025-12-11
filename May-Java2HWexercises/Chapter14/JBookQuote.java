// Chapter 14 - EX1a
// JFrame with Quote
import javax.swing.JFrame; 
import javax.swing.JLabel; 
import java.awt.FlowLayout; 
import java.awt.Font;     

public class JBookQuote extends JFrame {
    
    private JLabel quoteLabel = new JLabel("Life is a long lesson in humility");
    
   
    private final int WIDTH = 400; 
    private final int HEIGHT = 100; 
    
    
    private Font bigFont = new Font("Arial", Font.BOLD, 20);

    public JBookQuote() {
        super("Favorite Book Quote");
        
        setLayout(new FlowLayout());

        quoteLabel.setFont(bigFont);
        add(quoteLabel);

        setSize(WIDTH, HEIGHT);      
        setVisible(true);       
    }

    public static void main(String[] args) {
        new JBookQuote();
    }
}
