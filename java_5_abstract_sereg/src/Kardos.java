public class Kardos extends Soldier {

    Kardos() {
        this.attackPower = 20;
        this.lifePoint = 100;
        super.randomizeCoordinates();
    }

    Kardos(int coordinateX, int coordinateY) {
        super(coordinateX, coordinateY);
    }

    @Override
    public void tamad(Soldier attackedSoldier) {
        this.coordinateX = attackedSoldier.coordinateX;
        this.coordinateY = attackedSoldier.coordinateY;
        this.setLifePoint(this.getLifePoint() - 10);
        attackedSoldier.setLifePoint(attackedSoldier.getLifePoint() - this.attackPower);
    }

    @Override
    public String toString() {
        return "Kardos katona TE:" + this.attackPower + " ÉP:" + this.lifePoint + "pozíció:(" +
                this.coordinateX + "," + this.coordinateY + ") \n";
    }

}
