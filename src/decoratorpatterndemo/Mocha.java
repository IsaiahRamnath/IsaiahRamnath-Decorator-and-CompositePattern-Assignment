
package decoratorpatterndemo;

public class Mocha extends OptionDecorator {
    
    public Mocha(Beverage decoratedbeverage) {
        super(decoratedbeverage);
    }
    
    @Override
    public String getDescription() {
        return "Mocha";
    }
    
    @Override
    public double getCost(){
        return 5.00;
    }
    
}
