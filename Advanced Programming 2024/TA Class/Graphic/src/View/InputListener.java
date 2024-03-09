package View;

import Controller.Intersection;
import Model.Magnet;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class InputListener {


    InputMap inputMap;
    ActionMap actionMap;
    GameFrame gameFrame;
    Magnet magnet;

    public InputListener(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
        magnet = gameFrame.getMagnet();
        createKeyBindings();
        createKeyActions();
    }


    private void createKeyBindings() {

        inputMap = gameFrame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        actionMap = gameFrame.getRootPane().getActionMap();

        // Key Press:
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0), "moveUp");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0), "moveDown");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0), "moveLeft");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0), "moveRight");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0), "releaseBlock");

        // Key Release:

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, true), "moveUpReleased");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, true), "moveDownReleased");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, true), "moveLeftReleased");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, true), "moveRightReleased");

    }

    private void createKeyActions() {

        // Key Press Action:
        actionMap.put("moveUp", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // set limit
                if (magnet.getY() <= 20 || magnet.isMagnetHitDown()) {
                    magnet.setyVelocity(0);
                    if (magnet.getY() <= 20) {
                        magnet.setY(20);
                    }
                    return;
                }
                magnet.setyVelocity(-5);
            }
        });

        actionMap.put("moveDown", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // set limit
                if (magnet.getY() >= 40 || magnet.isMagnetHitUp()) {
                    magnet.setyVelocity(0);
                    if (magnet.getY() >= 40) {
                        magnet.setY(40);
                    }
                    return;
                }
                magnet.setyVelocity(5);
            }
        });

        actionMap.put("moveLeft", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // set limit
                if (magnet.getX() <= 20 || magnet.isMagnetHitRight()) {
                    magnet.setxVelocity(0);
                    if (magnet.getX() <= 470) {
                        magnet.setX(20);
                    }
                    return;
                }
                magnet.setxVelocity(-5);
            }
        });

        actionMap.put("moveRight", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // set limit
                if (magnet.getX() >= 470 || magnet.isMagnetHitLeft()) {
                    magnet.setxVelocity(0);
                    if (magnet.getX() >= 470) {
                        magnet.setX(470);
                    }
                    return;
                }
                magnet.setxVelocity(5);
            }
        });

        actionMap.put("releaseBlock", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // return if it is null
                if (gameFrame.getNewBlock() == null) {
                    return;
                }
                // magnet catches the block
                magnet.releaseBlock();
            }
        });

        // Key Release Action:
        actionMap.put("moveUpReleased", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                magnet.setyVelocity(0);
            }
        });

        actionMap.put("moveDownReleased", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                magnet.setyVelocity(0);
            }
        });

        actionMap.put("moveLeftReleased", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                magnet.setxVelocity(0);
            }
        });

        actionMap.put("moveRightReleased", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                magnet.setxVelocity(0);
            }
        });


    }

}
