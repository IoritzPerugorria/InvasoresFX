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
    public static int n = 18;
    public static int m = 31;
    public static int vx = 5;
    public static int vy = 3;
    public static int ticks = 100;
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
        List<AEnemy> enemies = new ArrayList<>();
        level = level % LEVELS;

        switch (level){
            case 1:
                enemies = crearEnemigosNivelHoam(gameRect);

                break;
            case 2:
                enemies = crearEnemigosNivelPaquito(gameRect);
                break;
            case 3:
                enemies = crearEnemigosNivelDonut(gameRect);
                break;
            default:
                enemies = crearEnemigosNivelPulpo(gameRect);
                break;
        }
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
    public static EnemyShip createEnemyShip(EEnemyType type, Image enemyImage, Rect gameRect, int i, int j, int vx, int vy, EEnemyShot shot, int familia) {
        EnemyShip e;
        switch (type){
            case E_DIAGONAL:
                e = new EnemyShipDiagonal(gameRect, enemyImage, TICKSxFRAME);
                break;
            case E_BIG:
                e = new EnemyBig(gameRect, enemyImage, TICKSxFRAME, familia);
                break;
            case E_NORMAL:
            default:
                e = new EnemyShip(gameRect, enemyImage, TICKSxFRAME);
                break;
        }
        if (shot == E_SHOT_GUN){
            e.setWeapon(new Gun(0));
        }
        else if (shot == E_SHOT_HOAMING){
            e.setWeapon(new Gun(1));
        }
        e.setPos(getX(gameRect, i), getY(gameRect, j));
        e.setXSpeed(vx);
        e.setYSpeed(vy);
        return e;
    }



    public static List<AEnemy> crearEnemigosNivelDonut(Rect gameRect) {
        List<AEnemy> enemies = new ArrayList<>();
        enemies.add(createEnemyShip(E_NORMAL, ENEMYSHIP_SPRITE_IMAGE_1, gameRect, 0, 0, vx, 0, E_SHOT_GUN, 0));
        enemies.add(createEnemyShip(E_NORMAL, ENEMYSHIP_SPRITE_IMAGE_1, gameRect, 14, 2, -vx, 3, E_SHOT_GUN, 1));

        List<EnemyShip> el1 = new ArrayList<>();
        el1.add(createEnemyShip(E_NORMAL, ENEMYSHIP_SPRITE_IMAGE_3, gameRect, 4, 6, 0, 0, E_SHOT_NOTHING, 0));
        el1.add(createEnemyShip(E_NORMAL, ENEMYSHIP_SPRITE_IMAGE_3, gameRect, 6, 4, 0, 0, E_SHOT_NOTHING, 1));
        el1.add(createEnemyShip(E_NORMAL, ENEMYSHIP_SPRITE_IMAGE_3, gameRect, 8, 4, 0, 0, E_SHOT_NOTHING, 2));
        el1.add(createEnemyShip(E_NORMAL, ENEMYSHIP_SPRITE_IMAGE_3, gameRect, 10, 6, 0, 0, E_SHOT_NOTHING, 3));
        el1.add(createEnemyShip(E_NORMAL, ENEMYSHIP_SPRITE_IMAGE_3, gameRect, 4, 8, 0, 0, E_SHOT_NOTHING, 4));
        el1.add(createEnemyShip(E_NORMAL, ENEMYSHIP_SPRITE_IMAGE_3, gameRect, 6, 10, 0, 0, E_SHOT_NOTHING, 5));
        el1.add(createEnemyShip(E_NORMAL, ENEMYSHIP_SPRITE_IMAGE_3, gameRect, 8, 10, 0, 0, E_SHOT_NOTHING, 6));
        el1.add(createEnemyShip(E_NORMAL, ENEMYSHIP_SPRITE_IMAGE_3, gameRect, 10, 8, 0, 0, E_SHOT_NOTHING, 7));
        EnemyShipGroup eg1 = new EnemyShipGroup(gameRect, el1);
        eg1.setXSpeed(vx);
        enemies.add(eg1);
        return enemies;
    }

    public static List<AEnemy> crearEnemigosNivelPaquito(Rect gameRect) {
        List<AEnemy> enemies = new ArrayList<>();
        enemies.add(createEnemyShip(E_NORMAL, ENEMYSHIP_SPRITE_IMAGE_2, gameRect, 0, 0, vx, 0, E_SHOT_GUN, 0));
        enemies.add(createEnemyShip(E_NORMAL, ENEMYSHIP_SPRITE_IMAGE_2, gameRect, 14, 2, -vx, 0, E_SHOT_GUN, 1));
        enemies.add(createEnemyShip(E_NORMAL, ENEMYSHIP_SPRITE_IMAGE_2, gameRect, 6, 4, vx, 0, E_SHOT_GUN, 2));
        enemies.add(createEnemyShip(E_NORMAL, ENEMYSHIP_SPRITE_IMAGE_2, gameRect, 8, 6, -vx, 0, E_SHOT_GUN, 3));
        List<EnemyShip> el1 = new ArrayList<>();
        el1.add(createEnemyShip(E_NORMAL, ENEMYSHIP_SPRITE_IMAGE_1, gameRect, 4, 8, vx, 0, E_SHOT_NOTHING, 4));
        el1.add(createEnemyShip(E_NORMAL, ENEMYSHIP_SPRITE_IMAGE_1, gameRect, 6, 8, vx, 0, E_SHOT_NOTHING, 5));
        el1.add(createEnemyShip(E_NORMAL, ENEMYSHIP_SPRITE_IMAGE_1, gameRect, 8, 8, vx, 0, E_SHOT_NOTHING, 6));
        el1.add(createEnemyShip(E_NORMAL, ENEMYSHIP_SPRITE_IMAGE_1, gameRect, 10, 8, vx, 0, E_SHOT_NOTHING, 7));

        EnemyShipGroup eg1 = new EnemyShipGroup(gameRect, el1);
        eg1.setXSpeed(vx);
        enemies.add(eg1);
        return enemies;
    }

    public static List<AEnemy> crearEnemigosNivelPulpo(Rect gameRect) {
        List<AEnemy> enemies = new ArrayList<>();
        enemies.add(createEnemyShip(E_NORMAL, ENEMYSHIP_SPRITE_IMAGE_2, gameRect, 0, 0, vx, 0, E_SHOT_GUN, 0));
        enemies.add(createEnemyShip(E_NORMAL, ENEMYSHIP_SPRITE_IMAGE_2, gameRect, 14, 2, -vx, 0, E_SHOT_GUN, 1));
        enemies.add(createEnemyShip(E_DIAGONAL, ENEMYSHIP_SPRITE_IMAGE_2, gameRect, 0, 0, vx, vy, E_SHOT_NOTHING, 2));
        enemies.add(createEnemyShip(E_DIAGONAL, ENEMYSHIP_SPRITE_IMAGE_2, gameRect, 14, 0, -vx, vy, E_SHOT_NOTHING, 3));
        enemies.add(createEnemyShip(E_DIAGONAL, ENEMYSHIP_SPRITE_IMAGE_2, gameRect, 6, 0, -vx, vy, E_SHOT_NOTHING, 4));
        enemies.add(createEnemyShip(E_DIAGONAL, ENEMYSHIP_SPRITE_IMAGE_2, gameRect, 8, 0, vx, vy, E_SHOT_NOTHING, 5));
        return enemies;
    }

    public static List<AEnemy> crearEnemigosNivelHoam(Rect gameRect) {
        List<AEnemy> enemies = new ArrayList<>();

        enemies.add(createEnemyShip(E_BIG, ENEMYSHIP_SPRITE_IMAGE_4_top,    gameRect, 11, 2, vx, 0, E_SHOT_HOAMING, 0));
        enemies.add(createEnemyShip(E_BIG, ENEMYSHIP_SPRITE_IMAGE_4_bottom, gameRect, 11, 3, vx, 3, E_SHOT_HOAMING, 0));
        enemies.add(createEnemyShip(E_BIG, ENEMYSHIP_SPRITE_IMAGE_4_top,    gameRect, 5, 2, vx, 0, E_SHOT_HOAMING, 1));
        enemies.add(createEnemyShip(E_BIG, ENEMYSHIP_SPRITE_IMAGE_4_bottom, gameRect, 5, 3, vx, 3, E_SHOT_HOAMING, 1));

        enemies.add(createEnemyShip(E_BIG, ENEMYSHIP_SPRITE_IMAGE_4_top,    gameRect, 14, 5, vx, 0, E_SHOT_HOAMING, 2));
        enemies.add(createEnemyShip(E_BIG, ENEMYSHIP_SPRITE_IMAGE_4_bottom, gameRect, 14, 6, vx, 3, E_SHOT_HOAMING, 2));
        enemies.add(createEnemyShip(E_BIG, ENEMYSHIP_SPRITE_IMAGE_4_top,    gameRect, 2, 5, vx, 0, E_SHOT_HOAMING, 3));
        enemies.add(createEnemyShip(E_BIG, ENEMYSHIP_SPRITE_IMAGE_4_bottom, gameRect, 2, 6, vx, 3, E_SHOT_HOAMING, 3));
        enemies.add(createEnemyShip(E_BIG, ENEMYSHIP_SPRITE_IMAGE_4_top,    gameRect, 8, 5, vx, 0, E_SHOT_HOAMING, 4));
        enemies.add(createEnemyShip(E_BIG, ENEMYSHIP_SPRITE_IMAGE_4_bottom, gameRect, 8, 6, vx, 3, E_SHOT_HOAMING, 4));

        enemies.add(createEnemyShip(E_BIG, ENEMYSHIP_SPRITE_IMAGE_4_top,    gameRect, 5, 8, vx, 0, E_SHOT_HOAMING, 5));
        enemies.add(createEnemyShip(E_BIG, ENEMYSHIP_SPRITE_IMAGE_4_bottom, gameRect, 5, 9, vx, 3, E_SHOT_HOAMING, 5));
        enemies.add(createEnemyShip(E_BIG, ENEMYSHIP_SPRITE_IMAGE_4_top,    gameRect, 11, 8, vx, 0, E_SHOT_HOAMING, 6));
        enemies.add(createEnemyShip(E_BIG, ENEMYSHIP_SPRITE_IMAGE_4_bottom, gameRect, 11, 9, vx, 3, E_SHOT_HOAMING, 6));


        return enemies;
    }


}
