package com.aetxabao.invasoresfx.game;

import com.aetxabao.invasoresfx.Main;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.io.File;
import java.net.URL;

public final class AppConsts {

    public static boolean hardmode = false;

    //region Logs
    public static final URL LOG4J_PROPERTIES = Main.class.getResource("log4j.properties");
    public static final String SYSTEM_PROPERTY = "userApp.userName";
    //endregion

    //region AppInvasoresFx
    static final String APP_TITLE = "InvasoresFx";
    public static final int BOARD_MARGIN_TOP = 30;
    static final int BOARD_WIDTH = 240*2;
    static final int BOARD_HEIGHT = 337*2 - BOARD_MARGIN_TOP;
    public static final double GAME_SPEED = 30;//steps per second
    static final Image ICON_16 = new Image(Main.class.getResource("icon/icon16.png").toString());
    static final Image ICON_32 = new Image(Main.class.getResource("icon/icon32.png").toString());
    static final Image ICON_64 = new Image(Main.class.getResource("icon/icon64.png").toString());
    static final Image ICON_128 = new Image(Main.class.getResource("icon/icon128.png").toString());
    //endregion

    //region EnemyGenerator
    final static int LEVELS = 5;
    final static int TICKSxFRAME = 3;
    public static final Image ENEMYSHIP_SPRITE_IMAGE_1 = new Image(Main.class.getResource("sprite/ei1.png").toString());
    public static final Image ENEMYSHIP_SPRITE_IMAGE_2 = new Image(Main.class.getResource("sprite/ei2.png").toString());
    public static final Image ENEMYSHIP_SPRITE_IMAGE_3 = new Image(Main.class.getResource("sprite/ei3.png").toString());
    public static final Image ENEMYSHIP_SPRITE_IMAGE_4_top = new Image(Main.class.getResource("sprite/ei4_top.png").toString());
    public static final Image ENEMYSHIP_SPRITE_IMAGE_4_bottom = new Image(Main.class.getResource("sprite/ei4_bottom.png").toString());
    public static final Image ENEMYSHIP_SPRITE_IMAGE_5_left = new Image(Main.class.getResource("sprite/ei5_left.png").toString());
    public static final Image ENEMYSHIP_SPRITE_IMAGE_5_middle = new Image(Main.class.getResource("sprite/ei5_middle.png").toString());
    public static final Image ENEMYSHIP_SPRITE_IMAGE_5_right = new Image(Main.class.getResource("sprite/ei5_right.png").toString());
    public static final Image ENEMYSHIP_SPRITE_IMAGE_BOSS = new Image(Main.class.getResource("sprite/boss.png").toString());


    static final Image ENEMYSHIP_SPRITE_IMAGE_test1 = new Image(Main.class.getResource("sprite/test_grid.png").toString());
    static final Image ENEMYSHIP_SPRITE_IMAGE_test2 = new Image(Main.class.getResource("sprite/test_grid.png").toString());
    static final Image ENEMYSHIP_SPRITE_IMAGE_test3 = new Image(Main.class.getResource("sprite/41wbi9.jpg").toString());
    static final Image ENEMYBARRIER4_SPRITE_IMAGE = new Image(Main.class.getResource("sprite/barrier4.png").toString());
    static final Image ENEMYTOWER3_SPRITE_IMAGE = new Image(Main.class.getResource("sprite/tower3.png").toString());
    //endregion

    //region GameManager
    static final int INIT_LEVEL = 1;
    static final int INIT_LIFES = 3;
    static final int PTS_ENEMYSHIP = 20;
    static final int PTS_NEWLEVEL = 100;
    static final Image SHIP_SPRITE_IMAGE = new Image(Main.class.getResource("sprite/ship0.png").toString());
    static final Image LIFES_SPRITE_IMAGE = new Image(Main.class.getResource("sprite/lifes.png").toString());
    static final Image LASER_SPRITE_IMAGE = new Image(Main.class.getResource("sprite/laser.png").toString());
    static final Image EXPLOSION_9_SPRITE_IMAGE = new Image(Main.class.getResource("sprite/explo9.png").toString());
    static final Image EXPLOSION_BOSS_SPRITE_IMAGE = new Image(Main.class.getResource("sprite/exploBoss.png").toString());

    static final Image EXPLOSION_12_SPRITE_IMAGE = new Image(Main.class.getResource("sprite/explo12.png").toString());
    //endregion

    //region Renderer
    static final double MARGIN_LEFT = 10.0;
    static final double MARGIN_TOP = 20.0;//see BOARD_MARGIN_TOP
    static final String TXT_YOU_CAN = "Tú puedes";
    static final String TXT_PRESS_ENTER = "Pulsa ENTER";
    static final String TXT_TO_START = "para empezar\n Pulsa H para\nmodo Dificil";
    static final String TXT_TO_CONTINUE = "para continuar";
    static final String TXT_YOU_WON = "GANASTE";
    static final String TXT_YOU_LOST = "PERDISTE";
    static final String TXT_LEVEL = "NIVEL";
    static final String TXT_POINTS = "Puntos";
    static final Image COVER_IMAGE = new Image(Main.class.getResource("img/cover.png").toString());
    static final Font FONT_HELVETICA_16 = Font.font( "Helvetica", FontWeight.EXTRA_BOLD, 16 );
    static final Font FONT_HELVETICA_52 = Font.font( "Helvetica", FontWeight.EXTRA_BOLD, 52 );
    //endregion

    //region Gun
    public static final Image BALL_SPRITE_IMAGE = new Image(Main.class.getResource("sprite/ball.png").toString());
    public static final Image BALL_HOAM_SPRITE_IMAGE = new Image(Main.class.getResource("sprite/ball_hoam.png").toString());
    public static final Image BALL_HEALTH_SPRITE_IMAGE = new Image(Main.class.getResource("sprite/ball_health.png").toString());
    //endregion

    //region Ship
    public static final int SHIP_ROWS = 3;
    public static final int SHIP_COLS = 3;
    public static final int SHIP_UP = 0;
    public static final int SHIP_DOWN = 0;
    public static final int SHIP_RIGHT = 1;
    public static final int SHIP_LEFT = 2;
    public static final int SHIP_MAX_SPEED = 5;
    //endregion

    //region EnemyShip
    public static final int ENEMYSHIP_ROWS = 1;
    public static final int ENEMYSHIP_COLS = 6;
    public static final int ENEMYSHIP_MAX_SPEED = 5;
    public static final double ENEMYSHIP_ALFA = 0.75;
    //endregion

    //region Lifes
    public static final int LIFES_ROWS = 4;
    public static final int LIFES_COLS = 1;
    public static final double LIFES_ALFA = 0.75;
    //endregion

    static final File shotSFX = new File(("src/main/resources/com/aetxabao/invasoresfx/audio/shot.wav"));
    static final File explosionSFX = new File(("src/main/resources/com/aetxabao/invasoresfx/audio/deltarune-explosion.wav"));
    static final File clearSFX = new File(("src/main/resources/com/aetxabao/invasoresfx/audio/MGClear00.wav"));
    static final File shieldHitSFX = new File(("src/main/resources/com/aetxabao/invasoresfx/audio/impact.wav"));
    static final File enemydedSFX = new File(("src/main/resources/com/aetxabao/invasoresfx/audio/enemyDed.wav"));




    private AppConsts() { }

}
