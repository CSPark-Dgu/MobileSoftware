import java.util.Random;

abstract class Character {
    protected int hitpoint;
    protected int portionNumber;

    public void initialize(){
        hitpoint = getMaxhitpoint();
        portionNumber = 5;
    }

    public int getDamage(int damage){
        hitpoint -= damage;
        if(hitpoint>0){
            System.out.println(this.whoAmI()+" has "+this.hitpoint+" now.");
        }
        return hitpoint;
    }

    abstract protected int getRecoveryAmount();

    public void recover() {
        int recoveryAmount = getRecoveryAmount();
        hitpoint = Math.min(hitpoint + recoveryAmount, getMaxhitpoint());
        portionNumber--;
        System.out.println(this.whoAmI()+" takes portion and "+this.hitpoint+" hit point now.");
    }

     public boolean isDie() {
        if (hitpoint <= 0) {
            System.out.println(whoAmI() + " is dead.");
            return true;
        }
        return false;
    }

     public boolean needPortion() {
        return hitpoint < getMaxhitpoint() / 2 && portionNumber > 0;
    }

    abstract protected int getMaxhitpoint();
    abstract public String whoAmI();
    abstract public void attack(Character c);
}

class Human extends Character{
    protected int getMaxhitpoint(){
        return 200;
    }
    public String whoAmI(){
        return "Human";
    }

    public void attack(Character c){
        int damage = 40;
        System.out.println(this.whoAmI()+" attacks with damage "+damage);
        c.getDamage(damage);
    }

    protected int getRecoveryAmount(){
        return 40;
    }
}

class CyberDemon extends Character{
    Random random = new Random();
    protected int getMaxhitpoint(){
        return 250;
    }

    public String whoAmI(){
        return "CyberDemon";
    }

    public void attack(Character c){
        int damage;
        if(random.nextDouble()<0.3) damage=60;
        else damage =40;
        System.out.println(this.whoAmI()+" attacks with damage "+damage);
        c.getDamage(damage);
    }

    protected int getRecoveryAmount(){
        int amount;
        if(random.nextDouble()<0.3) amount = 50;
        else amount = 30;
        return amount;
    }
}

class Barlog extends Character {
    protected int getMaxhitpoint(){
        return 170;
    }

    public String whoAmI(){
        return "Barlog";
    }

    public void attack(Character c){
        Random random = new Random();
        int damage = 0;
        if(random.nextDouble()<0.20) damage += 30;
        else damage += 20;
        if(random.nextDouble()<0.20) {
            damage += 30;
            System.out.println("Double Chance!!");
        }
        else damage += 20;
        System.out.println(this.whoAmI()+" attacks with damage "+damage);
        c.getDamage(damage);
    }

    protected int getRecoveryAmount(){
        return 30;
    }

    public void recover(){
        super.recover();
        if(portionNumber>0){
            super.recover();
        }
    }
}

class Elf extends Character{
    Random random = new Random();

    protected int getMaxhitpoint(){
        return 180;
    }

    public String whoAmI(){
        return "Elf";
    }

    public void attack(Character c){
        int damage;
        if(random.nextDouble()<0.3) damage = 70;
        else damage = 35;
        System.out.println(this.whoAmI()+" attacks with damage "+damage);
        c.getDamage(damage);
    }

    protected int getRecoveryAmount(){
        int amount;
        if(random.nextDouble()<0.25) amount = 60;
        else amount = 30;
        return amount;
    }
}

public class Game {
    public static Character battle(Character blue, Character red) {
        Character firstAttacker = blue;
        Character secondAttacker = red;

        while (true) {
            firstAttacker.attack(secondAttacker);
            if (secondAttacker.isDie()) {
                return firstAttacker;
            }

            if(secondAttacker.needPortion()){
                secondAttacker.recover();
            }

            Character temp = firstAttacker;
            firstAttacker = secondAttacker;
            secondAttacker = temp;
        }
    }

    public static void tournament(Character hu, Character cyber, Character bar, Character el) {
        Character semiFinalWinner1 = battle(hu, cyber);
        Character semiFinalWinner2 = battle(bar, el);
        semiFinalWinner1.initialize();
        semiFinalWinner2.initialize();
        Character finalWinner = battle(semiFinalWinner1, semiFinalWinner2);

        System.out.println("Tournament winner: " + finalWinner.whoAmI());
    }

    public static void main(String[] args) {
        Human human = new Human();
        CyberDemon cyberDemon = new CyberDemon();
        Barlog barlog = new Barlog();
        Elf elf = new Elf();

        human.initialize();
        cyberDemon.initialize();
        barlog.initialize();
        elf.initialize();

        tournament(human, cyberDemon, barlog, elf);
    }
}