// ******************************************************************
// CirclePanel.java
//
// A panel with a circle drawn in the center and buttons on the
// bottom that move the circle.
// ******************************************************************
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CirclePanel extends JPanel {
    
    // Instance variables (now accessible by the inner listener class)
    private final int CIRCLE_SIZE = 50;
    private int x, y;
    private Color c;
    
    // New Instance Variables for boundary checks and enabling/disabling
    private int panelWidth, panelHeight;
    private JButton left, right, up, down;

    // Constants for movement
    private final int MOVE_AMOUNT = 20;

    //---------------------------------------------------------------
    // Set up circle and buttons to move it.
    //---------------------------------------------------------------
    public CirclePanel(int width, int height) {
        
        // Store panel size in instance variables
        panelWidth = width;
        panelHeight = height;

        // Set coordinates so circle starts in middle
        x = (panelWidth / 2) - (CIRCLE_SIZE / 2);
        y = (panelHeight / 2) - (CIRCLE_SIZE / 2);
        c = Color.green;

        // Need a border layout to get the buttons on the bottom
        this.setLayout(new BorderLayout());

        // Create buttons to move the circle
        left = new JButton("Left");
        right = new JButton("Right");
        up = new JButton("Up");
        down = new JButton("Down");

        // Add mnemonics (ALT + Key)
        left.setMnemonic(KeyEvent.VK_L);
        right.setMnemonic(KeyEvent.VK_R);
        up.setMnemonic(KeyEvent.VK_U);
        down.setMnemonic(KeyEvent.VK_D);

        // Add tooltips
        left.setToolTipText("Moves circle left by " + MOVE_AMOUNT + " pixels (ALT+L)");
        right.setToolTipText("Moves circle right by " + MOVE_AMOUNT + " pixels (ALT+R)");
        up.setToolTipText("Moves circle up by " + MOVE_AMOUNT + " pixels (ALT+U)");
        down.setToolTipText("Moves circle down by " + MOVE_AMOUNT + " pixels (ALT+D)");

        // Add listeners to the buttons, using MOVE_AMOUNT constant
        left.addActionListener(new MoveListener(-MOVE_AMOUNT, 0));
        right.addActionListener(new MoveListener(MOVE_AMOUNT, 0));
        up.addActionListener(new MoveListener(0, -MOVE_AMOUNT));
        down.addActionListener(new MoveListener(0, MOVE_AMOUNT));

        // Need a panel to put the buttons on
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(left);
        buttonPanel.add(right);
        buttonPanel.add(up);
        buttonPanel.add(down);

        // Add the button panel to the bottom of the main panel
        this.add(buttonPanel, "South");
        
        // Check initial state (though unlikely to be at the edge)
        checkBoundaryLimits();
    }

    //---------------------------------------------------------------
    // Draw circle on CirclePanel
    //---------------------------------------------------------------
    public void paintComponent(Graphics page) {
        super.paintComponent(page);
        page.setColor(c);
        page.fillOval(x, y, CIRCLE_SIZE, CIRCLE_SIZE);
    }
    
    //---------------------------------------------------------------
    // Helper method to check boundaries and enable/disable buttons 
    //---------------------------------------------------------------
    private void checkBoundaryLimits() {
        // X-axis (Left/Right)
        
        // Check LEFT boundary (x coordinate is the top-left corner of the circle)
        if (x <= 0) {
            x = 0; // Bonus: Adjust coordinate to exactly 0
            left.setEnabled(false);
        } else {
            left.setEnabled(true);
        }

        // Check RIGHT boundary (x + CIRCLE_SIZE is the right edge of the circle)
        if (x + CIRCLE_SIZE >= panelWidth) {
            x = panelWidth - CIRCLE_SIZE; // Bonus: Adjust coordinate to touch the edge
            right.setEnabled(false);
        } else {
            right.setEnabled(true);
        }

        // Y-axis (Up/Down)
        
        // Check UP boundary (y coordinate is the top-left corner of the circle)
        if (y <= 0) {
            y = 0; // Bonus: Adjust coordinate to exactly 0
            up.setEnabled(false);
        } else {
            up.setEnabled(true);
        }

        // Check DOWN boundary (y + CIRCLE_SIZE is the bottom edge of the circle, 
        // panelHeight includes the button panel height, so use getHeight() for accurate size)
        // Note: Using panelHeight from constructor here, but getHeight() would be better 
        // if the panel size was dynamic. We assume the constructor size is correct for the drawing area.
        if (y + CIRCLE_SIZE >= panelHeight) {
            y = panelHeight - CIRCLE_SIZE; // Bonus: Adjust coordinate to touch the edge
            down.setEnabled(false);
        } else {
            down.setEnabled(true);
        }
    }

    //---------------------------------------------------------------
    // Class to listen for button clicks that move circle.
    //---------------------------------------------------------------
    private class MoveListener implements ActionListener {
        private int dx;
        private int dy;

        //---------------------------------------------------------------
        // Parameters tell how to move circle at click.
        //---------------------------------------------------------------
        public MoveListener(int dx, int dy) {
            this.dx = dx;
            this.dy = dy;
        }

        //---------------------------------------------------------------
        // Change x and y coordinates, check boundaries, and repaint.
        //---------------------------------------------------------------
        public void actionPerformed(ActionEvent e) {
            // Update coordinates
            x += dx;
            y += dy;
            
            // Check limits and disable/enable buttons
            checkBoundaryLimits();
            
            // Repaint the panel
            repaint();
        }
    }
}
