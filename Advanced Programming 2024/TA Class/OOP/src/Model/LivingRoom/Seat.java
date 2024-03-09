package Model.LivingRoom;

import java.awt.*;

public class Seat extends LivingRoomProduct {

    private String type;
    private int capacity;
    private Color color;

    public Seat(int price, String type, int capacity, Color color) {
        super(price);
        this.setName("seat");
        this.type = type;
        this.capacity = capacity;
        this.color = color;
    }

    @Override
    public void showDescription() {
        System.out.println("there is a Seat with, price: " + this.getPrice() + " , color : " + color + " , capacity :" + capacity + " and type: " + type);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}
