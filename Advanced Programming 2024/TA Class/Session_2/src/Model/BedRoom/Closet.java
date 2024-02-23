package Model.BedRoom;

import Model.Discountable;

import java.awt.*;

public class Closet extends BedRoomProduct implements Discountable {

    private String type;
    private Color color;
    private int size;
    private boolean hasMirror;

    public Closet(int price,String type,Color color,boolean hasMirror,int size) {
        super(price);
        this.setName("closet");
        this.type = type;
        this.color = color;
        this.hasMirror = hasMirror;
        this.size = size;
        this.setPrice(25);
    }

    @Override
    public void showDescription() {
        System.out.println("there is a Closet with, price: " + this.getPrice() + " , color : " + color + " , size :" + size + " and type: " + type);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isHasMirror() {
        return hasMirror;
    }

    public void setHasMirror(boolean hasMirror) {
        this.hasMirror = hasMirror;
    }

    @Override
    public void setDiscount() {
        this.setPrice(10);
    }
}
