//Concrete class
package decoratorpatterndemo;

public class DarkRoast implements Beverage {

    @Override
    public String getDescription() {
        return "Dark Roast";
    }

    @Override
    public double getCost() {
        return 10.00;
    }
    
}
