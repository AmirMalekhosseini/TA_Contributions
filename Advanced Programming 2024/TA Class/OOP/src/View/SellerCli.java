package View;

import Controller.CliConnector;
import Model.LivingRoom.Seat;
import Model.LivingRoom.Television;
import Model.Product;
import Model.Seller;

import java.awt.*;
import java.lang.reflect.TypeVariable;
import java.util.Scanner;

public class SellerCli {

    private CliConnector cliConnector;
    private final Seller seller;
    Scanner scanner = new Scanner(System.in);

    public SellerCli(Seller seller) {
        this.seller = seller;
    }

    public CliConnector getCliConnector() {
        return cliConnector;
    }

    public void init() {
        System.out.println("you have entered as a seller\n what do you want to do:\n 0- back\n 1- add product 2- show storage");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            addProduct();
        } else if (choice == 2) {
            showStorage();
        } else if (choice == 0) {
            cliConnector.init();
        } else {
            init();
        }

    }

    private void addProduct() {
        System.out.println("what product you want to add:\n 0 - back \n 1- living room product\n 2- bedroom product");
        System.out.println();

        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {

            // start adding process:
            addFinalProduct("Seat", "TV");

        } else if (choice == 2) {

            // start adding process:
            addFinalProduct("Bed", "Closet");

        } else if (choice == 0) {
            init();
        } else {
            addProduct();
        }


    }

    /*
    I created this method the way that
     it shows to seller two add options(if you want to add more options you can use lists)
     and then starts adding process
     this method helps me for avoiding code duplication
     */
    private void addFinalProduct(String firstAddOption, String secondAddOption) {

        System.out.println("what product you want to add:");
        System.out.println("1- " + firstAddOption);
        System.out.println("2- " + secondAddOption);
        System.out.println("0- back");
        System.out.println();

        int choose = scanner.nextInt();
        scanner.nextLine();

        if (choose == 1) {

            // Add a new product to seller's storage:
            seller.getStorage().addProduct(seller.getProductMap().get(firstAddOption));
            System.out.println("Adding to storage was successful");
            System.out.println();
            addProduct();

        } else if (choose == 2) {

            // Add a new product to seller's storage:
            seller.getStorage().addProduct(seller.getProductMap().get(secondAddOption));
            System.out.println("Adding to storage was successful");
            System.out.println();
            addProduct();

        } else if (choose == 0) {
            init();// back
        } else {
            addProduct();
        }

    }

    private void showStorage() {
        seller.getStorage().showStorage();
        System.out.println();
        //back
        init();
    }

    public void setCliConnector(CliConnector cliConnector) {
        this.cliConnector = cliConnector;
    }

    public Seller getSeller() {
        return seller;
    }
}
