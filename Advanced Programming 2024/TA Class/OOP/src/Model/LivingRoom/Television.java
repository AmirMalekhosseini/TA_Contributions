package Model.LivingRoom;

public class Television extends LivingRoomProduct {

    private String model;
    private boolean isCurved;
    private int height;
    private int width;


    public Television(int price, String model, boolean isCurved, int height, int width) {
        super(price);
        this.setName("TV");
        this.model = model;
        this.isCurved = isCurved;
        this.height = height;
        this.width = width;
    }

    @Override
    public void showDescription() {
        System.out.println("there is a TV with, price: " + this.getPrice() + " , height : " + height + " , width :" + width + " and model: " + model);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isCurved() {
        return isCurved;
    }

    public void setCurved(boolean curved) {
        isCurved = curved;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }


}
