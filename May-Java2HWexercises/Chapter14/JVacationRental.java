// Chapter-14-EX 4. 
//Use separate ButtonGroups to select one of three locations, the number of bedrooms, and whether meals are included 
//locations are parkside for $600 per week, poolside for $750 per week, or lakeside for $825 per week. 
//have one, two, or three bedrooms (greater than one adds $75)
//if meals are added($200 more per rental)
// EX 4. Lambert’s Vacation Rentals application using ButtonGroups.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class JVacationRental extends JFrame implements ActionListener {

    // Prices
    private final int PRICE_PARKSIDE = 600;
    private final int PRICE_POOLSIDE = 750;
    private final int PRICE_LAKESIDE = 825;
    private final int PRICE_EXTRA_BEDROOM = 75;
    private final int PRICE_MEALS = 200;
    
    // Location 
    private JLabel locationLabel = new JLabel("1. Select Location:");
    private JRadioButton parkside = new JRadioButton("Parkside ($" + PRICE_PARKSIDE + ")");
    private JRadioButton poolside = new JRadioButton("Poolside ($" + PRICE_POOLSIDE + ")");
    private JRadioButton lakeside = new JRadioButton("Lakeside ($" + PRICE_LAKESIDE + ")");
    private ButtonGroup locationGroup = new ButtonGroup();

    //Bedroom 
    private JLabel bedroomLabel = new JLabel("2. Select Bedrooms (Add $" + PRICE_EXTRA_BEDROOM + " per extra room):");
    private JRadioButton oneBedroom = new JRadioButton("1 Bedroom (Base)");
    private JRadioButton twoBedroom = new JRadioButton("2 Bedrooms (+$" + PRICE_EXTRA_BEDROOM + ")");
    private JRadioButton threeBedroom = new JRadioButton("3 Bedrooms (+$" + (2 * PRICE_EXTRA_BEDROOM) + ")");
    private ButtonGroup bedroomGroup = new ButtonGroup();

    // Meals 
    private JLabel mealsLabel = new JLabel("3. Include Meals? (Add $" + PRICE_MEALS + "):");
    private JRadioButton mealsYes = new JRadioButton("Yes");
    private JRadioButton mealsNo = new JRadioButton("No");
    private ButtonGroup mealsGroup = new ButtonGroup();

    // Output
    private JLabel totalLabel = new JLabel("Total Price: $0.00");
    
    private NumberFormat currency = NumberFormat.getCurrencyInstance();

    public JVacationRental() {
        super("Lambert's Vacation Rentals");
        
        // Use 2-column GridBagLayout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Padding
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // for Location Setup
        locationGroup.add(parkside);
        locationGroup.add(poolside);
        locationGroup.add(lakeside);
        parkside.setSelected(true); // Default selection
        
        // add Location components
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2; add(locationLabel, gbc);
        gbc.gridy = 1; gbc.gridwidth = 1; add(parkside, gbc);
        gbc.gridx = 1; gbc.gridy = 1; add(poolside, gbc);
        gbc.gridx = 0; gbc.gridy = 2; add(lakeside, gbc);

        // for Bedroom Setup 
        bedroomGroup.add(oneBedroom);
        bedroomGroup.add(twoBedroom);
        bedroomGroup.add(threeBedroom);
        oneBedroom.setSelected(true); // default selection

        // Add Bedroom components
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2; add(bedroomLabel, gbc);
        gbc.gridy = 4; gbc.gridwidth = 1; add(oneBedroom, gbc);
        gbc.gridx = 1; gbc.gridy = 4; add(twoBedroom, gbc);
        gbc.gridx = 0; gbc.gridy = 5; add(threeBedroom, gbc);
        
        //for Meals Setup 
        mealsGroup.add(mealsYes);
        mealsGroup.add(mealsNo);
        mealsNo.setSelected(true); 

        // Add Meals components
        gbc.gridx = 0; gbc.gridy = 6; gbc.gridwidth = 2; add(mealsLabel, gbc);
        gbc.gridy = 7; gbc.gridwidth = 1; add(mealsYes, gbc);
        gbc.gridx = 1; gbc.gridy = 7; add(mealsNo, gbc);

        // Total Label Setup
        gbc.gridx = 0; gbc.gridy = 8; gbc.gridwidth = 2;
        totalLabel.setFont(new Font("Arial", Font.BOLD, 18));
        totalLabel.setForeground(Color.RED);
        add(totalLabel, gbc);

        // add Listeners and Initial Calculation
        addListener(parkside);
        addListener(poolside);
        addListener(lakeside);
        addListener(oneBedroom);
        addListener(twoBedroom);
        addListener(threeBedroom);
        addListener(mealsYes);
        addListener(mealsNo);
        
        calculateTotal(); // Calculate initial price

        // Frame setup
        setSize(550, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    private void addListener(JRadioButton button) {
        button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // any button click recalculates the total price
        calculateTotal();
    }

    private void calculateTotal() {
        int basePrice = 0;
        int totalPrice = 0;
        int bedroomCost = 0;
        int mealCost = 0;

        // determine Location Base Price
        if (parkside.isSelected()) {
            basePrice = PRICE_PARKSIDE;
        } else if (poolside.isSelected()) {
            basePrice = PRICE_POOLSIDE;
        } else if (lakeside.isSelected()) {
            basePrice = PRICE_LAKESIDE;
        }

        // determine Bedroom Cost
        if (twoBedroom.isSelected()) {
            bedroomCost = PRICE_EXTRA_BEDROOM;
        } else if (threeBedroom.isSelected()) {
            bedroomCost = 2 * PRICE_EXTRA_BEDROOM; // $75 for 2nd room, $75 for 3rd room
        }
        // oneBedroom.isSelected() => bedroomCost = 0

        // determine Meal Cost
        if (mealsYes.isSelected()) {
            mealCost = PRICE_MEALS;
        }
        // mealsNo.isSelected() => mealCost = 0
        
        // Calculate Final Total
        totalPrice = basePrice + bedroomCost + mealCost;
        
        // Update the display label
        totalLabel.setText("Total Price: " + currency.format(totalPrice));
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            new JVacationRental();
        });
    }
}
