import java.util.Random;

interface Duck {
    public void quack();
    public void fly();
}

interface Turkey {
    public void gobble();
    public void fly();
}

class MallardDuck implements Duck {

    @Override
    public void quack() {
        System.out.println("Quack");
    }

    @Override
    public void fly() {
        System.out.println("Fly");
    }
}

class DuckAdapter implements Turkey {

    Duck duck;
    Random rand;

    DuckAdapter(Duck duck){
        this.duck = duck;
        this.rand = new Random();
    }

    @Override
    public void gobble() {
        duck.quack();
    }

    @Override
    public void fly() {
        if (rand.nextInt(5)  == 0){
            duck.fly();
        }
    }
}

public class AdapterPattern {
    public static void main(String[] args) {
        MallardDuck duck = new MallardDuck();
        Turkey duckAdapter = new DuckAdapter(duck);

        for(int i=0;i<10;i++) {
            System.out.println("The DuckAdapter says...");
            duckAdapter.gobble();
            duckAdapter.fly();
        }
    }
}
