package com.aetxabao.invasoresfx.sprite;

import com.aetxabao.invasoresfx.util.Rect;
import javafx.scene.image.Image;
import org.apache.log4j.Logger;

public class EnemyShipDiagonal extends EnemyShip implements IHaveShield {
    private static Logger log = Logger.getLogger(EnemyShipDiagonal.class);
    public EnemyShipDiagonal(Rect gameRect, Image img, int N, int health) {
        super(gameRect, img, N, health);
        log.debug("EnemyShipDiagonal N="+N);
    }

    @Override
    public void update() {
        if (x > gameRect.right - width - xSpeed || x + xSpeed < gameRect.left) {
            xSpeed = -xSpeed;
        }
        x = x + xSpeed;
        y = y + ySpeed;
        updateFrame();
    }

}