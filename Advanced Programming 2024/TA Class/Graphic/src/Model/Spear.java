package Model;

import MyProjcet.MyProjectData;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Spear extends ObjectsInGame{

    private final BufferedImage background;

    public Spear(int x, int y) {
        super(x, y);
        setWidth(30);
        setHeight(250);
        background = MyProjectData.getProjectData().getSpear();
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        // ToDO: change width and height here without change the real width and height
        g2D.drawImage(background, 0, 0, 30, 250, null);

    }

}
