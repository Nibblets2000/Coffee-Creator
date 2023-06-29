/**
 * Program 'Coffee Creator'
 * CS160L-1001-1002
 * @author Noah Thao
 */
import java.util.Collections;
import java.util.List;

public class WithHotWater extends CoffeeDecorator {
    private String location;
    public WithHotWater(Coffee c, String location) {
        super(c);
        this.location = location;
    }

    @Override
    public double getCost() {
        if (location.contains("Irvine")){
            return super.getCost() + 0.50;
        }
        else if (location.contains("Anaheim")){
            return super.getCost() + 0.25;
        }
        else {
            return super.getCost();
        }
    }

    @Override
    public List<String> getIngredients() {
        return Collections.singletonList("Hot water");
    }

    @Override
    public String printCoffee() {
        return super.printCoffee() + " with hot water";
    }
}
