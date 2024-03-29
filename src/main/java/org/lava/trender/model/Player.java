package org.lava.trender.model;

import org.lava.trender.controller.Game;

public class Player {

    private static Player instance = null;

    public Game game;
    public Level level;
    public double x, y, xa, ya, ra, rot;

    private Player(Game game) {
        this.game = game;
        this.level = game.level;
        this.x = level.xSpawn;
        this.y = level.ySpawn;
        rot = -Math.PI / 2.0;
    }

    public static Player getInstance(Game game) {
        if (instance == null) {
            instance = new Player(game);
        }
        return instance;
    }

    public void update(boolean up, boolean down, boolean left, boolean right, boolean turnLeft, boolean turnRight) {
        double wSpeed = 0.03;
        double rSpeed = 0.03;

        double xd = 0;
        double yd = 0;

        if (up)
            ++yd;
        if (down)
            --yd;
        if (left)
            --xd;
        if (right)
            ++xd;
        if (turnLeft)
            ++ra;
        if (turnRight)
            --ra;

        double rCos = Math.cos(rot);
        double rSin = Math.sin(rot);

        xa += (xd * rCos + yd * -rSin) * wSpeed;
        ya += (xd * rSin + yd * rCos) * wSpeed;
        rot += ra * rSpeed;

        if (isFree(x + xa, y))
            x += xa;
        if (isFree(x, y + ya))
            y += ya;

        xa *= 0.6;
        ya *= 0.6;
        ra *= 0.6;
    }

    public boolean isFree(double xx, double yy) {
        double d = 0.15;

        int x0 = (int) (Math.round(xx - d));
        int x1 = (int) (Math.round(xx + d));
        int y0 = (int) (Math.round(yy - d));
        int y1 = (int) (Math.round(yy + d));

        if (level.getBlock(x0, y0).isSolidMotion())
            return false;
        if (level.getBlock(x1, y0).isSolidMotion())
            return false;
        if (level.getBlock(x0, y1).isSolidMotion())
            return false;
        if (level.getBlock(x1, y1).isSolidMotion())
            return false;

        return true;
    }
}
