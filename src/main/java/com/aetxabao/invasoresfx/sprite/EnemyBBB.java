package com.aetxabao.invasoresfx.sprite;

import com.aetxabao.invasoresfx.sprite.weaponry.Gun;
import com.aetxabao.invasoresfx.util.Rect;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.aetxabao.invasoresfx.game.AppConsts.*;
import static com.aetxabao.invasoresfx.game.EnemySpawner.vx;

public class EnemyBBB extends EnemyShip implements ICanSpawn{
    int contadorFrame = 0;
    int numFamiliar = 0;
    public EnemyBBB(Rect gameRect, Image img, int N, int health) {
        super(gameRect, img, N,  health);
    }


    @Override
    public List<AEnemy> spawn(){
        Random random = new Random();
        contadorFrame ++;
        ArrayList<AEnemy> enemigos = new ArrayList<>();

        if (contadorFrame == 90){
            switch (random.nextInt(4)){
                case 0 -> {
                    enemigos.add(new EnemyShip(gameRect, ENEMYSHIP_SPRITE_IMAGE_1, n, 0));
                    enemigos.getFirst().setPos(gameRect.left + 8 * gameRect.width()/ 22, gameRect.top + 8*gameRect.height()/ 28);
                    enemigos.getFirst().setWeapon(new Gun(0));
                }
                case 1 -> {
                    enemigos.add(new EnemyShipDiagonal(gameRect, ENEMYSHIP_SPRITE_IMAGE_2, n, 0));
                    enemigos.getFirst().setPos(gameRect.left + 8 * gameRect.width()/ 22, gameRect.top + 8*gameRect.height()/ 28);
                    enemigos.getFirst().setWeapon(new Gun(0));
                    enemigos.getFirst().setYSpeed(3);
                }
                case 2 -> {
                    enemigos.add(new EnemyBigRaw(gameRect, ENEMYSHIP_SPRITE_IMAGE_4_top, n,numFamiliar, 0));
                    enemigos.add(new EnemyBigRaw(gameRect, ENEMYSHIP_SPRITE_IMAGE_4_bottom, n,numFamiliar, 0));
                    enemigos.getLast().setWeapon(new Gun(1));
                    enemigos.getFirst().setPos(gameRect.left + 8 * gameRect.width()/ 22, gameRect.top + 8*gameRect.height()/ 28);
                    enemigos.getLast().setPos(gameRect.left + 8 * gameRect.width()/ 22, (gameRect.top + 9*gameRect.height()/ 28));
                    numFamiliar ++;

                }
                case 3 ->{
                    enemigos.add(new EnemyShip(gameRect, ENEMYSHIP_SPRITE_IMAGE_1, n, 0));

                }

                default -> {
                    enemigos.add(new EnemyShip(gameRect, ENEMYSHIP_SPRITE_IMAGE_1, n, 0));

                }
            }



            contadorFrame = 1;

        }

        return enemigos;
    }

    @Override
    public void update() {
        updateFrame();
    }
}
