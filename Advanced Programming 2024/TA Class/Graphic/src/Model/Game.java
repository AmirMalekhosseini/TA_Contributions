package Model;

import Controller.Intersection;
import View.GameFrame;
import View.InputListener;

public class Game {

    protected GameFrame gameFrame;
    protected InputListener inputListener;
    protected Intersection intersection;
    private boolean isGameRunning = true;


    public Game() {
        gameFrame = new GameFrame();
        intersection = new Intersection(gameFrame.getMagnet());
        inputListener = new InputListener(gameFrame);
    }

    public GameFrame getGameFrame() {
        return gameFrame;
    }

    public void setGameFrame(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
    }

    public Intersection getIntersection() {
        return intersection;
    }

    public void setIntersection(Intersection intersection) {
        this.intersection = intersection;
    }

    public boolean isGameRunning() {
        return isGameRunning;
    }

    public void setGameRunning(boolean gameRunning) {
        isGameRunning = gameRunning;
    }

}
