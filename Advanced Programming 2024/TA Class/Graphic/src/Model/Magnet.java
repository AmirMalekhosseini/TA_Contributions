package Model;

import MyProjcet.MyProjectData;

import java.awt.*;

public class Magnet extends ObjectsInGame implements Moveable {

    private int xVelocity = 0;
    private int yVelocity = 0;
    protected BuildingBlock holdingBlock;
    private boolean isCaught;
    // ToDO: explain bug without these:
    private boolean magnetHitLeft;
    private boolean magnetHitRight;
    private boolean magnetHitDown;
    private boolean magnetHitUp;

    public Magnet(int x, int y) {
        super(x, y);
        setX(x);
        setY(y);
        this.setWidth(100);
        this.setHeight(100);
        this.setSize(getWidth(), getHeight());
        background = MyProjectData.getProjectData().getMagnet();
    }

    public void catchBlock(BuildingBlock buildingBlock) {
        holdingBlock = buildingBlock;
        holdingBlock.setCaught(true);
        isCaught = true;
    }

    public void releaseBlock() {
        // ToDo: move this to second line and run
        if (holdingBlock == null) {
            return;
        }
        holdingBlock.setReleased(true);
        holdingBlock = null;
        isCaught = false;
    }

    @Override
    public void move() {
        // update magnet's location:
        this.setX(this.getX() + xVelocity);
        this.setY(this.getY() + yVelocity);

        if (isCaught) {// Check if block is caught
            moveBlock();
        }
    }

    private void moveBlock() {
        if (holdingBlock == null) {
            return;
        }
        holdingBlock.setX(holdingBlock.getX() + xVelocity);
        holdingBlock.setY(holdingBlock.getY() + yVelocity);
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(background, 0, 0, getWidth(), getHeight(), null);

    }

    public BuildingBlock getHoldingBlock() {
        return holdingBlock;
    }

    public void setHoldingBlock(BuildingBlock holdingBlock) {
        this.holdingBlock = holdingBlock;
    }

    public int getxVelocity() {
        return xVelocity;
    }

    public void setxVelocity(int xVelocity) {
        this.xVelocity = xVelocity;
    }

    public int getyVelocity() {
        return yVelocity;
    }

    public void setyVelocity(int yVelocity) {
        this.yVelocity = yVelocity;
    }

    public boolean isCaught() {
        return isCaught;
    }

    public void setCaught(boolean caught) {
        isCaught = caught;
    }
    public boolean isMagnetHitLeft() {
        return magnetHitLeft;
    }

    public void setMagnetHitLeft(boolean magnetHitLeft) {
        this.magnetHitLeft = magnetHitLeft;
    }

    public boolean isMagnetHitRight() {
        return magnetHitRight;
    }

    public void setMagnetHitRight(boolean magnetHitRight) {
        this.magnetHitRight = magnetHitRight;
    }

    public boolean isMagnetHitDown() {
        return magnetHitDown;
    }

    public void setMagnetHitDown(boolean magnetHitDown) {
        this.magnetHitDown = magnetHitDown;
    }

    public boolean isMagnetHitUp() {
        return magnetHitUp;
    }

    public void setMagnetHitUp(boolean magnetHitUp) {
        this.magnetHitUp = magnetHitUp;
    }
}
