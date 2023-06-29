/**
 * Program 'Coffee Creator'
 * CS160L-1001-1002
 * @author Noah Thao
 */

import java.io.*;
import java.util.*;

public class Main {
    private static Map<String, Integer> inventory = new TreeMap<String, Integer>();
    private static List<CoffeeOrder> orders = new ArrayList<CoffeeOrder>();
    private static String logFile = "OrderLog.txt";
    private static String inventoryFile;

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        boolean fin = false;
        int i = 0;
        boolean locSelec = false;

        //Takes in location to utilize shop's inventory based on said location
        try{
            while (!locSelec) {
                System.out.println("Hello. Please select location.");
                System.out.println("1. San Diego\n2. Anaheim\n3. Irvine\n4. Long Beach");
                switch (scan.nextInt()){
                    case 1 -> {
                        inventoryFile = "Inventory - San Diego.txt";
                        System.out.println("Location selected: San Diego");
                        locSelec = true;
                    }
                    case 2 ->{
                        inventoryFile = "Inventory - Anaheim.txt";
                        System.out.println("Location selected: Anaheim");
                        locSelec = true;
                    }
                    case 3 ->{
                        inventoryFile = "Inventory - Irvine.txt";
                        System.out.println("Location selected: Irvine");
                        locSelec = true;
                    }
                    case 4 ->{
                        inventoryFile = "Inventory - Long Beach.txt";
                        System.out.println("Location selected: Long Beach");
                        locSelec = true;
                    }
                    default ->{System.out.println("Invalid input. Please try again");}
                }
            }
        }
        catch (Exception e){
            System.out.println("Error fetching location: " + e.getMessage());
        }

        readInventory(inventoryFile);


