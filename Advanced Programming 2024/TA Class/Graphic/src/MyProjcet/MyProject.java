package MyProjcet;

import Controller.GameLoop;
import Model.Game;

public class MyProject {

    protected Game game;
    protected GameLoop gameLoop;

    public MyProject() {
        game = new Game();
        gameLoop = new GameLoop(game);
        gameLoop.start();
    }

}
