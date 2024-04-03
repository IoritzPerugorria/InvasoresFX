package com.aetxabao.invasoresfx.sprite.weaponry;

import com.aetxabao.invasoresfx.sprite.ASprite;

import java.util.ArrayList;

import static com.aetxabao.invasoresfx.game.AppConsts.BALL_SPRITE_IMAGE;

public class Gun extends AWeapon {

    @Override
    public ArrayList<AShot> shoot(ASprite sprite) {
        ArrayList<AShot> list = new ArrayList<>();
        AShot shot = new Cannonball_Hoaming(BALL_SPRITE_IMAGE) {
        };
        shot.setPos(sprite.getRect().centerX(), sprite.getRect().bottom);
        if (shot instanceof Cannonball_Hoaming){
            ((Cannonball_Hoaming) shot).hoam();
        }
        list.add(shot);
        return list;
    }

}
