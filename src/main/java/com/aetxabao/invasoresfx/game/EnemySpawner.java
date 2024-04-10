package com.aetxabao.invasoresfx.game;

import com.aetxabao.invasoresfx.game.enums.EEnemyShot;
import com.aetxabao.invasoresfx.game.enums.EEnemyType;
import com.aetxabao.invasoresfx.sprite.*;
import com.aetxabao.invasoresfx.sprite.weaponry.Gun;
import com.aetxabao.invasoresfx.util.Rect;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

import static com.aetxabao.invasoresfx.game.AppConsts.*;
import static com.aetxabao.invasoresfx.game.enums.EEnemyShot.*;
import static com.aetxabao.invasoresfx.game.enums.EEnemyType.*;

public class EnemySpawner {

    //region attributes
    public static int n = 22; //anchura
    public static int m = 28; //altura
    public static int vx = 5;
    public static int vy = 3;
    private static int health;
    //endregion

    /**
     * Transforma una coordenada en una posición
     * @param i coordenada de 0 a n eje horizontal
     * @return posicion x
     */
    private static int getX(Rect gameRect, int i){
        return gameRect.left + i * gameRect.width()/ n;
    }

    /**
     * Transforma una coordenada en una posición
     * @param j coordenada de 0 a m eje vertical
     * @return posicion y
     */
    private static int getY(Rect gameRect, int j){
        return gameRect.top + j*gameRect.height()/ m;
    }

    public static List<AEnemy> createEnemies(Rect gameRect, int level) {
        List<AEnemy> enemies;
        level = level % LEVELS;

        if (hardmode){
            vx = 7;
            health = 3;
        }
        else {
            vx = 5;
            health = 0;
        }

        enemies = switch (level) {
            case 1 -> crearEnemigosNivelDonut(gameRect);
            case 2 -> crearEnemigosNivelPaquito(gameRect);
            case 3 -> crearEnemigosNivelPulpo(gameRect);
            case 4 -> crearEnemigosNivelHoam(gameRect);
            default -> crearEnemigosNivelBoss(gameRect);
        };
        return enemies;
    }

    /**
     * Crea un enemigo en una coordenada (i,j) con una velocidad (vx,vy)
     * @param i coordenada horizontal
     * @param j coordenada vertical
     * @param vx velocidad eje x
     * @param vy velocidad eje y
     * @return una instancia del enemigo
     */
    public static EnemyShip createEnemyShip(EEnemyType type, Image enemyImage, Rect gameRect, int i, int j, int vx, int vy, EEnemyShot shot, int familia, int health) {
        EnemyShip e;
        switch (type){
            case E_DIAGONAL:
                e = new EnemyShipDiagonal(gameRect, enemyImage, TICKSxFRAME, health);
                break;
            case E_BIG:
                e = new EnemyBigRaw(gameRect, enemyImage, TICKSxFRAME, familia, health);
                break;
            case E_BBB:
                e = new EnemyBBB(gameRect, enemyImage, TICKSxFRAME * 2, health);
                break;
            case E_NORMAL:
            default:
                e = new EnemyShip(gameRect, enemyImage, TICKSxFRAME, health);
                break;
        }
        if (shot == E_SHOT_GUN){
            e.setWeapon(new Gun(0));
        }
        else if (shot == E_SHOT_HOAMING){
            e.setWeapon(new Gun(1));
        }
        else if (shot == E_SHOT_HEALTH){
            e.setWeapon(new Gun(2));
        }
        e.setPos(getX(gameRect, i), getY(gameRect, j));
        e.setXSpeed(vx);
        e.setYSpeed(vy);
        return e;
    }



