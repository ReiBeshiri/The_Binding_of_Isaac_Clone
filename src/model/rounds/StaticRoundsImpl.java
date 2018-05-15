package model.rounds;

import java.util.List;

import input.Command;
import model.animated.Animated;
import model.animated.EnemyFactory;
import model.animated.EnemyFactoryImpl;
import model.hitbox.CircleHitBox;
import model.hitbox.HitBox;
import utility.ModelUtility;
import utility.ProportionUtility;
import utility.Spawns;
/**
 * Static Rounds Implement class.
 */
public class StaticRoundsImpl implements StaticRounds {
    private List<Animated> listReturnEnemy;
    /**
     * @return the list of the  monsters generated this round.
     */
    @Override
    public List<Animated> generateMonster() {
        if (getCurrentRound() == 1) {
            //first enemy is a static simple direction shot enemy.
            EnemyFactory enemyFirst = new EnemyFactoryImpl();
            HitBox hbFirst = new CircleHitBox(Spawns.B.getX(), Spawns.B.getY(), ProportionUtility.getRadiusEnemy());
            enemyFirst.createStaticSimpleDirectionShotEnemy(hbFirst, Command.DOWN, ProportionUtility.getRadiusBullet());
            listReturnEnemy.add((Animated) enemyFirst);
            //second enemy is a simple direction moved enemy enemy.
            EnemyFactory enemySecond = new EnemyFactoryImpl();
            HitBox hbSecond = new CircleHitBox(Spawns.D.getX(), Spawns.D.getY(), ProportionUtility.getRadiusEnemy());
            enemySecond.createSimpleDirectionMovedEnemy(hbSecond, Command.UP, Command.LEFT, ProportionUtility.getRadiusEnemy());
            listReturnEnemy.add((Animated) enemySecond);
        } else if (getCurrentRound() == 2) {
            //first enemy is a static simple direction shot enemy.
            EnemyFactory enemyFirst = new EnemyFactoryImpl();
            HitBox hbFirst = new CircleHitBox(Spawns.B.getX(), Spawns.B.getY(), ProportionUtility.getRadiusEnemy());
            enemyFirst.createStaticSimpleDirectionShotEnemy(hbFirst, Command.DOWN, ProportionUtility.getRadiusBullet());
            listReturnEnemy.add((Animated) enemyFirst);
            //second enemy is a simple direction moved enemy enemy.
            EnemyFactory enemySecond = new EnemyFactoryImpl();
            HitBox hbSecond = new CircleHitBox(Spawns.D.getX(), Spawns.D.getY(), ProportionUtility.getRadiusEnemy());
            enemySecond.createSimpleDirectionMovedEnemy(hbSecond, Command.UP, Command.LEFT, ProportionUtility.getRadiusEnemy());
            listReturnEnemy.add((Animated) enemySecond);
            //second enemy is a simple direction moved enemy enemy.
            EnemyFactory enemyThird = new EnemyFactoryImpl();
            HitBox hbThird = new CircleHitBox(Spawns.H.getX(), Spawns.H.getY(), ProportionUtility.getRadiusEnemy());
            enemyThird.createSimpleDirectionMovedEnemy(hbThird, Command.LEFT, Command.UP, ProportionUtility.getRadiusEnemy());
            listReturnEnemy.add((Animated) enemyThird);
        } else {
            //first enemy is a simple direction moved enemy enemy.
            EnemyFactory enemyFirst = new EnemyFactoryImpl();
            HitBox hbFirst = new CircleHitBox(Spawns.D.getX(), Spawns.D.getY(), ProportionUtility.getRadiusEnemy());
            enemyFirst.createSimpleDirectionMovedEnemy(hbFirst, Command.UP, Command.LEFT, ProportionUtility.getRadiusEnemy());
            listReturnEnemy.add((Animated) enemyFirst);
            //second enemy is a simple direction moved enemy enemy.
            EnemyFactory enemySecond = new EnemyFactoryImpl();
            HitBox hbSecond = new CircleHitBox(Spawns.E.getX(), Spawns.E.getY(), ProportionUtility.getRadiusEnemy());
            enemySecond.createSimpleDirectionMovedEnemy(hbSecond, Command.UP, Command.LEFT, ProportionUtility.getRadiusEnemy());
            listReturnEnemy.add((Animated) enemySecond);
            //third enemy is a simple direction moved enemy enemy.
            EnemyFactory enemyThird = new EnemyFactoryImpl();
            HitBox hbThird = new CircleHitBox(Spawns.F.getX(), Spawns.F.getY(), ProportionUtility.getRadiusEnemy());
            enemyThird.createStaticAimedBulletEnemy(hbThird, ProportionUtility.getRadiusEnemy());
            listReturnEnemy.add((Animated) enemyThird);
            //forth enemy is a simple direction moved enemy enemy.
            EnemyFactory enemyForth = new EnemyFactoryImpl();
            HitBox hbForth = new CircleHitBox(Spawns.B.getX(), Spawns.B.getY(), ProportionUtility.getRadiusEnemy());
            enemyForth.createStaticAimedBulletEnemy(hbForth, ProportionUtility.getRadiusEnemy());
            listReturnEnemy.add((Animated) enemyForth);
        }
        return listReturnEnemy;
    }
    /**
     * @return the number of monsters to generate.
     */
    @Override
    public int numberOfEnemyToGenerate() {
        return 1 + getCurrentRound();
    }
    /**
     * @return the current rounds, so the difficulty can be adapted.
     */
    private int getCurrentRound() {
        return ModelUtility.getCurrentRound();
    }

}
