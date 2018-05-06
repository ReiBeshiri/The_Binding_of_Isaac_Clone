package model.dinamicrounds;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import input.Command;
import model.animated.AbstractCharacter;
import model.animated.Enemy;
import model.animated.EnemyFactory;
import model.animated.EnemyFactoryImpl;
import model.animated.EntityType;
import model.hitbox.CircleHitBox;
import model.hitbox.HitBox;
import utility.Collisions;
import utility.ModelUtility;
import utility.ProportionUtility;
import utility.Spawns;

/**
 *
 */
public class DinamicRoundsImpl implements DinamicRounds {
    private static final int MAXENEMY = 7;
    private List<EntityType> list;
    private List<Spawns> spawns;
    /**
     * Add to the list all the possible enemies, and the spawns.
     */
    public DinamicRoundsImpl() {
        list.add(EntityType.STATIC_ENEMY);
        list.add(EntityType.MOVEABLE_ENEMY);
        spawns.add(Spawns.A);
        spawns.add(Spawns.B);
        spawns.add(Spawns.C);
        spawns.add(Spawns.D);
        spawns.add(Spawns.E);
        spawns.add(Spawns.F);
        spawns.add(Spawns.G);
        spawns.add(Spawns.H);
    }
    /**
     * Generate a random Monster. 
     */
    @Override
    public void generateMonster() {
        Collections.shuffle(list);
        Collections.shuffle(spawns);
        HitBox hb = new CircleHitBox(spawns.get(0).getX(), spawns.get(0).getY(), ProportionUtility.getRadiusEnemy());
        EnemyFactory enemy = new EnemyFactoryImpl();
        enemy.createSimpleDirectionMovedEnemy(hb, Command.UP, Command.LEFT, ProportionUtility.getRadiusBullet());
    }
    /**
     * @return the number of monsters to generate.
     */
    @Override
    public int numerOfEnemyToGenerate() {
        return getCurrentRound() < DinamicRoundsImpl.MAXENEMY ? getCurrentRound() : DinamicRoundsImpl.MAXENEMY; 
    }
    /**
     * @return the current rounds, so the difficulty can be adapted.
     */
    private int getCurrentRound() {
        return ModelUtility.getCurrentRound();
    }
}
