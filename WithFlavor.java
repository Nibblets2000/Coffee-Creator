/**
 * Program 'Coffee Creator'
 * CS160L-1001-1002
 * @author Noah Thao
 */
import java.util.Collections;
import java.util.List;

public class WithFlavor extends CoffeeDecorator {

    enum Syrup {
        CARAMEL,
        MOCHA,
        VANILLA
    }

    private Syrup flavor;
    private String location;

    public WithFlavor(Coffee c, Syrup s, String location) {
        super(c);
        flavor = s;
        this.location = location;
    }

    @Override
    public double getCost() {
        if (location.contains("Irvine")){
            return super.getCost() + 1.25;
        }
        else if (location.contains("Anaheim")){
            return super.getCost() + 1.00;
        }
        else if (location.contains("San Diego")){
            return super.getCost() + 0.70;
        }
        else {
            return super.getCost() + 0.35;
        }
    }

    @Override
    public List<String> getIngredients() {
        return Collections.singletonList(flavor + " syrup");
    }

    @Override
    public String printCoffee() {
        return super.printCoffee() + " with " + flavor;
    }
}
