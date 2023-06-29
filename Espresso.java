/**
 * Program 'Coffee Creator'
 * CS160L-1001-1002
 * @author Noah Thao
 */
import java.util.Collections;
import java.util.List;

public class Espresso implements Coffee {
    private String location;
    Espresso (String location){
        this.location = location;
    }
    @Override
    public double getCost() {
        if (location.contains("Irvine")){
            return 4.0;
        }
        else if (location.contains("Anaheim")){
            return 3.0;
        }
        else if (location.contains("San Diego")){
            return 2.40;
        }
        else {
            return 1.75;
        }
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