    public static List<AEnemy> crearEnemigosNivelDonut(Rect gameRect) {

        List<AEnemy> enemies = new ArrayList<>();
        enemies.add(createEnemyShip(E_NORMAL, ENEMYSHIP_SPRITE_IMAGE_1, gameRect, 0, 0, vx, 0, E_SHOT_GUN, 0, health));
        enemies.add(createEnemyShip(E_NORMAL, ENEMYSHIP_SPRITE_IMAGE_1, gameRect, 14, 2, -vx, 3, E_SHOT_GUN, 1, health));

        List<EnemyShip> el1 = new ArrayList<>();
        el1.add(createEnemyShip(E_NORMAL, ENEMYSHIP_SPRITE_IMAGE_3, gameRect, 4, 6, 0, 0, E_SHOT_NOTHING, 0, health));
        el1.add(createEnemyShip(E_NORMAL, ENEMYSHIP_SPRITE_IMAGE_3, gameRect, 6, 4, 0, 0, E_SHOT_NOTHING, 1, health));
        el1.add(createEnemyShip(E_NORMAL, ENEMYSHIP_SPRITE_IMAGE_3, gameRect, 8, 4, 0, 0, E_SHOT_NOTHING, 2, health));
        el1.add(createEnemyShip(E_NORMAL, ENEMYSHIP_SPRITE_IMAGE_3, gameRect, 10, 6, 0, 0, E_SHOT_NOTHING, 3, health));
        el1.add(createEnemyShip(E_NORMAL, ENEMYSHIP_SPRITE_IMAGE_3, gameRect, 4, 8, 0, 0, E_SHOT_NOTHING, 4, health));
        el1.add(createEnemyShip(E_NORMAL, ENEMYSHIP_SPRITE_IMAGE_3, gameRect, 6, 10, 0, 0, E_SHOT_NOTHING, 5, health));
        el1.add(createEnemyShip(E_NORMAL, ENEMYSHIP_SPRITE_IMAGE_3, gameRect, 8, 10, 0, 0, E_SHOT_NOTHING, 6, health));
        el1.add(createEnemyShip(E_NORMAL, ENEMYSHIP_SPRITE_IMAGE_3, gameRect, 10, 8, 0, 0, E_SHOT_NOTHING, 7, health));
        EnemyShipGroup eg1 = new EnemyShipGroup(gameRect, el1, health);
        eg1.setXSpeed(vx);
        enemies.add(eg1);
        return enemies;
    }

    public static List<AEnemy> crearEnemigosNivelPaquito(Rect gameRect) {
        List<AEnemy> enemies = new ArrayList<>();
        enemies.add(createEnemyShip(E_NORMAL, ENEMYSHIP_SPRITE_IMAGE_2, gameRect, 0, 0, vx, 0, E_SHOT_GUN, 0, health));
        enemies.add(createEnemyShip(E_NORMAL, ENEMYSHIP_SPRITE_IMAGE_2, gameRect, 14, 2, -vx, 0, E_SHOT_GUN, 1, health));
        enemies.add(createEnemyShip(E_NORMAL, ENEMYSHIP_SPRITE_IMAGE_2, gameRect, 6, 4, vx, 0, E_SHOT_GUN, 2, health));
        enemies.add(createEnemyShip(E_NORMAL, ENEMYSHIP_SPRITE_IMAGE_2, gameRect, 8, 6, -vx, 0, E_SHOT_GUN, 3, health));
        List<EnemyShip> el1 = new ArrayList<>();
        el1.add(createEnemyShip(E_NORMAL, ENEMYSHIP_SPRITE_IMAGE_1, gameRect, 4, 8, vx, 0, E_SHOT_NOTHING, 4, health));
        el1.add(createEnemyShip(E_NORMAL, ENEMYSHIP_SPRITE_IMAGE_1, gameRect, 6, 8, vx, 0, E_SHOT_NOTHING, 5, health));
        el1.add(createEnemyShip(E_NORMAL, ENEMYSHIP_SPRITE_IMAGE_1, gameRect, 8, 8, vx, 0, E_SHOT_NOTHING, 6, health));
        el1.add(createEnemyShip(E_NORMAL, ENEMYSHIP_SPRITE_IMAGE_1, gameRect, 10, 8, vx, 0, E_SHOT_NOTHING, 7, health));

        EnemyShipGroup eg1 = new EnemyShipGroup(gameRect, el1, health);
        eg1.setXSpeed(vx);
        enemies.add(eg1);
        return enemies;
    }

    public static List<AEnemy> crearEnemigosNivelPulpo(Rect gameRect) {
        List<AEnemy> enemies = new ArrayList<>();
        enemies.add(createEnemyShip(E_NORMAL, ENEMYSHIP_SPRITE_IMAGE_2, gameRect, 0, 0, vx, 0, E_SHOT_GUN, 0, health));
        enemies.add(createEnemyShip(E_NORMAL, ENEMYSHIP_SPRITE_IMAGE_2, gameRect, 14, 2, -vx, 0, E_SHOT_GUN, 1, health));
        enemies.add(createEnemyShip(E_DIAGONAL, ENEMYSHIP_SPRITE_IMAGE_2, gameRect, 0, 0, vx, vy, E_SHOT_NOTHING, 2, health));
        enemies.add(createEnemyShip(E_DIAGONAL, ENEMYSHIP_SPRITE_IMAGE_2, gameRect, 14, 0, -vx, vy, E_SHOT_NOTHING, 3, health));
        enemies.add(createEnemyShip(E_DIAGONAL, ENEMYSHIP_SPRITE_IMAGE_2, gameRect, 6, 0, -vx, vy, E_SHOT_NOTHING, 4, health));
        enemies.add(createEnemyShip(E_DIAGONAL, ENEMYSHIP_SPRITE_IMAGE_2, gameRect, 8, 0, vx, vy, E_SHOT_NOTHING, 5, health));
        return enemies;
    }

