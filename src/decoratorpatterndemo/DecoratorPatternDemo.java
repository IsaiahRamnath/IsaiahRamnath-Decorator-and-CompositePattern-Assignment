
package decoratorpatterndemo;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.awt.event.*;


public class DecoratorPatternDemo extends JFrame {
    
    //VARIABLES
    private int beverageOption;
    private double totalCost, totalcost;
    private double Total;
    private Beverage choice;
    private final JPanel screen1;    
    private final JPanel screen2; 
    private final JPanel screen3;
    private final JPanel billTop;
    private final JLabel total, description, added;
    
    StringBuilder stream = new StringBuilder();
    DecimalFormat df = new DecimalFormat("#.00");
    

    public DecoratorPatternDemo() {
        
        
        //Screen 1 Objects
        JFrame frameA = new JFrame();
        screen1 = new JPanel();
        String menuInfo = "<html> <font size = '12' color = '#000000' text align = 'center'> Choose Your Coffee  </font> </html>";  
        JLabel menu = new JLabel(menuInfo, JLabel.CENTER);
        
        
        //Screen 1 Buttons
        JButton HouseBlendButton = new JButton("HOUSE BLEND $10.00");            
        JButton DecafButton = new JButton("DECAF $10.00");   
        JButton ExpressoButton = new JButton("ESPRESSO $10.00");    
        JButton DarkRoastButton = new JButton("DARK ROAST $10.00");
       
        
        //Screen 1 Characteristics
        frameA.setSize(800, 800);
        frameA.setLocationRelativeTo(null);
        frameA.add(screen1, BorderLayout.CENTER);
        frameA.setResizable(false);
        frameA.setTitle("Coffee Shop");
        frameA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frameA.setVisible(true);
        
        screen1.setVisible(true);  
        screen1.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        screen1.setBackground(Color.ORANGE);
        screen1.setLayout(new GridLayout(0,1));       
        screen1.add(menu);
        screen1.add(new JSeparator() );
        
        screen1.add(HouseBlendButton);
        screen1.add(DecafButton);
        screen1.add(ExpressoButton);
        screen1.add(DarkRoastButton);
        

        HouseBlendButton.setActionCommand("HOUSE BLEND 💲10.00");
        DecafButton.setActionCommand("DECAF 💲10.00");
        ExpressoButton.setActionCommand("ESPRESSO 💲10.00");
        DarkRoastButton.setActionCommand("DARK ROAST 💲10.00");
        
        HouseBlendButton.addActionListener(new ButtonClickedListener() );
        DecafButton.addActionListener(new ButtonClickedListener() );
        ExpressoButton.addActionListener(new ButtonClickedListener() );
        DarkRoastButton.addActionListener(new ButtonClickedListener() );

        
        
        //SCREEN 2
        screen2 = new JPanel();      
        String toppingInfo = "<html> <font size = '12' color = '#000000' text align = 'center'> Ad-Ons  </font> </html>";
        frameA.add(screen2, BorderLayout.CENTER);   
        JLabel topping = new JLabel(toppingInfo, JLabel.CENTER);
        screen2.add(topping);
        screen2.add(new JSeparator() );
            
        //Screen 2 Buttons
        JButton MilkButton = new JButton("MILK 💲5.00");      
        JButton MochaButton = new JButton("MOCHA 💲5.00");
        JButton WhipCreamButton = new JButton("WHIP CREAM 💲5.00");
        JButton ChocolateSyrupButton = new JButton("CHOCOLATE SYRUP 💲5.00");
        JButton CaramelSyrupButton = new JButton("CARAMEL SYRUP 💲5.00");  
        
        //Screen 2 Characteristics
        screen2.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        screen2.setBackground(Color.ORANGE);
        screen2.setLayout(new GridLayout(0,1));
        
        screen2.setVisible(false);
        
        screen2.add(MilkButton);
        screen2.add(MochaButton);
        screen2.add(WhipCreamButton);
        screen2.add(ChocolateSyrupButton);
        screen2.add(CaramelSyrupButton);
        
        MilkButton.setActionCommand("MILK 💲5.00");
        MochaButton.setActionCommand("MOCHA 💲5.00");
        WhipCreamButton.setActionCommand("WHIP CREAM 💲5.00");
        ChocolateSyrupButton.setActionCommand("CHOCOLATE SYRUP $5.00");
        CaramelSyrupButton.setActionCommand("CARAMEL SYRUP 💲5.00");
        MilkButton.addActionListener(new OptionsAddedListener() );              
        MochaButton.addActionListener(new OptionsAddedListener() );             
        WhipCreamButton.addActionListener(new OptionsAddedListener() );             
        ChocolateSyrupButton.addActionListener(new OptionsAddedListener() );            
        CaramelSyrupButton.addActionListener(new OptionsAddedListener() );
        
        
        //SCREEN 3
        screen3 = new JPanel(); 
        billTop = new JPanel();
        billTop.setLayout(new BorderLayout() );
        screen3.setLayout(new FlowLayout() );
        screen3.setBackground(Color.ORANGE);
        frameA.add(screen3);
        
        //Screen 3 Objects
        String billInfo = "<html> <font size = '12' color = '#000000' text align = 'center'> BILL  </font> </html>";        
        JLabel bill = new JLabel(billInfo, JLabel.CENTER);     
        billTop.add(new JSeparator(), BorderLayout.CENTER ); 
        
        
        
        String costInfo = "Total Cost: $";
        JLabel cost = new JLabel(costInfo);
        total = new JLabel();  
        
        
        String beverageInfo = "\n Beverage: ";
        JLabel bev = new JLabel(beverageInfo);
        description = new JLabel();
        
        
        String optionsInfo = "\n Ad-Ons: ";
        JLabel options = new JLabel(optionsInfo);
        added = new JLabel();
        
  
        options.setPreferredSize(new Dimension(100,20) );
        added.setPreferredSize(new Dimension(150,20) );


        screen3.add(billTop);
        screen3.add(cost);
        screen3.add(total);        
        screen3.add(bev);
        screen3.add(description);       
        screen3.add(options);
        screen3.add(added);  
        

        screen3.setBackground(Color.ORANGE);
        billTop.setBackground(Color.white);
               
        screen3.setVisible(false);       
    }

    
    //MAIN
    public static void main(String[] args) {
        DecoratorPatternDemo decoratorPatternDemo = new DecoratorPatternDemo();         
    } 


