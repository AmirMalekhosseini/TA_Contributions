package Model;

import Controller.CommunicateToSeller;
import Model.BedRoom.Bed;

import java.awt.*;
import java.util.ArrayList;

public class Customer extends User{

    private ArrayList<Product> customerBasket = new ArrayList<>();
    private CommunicateToSeller communicate;

    public Customer(CommunicateToSeller communicate) {
        this.setUsername("Customer");
        this.communicate = communicate;
    }

    public void buyProduct(Product purchasedProduct) {
        customerBasket.add(purchasedProduct);
        communicate.getSeller().getStorage().sellProduct(purchasedProduct);
    }

    public void seeBasket() {

        for (Product storageProduct : customerBasket) {
            storageProduct.showDescription();
            System.out.println();// next line
        }

    }

    public ArrayList<Product> getCustomerBasket() {
        return customerBasket;
    }

    public void setCustomerBasket(ArrayList<Product> customerBasket) {
        this.customerBasket = customerBasket;
    }

    public CommunicateToSeller getCommunicate() {
        return communicate;
    }

    public void setCommunicate(CommunicateToSeller communicate) {
        this.communicate = communicate;
    }
}
