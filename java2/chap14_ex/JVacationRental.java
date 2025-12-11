package chap14_ex;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JVacationRental extends JFrame implements ActionListener {
    final int PARKSIDE_PRICE = 600;
    final int POOLSIDE_PRICE = 750;
    final int LAKESIDE_PRICE = 825;
    
    JRadioButton parkside = new JRadioButton("Parkside ($600)", true);
    JRadioButton poolside = new JRadioButton("Poolside ($750)", false);
    JRadioButton lakeside = new JRadioButton("Lakeside ($825)", false);

    JRadioButton oneBed = new JRadioButton("1 Bedroom (Base)", true);
    JRadioButton twoBed = new JRadioButton("2 Bedrooms (+$75)", false);
    JRadioButton threeBed = new JRadioButton("3 Bedrooms (+$150)", false);

    JRadioButton noMeals = new JRadioButton("No Meals", true);
    JRadioButton yesMeals = new JRadioButton("Include Meals (+$200)", false);

    JLabel resultLabel = new JLabel("Total Price: $600");
    JButton calculateBtn = new JButton("Calculate Total");

    public JVacationRental() {
        super("Lambert's Vacation Rentals");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 1)); 

        ButtonGroup locationGroup = new ButtonGroup();
        locationGroup.add(parkside);
        locationGroup.add(poolside);
        locationGroup.add(lakeside);
        
        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p1.setBorder(BorderFactory.createTitledBorder("Location"));
        p1.add(parkside); p1.add(poolside); p1.add(lakeside);

        ButtonGroup bedGroup = new ButtonGroup();
        bedGroup.add(oneBed);
        bedGroup.add(twoBed);
        bedGroup.add(threeBed);

        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p2.setBorder(BorderFactory.createTitledBorder("Bedrooms"));
        p2.add(oneBed); p2.add(twoBed); p2.add(threeBed);

        ButtonGroup mealGroup = new ButtonGroup();
        mealGroup.add(noMeals);
        mealGroup.add(yesMeals);

        JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p3.setBorder(BorderFactory.createTitledBorder("Meals"));
        p3.add(noMeals); p3.add(yesMeals);

        add(p1);
        add(p2);
        add(p3);
        add(calculateBtn);
        
        resultLabel.setHorizontalAlignment(JLabel.CENTER);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(resultLabel);

        calculateBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int totalPrice = 0;

        if (parkside.isSelected()) totalPrice += PARKSIDE_PRICE;
        else if (poolside.isSelected()) totalPrice += POOLSIDE_PRICE;
        else if (lakeside.isSelected()) totalPrice += LAKESIDE_PRICE;

        if (twoBed.isSelected()) totalPrice += 75;
        else if (threeBed.isSelected()) totalPrice += 150; 

        if (yesMeals.isSelected()) totalPrice += 200;

        resultLabel.setText("Total Price: $" + totalPrice);
    }

    public static void main(String[] args) {
        JVacationRental frame = new JVacationRental();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}