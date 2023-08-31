import java.util.concurrent.ThreadLocalRandom;

public class Archer extends Soldier{
private int shootDistance;

Archer() {
    this.attackPower = 20;
    this.lifePoint = 100;
    this.shootDistance = ThreadLocalRandom.current().nextInt(3,11); //shootdist:3-11
    super.randomizeCoordinates();
}
    Archer(int coordinateX, int coordinateY, int shootDistance) {
        super(coordinateX, coordinateY);
        this.shootDistance = ThreadLocalRandom.current().nextInt(3,11); //shootdist:3-11
    }

    public int getShootDistance() {
        return shootDistance;
    }

    public Archer setShootDistance(int shootDistance) {
//        this.shootDistance = shootDistance;
        this.shootDistance = ThreadLocalRandom.current().nextInt(3,11);     //shootdist:3-11
        return this;
    }

    @Override
    public void tamad(Soldier attackedSoldier) {
        if (Math.sqrt((double)(Math.pow((this.getCoordinateX()-attackedSoldier.getCoordinateX()),2) + Math.pow((this.getCoordinateY()-attackedSoldier.getCoordinateY()),2)))<=this.shootDistance) {
        attackedSoldier.setLifePoint(attackedSoldier.getLifePoint()-this.attackPower);        //itt nem az íjászé van beállítva
        }



    }

    @Override
    public String toString() {
        return "Íjász LT:" + this.shootDistance + " TE:" + this.attackPower + " ÉP:" + this.lifePoint + "pozíció:(" +
                this.coordinateX + "," + this.coordinateY + ") \n";
    }

}
