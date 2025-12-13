// EX3. Create an application with a JFrame and at least six labels that contain facts about your favorite topic.
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.util.Arrays; 

public class JFacts extends JFrame implements ActionListener {

 
    private JButton factButton = new JButton("Next Fact");
    private JLabel currentFactLabel; 
    
    //at least 6 labels
    private final String[] facts = {
        "1. The hottest planet in our solar system is Venus (450°C).",
        "2. One day on Venus is longer than one year on Venus.",
        "3. A single day on Mars is 24 hours and 37 minutes.",
        "4. Jupiter's Great Red Spot is a storm larger than Earth.",
        "5. There are more stars in the universe than grains of sand on all Earth's beaches.",
        "6. Light from the Sun takes about 8 minutes to reach Earth.",
        "7. There is a volcano on Mars three times the size of Mount Everest.",
        "8. The first photograph of the Moon was taken in 1840."
    };
    

    private int currentFactIndex = 0;
    

    private final int WIDTH = 600; 
    private final int HEIGHT = 150; 
    private Font factFont = new Font("SansSerif", Font.BOLD, 16);

    public JFacts() {
        super("Fascinating Astronomy Facts");
        
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20)); // Centered components
        
  
        currentFactLabel = new JLabel(facts[currentFactIndex]);
        currentFactLabel.setFont(factFont);
        currentFactLabel.setForeground(Color.BLUE);
        
        // Style the button
        factButton.setFont(new Font("Arial", Font.PLAIN, 14));

       
        add(factButton);
        add(currentFactLabel);
        
    
        factButton.addActionListener(this);
        
     
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == factButton) {
            // Remove the old label
            remove(currentFactLabel);
            
            // Increment the index and wrap around to 0 if hit the end
            currentFactIndex = (currentFactIndex + 1) % facts.length;
            
            // Create the new label with the next fact
            currentFactLabel = new JLabel(facts[currentFactIndex]);
            currentFactLabel.setFont(factFont);
            currentFactLabel.setForeground(Color.BLUE);
            
            // Add the new label
            add(currentFactLabel);
            
      
            revalidate();
            repaint();
        }
    }
        
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            new JFacts();
        });
    }
}
