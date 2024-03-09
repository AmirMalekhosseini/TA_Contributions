package MyProjcet;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MyProjectData {

    private static MyProjectData projectData;

    protected BufferedImage block;
    protected BufferedImage simpleBlock;
    protected BufferedImage magnet;
    protected BufferedImage spear;

    private MyProjectData() {
        addImages();
    }

    private void addImages() {

        try {
            String pathBackground = "BlockInAir.png";
            File fileBackground = new File(pathBackground);
            block = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String pathBackground = "EmptyBlockInAir.png";
            File fileBackground = new File(pathBackground);
            simpleBlock = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String pathBackground = "magnet.png";
            File fileBackground = new File(pathBackground);
            magnet = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            String pathBackground = "spear.png";
            File fileBackground = new File(pathBackground);
            spear = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static MyProjectData getProjectData() {
        if (projectData == null) {
            projectData = new MyProjectData();
        }
        return projectData;
    }

    public BufferedImage getBlock() {
        return block;
    }

    public BufferedImage getSimpleBlock() {
        return simpleBlock;
    }

    public BufferedImage getMagnet() {
        return magnet;
    }

    public BufferedImage getSpear() {
        return spear;
    }

    public void setSpear(BufferedImage spear) {
        this.spear = spear;
    }
}
