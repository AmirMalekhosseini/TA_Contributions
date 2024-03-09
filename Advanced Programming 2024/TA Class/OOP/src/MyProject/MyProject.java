package MyProject;

import Controller.CliConnector;
import Controller.CommunicateToSeller;
import Model.BedRoom.Bed;
import Model.BedRoom.Closet;
import Model.Customer;
import Model.LivingRoom.Seat;
import Model.LivingRoom.Television;
import Model.Product;
import Model.Seller;
import View.CustomerCli;
import View.SellerCli;

import java.awt.*;

public class MyProject {

    public MyProject(){
        init();
    }

    public void init(){
        // ToDO: Explain why  null pointer?!
        Seller seller = new Seller();
        CommunicateToSeller communicate = new CommunicateToSeller(seller);
        Customer customer = new Customer(communicate);
        CustomerCli customerCli = new CustomerCli(customer);
        SellerCli sellerCli = new SellerCli(seller);
        CliConnector cliConnector = new CliConnector(customerCli, sellerCli);
        addInitProducts(seller);
        sellerCli.setCliConnector(cliConnector);
        customerCli.setCliConnector(cliConnector);
        //cliConnector.addCliConnector();
        cliConnector.init();
    }

    private void addInitProducts(Seller seller) {

        seller.getStorage().getProducts().add(new Bed(20, "wooden", Color.BLACK, true, 100));
        seller.getStorage().getProducts().add(new Closet(20, "wooden", Color.BLACK, true, 100));
        seller.getStorage().getProducts().add(new Seat(50, "wooden", 5, Color.WHITE));
        seller.getStorage().getProducts().add(new Television(50, "LG", true, 100, 50));


    }

}
