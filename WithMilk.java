import java.util.Collections;
import java.util.List;

public class WithMilk extends CoffeeDecorator {
    public WithMilk(Coffee c) {
        super(c);
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.55;
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
