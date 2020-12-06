
package decoratorpatterndemo;

public class ChocolateSyrup extends OptionDecorator{
    
    public ChocolateSyrup(Beverage decoratedbeverage) {
        super(decoratedbeverage);
    }
    
    @Override
    public String getDescription (){
        return "Chocolate Syrup";
    }
   
    @Override
    public double getCost() {
        return 5.00;
    }
}
