package com.aetxabao.invasoresfx.sprite.weaponry;

import com.aetxabao.invasoresfx.sprite.IHaveShield;
import javafx.scene.image.Image;

/**
 * Disparo descendente sin animación
 */
public class Cannonball_Health extends Cannonball implements IHaveShield {

    int health;
    public Cannonball_Health(Image img, int health) {
        super(img);
        this.health = health;
    }

    @Override
    public boolean impact() {
        health --;
        return health <= 0;
    }
}
