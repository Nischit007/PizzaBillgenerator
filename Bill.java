import java.util.Scanner;

class Pizza {
    private int price;
    private boolean veg;
    private int addExtraCheese = 100;
    private int addExtraTopping = 150;
    private int addTakeAway = 20;
    private int basePizzaPrice;
    private boolean isExtraCheeseAdded;
    private boolean isExtraToppingAdded;
    private boolean isTakeAway;

    Pizza(boolean veg) {
        this.veg = veg;
        if (veg) {
            this.price = 300;
        } else {
            this.price = 400;
        }
        basePizzaPrice = this.price;
    }

    public void addExtraCheese() {
        System.out.println("Extra Cheese added");
        this.price += addExtraCheese;
        this.isExtraCheeseAdded = true;
    }

    public void addExtraTopping() {
        System.out.println("Extra Topping added");
        this.price += addExtraTopping;
        this.isExtraToppingAdded = true;
    }

    public void addTakeAway() {
        System.out.println("Take away");
        this.price += addTakeAway;
        this.isTakeAway = true;
    }

    public void getBill() {
        System.out.println("Price of pizza is " + basePizzaPrice);
        if (isExtraCheeseAdded) {
            System.out.println("Extra cheese is Added: " + addExtraCheese);
        }
        if (isExtraToppingAdded) {
            System.out.println("Extra topping is Added: " + addExtraTopping);
        }
        if (isTakeAway) {
            System.out.println("Take away: " + addTakeAway);
        }
        System.out.println("Total price of pizza " + this.price);
    }
}

class DeluxPizza extends Pizza {

    DeluxPizza(boolean veg) {
        super(veg);
        super.addExtraCheese();
        super.addExtraTopping();
    }

    @Override
    public void addExtraCheese() {
        System.out.println("Extra Cheese cannot be added to Delux Pizza");
    }

    @Override
    public void addExtraTopping() {
        System.out.println("Extra Topping cannot be added to Delux Pizza");
    }
}

public class Bill {
    public static void main(String[] args) {
        System.out.println("Do You Want to Order Pizza or DeluxPizza");

        Scanner sc = new Scanner(System.in);
        String scan = sc.nextLine();

        if (scan.equals("Pizza")) {
            System.out.println("Do you want to order Veg or non-veg");
            String type = sc.nextLine();
            boolean veg = type.equalsIgnoreCase("Veg");
            Pizza pizza = new Pizza(veg);
            pizza.addTakeAway();
            pizza.getBill();
        } else if (scan.equals("DeluxPizza")) {
            System.out.println("Do you want to order Veg or non-veg");
            String type = sc.nextLine();
            boolean veg = type.equalsIgnoreCase("Veg");
            DeluxPizza deluxPizza = new DeluxPizza(veg);
            deluxPizza.addTakeAway();
            deluxPizza.getBill();
        } else {
            System.out.println("Enter a valid order");
            
        }
    }
}
