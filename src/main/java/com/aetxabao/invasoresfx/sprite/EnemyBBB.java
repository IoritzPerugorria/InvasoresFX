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
        int xPosicion = (random.nextInt(15) + 3);
        contadorFrame ++;
        ArrayList<AEnemy> enemigos = new ArrayList<>();

        if (contadorFrame == (GAME_SPEED)){
            switch (random.nextInt(4)){
                case 0 -> {
                    enemigos.add(new EnemyShip(gameRect, ENEMYSHIP_SPRITE_IMAGE_1, 3, 0));
                    enemigos.getFirst().setPos(gameRect.left + xPosicion * gameRect.width()/ 22, gameRect.top + 8*gameRect.height()/ 28);
                    enemigos.getFirst().setWeapon(new Gun(0));
                    if (random.nextInt(2) == 0){
                        enemigos.getFirst().setXSpeed(vx);
                    }
                    else{
                        enemigos.getFirst().setXSpeed(-vx);
                    }
                }
                case 1 -> {
                    enemigos.add(new EnemyShipDiagonal(gameRect, ENEMYSHIP_SPRITE_IMAGE_2, 3, 0));
                    enemigos.getFirst().setPos(gameRect.left + xPosicion * gameRect.width()/ 22, gameRect.top + 8*gameRect.height()/ 28);
                    enemigos.getFirst().setWeapon(new Gun(0));
                    enemigos.getFirst().setYSpeed(3);
                    enemigos.getFirst().setWeapon(new Gun(0));
                    if (random.nextInt(2) == 0){
                        enemigos.getFirst().setXSpeed(vx);
                    }
                    else{
                        enemigos.getFirst().setXSpeed(-vx);
                    }

                }
                case 2 -> {
                    enemigos.add(new EnemyBigRaw(gameRect, ENEMYSHIP_SPRITE_IMAGE_4_top, 3,numFamiliar, 0));
                    enemigos.add(new EnemyBigRaw(gameRect, ENEMYSHIP_SPRITE_IMAGE_4_bottom, 3,numFamiliar, 0));
                    enemigos.getLast().setWeapon(new Gun(1));
                    enemigos.getFirst().setPos(gameRect.left + xPosicion * gameRect.width()/ 22, gameRect.top + 8*gameRect.height()/ 28);
                    enemigos.getLast().setPos(gameRect.left + xPosicion * gameRect.width()/ 22, (gameRect.top + 9*gameRect.height()/ 28));
                    if (random.nextInt(2) == 0){
                        enemigos.getFirst().setXSpeed(vx);
                        enemigos.getLast().setXSpeed(vx);
                    }
                    else{
                        enemigos.getFirst().setXSpeed(-vx);
                        enemigos.getLast().setXSpeed(-vx);
                    }
                    numFamiliar ++;
                }

                default -> {
                    enemigos.add(new EnemyBigRaw(gameRect, ENEMYSHIP_SPRITE_IMAGE_5_left, 3,numFamiliar, 0));
                    enemigos.add(new EnemyBigRaw(gameRect, ENEMYSHIP_SPRITE_IMAGE_5_middle, 3,numFamiliar, 0));
                    enemigos.add(new EnemyBigRaw(gameRect, ENEMYSHIP_SPRITE_IMAGE_5_right, 3,numFamiliar, 0));
                    enemigos.getFirst().setWeapon(new Gun(2));
                    enemigos.getLast().setWeapon(new Gun(2));
                    enemigos.getFirst().setPos(gameRect.left + (xPosicion - 1) * gameRect.width()/ 22, gameRect.top + 8 * gameRect.height()/ 28);
                    enemigos.get(1).setPos(gameRect.left + (xPosicion) * gameRect.width()/ 22, gameRect.top + 8 * gameRect.height()/ 28);
                    enemigos.getLast().setPos(gameRect.left + (xPosicion + 1) * gameRect.width()/ 22, (gameRect.top + 8 * gameRect.height()/ 28));
                    if (random.nextInt(2) == 0){
                        enemigos.getFirst().setXSpeed(vx);
                        enemigos.get(1).setXSpeed(vx);
                        enemigos.getLast().setXSpeed(vx);
                    }
                    else{
                        enemigos.getFirst().setXSpeed(-vx);
                        enemigos.get(1).setXSpeed(-vx);
                        enemigos.getLast().setXSpeed(-vx);
                    }
                    numFamiliar ++;
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
