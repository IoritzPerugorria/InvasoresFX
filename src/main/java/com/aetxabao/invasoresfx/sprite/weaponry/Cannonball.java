package com.aetxabao.invasoresfx.sprite.weaponry;

import javafx.scene.image.Image;

import static com.aetxabao.invasoresfx.game.AppConsts.hardmode;

/**
 * Clase abstracta para diferentes tipos de disparos
 */
public abstract class Cannonball extends AShot {

    // region attributes
    static int ROWS = 1;
    static int COLS = 1;
    static final int MAX_SPEED = 10;
    //endregion

    public Cannonball(Image img) {
        super(img,ROWS,COLS);
        xSpeed = 0;
        if(hardmode){
            ySpeed = MAX_SPEED + (MAX_SPEED / 2);
        }
        else{
            ySpeed = MAX_SPEED;
        }
    }

    public void update() {
        x = x + xSpeed;
        y = y + ySpeed;
    }
}
