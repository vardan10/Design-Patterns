abstract class Monster implements Cloneable {

    boolean eatsChildren = true;
    boolean hasWings = false;
    int numHeads = 1;
    boolean canBreatheFire = false;
    String name;

    public Monster(String name) {
        this.name = name;
    }

    public abstract Monster copy() throws CloneNotSupportedException;
}

class Drakon extends Monster {

    public Drakon(String name, int numHeads, boolean  canBreatheFire) {
        super(name);
        this.numHeads = numHeads;
        this.canBreatheFire = canBreatheFire;
    }

    public void spitPoison() {
        System.out.println(this.name + " spits poison");
    }

    @Override
    public Monster copy() throws CloneNotSupportedException {
        return (Monster) this.clone();
    }
}

public class PrototypePattern {
    public static void main(String[] args) {
        Drakon drakon = new Drakon("DROGON", 10, true);
        System.out.println(drakon);

        try{
            Monster newDrakon = drakon.copy();
            System.out.println(newDrakon);

            if(drakon == newDrakon)
                System.out.println("We just have single Monster");
            else
                System.out.println("We have 2 Monsters");
        } catch(Exception e){
            System.out.println("Error here");
        }

    }
}
