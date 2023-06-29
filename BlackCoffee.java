/**
 * Program 'Coffee Creator'
 * CS160L-1001-1002
 * @author Noah Thao
 */
import java.util.Collections;
import java.util.List;

public class BlackCoffee implements Coffee {
    private String location;
    BlackCoffee(String location){
        this.location = location;
    }
    @Override
    public double getCost() {
        if (location.contains("Irvine")){
            return 2.5;
        }
        else if (location.contains("Anaheim")){
            return 2.25;
        }
        else if (location.contains("San Diego")){
            return 1.50;
        }
        else {
            return 1.0;
        }
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
