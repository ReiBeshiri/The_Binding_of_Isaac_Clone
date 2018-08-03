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
    private final List<Animated> listReturnEnemy = new ArrayList<>();
    /**
     * @return the list of the  monsters generated this round.
     */
    @Override
    public List<Animated> generateMonster() {
        final EnemyFactory enemyFactory = new EnemyFactoryImpl();
        this.listReturnEnemy.clear();
        if (getCurrentRound() == 1) {
            //first enemy is a static simple direction shot enemy.
            final HitBox hbFirst = new CircleHitBox(Spawns.B.getX(), Spawns.B.getY(), ProportionUtility.getRadiusEnemy());
            final Animated en1 = enemyFactory.createStaticSimpleDirectionShotEnemy(hbFirst, Command.DOWN, ProportionUtility.getRadiusBullet(), ImageType.BASIC_ENEMY, ProportionUtility.getEnemyBulletRatio());
            listReturnEnemy.add(en1);
            //second enemy is a simple direction moved enemy enemy.
            final HitBox hbSecond = new CircleHitBox(Spawns.D.getX(), Spawns.D.getY(), ProportionUtility.getRadiusEnemy());
            final Animated en2 = enemyFactory.createSimpleDirectionMovedEnemy(hbSecond, Command.UP, Command.LEFT, ProportionUtility.getRadiusBullet(), ImageType.BASIC_ENEMY, ProportionUtility.getEnemyBulletRatio());
            listReturnEnemy.add(en2);
        } else if (getCurrentRound() == 2) {
            //first enemy is a static simple direction shot enemy.
            final HitBox hbFirst = new CircleHitBox(Spawns.B.getX(), Spawns.B.getY(), ProportionUtility.getRadiusEnemy());
            final Animated en1 = enemyFactory.createStaticSimpleDirectionShotEnemy(hbFirst, Command.DOWN, ProportionUtility.getRadiusBullet(), ImageType.BASIC_ENEMY, ProportionUtility.getEnemyBulletRatio());
            listReturnEnemy.add(en1);
            //second enemy is a simple direction moved enemy enemy.
            final HitBox hbSecond = new CircleHitBox(Spawns.D.getX(), Spawns.D.getY(), ProportionUtility.getRadiusEnemy());
            final Animated en2 = enemyFactory.createSimpleDirectionMovedEnemy(hbSecond, Command.UP, Command.LEFT, ProportionUtility.getRadiusBullet(), ImageType.BASIC_ENEMY, ProportionUtility.getEnemyBulletRatio());
            listReturnEnemy.add(en2);
            //second enemy is an enemy thats move in a simple direction.
            final HitBox hbThird = new CircleHitBox(Spawns.H.getX(), Spawns.H.getY(), ProportionUtility.getRadiusEnemy());
            final Animated en3 = enemyFactory.createSimpleDirectionMovedEnemy(hbThird, Command.LEFT, Command.UP, ProportionUtility.getRadiusBullet(), ImageType.BASIC_ENEMY, ProportionUtility.getEnemyBulletRatio());
            listReturnEnemy.add(en3);
        } else if (getCurrentRound() == 3) {
            //first enemy is a simple direction moved enemy.
            final HitBox hbFirst = new CircleHitBox(Spawns.D.getX(), Spawns.D.getY(), ProportionUtility.getRadiusEnemy());
            final Animated en1 = enemyFactory.createSimpleDirectionMovedEnemy(hbFirst, Command.UP, Command.LEFT, ProportionUtility.getRadiusBullet(), ImageType.BASIC_ENEMY, ProportionUtility.getEnemyBulletRatio());
            listReturnEnemy.add(en1);
            //second enemy is enemy thats move in a simple direction.
            final HitBox hbSecond = new CircleHitBox(Spawns.E.getX(), Spawns.E.getY(), ProportionUtility.getRadiusEnemy());
            final Animated en2 = enemyFactory.createSimpleDirectionMovedEnemy(hbSecond, Command.UP, Command.LEFT, ProportionUtility.getRadiusBullet(), ImageType.BASIC_ENEMY, ProportionUtility.getEnemyBulletRatio());
            listReturnEnemy.add(en2);
            //third enemy is a Static enemy with aimed shot.
            final HitBox hbThird = new CircleHitBox(Spawns.F.getX(), Spawns.F.getY(), ProportionUtility.getRadiusEnemy());
            final Animated en3 = enemyFactory.createStaticAimedBulletEnemy(hbThird, ProportionUtility.getRadiusBullet(), ImageType.AIMED_ENEMY, ProportionUtility.getEnemyBulletRatio());
            listReturnEnemy.add(en3);
            //forth enemy is a Static enemy with aimed shot.
            final HitBox hbForth = new CircleHitBox(Spawns.B.getX(), Spawns.B.getY(), ProportionUtility.getRadiusEnemy());
            final Animated en4 = enemyFactory.createStaticAimedBulletEnemy(hbForth, ProportionUtility.getRadiusBullet(), ImageType.AIMED_ENEMY, ProportionUtility.getEnemyBulletRatio());
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
