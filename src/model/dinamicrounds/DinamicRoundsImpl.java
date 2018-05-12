package model.dinamicrounds;
import java.util.Collections;
import java.util.List;
import input.Command;
import model.animated.Animated;
import model.animated.EnemyFactory;
import model.animated.EnemyFactoryImpl;
import model.animated.EnemyType;
import model.hitbox.CircleHitBox;
import model.hitbox.HitBox;
import utility.ModelUtility;
import utility.ProportionUtility;
import utility.Spawns;

/**
 *      Dinamic Rounds.
 */
public class DinamicRoundsImpl implements DinamicRounds {
    private static final int MAXENEMY = 7;
    private List<EnemyType> listEnemy;
    private List<Command> listCommand;
    private List<Spawns> listSpawns;
    private int enemyToSpawn;
    private List<Animated> listReturnEnemy;
    /**
     * Add to the list all the possible enemies, and the spawns.
     */
    public DinamicRoundsImpl() {
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
    /**
     * Generate a random Monster. 
     */
    @Override
    public List<Animated> generateMonster() {
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
                enemy.createStaticSimpleDirectionShotEnemy(hb, listCommand.get(0), ProportionUtility.getRadiusBullet());
                listReturnEnemy.add((Animated) enemy); 
            } else if (listEnemy.get(0).equals(EnemyType.SIMPLEMOVE)) {
                HitBox hb = new CircleHitBox(spawn.getX(), spawn.getY(), ProportionUtility.getRadiusEnemy());
                enemy.createSimpleDirectionMovedEnemy(hb, listCommand.get(0), listCommand.get(1), ProportionUtility.getRadiusBullet());
                listReturnEnemy.add((Animated) enemy); 
            } else if (listEnemy.get(0).equals(EnemyType.SIMPLEAIMED)) {
                HitBox hb = new CircleHitBox(spawn.getX(), spawn.getY(), ProportionUtility.getRadiusEnemy());
                enemy.createStaticAimedBulletEnemy(hb, ProportionUtility.getRadiusBullet());
                listReturnEnemy.add((Animated) enemy);
            }
        }
        return listReturnEnemy;
    }
    /**
     * @return the number of monsters to generate.
     */
    @Override
    public int numberOfEnemyToGenerate() {
        return getCurrentRound() < DinamicRoundsImpl.MAXENEMY ? getCurrentRound() : DinamicRoundsImpl.MAXENEMY; 
    }
    /**
     * @return the current rounds, so the difficulty can be adapted.
     */
    private int getCurrentRound() {
        return ModelUtility.getCurrentRound();
    }
}
