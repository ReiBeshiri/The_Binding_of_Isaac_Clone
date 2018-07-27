package model.rounds;

import java.util.ArrayList;
import java.util.List;

import input.Command;
import model.animated.Animated;
import model.animated.EnemyFactory;
import model.animated.EnemyFactoryImpl;
import model.hitbox.CircleHitBox;
import model.hitbox.HitBox;
import proxyutility.ImageType;
import utility.ModelUtility;
import utility.ProportionUtility;
import utility.Spawns;
/**
 *      Static Rounds class.
 *      This class works like the DinamicRounds class but the list of monster generated is pre setted.
 */
public class StaticRounds implements RoundsGenerator {
    private List<Animated> listReturnEnemy = new ArrayList<>();
    private static final double SHOTRATIOBASIC = 0.5;
    private static final double SHOTRATIOHARD = 0.4;
    /**
     * @return the list of the  monsters generated this round.
     */
    @Override
    public List<Animated> generateMonster() {
        if (getCurrentRound() == 1) {
            //first enemy is a static simple direction shot enemy.
            EnemyFactory enemyFirst = new EnemyFactoryImpl();
            HitBox hbFirst = new CircleHitBox(Spawns.B.getX(), Spawns.B.getY(), ProportionUtility.getRadiusEnemy());
            Animated en1 = enemyFirst.createStaticSimpleDirectionShotEnemy(hbFirst, Command.DOWN, ProportionUtility.getRadiusBullet(), ImageType.BASIC_ENEMY, StaticRounds.SHOTRATIOBASIC);
            listReturnEnemy.add(en1);
            //second enemy is a simple direction moved enemy enemy.
            EnemyFactory enemySecond = new EnemyFactoryImpl();
            HitBox hbSecond = new CircleHitBox(Spawns.D.getX(), Spawns.D.getY(), ProportionUtility.getRadiusEnemy());
            Animated en2 = enemySecond.createSimpleDirectionMovedEnemy(hbSecond, Command.UP, Command.LEFT, ProportionUtility.getRadiusEnemy(), ImageType.BASIC_ENEMY, StaticRounds.SHOTRATIOBASIC);
            listReturnEnemy.add(en2);
        } else if (getCurrentRound() == 2) {
            //first enemy is a static simple direction shot enemy.
            EnemyFactory enemyFirst = new EnemyFactoryImpl();
            HitBox hbFirst = new CircleHitBox(Spawns.B.getX(), Spawns.B.getY(), ProportionUtility.getRadiusEnemy());
            Animated en1 = enemyFirst.createStaticSimpleDirectionShotEnemy(hbFirst, Command.DOWN, ProportionUtility.getRadiusBullet(), ImageType.BASIC_ENEMY, StaticRounds.SHOTRATIOBASIC);
            listReturnEnemy.add(en1);
            //second enemy is a simple direction moved enemy enemy.
            EnemyFactory enemySecond = new EnemyFactoryImpl();
            HitBox hbSecond = new CircleHitBox(Spawns.D.getX(), Spawns.D.getY(), ProportionUtility.getRadiusEnemy());
            Animated en2 = enemySecond.createSimpleDirectionMovedEnemy(hbSecond, Command.UP, Command.LEFT, ProportionUtility.getRadiusEnemy(), ImageType.BASIC_ENEMY, StaticRounds.SHOTRATIOBASIC);
            listReturnEnemy.add(en2);
            //second enemy is an enemy thats move in a simple direction.
            EnemyFactory enemyThird = new EnemyFactoryImpl();
            HitBox hbThird = new CircleHitBox(Spawns.H.getX(), Spawns.H.getY(), ProportionUtility.getRadiusEnemy());
            Animated en3 = enemyThird.createSimpleDirectionMovedEnemy(hbThird, Command.LEFT, Command.UP, ProportionUtility.getRadiusEnemy(), ImageType.BASIC_ENEMY, StaticRounds.SHOTRATIOBASIC);
            listReturnEnemy.add(en3);
        } else if (getCurrentRound() == 3) {
            //first enemy is a simple direction moved enemy.
            EnemyFactory enemyFirst = new EnemyFactoryImpl();
            HitBox hbFirst = new CircleHitBox(Spawns.D.getX(), Spawns.D.getY(), ProportionUtility.getRadiusEnemy());
            Animated en1 = enemyFirst.createSimpleDirectionMovedEnemy(hbFirst, Command.UP, Command.LEFT, ProportionUtility.getRadiusEnemy(), ImageType.BASIC_ENEMY, StaticRounds.SHOTRATIOBASIC);
            listReturnEnemy.add(en1);
            //second enemy is enemy thats move in a simple direction.
            EnemyFactory enemySecond = new EnemyFactoryImpl();
            HitBox hbSecond = new CircleHitBox(Spawns.E.getX(), Spawns.E.getY(), ProportionUtility.getRadiusEnemy());
            Animated en2 = enemySecond.createSimpleDirectionMovedEnemy(hbSecond, Command.UP, Command.LEFT, ProportionUtility.getRadiusEnemy(), ImageType.BASIC_ENEMY, StaticRounds.SHOTRATIOBASIC);
            listReturnEnemy.add(en2);
            //third enemy is a Static enemy with aimed shot.
            EnemyFactory enemyThird = new EnemyFactoryImpl();
            HitBox hbThird = new CircleHitBox(Spawns.F.getX(), Spawns.F.getY(), ProportionUtility.getRadiusEnemy());
            Animated en3 = enemyThird.createStaticAimedBulletEnemy(hbThird, ProportionUtility.getRadiusEnemy(), ImageType.AIMED_ENEMY, StaticRounds.SHOTRATIOHARD);
            listReturnEnemy.add(en3);
            //forth enemy is a Static enemy with aimed shot.
            EnemyFactory enemyForth = new EnemyFactoryImpl();
            HitBox hbForth = new CircleHitBox(Spawns.B.getX(), Spawns.B.getY(), ProportionUtility.getRadiusEnemy());
            Animated en4 = enemyForth.createStaticAimedBulletEnemy(hbForth, ProportionUtility.getRadiusEnemy(), ImageType.AIMED_ENEMY, StaticRounds.SHOTRATIOHARD);
            listReturnEnemy.add(en4);
        }
        return listReturnEnemy;
    }

    /**
     * @return the current rounds, so the difficulty can be adapted.
     */
    private int getCurrentRound() {
        return ModelUtility.getCurrentRound();
    }

}