    public static List<AEnemy> crearEnemigosNivelHoam(Rect gameRect) {
        health = health + 2;
        List<AEnemy> enemies = new ArrayList<>();

        enemies.add(createEnemyShip(E_BIG, ENEMYSHIP_SPRITE_IMAGE_4_top,    gameRect, 14, 4, -vx , 0, E_SHOT_HOAMING, 0, health));
        enemies.add(createEnemyShip(E_BIG, ENEMYSHIP_SPRITE_IMAGE_4_bottom, gameRect, 14, 5, -vx, 3, E_SHOT_HOAMING, 0, health));
        enemies.add(createEnemyShip(E_BIG, ENEMYSHIP_SPRITE_IMAGE_4_top,    gameRect, 6, 1, vx, 0, E_SHOT_HOAMING, 1, health));
        enemies.add(createEnemyShip(E_BIG, ENEMYSHIP_SPRITE_IMAGE_4_bottom, gameRect, 6, 2, vx, 3, E_SHOT_HOAMING, 1, health));

        enemies.add(createEnemyShip(E_BIG, ENEMYSHIP_SPRITE_IMAGE_4_top,    gameRect, 18, 10, -vx, 0, E_SHOT_HOAMING, 2, health));
        enemies.add(createEnemyShip(E_BIG, ENEMYSHIP_SPRITE_IMAGE_4_bottom, gameRect, 18, 11, -vx, 3, E_SHOT_HOAMING, 2, health));
        enemies.add(createEnemyShip(E_BIG, ENEMYSHIP_SPRITE_IMAGE_4_top,    gameRect, 2, 7, vx, 0, E_SHOT_HOAMING, 3, health));
        enemies.add(createEnemyShip(E_BIG, ENEMYSHIP_SPRITE_IMAGE_4_bottom, gameRect, 2, 8, vx, 3, E_SHOT_HOAMING, 3, health));

        enemies.add(createEnemyShip(E_BIG, ENEMYSHIP_SPRITE_IMAGE_4_top,    gameRect, 6, 13, vx, 0, E_SHOT_HOAMING, 5, health));
        enemies.add(createEnemyShip(E_BIG, ENEMYSHIP_SPRITE_IMAGE_4_bottom, gameRect, 6, 14, vx, 3, E_SHOT_HOAMING, 5, health));
        enemies.add(createEnemyShip(E_BIG, ENEMYSHIP_SPRITE_IMAGE_4_top,    gameRect, 14, 16, -vx, 0, E_SHOT_HOAMING, 6, health));
        enemies.add(createEnemyShip(E_BIG, ENEMYSHIP_SPRITE_IMAGE_4_bottom, gameRect, 14, 17, -vx, 3, E_SHOT_HOAMING, 6, health));


        enemies.add(createEnemyShip(E_BIG, ENEMYSHIP_SPRITE_IMAGE_5_left,    gameRect, 2, 0, -vx, 0, E_SHOT_HEALTH, 7, health));
        enemies.add(createEnemyShip(E_BIG, ENEMYSHIP_SPRITE_IMAGE_5_middle,    gameRect, 3, 0, -vx, 0, E_SHOT_NOTHING, 7, health));
        enemies.add(createEnemyShip(E_BIG, ENEMYSHIP_SPRITE_IMAGE_5_right,    gameRect, 4, 0, -vx, 0, E_SHOT_HEALTH, 7, health));

        enemies.add(createEnemyShip(E_BIG, ENEMYSHIP_SPRITE_IMAGE_5_left,    gameRect, 15, 0, vx, 0, E_SHOT_HEALTH, 8, health));
        enemies.add(createEnemyShip(E_BIG, ENEMYSHIP_SPRITE_IMAGE_5_middle,    gameRect, 16, 0, vx, 0, E_SHOT_NOTHING, 8, health));
        enemies.add(createEnemyShip(E_BIG, ENEMYSHIP_SPRITE_IMAGE_5_right,    gameRect, 17, 0, vx, 0, E_SHOT_HEALTH, 8, health));


        return enemies;
    }


    public  static List<AEnemy> crearEnemigosNivelBoss(Rect gameRect){
        List<AEnemy> enemies = new ArrayList<>();
        if (hardmode){
            health = 50;
        }

        enemies.add(createEnemyShip(E_BBB, ENEMYSHIP_SPRITE_IMAGE_BOSS,    gameRect, 1, 0, 0, 0, E_SHOT_NOTHING, 3, health + 100));

        health = 3;
        return enemies;
    }