        //Displays starting menu for user
        try {
            do {
                System.out.println("Please choose the desired option");
                System.out.println("1. Create order\n2. Reload inventory\n3. Update order log\n4. Update inventory\n5. Exit");
                switch (scan.next()) {
                    case "1" -> {
                        orders.add(buildOrder());
                        System.out.println(orders.get(i).printOrder());
                        System.out.println("Order added.\n");
                        i++;
                        break;
                    }
                    case "5" -> {
                        writeOrderLog(logFile);
                        System.out.println("Closing...");
                        fin = true;
                        break;
                    }
                    case "2" -> {
                        readInventory(inventoryFile);
                        System.out.println("Inventory reloaded\n");
                        break;
                    }
                    case "4" -> {
                        writeInventory(inventoryFile);
                        System.out.println("Inventory updated\n");
                        break;
                    }
                    case "3" -> {
                        writeOrderLog(logFile);
                        System.out.println("Order log updated");
                        break;
                    }
                    case "6" ->{
                        System.out.println(inventory);
                    }
                    default -> {
                        System.out.println("Incorrect input, please try again\n");
                    }
                }
            }
            while (!fin);
        }
        catch (Exception e){
            System.out.println("Error encountered: " + e.getMessage());
        }
    }

    //Method reads the inventory file, then pastes the results into the Inventory map
    private static Map<String, Integer> readInventory(String filePath){
        try (BufferedReader bR = new BufferedReader(new FileReader(filePath))) {
            Scanner scan;
            String line = bR.readLine();
            String ingredient = "";
            int ingAmnt = 0;
            String part1 = "";
            String part2 = "";

            while (line != null) {
                scan = new Scanner(line);
                part1 = scan.next();
                part2 = scan.next();
                if (part2.contains("=")) {
                    ingredient = part1;
                } else {
                    ingredient = part1;
                    ingredient += " " + part2;
                    scan.next();
                }

                ingAmnt = scan.nextInt();
                inventory.put(ingredient, ingAmnt);

                line = bR.readLine();
            }

        }
        catch (Exception e){
            System.out.println("Error reading inventory: " + e.getMessage());
        }
        return inventory;
    }


    //Method writes the current Inventory map into the Inventory file
    private static void writeInventory(String filePath){
        try (BufferedWriter bW = new BufferedWriter(new FileWriter(filePath, false))) {
            for (String i : inventory.keySet()) {
                    bW.write(i + " = " + inventory.get(i));
                    bW.newLine();
                }
            bW.flush();
            bW.close();

            System.out.println("File written successfully");
        }
        catch (Exception e){
            System.out.println("Error writing inventory: " + e.getMessage());
        }

    }

    private static List<CoffeeOrder> readOrderLog(String filePath) {
        return null;
    }

    //Method writes all the orders that were created and added to the orders arraylist to the inventory file
    private static void writeOrderLog(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            for (CoffeeOrder order : orders) {
                writer.write(order.printOrder());
                writer.newLine();
            }
            orders.clear();
        } catch (Exception e) {
            System.out.println("Error writing order log: " + e.getMessage());
        }

    }

    //Method checks the inventory list to see if the given item is in stock and returns a boolean value
    private static boolean isInInventory(String i) {
        try {
            if (inventory.get(i) != 0) {
                return true;
            }
        }
        catch (Exception e){
            System.out.println("Error checking inventory: " + e.getMessage());
        }
        return false;
    }

    //Displays menu for ordering and adding coffees
    private static CoffeeOrder buildOrder() {
        Scanner scan = new Scanner(System.in);
        CoffeeOrder order = new CoffeeOrder(inventoryFile);
        Coffee orD = null;
        boolean finished = false;

        try {
            while (!finished) {
                System.out.println("1. Add a coffee\n2. Exit");
                switch (scan.next()) {
                    case "1":
                        if ((isInInventory("Black Coffee")) || isInInventory("Espresso")) {
                            System.out.println("Select Coffee\n1. Black\n2. Espresso");
                            switch (scan.next()) {
                                case "2":
                                    orD = new Espresso(inventoryFile);
                                    inventory.put("Espresso", inventory.get("Espresso") - 1);
                                    orD = toppings(orD);
                                    order.addCoffee(orD);
                                    break;

                                case "1":
                                    orD = new BlackCoffee(inventoryFile);
                                    inventory.put("Black Coffee", inventory.get("Black Coffee") - 1);
                                    orD = toppings(orD);
                                    order.addCoffee(orD);
                                    break;
                            }
                        } else {
                            System.out.println("Sorry! None in stock!");
                            break;
                        }
                        break;

                    case "2":
                        finished = true;
                        break;

                    default:
                        System.out.println("Incorrect input, please try again");
                        scan.next();
                }
            }
        }
        catch (Exception e){
            System.out.println("Error while checking inventory: " + e.getMessage());
        }
        return order;
    }

    //Method adds toppings to the given coffee
    private static Coffee toppings(Coffee c) {
        Scanner scan = new Scanner(System.in);
        Coffee impOrder = c;
        boolean finished = false;

        try {
            while (!finished) {
                System.out.println("Toppings?");
                System.out.println("1. Hot Water\n2. Milk\n3. Sugar\n4. Whipped Cream\n5. Syrup\n6. Exit");
                switch (scan.next()) {
                    case "1":
                        if (isInInventory("Hot Water")) {
                            impOrder = new WithHotWater(impOrder, inventoryFile);
                            inventory.put("Hot Water", inventory.get("Hot Water") - 1);
                            break;
                        } else {
                            System.out.println("Sorry! None in stock!");
                            break;
                        }

                    case "2":
                        if (isInInventory("Milk")) {
                            impOrder = new WithMilk(impOrder, inventoryFile);
                            inventory.put("Milk", inventory.get("Milk") - 1);
                            break;
                        } else {
                            System.out.println("Sorry! None in stock");
                            break;
                        }

                    case "3":
                        if (isInInventory("Sugar")) {
                            impOrder = new WithSugar(impOrder, inventoryFile);
                            inventory.put("Sugar", inventory.get("Sugar") - 1);
                            break;
                        } else {
                            System.out.println("Sorry! None in stock!");
                            break;
                        }

                    case "4":
                        if (isInInventory("Whipped Cream")) {
                            impOrder = new WithWhippedCream(impOrder, inventoryFile);
                            inventory.put("Whipped Cream", inventory.get("Whipped Cream") - 1);
                            break;
                        } else {
                            System.out.println("Sorry! None in stock!");
                            break;
                        }

                        //Case for syrup asks the user to select their type of syrup with an internal switch statement
                    case "5":
                        System.out.println("Select syrup flavor");
                        System.out.println("1. Mocha\n2. Caramel\n3. Vanilla\n4. Cancel");
                        switch (scan.next()) {
                            case "1":
                                if (isInInventory("MOCHA Syrup")) {
                                    impOrder = new WithFlavor(impOrder, WithFlavor.Syrup.MOCHA, inventoryFile);
                                    inventory.put("MOCHA Syrup", inventory.get("MOCHA Syrup") - 1);
                                    break;
                                } else {
                                    System.out.println("Sorry! None in stock!");
                                    break;
                                }
                            case "2":
                                if (isInInventory("CARAMEL Syrup")) {
                                    impOrder = new WithFlavor(impOrder, WithFlavor.Syrup.CARAMEL, inventoryFile);
                                    inventory.put("CARAMEL Syrup", inventory.get("CARAMEL Syrup") - 1);
                                    break;
                                } else {
                                    System.out.println("Sorry! None in stock!");
                                    break;
                                }

                            case "3":
                                if (isInInventory("VANILLA Syrup")) {
                                    impOrder = new WithFlavor(impOrder, WithFlavor.Syrup.VANILLA, inventoryFile);
                                    inventory.put("VANILLA Syrup", inventory.get("VANILLA Syrup") - 1);
                                    break;
                                } else {
                                    System.out.println("Sorry! None in stock!");
                                    break;
                                }
                            case "4":
                                break;

                            default:
                                System.out.println("Invalid input. Please try again");
                                break;
                        }
                        break;
                    case "6":
                        System.out.println("Finishing order...");
                        finished = true;
                        break;
                }
            }
        }
        catch (Exception e){
            System.out.println("Error while adding toppings: " + e.getMessage());
        }
        return impOrder;
    }
}
