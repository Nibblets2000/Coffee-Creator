/**
 * Program 'Coffee Creator'
 * CS160L-1001-1002
 * @author Noah Thao
 */
import java.util.Collections;
import java.util.List;

public class WithSugar extends CoffeeDecorator {
    private String location;
    public WithSugar(Coffee c, String location) {
        super(c);
        this.location = location;
    }

    @Override
    public double getCost() {
        if (location.contains("Irvine")){
            return super.getCost() + 1.00;
        }
        else if (location.contains("Anaheim")){
            return super.getCost() + 0.75;
        }
        else if (location.contains("San Diego")){
            return super.getCost() + 0.30;
        }
        else {
            return super.getCost() + 0.15;
        }
    }

    @Override
    public List<String> getIngredients() {
        return Collections.singletonList("Sugar");
    }

    @Override
    public String printCoffee() {
        return super.printCoffee() + " with sugar";
    }
}