    public static List<AEnemy> crearEnemigosNiveltest(Rect gameRect) {
        List<AEnemy> enemies = new ArrayList<>();

        enemies.add(createEnemyShip(E_BIG, ENEMYSHIP_SPRITE_IMAGE_5_left,    gameRect, 5, 2, vx, 0, E_SHOT_HEALTH, 1, 0));
        enemies.add(createEnemyShip(E_BIG, ENEMYSHIP_SPRITE_IMAGE_5_middle,    gameRect, 6, 2, vx, 0, E_SHOT_NOTHING, 1, 0));
        enemies.add(createEnemyShip(E_BIG, ENEMYSHIP_SPRITE_IMAGE_5_right,    gameRect, 7, 2, vx, 0, E_SHOT_HEALTH, 1, 0));

        enemies.add(createEnemyShip(E_BIG, ENEMYSHIP_SPRITE_IMAGE_test1,    gameRect, 5, 8, vx, 0, E_SHOT_NOTHING, 0, 0));
        enemies.add(createEnemyShip(E_BIG, ENEMYSHIP_SPRITE_IMAGE_test2,    gameRect, 6, 8, vx, 3, E_SHOT_NOTHING, 0, 0));
        enemies.add(createEnemyShip(E_BIG, ENEMYSHIP_SPRITE_IMAGE_test1,    gameRect, 7, 8, vx, 0, E_SHOT_NOTHING, 0, 0));
        enemies.add(createEnemyShip(E_BIG, ENEMYSHIP_SPRITE_IMAGE_test2,    gameRect, 5, 9, vx, 0, E_SHOT_NOTHING, 0, 0));
        enemies.add(createEnemyShip(E_BIG, ENEMYSHIP_SPRITE_IMAGE_test1,    gameRect, 6, 9, vx, 3, E_SHOT_NOTHING, 0, 0));
        enemies.add(createEnemyShip(E_BIG, ENEMYSHIP_SPRITE_IMAGE_test2,    gameRect, 7, 9, vx, 0, E_SHOT_NOTHING, 0, 0));
        enemies.add(createEnemyShip(E_BIG, ENEMYSHIP_SPRITE_IMAGE_test1,    gameRect, 5, 10, vx, 0, E_SHOT_NOTHING, 0, 0));
        enemies.add(createEnemyShip(E_BIG, ENEMYSHIP_SPRITE_IMAGE_test2,    gameRect, 6, 10, vx, 3, E_SHOT_NOTHING, 0, 0));
        enemies.add(createEnemyShip(E_BIG, ENEMYSHIP_SPRITE_IMAGE_test1,    gameRect, 7, 10, vx, 0, E_SHOT_NOTHING, 0, 0));



        return enemies;
    }

    public static List<AEnemy> crearEnemigosNivel5(Rect gameRect) {
        List<AEnemy> enemies = new ArrayList<>();

        enemies.add(createEnemyShip(E_BIG, ENEMYSHIP_SPRITE_IMAGE_5_left,    gameRect, 2, 2, vx, 0, E_SHOT_HEALTH, 1, health));
        enemies.add(createEnemyShip(E_BIG, ENEMYSHIP_SPRITE_IMAGE_5_middle,    gameRect, 3, 2, vx, 0, E_SHOT_NOTHING, 1, health));
        enemies.add(createEnemyShip(E_BIG, ENEMYSHIP_SPRITE_IMAGE_5_right,    gameRect, 4, 2, vx, 0, E_SHOT_HEALTH, 1, health));

        enemies.add(createEnemyShip(E_BIG, ENEMYSHIP_SPRITE_IMAGE_5_left,    gameRect, 8, 2, vx, 0, E_SHOT_HEALTH, 2, health));
        enemies.add(createEnemyShip(E_BIG, ENEMYSHIP_SPRITE_IMAGE_5_middle,    gameRect, 9, 2, vx, 0, E_SHOT_NOTHING, 2, health));
        enemies.add(createEnemyShip(E_BIG, ENEMYSHIP_SPRITE_IMAGE_5_right,    gameRect, 10, 2, vx, 0, E_SHOT_HEALTH, 2, health));

        enemies.add(createEnemyShip(E_BIG, ENEMYSHIP_SPRITE_IMAGE_5_left,    gameRect, 5, 5, vx, 0, E_SHOT_HEALTH, 3, health));
        enemies.add(createEnemyShip(E_BIG, ENEMYSHIP_SPRITE_IMAGE_5_middle,    gameRect, 6, 5, vx, 0, E_SHOT_NOTHING, 3, health));
        enemies.add(createEnemyShip(E_BIG, ENEMYSHIP_SPRITE_IMAGE_5_right,    gameRect, 7, 5, vx, 0, E_SHOT_HEALTH, 3, health));

        return enemies;
    }

}
