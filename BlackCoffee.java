import java.util.Collections;
import java.util.List;

public class BlackCoffee implements Coffee {
    @Override
    public double getCost() {
        return 1.0;
    }

    @Override
    public List<String> getIngredients() {
        return Collections.singletonList("Black Coffee");
    }

    @Override
    public String printCoffee() {
        return "A black coffee";

    }
}
