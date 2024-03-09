package View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BackGroundPanel extends JPanel {

    private BufferedImage image;

    public BackGroundPanel() {

        try {
            image = ImageIO.read(new File("background.jpeg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        this.setBounds(0,0,600,800);

    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0, 0, 600, 800, null);
        }

    }

}
