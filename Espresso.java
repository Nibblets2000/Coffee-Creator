import java.util.Collections;
import java.util.List;

public class Espresso implements Coffee {
    @Override
    public double getCost() {
        return 1.75;
    }

    @Override
    public List<String> getIngredients() {
        return Collections.singletonList("Espresso");
    }

    @Override
    public String printCoffee() {
        return "An espresso";
    }
}

