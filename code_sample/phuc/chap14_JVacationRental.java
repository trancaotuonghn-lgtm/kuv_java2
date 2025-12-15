package chap14;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class JVacationRental 
{
    public static void main(String[] args) 
    {
        JFrame frame = new JFrame("Vacation Rental Selector");
        frame.setLayout(new GridLayout(4, 1));
        JPanel locationPanel = new JPanel();
        locationPanel.add(new JLabel("Location:"));
        ButtonGroup locationGroup = new ButtonGroup();
        JRadioButton park = new JRadioButton("Parkside ($600)");
        JRadioButton pool = new JRadioButton("Poolside ($750)");
        JRadioButton lake = new JRadioButton("Lakeside ($825)");
        locationGroup.add(park);
        locationGroup.add(pool);
        locationGroup.add(lake);
        locationPanel.add(park);
        locationPanel.add(pool);
        locationPanel.add(lake);
        JPanel bedPanel = new JPanel();
        bedPanel.add(new JLabel("Bedrooms:"));
        ButtonGroup bedGroup = new ButtonGroup();
        JRadioButton oneBed = new JRadioButton("1");
        JRadioButton twoBed = new JRadioButton("2");
        JRadioButton threeBed = new JRadioButton("3");
        bedGroup.add(oneBed);
        bedGroup.add(twoBed);
        bedGroup.add(threeBed);
        bedPanel.add(oneBed);
        bedPanel.add(twoBed);
        bedPanel.add(threeBed);
        JPanel mealsPanel = new JPanel();
        mealsPanel.add(new JLabel("Meals Included:"));
        ButtonGroup mealsGroup = new ButtonGroup();
        JRadioButton mealsYes = new JRadioButton("Yes (+$200)");
        JRadioButton mealsNo = new JRadioButton("No");
        mealsGroup.add(mealsYes);
        mealsGroup.add(mealsNo);
        mealsPanel.add(mealsYes);
        mealsPanel.add(mealsNo);
        JLabel priceLabel = new JLabel("Total Price: $0");
        JButton calcButton = new JButton("Calculate Price");
        calcButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                int price = 0;
                if (park.isSelected()) price = 600;
                else if (pool.isSelected()) price = 750;
                else if (lake.isSelected()) price = 825;
                if (twoBed.isSelected()) price += 75;
                if (threeBed.isSelected()) price += 150;
                if (mealsYes.isSelected()) price += 200;
                priceLabel.setText("Total Price: $" + price);
            }
        });
        frame.add(locationPanel);
        frame.add(bedPanel);
        frame.add(mealsPanel);
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(calcButton);
        bottomPanel.add(priceLabel);
        frame.add(bottomPanel);
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}