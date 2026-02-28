import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter your credit card limit:");
        double limit  = input.nextDouble();
        CreditCard card = new CreditCard(limit);

        int quit = 1;
        while (quit != 0) {
            System.out.println("What are you buying?");
            String description = input.next();

            System.out.println("How much does your item cost?");
            double price = input.nextDouble();

            Purchase purchase1 = new Purchase(description, price);
            boolean completePurchase = card.processPurchase(purchase1);

            if (completePurchase) {
                System.out.println("Purchase successful!");
                System.out.println("Type 0 to quit or 1 to keep shopping!");
                quit = input.nextInt();
            } else {
                System.out.println("Purchase unsuccessful!");
                quit = 0;
            }
        }

        System.out.println("-----------------");
        System.out.println("Purchase history: ");
        for (Purchase p : card.getPurchases())  {
            System.out.println(p.getDescription() + " $ " + p.getPrice());
        }
        System.out.println("-----------------");

        System.out.println("Remaining balance: $ " + card.getBalance());
    }
}