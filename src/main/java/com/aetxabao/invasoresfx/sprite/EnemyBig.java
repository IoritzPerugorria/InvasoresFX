package com.aetxabao.invasoresfx.sprite;

import com.aetxabao.invasoresfx.game.GameManager;
import com.aetxabao.invasoresfx.util.Rect;
import javafx.scene.image.Image;


public class EnemyBig extends EnemyShip{

    int familia;

    public EnemyBig(Rect gameRect, Image img, int N, int familia) {
        super(gameRect, img, N);
        this.familia = familia;
    }

    public int getFamilia(){
        return familia;
    }

    @Override
    public void update() {

        if (x + xSpeed> gameRect.right - width) {
            x = x + (xSpeed * 2);
            xSpeed = -xSpeed;
            y = y + height;

            this.updateSiblings();


            x = x + (xSpeed * 2);

        }
        else if(x + xSpeed < gameRect.left){
            xSpeed = -xSpeed;
            y = y + height;

            this.updateSiblings();
        }
        x = x + xSpeed;
        updateFrame();
    }

    public void updateSiblings(){
        for (AEnemy enemigo : GameManager.getEnemies()) {
            if (enemigo.hashCode() != this.hashCode()) {
                if (enemigo instanceof EnemyBig) {
                    if (((EnemyBig) enemigo).getFamilia() == this.getFamilia()) {
                        enemigo.xSpeed = -enemigo.xSpeed;
                        enemigo.y = enemigo.y + enemigo.height;
                        if (x + xSpeed> gameRect.right - width) {
                            if (enemigo.y == y){
                                enemigo.x = enemigo.x + (enemigo.xSpeed * 2);
                            }
                        }
                    }
                }
            }

        }
    }
}