package Model.LivingRoom;

import Model.Product;

public abstract class LivingRoomProduct extends Product {

    public LivingRoomProduct(int price) {
        super(price);
    }

    public abstract void showDescription();

}
