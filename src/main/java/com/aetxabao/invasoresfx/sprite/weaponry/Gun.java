package com.aetxabao.invasoresfx.sprite.weaponry;

import com.aetxabao.invasoresfx.sprite.ASprite;

import java.util.ArrayList;

import static com.aetxabao.invasoresfx.game.AppConsts.*;

public class Gun extends AWeapon {

    int tipo;

    public Gun(int tipo){
        this.tipo = tipo;
    }

    @Override
    public ArrayList<AShot> shoot(ASprite sprite) {
        ArrayList<AShot> list = new ArrayList<>();

        AShot shot = null;
        if (tipo == 0){
            list.add(shot = new Cannonball_Regular(BALL_SPRITE_IMAGE));
        }
        else if (tipo == 1){
            list.add(shot = new Cannonball_Hoaming(BALL_HOAM_SPRITE_IMAGE));
        }
        else if (tipo == 2){
            list.add(shot = new Cannonball_Health(BALL_HEALTH_SPRITE_IMAGE, 2));
        }

        shot.setPos(sprite.getRect().centerX(), sprite.getRect().bottom);
        if (shot instanceof Cannonball_Hoaming){
            ((Cannonball_Hoaming) shot).hoam();
        }

        return list;
    }

}