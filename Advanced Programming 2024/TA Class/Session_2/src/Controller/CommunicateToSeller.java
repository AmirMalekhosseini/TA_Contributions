package Controller;

import Model.Seller;

public class CommunicateToSeller {

    private Seller seller;

    public CommunicateToSeller(Seller seller) {
        this.seller = seller;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }
}
