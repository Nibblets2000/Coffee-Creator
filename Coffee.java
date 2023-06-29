/**
 * Program 'Coffee Creator'
 * CS160L-1001-1002
 * @author Noah Thao
 */
import java.util.List;

public interface Coffee {
    public double getCost();

    public List<String> getIngredients();

    public String printCoffee();
}
