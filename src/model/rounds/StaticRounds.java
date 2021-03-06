package model.rounds;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import model.animated.CharacterFactory;
import model.animated.CharacterFactoryImpl;
import model.animated.Enemy;
import model.animated.EntityStats;
import model.hitbox.CircleHitBox;
import model.hitbox.HitBox;
import model.utility.ModelUtility;
import model.utility.Spawn;
import utility.Command;

/**
 * Static Rounds class. This class works like the DinamicRounds class but the
 * list of monster generated is pre setted.
 */
public final class StaticRounds implements RoundsGenerator {

    private final List<Enemy> listReturnEnemy = new ArrayList<>();

    private static StaticRounds singleton;

    /**
     * Private constructor to avoid client applications to use constructor.
     */
    private StaticRounds() { }

    /**
     * Get the instance of StaticRounds.
     * 
     * @return the instance of StaticRounds.
     */
    public static StaticRounds getInstance() {
        if (Objects.isNull(singleton)) {
            singleton = new StaticRounds();
        }
        return singleton;
    }

    /**
     * @return the list of the monsters generated this round.
     */
    @Override
    public List<Enemy> generateMonster() {
        final CharacterFactory enemyFactory = new CharacterFactoryImpl();
        this.listReturnEnemy.clear();
        if (getCurrentRound() == 1) {
            // first enemy is a static simple direction shot enemy.
            final HitBox hbFirst = new CircleHitBox(Spawn.B.getX(), Spawn.B.getY(),
                    EntityStats.MOVEABLE_ENEMY.getEntityRadius());
            final Enemy en1 = enemyFactory.createStaticSimpleDirectionShotEnemy(hbFirst, Command.DOWN);
            listReturnEnemy.add(en1);
            // second enemy is a simple direction moved enemy enemy.
            final HitBox hbSecond = new CircleHitBox(Spawn.D.getX(), Spawn.D.getY(),
                    EntityStats.MOVEABLE_ENEMY.getEntityRadius());
            final Enemy en2 = enemyFactory.createSimpleDirectionMovedEnemy(hbSecond, Command.UP, Command.LEFT);
            listReturnEnemy.add(en2);
        } else if (getCurrentRound() == 2) {
            // first enemy is a static enemy four way diagonal shot.
            final HitBox hbFirst = new CircleHitBox(Spawn.B.getX(), Spawn.B.getY(),
                    EntityStats.MOVEABLE_ENEMY.getEntityRadius());
            final Enemy en1 = enemyFactory.createStaticEnemyFourWayStraightProjectile(hbFirst);
            listReturnEnemy.add(en1);
            // second enemy is a simple direction moved enemy enemy.
            final HitBox hbSecond = new CircleHitBox(Spawn.D.getX(), Spawn.D.getY(),
                    EntityStats.MOVEABLE_ENEMY.getEntityRadius());
            final Enemy en2 = enemyFactory.createSimpleDirectionMovedEnemy(hbSecond, Command.UP, Command.LEFT);
            listReturnEnemy.add(en2);
            // second enemy is an enemy thats move in a simple direction.
            final HitBox hbThird = new CircleHitBox(Spawn.H.getX(), Spawn.H.getY(),
                    EntityStats.MOVEABLE_ENEMY.getEntityRadius());
            final Enemy en3 = enemyFactory.createSimpleDirectionMovedEnemy(hbThird, Command.LEFT, Command.UP);
            listReturnEnemy.add(en3);
        } else if (getCurrentRound() == 3) {
            // first enemy is a simple direction moved enemy.
            final HitBox hbFirst = new CircleHitBox(Spawn.D.getX(), Spawn.D.getY(),
                    EntityStats.MOVEABLE_ENEMY.getEntityRadius());
            final Enemy en1 = enemyFactory.createSimpleDirectionMovedEnemy(hbFirst, Command.UP, Command.LEFT);
            listReturnEnemy.add(en1);
            // second enemy is enemy thats move in a simple direction.
            final HitBox hbSecond = new CircleHitBox(Spawn.E.getX(), Spawn.E.getY(),
                    EntityStats.MOVEABLE_ENEMY.getEntityRadius());
            final Enemy en2 = enemyFactory.createStaticEnemyFourWayStraightProjectile(hbSecond);
            listReturnEnemy.add(en2);
            // third enemy is a Static enemy with aimed shot.
            final HitBox hbThird = new CircleHitBox(Spawn.G.getX(), Spawn.G.getY(),
                    EntityStats.STATIC_ENEMY.getEntityRadius());
            final Enemy en3 = enemyFactory.createStaticEnemyFollowPlayerBullet(hbThird);
            listReturnEnemy.add(en3);
            // forth enemy is a Static enemy with aimed shot.
            final HitBox hbForth = new CircleHitBox(Spawn.B.getX(), Spawn.B.getY(),
                    EntityStats.STATIC_ENEMY.getEntityRadius());
            final Enemy en4 = enemyFactory.createStaticAimedBulletEnemy(hbForth);
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
