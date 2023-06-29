import java.util.Collections;
import java.util.List;

public class WithFlavor extends CoffeeDecorator {

    enum Syrup {
        CARAMEL,
        MOCHA,
        VANILLA
    }

    private Syrup flavor;

    public WithFlavor(Coffee c, Syrup s) {
        super(c);
        flavor = s;
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.35;
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
