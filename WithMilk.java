/**
 * Program 'Coffee Creator'
 * CS160L-1001-1002
 * @author Noah Thao
 */
import java.util.Collections;
import java.util.List;

public class WithMilk extends CoffeeDecorator {
    private String location;
    public WithMilk(Coffee c, String location) {
        super(c);
        this.location = location;
    }

    @Override
    public double getCost() {
        if (location.contains("Irvine")){
            return super.getCost() + 1.90;
        }
        else if (location.contains("Anaheim")){
            return super.getCost() + 1.50;
        }
        else if (location.contains("San Diego")){
            return super.getCost() + 0.99;
        }
        else {
            return super.getCost() + 0.55;
        }
    }

    @Override
    public List<String> getIngredients() {
        return Collections.singletonList("Milk");
    }

    @Override
    public String printCoffee() {
        return super.printCoffee() + " with milk";
    }
}
