package com.aetxabao.invasoresfx.sprite;

import com.aetxabao.invasoresfx.game.AppInvasoresFx;
import com.aetxabao.invasoresfx.game.EnemySpawner;
import com.aetxabao.invasoresfx.game.GameManager;
import com.aetxabao.invasoresfx.game.Renderer;
import com.aetxabao.invasoresfx.util.Rect;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

import static com.aetxabao.invasoresfx.game.AppConsts.ENEMYSHIP_SPRITE_IMAGE_1;
import static com.aetxabao.invasoresfx.game.AppConsts.ENEMYSHIP_SPRITE_IMAGE_5_middle;
import static com.aetxabao.invasoresfx.game.enums.EEnemyShot.E_SHOT_GUN;
import static com.aetxabao.invasoresfx.game.enums.EEnemyType.E_NORMAL;


public class EnemyBig extends EnemyShip implements IHaveShield{

    int contador = 1;
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

        if(contador / 30 == 0){
            contador = 1;
        }
        else{
            contador ++;
        }

        //AEnemy enemy = EnemySpawner.createEnemyShip(E_NORMAL, ENEMYSHIP_SPRITE_IMAGE_1, gameRect, x, y - 1, 5, 0, E_SHOT_GUN, 0);
        //Renderer.drawSummonedEnemy(enemy);

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

    @Override
    public boolean impact() {
        return false;
    }
}