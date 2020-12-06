
package decoratorpatterndemo;

public class WhipCream extends OptionDecorator {
    
    public WhipCream(Beverage decoratedbeverage) {
        super(decoratedbeverage);
    }
    
    @Override
    public String getDescription(){
        return "Whip Cream";
    }
    
    @Override
    public double getCost() {
        return 5.00;
    }
    
}
