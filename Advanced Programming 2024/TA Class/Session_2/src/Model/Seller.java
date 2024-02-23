package Model;

import Model.BedRoom.Bed;
import Model.BedRoom.Closet;
import Model.LivingRoom.Seat;
import Model.LivingRoom.Television;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Seller extends User {

    private SellerStorage storage;

    // Creating a HashMap to map every product name to its object
    // To help creating new products easier:
    private final Map<String, Product> productMap = new HashMap<>();

    public Seller() {
        this.setUsername("Admin");
        storage = new SellerStorage();
        mapProducts();
    }

    private void mapProducts() {
        // to avoid complexity I created products in hardcode way
        productMap.put("Seat", new Seat(50, "wooden", 5, Color.WHITE));
        productMap.put("Closet", new Closet(20, "wooden", Color.BLACK, true, 100));
        productMap.put("Bed", new Bed(20, "wooden", Color.BLACK, true, 100));
        productMap.put("TV", new Television(50, "LG", true, 100, 50));
    }

    public SellerStorage getStorage() {
        return storage;
    }

    public void setStorage(SellerStorage storage) {
        this.storage = storage;
    }

    public Map<String, Product> getProductMap() {
        return productMap;
    }
}
