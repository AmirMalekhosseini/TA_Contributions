package Controller;

import View.CustomerCli;
import View.SellerCli;

import java.util.Scanner;

public class CliConnector {

    private CustomerCli customerCli;
    private SellerCli sellerCli;

    Scanner scanner = new Scanner(System.in);

    public CliConnector(CustomerCli customerCli, SellerCli sellerCli) {
        this.customerCli = customerCli;
        this.sellerCli = sellerCli;
    }

    public void addCliConnector() {
        // ToDo
    }

    public void init() {
        System.out.println("Enter your username to sign in:");
        String username = scanner.next();
        scanner.nextLine();

        // sign in:
        if (username.equalsIgnoreCase("customer")) {

            customerCli.init();

        } else if (username.equalsIgnoreCase("seller")) {

            sellerCli.init();

        } else {
            init();
        }

    }

    public void goToSellerCli() {
        sellerCli.init();
    }

    public void goToCustomerCli() {
        customerCli.init();
    }

    public CustomerCli getCustomerCli() {
        return customerCli;
    }

    public void setCustomerCli(CustomerCli customerCli) {
        this.customerCli = customerCli;
    }

    public SellerCli getSellerCli() {
        return sellerCli;
    }

    public void setSellerCli(SellerCli sellerCli) {
        this.sellerCli = sellerCli;
    }
}
