
package decoratorpatterndemo;

public class CaramelSyrup extends OptionDecorator{
    
    public CaramelSyrup(Beverage decoratedbeverage) {
        super(decoratedbeverage);
    }
    
    @Override
    public String getDescription() {
        return "Caramel Syrup";
    }
    
    @Override
    public double getCost() {
        return 5.00;
    }
}
