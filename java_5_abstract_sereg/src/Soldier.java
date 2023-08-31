import java.util.concurrent.ThreadLocalRandom;

public abstract class Soldier {
    protected int attackPower;
    protected int lifePoint;
    protected int coordinateX;
    protected int coordinateY;

    Soldier() {
        this.attackPower = 20;
        this.lifePoint = 100;
    }
    Soldier(int coordinateX, int coordinateY) {
        this.attackPower = 20;
        this.lifePoint = 100;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }


    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getLifePoint() {
        return lifePoint;
    }

    public void setLifePoint(int lifePoint) {
        this.lifePoint = lifePoint;
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }

    public abstract void tamad(Soldier attackedSoldier);

    /**
     * defines the initial coordinates
     * @return
     */
    public Soldier randomizeCoordinates () {
        this.coordinateX= ThreadLocalRandom.current().nextInt(0,11);        //0-10-es koordináták
        this.coordinateY= ThreadLocalRandom.current().nextInt(0,11);
        return this;
    }


@Override
    public String toString() {
    return "TE:" + this.attackPower + " ÉP:" + this.lifePoint + "pozíció:(" +
            this.coordinateX + "," + this.coordinateY + ") \n";
}

}