    private class OptionsAddedListener implements ActionListener {

        public OptionsAddedListener() {
        }
        
        public int optionCount(String str) {
            return str.split("%n|\r").length;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String adOns = e.getActionCommand();
            
            String str = adOns;
                        
            if (adOns.equals("MILK 💲5.00")) {
                Beverage milk = (Beverage) new Milk(choice);
                stream.append(milk.getDescription() );
                totalcost += milk.getCost();
                
                Total = totalcost + totalCost;      
                total.setText(String.valueOf(Total) );
                added.setText(stream.toString());
            }
            
            if (adOns.equals("MOCHA 💲5.00")) {
                Beverage mocha = (Beverage) new Mocha(choice);
                stream.append(mocha.getDescription() );
                totalcost += mocha.getCost();               
                Total = totalcost + totalCost;                
                total.setText(String.valueOf(Total) );
                added.setText(stream.toString());               
            }
            
            if (adOns.equals("WHIP CREAM 💲5.00")) {
                Beverage whip = (Beverage) new WhipCream(choice);
                stream.append(whip.getDescription());
                totalcost += whip.getCost();
                Total = totalcost + totalCost;   
                total.setText(String.valueOf(Total) );
                added.setText(stream.toString());    
            }
            
            if (adOns.equals("CHOCOLATE SYRUP 💲5.00")) {
                Beverage chocolate = (Beverage) new ChocolateSyrup(choice);
                stream.append(chocolate.getDescription());
                totalcost += chocolate.getCost();
                Total = totalcost + totalCost;
                total.setText(String.valueOf(Total) );
                added.setText(stream.toString());      
            }
            
            if (adOns.equals("CARAMEL SYRUP 💲5.00")) {
                Beverage caramel = (Beverage) new CaramelSyrup(choice);
                stream.append(caramel.getDescription());
                totalcost += caramel.getCost();
                Total = totalcost + totalCost;
                total.setText(String.valueOf(Total) );
                added.setText(stream.toString());
            }
                
                if (optionCount(str) == 1) { 
                    
                    screen2.setVisible(false);
                    screen3.setVisible(true); 
            }
                Total = totalcost + totalCost;
                //System.out.println(str);
                //System.out.println(optionCount(str));
        }
    }
    
    /*
    public static String beverageWithoutOptions(int beverageOption) {
        DecimalFormat df = new DecimalFormat("#.00");
        String description = null;
        double totalCost = 0.00;
        
        if (beverageOption == 1){
            Beverage houseblend = new HouseBlend();
            description = houseblend.getDescription();
            totalCost = houseblend.getCost();
        }
        else if (beverageOption == 2 ){
            Beverage decaf = new Decaf();
            description = decaf.getDescription();
            totalCost = decaf.getCost();
        }
        else if (beverageOption == 3 ) {
            Beverage espresso = new Espresso();
            description = espresso.getDescription();
            totalCost = espresso.getCost();
        }
        else if (beverageOption == 4 ){
            Beverage darkroast = new DarkRoast();
            description = darkroast.getDescription();
            totalCost = darkroast.getCost();
        }
        return "Total Cost $" + df.format(totalCost) + "\n Beverage:" + description; 
    }
    */
    
