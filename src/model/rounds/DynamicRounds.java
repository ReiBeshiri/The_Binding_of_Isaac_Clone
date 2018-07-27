package model.rounds;
import java.util.ArrayList;

import java.util.Collections;
import java.util.List;
import input.Command;
import model.animated.Animated;
import model.animated.EnemyFactory;
import model.animated.EnemyFactoryImpl;
import model.animated.EnemyType;
import model.hitbox.CircleHitBox;
import model.hitbox.HitBox;
import proxyutility.ImageType;
import utility.ModelUtility;
import utility.ProportionUtility;
import utility.Spawns;

/**
 *      Dynamic Round class.
 *      This class will mainly create a list of Enemy in a loop.
 *      Every time the player get in a higher rounds there will be more monsters, the max number of monsters in a single round is 7.
 */
public class DynamicRounds implements RoundsGenerator {
    private static final int MAXENEMY = 7;
    private static final double SHOTRATIOBASIC = 0.5;
    private static final double SHOTRATIOHARD = 0.4;
    private final List<EnemyType> listEnemy = new ArrayList<>();
    private final List<Command> listCommand = new ArrayList<>();
    private final List<Spawns> listSpawns = new ArrayList<>();
    private int enemyToSpawn;
    private final List<Animated> listReturnEnemy = new ArrayList<>();
    /**
     * Add to the list all the possible enemies, and the spawns.
     */
    public DynamicRounds() {
    }

    /**
     * Generate a random Monster. 
     */
    @Override
    public List<Animated> generateMonster() {
        fullList();
        enemyToSpawn = numberOfEnemyToGenerate();
        Collections.shuffle(listSpawns);
        for (int i = 0; i < enemyToSpawn; i++) {
            Collections.shuffle(listEnemy);
            Collections.shuffle(listCommand);
            EnemyFactory enemy = new EnemyFactoryImpl();
            Spawns spawn;
            spawn = listSpawns.remove(0);
            if (listEnemy.get(0).equals(EnemyType.SIPMLE)) {
                HitBox hb = new CircleHitBox(spawn.getX(), spawn.getY(), ProportionUtility.getRadiusEnemy());
                Animated en = enemy.createStaticSimpleDirectionShotEnemy(hb, listCommand.get(0), ProportionUtility.getRadiusBullet(), ImageType.BASIC_ENEMY, DynamicRounds.SHOTRATIOBASIC);
                listReturnEnemy.add(en); 
            } else if (listEnemy.get(0).equals(EnemyType.SIMPLEMOVE)) {
                HitBox hb = new CircleHitBox(spawn.getX(), spawn.getY(), ProportionUtility.getRadiusEnemy());
                Animated en = enemy.createSimpleDirectionMovedEnemy(hb, listCommand.get(0), listCommand.get(1), ProportionUtility.getRadiusBullet(), ImageType.BASIC_ENEMY, DynamicRounds.SHOTRATIOBASIC);
                listReturnEnemy.add(en); 
            } else if (listEnemy.get(0).equals(EnemyType.SIMPLEAIMED)) {
                HitBox hb = new CircleHitBox(spawn.getX(), spawn.getY(), ProportionUtility.getRadiusEnemy());
               Animated en = enemy.createStaticAimedBulletEnemy(hb, ProportionUtility.getRadiusBullet(), ImageType.AIMED_ENEMY, DynamicRounds.SHOTRATIOHARD);
                listReturnEnemy.add(en);
            }
        }
        return listReturnEnemy;
    }

    /**
     * @return the number of monsters to generate.
     */
    private int numberOfEnemyToGenerate() {
        return getCurrentRound() < DynamicRounds.MAXENEMY ? getCurrentRound() : DynamicRounds.MAXENEMY; 
    }

    /**
     * @return the current rounds, so the difficulty can be adapted.
     */
    private int getCurrentRound() {
        return ModelUtility.getCurrentRound();
    }

    /**
     * full the lists with the needed parameters.
     */
    private void fullList() {
        listEnemy.add(EnemyType.SIMPLEAIMED);
        listEnemy.add(EnemyType.SIMPLEMOVE);
        listEnemy.add(EnemyType.SIPMLE);
        //spawns.add(Spawns.A); i'll take A as player's spawn.
        listSpawns.add(Spawns.B);
        listSpawns.add(Spawns.C);
        listSpawns.add(Spawns.D);
        listSpawns.add(Spawns.E);
        listSpawns.add(Spawns.F);
        listSpawns.add(Spawns.G);
        listSpawns.add(Spawns.H);
        listCommand.add(Command.UP);
        listCommand.add(Command.RIGHT);
        listCommand.add(Command.DOWN);
        listCommand.add(Command.LEFT);
    }
}
