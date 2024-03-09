package Controller;

import Model.*;
import View.GameFrame;

public class GameLoop extends Thread {

    private Game game;

    // ToDO: move all calculations to new class
    public GameLoop(Game game) {
        this.game = game;
    }

    public void run() {

        while (game.isGameRunning()) {
            update();
        }

    }

    private void update() {

        // move Magnet
        game.getGameFrame().getMagnet().move();

            /* check newBlock intersection
            if it intersects with another block or ground, stop falling
            if else; intersects with spear, destroy
            else; keep falling
             */
        checkNewBlockIntersection();

        // check magnet catch new block:
        BuildingBlock newBlock = game.getGameFrame().getNewBlock();
        if (game.getIntersection().intersectTop(newBlock, game.getGameFrame().getMagnet()) &&
                !newBlock.isReleased()) {
            game.getGameFrame().getMagnet().catchBlock(newBlock);
        }

        // check magnet intersection:
        checkMagnetIntersection();

        // check end game condition:
        if (checkEndGame()) {
            // ToDo: run without this line
            game.getGameFrame().dispose();
            game = new Game();
        }

        // ToDo: remove this and run
        game.getGameFrame().repaint();

        // ToDo: remove this and run
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    private void checkNewBlockIntersection() {

        BuildingBlock newBlock = game.getGameFrame().getNewBlock();

        // check intersection with simpleBlocks:
        for (SimpleBlock simpleBlock : game.getGameFrame().getSimpleBlocks()) {
            // ToDo: explain why !newBlock.isCaught
            if (game.getIntersection().intersectTop(simpleBlock, newBlock) && !newBlock.isCaught()) {
                // place the block exactly on top the simpleBlock
                newBlock.setY(simpleBlock.getY() - newBlock.getHeight() + 1);
                return;
            }
        }

        // check intersection with other buildingBlocks:
        for (BlockInGame blockInGame : game.getGameFrame().getBlockInGames()) {
            // first check if it has intersection or not,
            // if yes, check intersection from top:
            if (game.getIntersection().intersectTop(blockInGame, newBlock)) {

                // place the block exactly on top the blockInGame
                newBlock.setY(blockInGame.getY() - blockInGame.getHeight());
                // add newBlock to block list
                game.getGameFrame().getBlockInGames().add(newBlock);
                // create another newBlock
                BuildingBlock newNewBlock = new BuildingBlock(GameFrame.newBlockX, GameFrame.newBlockY);
                game.getGameFrame().setNewBlock(newNewBlock);
                // add newNewBlock to gameFrame
                game.getGameFrame().getGamePanel().add(newNewBlock);
                // exit this method
                return;
            }
        }

        // check intersection with spears:
        for (Spear spear : game.getGameFrame().getSpears()) {
            // check if it has intersection,
            // if yes, destroy the block and remove it from gameFrame:
            if (game.getIntersection().intersectTop(spear, newBlock)) {
                // remove the newBlock from gameFrame
                game.getGameFrame().getGamePanel().remove(newBlock);
                // create another newBlock
                BuildingBlock newNewBlock = new BuildingBlock(GameFrame.newBlockX, GameFrame.newBlockY);
                game.getGameFrame().setNewBlock(newNewBlock);
                // add newNewBlock to gameFrame
                game.getGameFrame().getGamePanel().add(newNewBlock);
                // exit this method
                return;
            }
        }

        // if it hits the ground:
        if (newBlock.getY() + newBlock.getHeight() >= GameFrame.groundY) {
            // place the block exactly on top of the ground
            newBlock.setY(GameFrame.groundY);
            // add newBlock to block list
            game.getGameFrame().getBlockInGames().add(newBlock);

            return;
        }

        // ToDo: explain this if
        // else all conditions keep falling:
        if (!newBlock.isCaught() || newBlock.isReleased()) {
            newBlock.gravity();
        }


    }

    private void checkMagnetIntersection() {

        for (SimpleBlock simpleBlock : game.getGameFrame().getSimpleBlocks()) {
            game.getIntersection().intersect(simpleBlock,game.getIntersection().getMagnet());
        }

    }

    private boolean checkEndGame() {
        int minY = GameFrame.groundY;
        for (BlockInGame block : game.getGameFrame().getBlockInGames()) {
            if (block.getY() <= minY) {
                minY = block.getY();
            }
        }
        if (minY <= 250) {
            return true;
        }
        return false;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
