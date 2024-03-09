package Model;

import MyProjcet.MyProjectData;

import java.awt.*;

public class SimpleBlock extends BlockInGame {

    public SimpleBlock(int x, int y) {

        super(x, y);
//        setX(x);
//        setY(y);
        this.setWidth(50);
        this.setHeight(50);
        this.setSize(getWidth(),getHeight());
        background = MyProjectData.getProjectData().getSimpleBlock();

    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(background, 0, 0, 50, 50, null);

    }

}
