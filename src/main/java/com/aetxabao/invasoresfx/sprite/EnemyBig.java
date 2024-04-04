package com.aetxabao.invasoresfx.sprite;

import com.aetxabao.invasoresfx.util.Rect;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import static com.aetxabao.invasoresfx.game.AppConsts.*;

public class EnemyBig extends EnemyShip{

    int familia;

    public EnemyBig(Rect gameRect, Image img, int N, int familia) {
        super(gameRect, img, N);
        this.familia = familia;
    }

    public int getFamilia(){
        return familia;
    }
}
