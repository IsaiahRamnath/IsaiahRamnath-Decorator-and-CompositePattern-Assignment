
package decoratorpatterndemo;

public class Decaf implements Beverage {

    @Override
    public String getDescription() {
        return "Decaf";
    }

    @Override
    public double getCost() {
        return 16.00;
    }
    
}
