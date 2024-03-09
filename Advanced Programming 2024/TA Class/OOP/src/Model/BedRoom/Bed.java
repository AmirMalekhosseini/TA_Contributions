package Model.BedRoom;

import java.awt.*;

public class Bed extends BedRoomProduct{

    private String type;
    private Color color;
    private boolean isSoft;
    private int size;

    public Bed(int price, String type, Color color, boolean isSoft, int size) {
        super(price);
        this.setName("bed");
        this.type = type;
        this.color = color;
        this.isSoft = isSoft;
        this.size = size;
        this.setPrice(20);
    }

    @Override
    public void showDescription() {
        System.out.println("there is a Bed with, price: " + this.getPrice() + " , color : " + color + " , size :" + size + " and type: " + type);
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

    public boolean isSoft() {
        return isSoft;
    }

    public void setSoft(boolean soft) {
        isSoft = soft;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }


}
