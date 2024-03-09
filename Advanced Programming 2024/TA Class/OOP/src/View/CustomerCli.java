package View;

import Controller.CliConnector;
import Model.Customer;
import Model.Product;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerCli {

    private CliConnector cliConnector;
    private final Customer customer;
    Scanner scanner = new Scanner(System.in);

    public CustomerCli(Customer customer) {
        this.customer = customer;
    }

    public CliConnector getCliConnector() {
        return cliConnector;
    }

    public void init() {

        System.out.println("you have entered as a customer\n what do you want to do:\n 0- back\n 1- buy product 2- show basket");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            buyProduct(); // Buy procedure
        } else if (choice == 2) {
            showBasket();// Showing customer's basket
        } else if (choice == 0) {
            cliConnector.init();
        } else {
            init();
        }

    }

    private void buyProduct() {

        cliConnector.getSellerCli().getSeller().getStorage().showStorage();
        System.out.println();
        System.out.println("what product you want to buy: 0 - back \n 1- living room product\n 2- bedroom product");
        System.out.println();

        int choice1 = scanner.nextInt();
        scanner.nextLine();

        if (choice1 == 1) {

            chooseFinalProduct("seat", "TV");

        } else if (choice1 == 2) {

            chooseFinalProduct("Bed", "Closet");

        } else if (choice1 == 0) {
            init(); // back
        } else {
            buyProduct();
        }


    }

    private void showBasket() {

        customer.seeBasket();
        System.out.println();
        init();

    }

    public void setCliConnector(CliConnector cliConnector) {
        this.cliConnector = cliConnector;
    }


    /*
    I created this method the way that
     it shows to customer two buy options(if you want to add more options you can use lists)
     and then starts purchasing process
     this method helps me for avoiding code duplication
     */
    private void chooseFinalProduct(String firstBuyOption, String secondBuyOption) {

        System.out.println("what product you want to buy:");
        System.out.println("1- " + firstBuyOption);
        System.out.println("2- " + secondBuyOption);
        System.out.println("0- back");
        System.out.println();

        int choose = scanner.nextInt();
        scanner.nextLine();

        if (choose == 1) {

            helpForBuy(firstBuyOption);
            System.out.println();

        } else if (choose == 2) {

            helpForBuy(secondBuyOption);
            System.out.println();

        } else if (choose == 0) {
            init();
        } else {
            buyProduct();
        }

    }


    // Method that inputs name of a product and process the purchase:
    // It inputs a name and searches for products with this name
    private void helpForBuy(String name) {

        ArrayList<Product> tempList = new ArrayList<>();
        for (Product product : cliConnector.getSellerCli().getSeller().getStorage().getProducts()) {
            if (product.getName().equalsIgnoreCase(name)) {
                tempList.add(product);
            }
        }

        System.out.println();

        for (int i = 0; i < tempList.size(); i++) {
            System.out.print(i + 1 + ": ");
            tempList.get(i).showDescription();
            System.out.println();

        }
        System.out.println(" 0- back");
        System.out.println();
        System.out.println("enter product's number to buy it or enter 0 to back to previous page:");

        int chooseProduct = scanner.nextInt();// choose product from list
        scanner.nextLine();
        System.out.println();

        if (chooseProduct == 0) {
            init(); //back
        } else if (chooseProduct <= tempList.size()) { // customer buys chosen product
            customer.buyProduct(tempList.get(chooseProduct - 1));
            System.out.println("Purchase was successful");
            System.out.println();
            init();
        }

    }

}
