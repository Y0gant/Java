package src.OOPS;

/**
 * Requirements
 * All soldiers of the imperial army must know their rank.
 * A soldier can be ordered to fight to the death, and no one but a soldier can receive such an order.
 * Some soldiers are archers; all archers are soldiers
 * Archers must know the number of arrows in their possession.
 * An archer may be ordered to shoot a distant foe, and no one but an archer can receive such an order.
 * Some soldiers are horsemen; all horseman are soldiers.
 * Horsemen must know the horse that has been assigned to them.
 * A horseman may be ordered to trample the enemies in his path,and no one but a horseman can receive such an order.
 * Some soldiers belong to the Flying Rain of Fire,whose members are both horsemen and archers in every respect.
 * A member of the Flying Rain may be ordered to lead the charge,and no one but a member of the Flying Rain can receive such an order.
 */

interface Soldier {
    String getRank();

    void fightToDeath();
}

interface Archer extends Soldier {
    int getNumberOfArrows();

    void shootDistantFoe();
}

interface Horseman extends Soldier {
    String assignedHorse();

    void trampleEnemy();
}

interface FlyingRainOfFire extends Horseman, Archer {
    void leadArmy();
}

//Base class for all soldiers.
abstract class BaseSoldier implements Soldier {
    private final String rank;

    BaseSoldier(String rank) {
        this.rank = rank;
    }

    @Override
    public String getRank() {
        return rank;
    }

    @Override
    public void fightToDeath() {
        System.out.println(rank + " is fighting to death. ");
    }
}

//Archer Implementation
class ImperialArcher extends BaseSoldier implements Archer {

    private int arrowCount;

    ImperialArcher(String rank, int arrowCount) {
        super(rank);
        this.arrowCount = arrowCount;
    }

    @Override
    public int getNumberOfArrows() {
        return arrowCount;
    }

    @Override
    public void shootDistantFoe() {
        if (getNumberOfArrows() > 0) {
            System.out.println(getRank() + " is shooting distant enemies.");
            arrowCount--;
        } else {
            System.out.println(getRank() + " is out of arrows.");
        }
    }
}

//Horseman class Implementation
class ImperialHorseman extends BaseSoldier implements Horseman {
    private final String horseName;

    ImperialHorseman(String rank, String horseName) {
        super(rank);
        this.horseName = horseName;

    }

    @Override
    public String assignedHorse() {
        return horseName;
    }

    @Override
    public void trampleEnemy() {
        System.out.println(getRank() + " is trampling enemies with " + assignedHorse());
    }

}


//FlyingRainOfFire member implementation
class ImperialFlyingRainOfFire extends BaseSoldier implements FlyingRainOfFire {
    private final String assignedHorse;
    private int arrowCount;

    ImperialFlyingRainOfFire(String rank, int arrowCount, String assignedHorse) {
        super(rank);
        this.arrowCount = arrowCount;
        this.assignedHorse = assignedHorse;
    }

    @Override
    public void leadArmy() {
        System.out.println(getRank() + " is leading th army. ");
    }

    @Override
    public int getNumberOfArrows() {
        return arrowCount;
    }

    @Override
    public void shootDistantFoe() {
        if (arrowCount > 0) {
            System.out.println(getRank() + " is shooting a distant foe!");
            arrowCount--;
        } else {
            System.out.println(getRank() + " has no arrows left!");
        }
    }

    @Override
    public String assignedHorse() {
        return assignedHorse;
    }

    @Override
    public void trampleEnemy() {
        System.out.println(getRank() + " is trampling enemies with " + assignedHorse());
    }
}

//Driver class
public class ImperialArmy {

    public static void main(String[] args) {
        Archer archer = new ImperialArcher("Archer Captain", 10);
        archer.shootDistantFoe();
        archer.fightToDeath();

        Horseman horseman = new ImperialHorseman("Horseman Commander", "Shadow fax");
        horseman.trampleEnemy();
        horseman.fightToDeath();

        FlyingRainOfFire flyingRainWarrior = new ImperialFlyingRainOfFire("Flying Rain General", 15, "Storm-wind");
        flyingRainWarrior.shootDistantFoe();
        flyingRainWarrior.trampleEnemy();
        flyingRainWarrior.leadArmy();
        flyingRainWarrior.fightToDeath();
    }
}
