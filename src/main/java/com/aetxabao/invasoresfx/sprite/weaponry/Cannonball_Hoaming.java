package com.aetxabao.invasoresfx.sprite.weaponry;

import com.aetxabao.invasoresfx.game.GameManager;
import com.aetxabao.invasoresfx.sprite.ASprite;

import javafx.scene.image.Image;

/**
 * Disparo descendente sin animación
 */
public class Cannonball_Hoaming extends Cannonball {

    public Cannonball_Hoaming(Image img) {
        super(img);
    }

    public void hoam(){
        if (this.x < GameManager.getShip().getX()){
            xSpeed = 2;
        }
        else{
            xSpeed = -2;
        }
    }
}
