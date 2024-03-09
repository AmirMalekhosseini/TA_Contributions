package Model.BedRoom;

import Model.Product;

public abstract class BedRoomProduct extends Product {

    public BedRoomProduct(int price) {
        super(price);
    }

    public abstract void showDescription();
}
