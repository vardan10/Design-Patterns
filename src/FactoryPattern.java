import java.util.ArrayList;
import java.util.List;

class Burger {
    String name;
    String bread;
    String sauce;
    List<String> toppings = new ArrayList<>();

    public void prepare() {
        System.out.println("Preparing " + name);
    }

    public void bake() {
        System.out.println("Baking " + name);
    }

    public void cut() {
        System.out.println("Cutting " + name);
    }

    public void box() {
        System.out.println("Boxing " + name);
    }

    public String toString() {
        StringBuffer display = new StringBuffer();
        display.append("---- " + name + " ----\n");
        display.append(bread + "\n");
        display.append(sauce + "\n");
        for (String topping : toppings) {
            display.append(topping + "\n");
        }
        return display.toString();
    }
}

class VeggieBurger extends Burger{
    public VeggieBurger() {
        name = "Veggie Burger";
        bread = "Crust";
        sauce = "Marinara sauce";
        toppings.add("Shredded mozzarella");
        toppings.add("Grated parmesan");
        toppings.add("Diced onion");
        toppings.add("Sliced mushrooms");
        toppings.add("Sliced red pepper");
        toppings.add("Sliced black olives");
    }
}

class CheeseBurger extends Burger{
    public CheeseBurger() {
        name = "Cheese Burger";
        bread = "Regular Crust";
        sauce = "Marinara sauce";
        toppings.add("Fresh Mozzarella");
        toppings.add("Parmesan");
    }
}

class BurgerFactory {

    public Burger createBurger(String type){
        Burger burger = null;

        if(type.equals("veggie")){
            burger = new VeggieBurger();
        } else if(type.equals("cheese")){
            burger = new CheeseBurger();
        }

        return burger;
    }

}

class BurgerStore {
    BurgerFactory factory;

    BurgerStore(BurgerFactory factory){
        this.factory = factory;
    }

    public Burger createBurger(String type){
        Burger burger = factory.createBurger(type);

        burger.prepare();
        burger.bake();
        burger.cut();
        burger.box();

        return burger;
    }
}

public class FactoryPattern {
    public static void main(String[] args) {
        BurgerFactory factory = new BurgerFactory();
        BurgerStore store = new BurgerStore(factory);

        store.createBurger("veggie");
    }
}
