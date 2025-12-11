// Chapter 14 - EX2.b

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane; 

public class JFrameDisableButton2 extends JFrame implements ActionListener {

    private JButton clickButton = new JButton("Click Me (8 Times)");
    private JLabel statusLabel = new JLabel("Clicks: 0"); 
    private JButton resetButton = new JButton("Click to reduce count"); 
    

    private int clickCount = 0;
    private final int MAX_CLICKS = 8; 
    

    private final int WIDTH = 400; 
    private final int HEIGHT = 150; 
    private Font defaultFont = new Font("Arial", Font.BOLD, 14);

    public JFrameDisableButton2() {
        super("Count Up to 8, Reduce by 1");
        
        setLayout(new FlowLayout());


        clickButton.setFont(defaultFont);
        statusLabel.setFont(defaultFont);
        resetButton.setFont(defaultFont);
        

        resetButton.setEnabled(false); 


        add(clickButton);
        add(statusLabel);
        add(resetButton);
        

        clickButton.addActionListener(this);
        resetButton.addActionListener(this);

        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        Object source = e.getSource();
        
        if (source == clickButton) {
            
            if (clickCount < MAX_CLICKS) {
                clickCount++;
                statusLabel.setText("Clicks: " + clickCount);
                
                
                resetButton.setEnabled(true); 
            }
            
            
            if (clickCount == MAX_CLICKS) {
                clickButton.setEnabled(false); 
                clickButton.setText("FINISHED!");
                
                
                JOptionPane.showMessageDialog(this, "The maximum count of 8 has been reached!", "Limit Reached", JOptionPane.INFORMATION_MESSAGE);
            }
            
        } else if (source == resetButton) {
            
            if (clickCount > 0) {
                clickCount--; 
                statusLabel.setText("Clicks: " + clickCount); 
                
                
                if (clickCount < MAX_CLICKS) {
                    clickButton.setEnabled(true);
                    clickButton.setText("Click Me (" + MAX_CLICKS + " Times)");
                }
            }
            
            
            if (clickCount == 0) {
                resetButton.setEnabled(false); 
            }
        }
    }
        
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            new JFrameDisableButton2();
        });
    }
}
