package org.lava.trender.controller;

import static java.awt.event.KeyEvent.*;

import org.lava.trender.model.Level;
import org.lava.trender.model.Player;

public class Game {
    private static Game instance = null;

    public Level level;
    public Player player;
    public int time;

    private Game() {
        level = Level.loadLevel("level1");
        player = Player.getInstance(this);
    }

    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    public void update(boolean[] keys) {
        ++time;

        boolean up = keys[VK_W];
        boolean down = keys[VK_S];
        boolean left = keys[VK_A];
        boolean right = keys[VK_D];
        boolean turnLeft = keys[VK_Q];
        boolean turnRight = keys[VK_E];

        player.update(up, down, left, right, turnLeft, turnRight);
    }
}
