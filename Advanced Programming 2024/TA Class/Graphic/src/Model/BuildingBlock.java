package Model;

import MyProjcet.MyProjectData;
import java.awt.*;

public class BuildingBlock extends BlockInGame implements Gravity {


    private boolean isCaught;
    //ToDo: explain why we both of these two booleans
    private boolean isReleased;
    public BuildingBlock(int x, int y) {

        super(x, y);
        this.setWidth(70);
        this.setHeight(70);
        background= MyProjectData.getProjectData().getBlock();

    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(background, 0, 0, 70, 70, null);

    }

    public boolean isCaught() {
        return isCaught;
    }

    public void setCaught(boolean caught) {
        isCaught = caught;
    }

    @Override
    public void gravity() {
        setY(getY() + 10);
    }

    public boolean isReleased() {
        return isReleased;
    }

    public void setReleased(boolean released) {
        isReleased = released;
    }

}
