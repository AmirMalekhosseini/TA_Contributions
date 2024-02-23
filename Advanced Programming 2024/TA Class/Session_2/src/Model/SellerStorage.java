package Model;

import java.util.ArrayList;

public class SellerStorage {

    private ArrayList<Product> products = new ArrayList<>();

    public SellerStorage() {

    }

    public void addProduct(Product newProduct) {

        products.add(newProduct);

    }

    public void sellProduct(Product sellingProduct) {

        products.remove(sellingProduct);

    }

    public void showStorage() {

        for (Product storageProduct : products) {
            storageProduct.showDescription();
            System.out.println();// next line
        }

    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }


}
