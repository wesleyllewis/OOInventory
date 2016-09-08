import java.util.ArrayList;
import java.util.Scanner;

public class InventoryTracker  {

    static ArrayList<Grocery> groceries = new ArrayList<>();
    static Scanner scanText = new Scanner(System.in);
    static Scanner scanInt = new Scanner(System.in);


    public static void main(String[] args) {


        while (true) {

            System.out.println("Please Enter the Number Corresponding With Your Choice");
            System.out.println("(1) Add A Grocery Item");
            System.out.println("(2) Remove a Grocery Item");
            System.out.println("(3) Update The Quantity of Groceries");
            System.out.println("---------");
            int i = 1;
            for (Grocery item : groceries) {
                System.out.printf(i + ") [%s]  %s  [%s]", item.quantity, item.item, item.category);
                i++;
            }


            String option = scanText.nextLine();

            switch (option) {
                case "1":{
                    Grocery grocery = null;
                    try {
                        grocery = createItem(scanText);
                        groceries.add(grocery);
                    } catch (Exception e) {
                        System.out.println("Could Not Create The Item");
                    }
                    break;
                  }
                case "2": {
                    System.out.println("Please Enter The Number Corresponding To The Item You Would Like To Remove");
                    int itemNumber = Integer.valueOf(scanInt.nextInt());
                    groceries.remove(itemNumber - 1);
                    break;
                }
                case "3": {
                    System.out.println("Which Grocery Would You Like To Update");
                    int itemNumber = Integer.valueOf(scanInt.nextInt());
                    Grocery grocery = groceries.get(itemNumber - 1);
                    System.out.println("How Much To Add");
                    int itemAmount = Integer.valueOf(scanInt.nextInt());
                    grocery.quantity = itemAmount;
                    break;

                }
                default: {
                    System.out.println("Invalid Choice");
                }

            }

        }

    }

    public static Grocery createItem(Scanner scanText) throws Exception{
        System.out.println("Please Enter the Item to Add");
        String text = scanText.nextLine();
        System.out.println("What kind?\n 1) Frozen\n 2) Meat\n 3) Bread\n 4) Fruit\n 5) Vegetable");
        String cat = scanInt.nextLine();
        switch (cat) {
            case "1":
                Frozen frozen = new Frozen(text, 0);
                return frozen;
            case "2":
                Meat meat = new Meat(text, 0);
                return meat;
            case "3":
                Bread bread = new Bread(text, 0);
                return bread;
            case "4":
                Fruit fruit = new Fruit(text, 0);
                return fruit;
            case "5":
                Vegetable vegetable = new Vegetable(text, 0);
                return vegetable;
            default: throw new Exception("Pick a Number 1-5");
        }

    }
}