    private class ButtonClickedListener implements ActionListener {

        public ButtonClickedListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
                        
            if (command.equals("HOUSE BLEND 💲10.00")){
                
                int a = JOptionPane.showConfirmDialog(null, "Would you like Ad-Ons?");
        
                if (a == JOptionPane.YES_OPTION) {
                    choice = new HouseBlend();
                    totalCost = choice.getCost();
                
                    Beverage houseblend = new HouseBlend();
                    String description2 = houseblend.getDescription();
                    totalCost = houseblend.getCost();
                    
                    Total = totalcost + totalCost;
                    total.setText(String.valueOf(Total) );
                    description.setText(String.valueOf(description2));
                    
                    
                    //System.out.println(Total+ " " + description);
                
                    screen1.setVisible(false);
                    screen2.setVisible(true);                       
                }
                else if (a == JOptionPane.NO_OPTION) {
                    screen1.setVisible(false);
                    screen3.setVisible(true);
                
                    Beverage houseblend = new HouseBlend();
                    String description2 = houseblend.getDescription();
                    totalCost = houseblend.getCost();
                    
                    Total = totalcost + totalCost;
                    
                    total.setText(String.valueOf(Total) );
                    description.setText(String.valueOf(description2));
                }
            }
            if (command.equals("DECAF 💲10.00")){
                int b = JOptionPane.showConfirmDialog(null, "Would you like Ad-Ons?");
        
                if (b == JOptionPane.YES_OPTION) {
                    choice = new Decaf();
                    totalCost = choice.getCost();
                
                    Beverage decaf = new Decaf();
                    String description2 = decaf.getDescription();
                    totalCost = decaf.getCost();
                
                    //System.out.println(totalCost);
                    Total = totalcost + totalCost;
                    total.setText(String.valueOf(Total) );
                    description.setText(String.valueOf(description2));
                
                    screen1.setVisible(false);
                    screen2.setVisible(true);
                }
                else if (b == JOptionPane.NO_OPTION) {
                    screen1.setVisible(false);
                    screen3.setVisible(true);
                
                    Beverage decaf = new Decaf();
                    String description2 = decaf.getDescription();
                    totalCost = decaf.getCost();
                    
                    Total = totalcost + totalCost;
                    total.setText(String.valueOf(Total) );
                    description.setText(String.valueOf(description2));
                }
            }
            if (command.equals("ESPRESSO 💲10.00")) {
                int c = JOptionPane.showConfirmDialog(null, "Would you like Ad-Ons?");
        
                if (c == JOptionPane.YES_OPTION) {
                    choice = new Espresso();
                    totalCost = choice.getCost();
                
                    Beverage espresso = new Espresso();
                    String description2 = espresso.getDescription();
                    totalCost = espresso.getCost();
                    Total = totalcost + totalCost;
                    total.setText(String.valueOf(Total) );
                    description.setText(String.valueOf(description2));
                
                    //System.out.println(totalCost);
                
                    screen1.setVisible(false);
                    screen2.setVisible(true);
                }
                if (c == JOptionPane.NO_OPTION) {
                    screen1.setVisible(false);
                    screen3.setVisible(true);
                
                    Beverage espresso = new Espresso();
                    String description2 = espresso.getDescription();
                    totalCost = espresso.getCost();
                    Total = totalcost + totalCost;
                    total.setText(String.valueOf(Total) );
                    description.setText(String.valueOf(description2));
                
                    //System.out.println(description + " " + totalCost);
                }
            }
            if (command.equals("DARK ROAST 💲10.00")) {
                int d = JOptionPane.showConfirmDialog(null, "Would you like Ad-Ons?");
        
                if (d == JOptionPane.YES_OPTION) {
                    choice = new DarkRoast();
                    totalCost = choice.getCost();
                
                    Beverage darkroast = new DarkRoast();
                    String description2 = darkroast.getDescription();
                    totalCost = darkroast.getCost();
                    
                    Total = totalcost + totalCost;
                    total.setText(String.valueOf(Total) );
                    description.setText(String.valueOf(description2));
                
                    //System.out.println(totalCost);
                
                    screen1.setVisible(false);
                    screen2.setVisible(true);
                }
                if (d == JOptionPane.NO_OPTION) {
                    screen1.setVisible(false);
                    screen3.setVisible(true);
                
                    Beverage darkroast = new DarkRoast();
                    String description2 = darkroast.getDescription();
                    totalCost = darkroast.getCost();
                    Total = totalcost + totalCost;
                    total.setText(String.valueOf(Total) );
                    description.setText(String.valueOf(description2));
                
                    //System.out.println(description + " " + totalCost);
                }
}
}
}
}