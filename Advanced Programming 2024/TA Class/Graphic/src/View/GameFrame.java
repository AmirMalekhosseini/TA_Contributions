package View;

import Model.*;

import javax.swing.*;
import java.util.ArrayList;

public class GameFrame extends JFrame {

    public final static int groundY = 760;
    public final static int newBlockX = 70;
    public final static int newBlockY = 150;
    private final static int magnetStartX = 270;
    private final static int magnetStartY = 50;
    JPanel panel;
    protected JPanel gamePanel;
    BackGroundPanel backGroundPanel;
    private ArrayList<BlockInGame> blockInGames = new ArrayList<>();
    private ArrayList<SimpleBlock> simpleBlocks = new ArrayList<>();
    private ArrayList<Spear> spears = new ArrayList<>();
    private Magnet magnet;
    private BuildingBlock newBlock;

    public GameFrame() {

        setTitle("Building Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 800);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);

        panel = new JPanel();
        panel.setBounds(0, 0, 600, 800);
        panel.setVisible(true);
        panel.setFocusable(true);
        panel.requestFocus();
        panel.requestFocusInWindow();
        panel.setLayout(null);
        setContentPane(panel);

        gamePanel = new JPanel();
        gamePanel.setBounds(0, 0, 600, 800);
        gamePanel.setVisible(true);
        gamePanel.setFocusable(true);
        gamePanel.requestFocus();
        gamePanel.requestFocusInWindow();
        gamePanel.setLayout(null);
        gamePanel.setOpaque(false);

        backGroundPanel = new BackGroundPanel();
        backGroundPanel.setLayout(null);


        magnet = new Magnet(magnetStartX, magnetStartY);

        addSimpleBlock();
        addSpear();
        panel.add(gamePanel);
        panel.add(backGroundPanel);
        gamePanel.add(magnet);

    }

    private void addSimpleBlock() {

        int x = 0;
        for (int i = 0; i < 4; i++) {

            SimpleBlock newSimpleBlock = new SimpleBlock(x, 200);
            gamePanel.add(newSimpleBlock);
            simpleBlocks.add(newSimpleBlock);
            x += 50;
        }

        newBlock = new BuildingBlock(newBlockX, newBlockY);
        gamePanel.add(newBlock);

    }

    private void addSpear() {
        int x = 250;
        for (int i = 0; i < 2; i++) {

            Spear spear = new Spear(x, 520);
            spears.add(spear);
            gamePanel.add(spear);
            x += 250;
        }
    }

    public Magnet getMagnet() {
        return magnet;
    }

    public void setMagnet(Magnet magnet) {
        this.magnet = magnet;
    }

    public BuildingBlock getNewBlock() {
        return newBlock;
    }

    public void setNewBlock(BuildingBlock newBlock) {
        this.newBlock = newBlock;
    }

    public ArrayList<BlockInGame> getBlockInGames() {
        return blockInGames;
    }

    public void setBlockInGames(ArrayList<BlockInGame> blockInGames) {
        this.blockInGames = blockInGames;
    }

    public ArrayList<Spear> getSpears() {
        return spears;
    }

    public void setSpears(ArrayList<Spear> spears) {
        this.spears = spears;
    }

    public JPanel getGamePanel() {
        return gamePanel;
    }

    public void setGamePanel(JPanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public ArrayList<SimpleBlock> getSimpleBlocks() {
        return simpleBlocks;
    }

    public void setSimpleBlocks(ArrayList<SimpleBlock> simpleBlocks) {
        this.simpleBlocks = simpleBlocks;
    }
}
