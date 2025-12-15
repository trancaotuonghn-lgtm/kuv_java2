package chap14;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
public class JFacts 
{
    public static void main(String[] args) 
    {
        JFrame frame = new JFrame("Astronomy Facts");
        frame.setLayout(new FlowLayout());
        JButton button = new JButton("Next Fact");
        JLabel factLabel = new JLabel();
        ArrayList<String> facts = new ArrayList<>();
        facts.add("The Sun is over 4.6 billion years old.");
        facts.add("A day on Venus is longer than a year on Venus.");
        facts.add("There are more stars in the universe than grains of sand on Earth.");
        facts.add("Jupiter has 79 known moons.");
        facts.add("Neutron stars can spin 600 times per second.");
        facts.add("Black holes warp both space and time.");
        factLabel.setText(facts.remove(0));
        button.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                if (!facts.isEmpty()) 
                {
                    factLabel.setText(facts.remove(0));
                } 
                else {
                    factLabel.setText("No more facts!");
                    button.setEnabled(false);
                }
            }
        });

        frame.add(button);
        frame.add(factLabel);
        frame.setSize(400, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}