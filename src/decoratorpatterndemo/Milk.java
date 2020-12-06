
package decoratorpatterndemo;

public class Milk extends OptionDecorator {
    
    public Milk(Beverage decoratedbeverage) {
        super(decoratedbeverage); 
    }
    
    @Override
    public String getDescription(){
        return "Milk";
    }
    
    @Override
    public double getCost() {
        return 5.00;
    }
    
}
