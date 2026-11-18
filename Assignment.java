
import java.util.Scanner;

public class SmartRestaurant {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = input.nextLine();

        System.out.print("Enter meal price: ");
        double meal = input.nextDouble();

        System.out.print("Enter number of drinks: ");
        int drinks = input.nextInt();

        System.out.print("Are you a student? true/false: ");
        boolean student = input.nextBoolean();

        System.out.print("Enter your age: ");
        int age = input.nextInt();

        System.out.print("Enter service rating: ");
        int rating = input.nextInt();

        if (rating < 1 || rating > 5) {

            System.out.println("Invalid rating!");

        } else {

            double drinkPrice = 15.50;
            double drinksTotal = drinks * drinkPrice;

            double subtotal = meal + drinksTotal;

            double discount = 0;

            if (student == true) {
                discount = 0.10;
            }

            if (age >= 60 && discount < 0.05) {
                discount = 0.05;
            }

            double discountAmount = subtotal * discount;

            double tip = 0;

            if (rating == 4 || rating == 5) {
                tip = (subtotal - discountAmount) * 0.10;
            }

            double finalBill = subtotal - discountAmount + tip;

            int wholeBill = (int) finalBill;

            System.out.println("----- RECEIPT -----");
            System.out.println("Name: " + name);
            System.out.println("Meal: $" + meal);
            System.out.println("Drinks: $" + drinksTotal);
            System.out.println("Discount: $" + discountAmount);
            System.out.println("Tip: $" + tip);
            System.out.println("Final Bill: $" + finalBill);
            System.out.println("Whole Bill: $" + wholeBill);

        }

        input.close();
    }
}
