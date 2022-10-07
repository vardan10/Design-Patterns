
class ChocolateBoiler {
    private static ChocolateBoiler instance;

    private ChocolateBoiler(){}

    public static ChocolateBoiler getInstance(){
        if(instance == null) {
            instance = new ChocolateBoiler();
        }

        return instance;
    }

}

public class SingletonPattern {
    public static void main(String[] args) {
        ChocolateBoiler chocolateBoiler1 = ChocolateBoiler.getInstance();
        ChocolateBoiler chocolateBoiler2 = ChocolateBoiler.getInstance();

        if(chocolateBoiler1 == chocolateBoiler2)
            System.out.println("Got the same instance");
    }
}
