/**
 * Program 'Coffee Creator'
 * CS160L-1001-1002
 * @author Noah Thao
 */
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CoffeeOrder {
    private List<Coffee> coffees;
    private LocalDateTime orderDate;
    private String location;

    //Constructor will check the location given
    public CoffeeOrder(String location) {
        coffees = new ArrayList<Coffee>();
        orderDate = LocalDateTime.now();
        if (location.contains("Irvine")){
            this.location = "Irvine";
        }
        else if (location.contains("Anaheim")){
            this.location = "Anaheim";
        }
        else if (location.contains("San Diego")){
            this.location = "San Diego";
        }
        else{
            this.location = "Long Beach";
        }
    }
    public CoffeeOrder(LocalDateTime date){
        orderDate = date;
    }

    public void addCoffee(Coffee c) {
        coffees.add(c);
    }

    public List<Coffee> getCoffees() {
        return coffees;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    //Method calculates the total of all coffees in the created order
    public double getTotal() {
        double total = 0;
        for (Coffee coffee : coffees) {
            total += coffee.getCost();
        }
        return total;
    }

    //Method formats receipt of the order, providing the date, time, coffees and costs
    public String printOrder() {
        StringBuilder order = new StringBuilder();
        order.append("ORDER RECEIPT\n");
        order.append("TimeStamp: ").append(getOrderDate()).append("\nLocation: ").append(location).append("\n");

        for (int i = 0; i < coffees.size(); i++) {
            Coffee coffee = coffees.get(i);
            String form = "";
            form = String.format("Item %d: ", (i + 1));
            form += String.format("%s - %.2f %n", coffee.printCoffee(), coffee.getCost());
            order.append(form);
        }
        order.append(String.format("TOTAL = %.2f %n", getTotal()));
        return order.toString();
    }



}
