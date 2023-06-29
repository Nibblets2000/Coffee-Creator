import java.util.Collections;
import java.util.List;

public class WithSugar extends CoffeeDecorator {
    public WithSugar(Coffee c) {
        super(c);
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.15;
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
