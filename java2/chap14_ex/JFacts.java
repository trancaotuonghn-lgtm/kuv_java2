package chap14_ex;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JFacts extends JFrame implements ActionListener {
    JButton nextButton = new JButton("Next Fact");
    JLabel currentFactLabel;
    
    String[] facts = {
        "Fact 1: The Sun contains 99.86% of the mass in the Solar System.",
        "Fact 2: One million Earths could fit inside the Sun.",
        "Fact 3: Neutron stars can spin 600 times per second.",
        "Fact 4: Space is completely silent.",
        "Fact 5: There are more stars in the universe than grains of sand on Earth.",
        "Fact 6: A day on Venus is longer than a year on Venus."
    };
    
    int factIndex = 0;

    public JFacts() {
        super("Astronomy Facts");
        setSize(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        currentFactLabel = new JLabel(facts[0]);
        currentFactLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        add(currentFactLabel);
        add(nextButton);
        
        nextButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        remove(currentFactLabel);

        factIndex = (factIndex + 1) % facts.length;

        currentFactLabel = new JLabel(facts[factIndex]);
        currentFactLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        
        add(currentFactLabel, 0);

        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        JFacts frame = new JFacts();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
