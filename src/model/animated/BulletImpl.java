package model.animated;

public class BulletImpl /*extends AbstractCharacter implements Bullet */{ 
                        //Devo estendere da qualche metodo che
                        //implementa Animated, altrimenti la sola implementazione
                        //di Bullet mi obbliga a definire anche:
                        //getVel, setVel, update, getHitBox, setHitBox.
                        //Se estendo da AbstractCharacter il costruttore è errato 
                        //perche non devo passare nessun Life e nessuna "Ai" (questa la definisco con una strategy)
                        //e qui non definisco "shot" ma solamente il quanto "Range" deve ancora percorrere il bullet.
                        //Quindi: non posso implementare BULLET, ANIMATED, o GAMEOBJECT
                                //se estendo da AbstractCharacter non va bene il costruttore.
                        //Unica soluzione che mi viene in mente è passare per una classe astratta intermedia
                        //Questa implementa Animated. AbstractCharacter estendera questa classe intermedia,
                        //E BulletImpl estendera la classe intermedia implementando Bullet.
    /*
    public BulletImpl(double v, int life, HitBox h, AI ai) {
        super(v, life, h, ai);
        // TODO Auto-generated constructor stub
    }

    @Override
    public double getRange() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean isDead() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    protected void move(int dt) {
        // TODO Auto-generated method stub
        
    }

    @Override
    protected Collection<Bullet> shot(Command direction) {
        // TODO Auto-generated method stub
        return null;
    }*/
}
