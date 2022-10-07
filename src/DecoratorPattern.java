


abstract class Pizza {
    String description = "Basic Pizza";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}

abstract class ToppingDecorator extends Pizza {
    Pizza pizza;
    public abstract String getDescription();
}

class ThincrustPizza extends Pizza {

    String description = "Thin Crust Pizza";

    @Override
    public double cost() {
        return 5;
    }
}

class Cheese extends ToppingDecorator {

    Cheese(Pizza pizza){
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " , Cheese";
    }

    @Override
    public double cost() {
        return pizza.cost() + 2;
    }
}

class Olive extends ToppingDecorator {

    Olive(Pizza pizza){
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " , Olive";
    }

    @Override
    public double cost() {
        return pizza.cost() + 1;
    }
}

public class DecoratorPattern {
    public static void main(String[] args) {

        Pizza pizza = new ThincrustPizza();
        Pizza cheesePizza = new Cheese(pizza);
        Pizza moreCheesePizza = new Cheese(cheesePizza);
        Pizza olivePizza = new Olive(moreCheesePizza);

        System.out.println("Ordered Pizza: \nDescription: " + olivePizza.getDescription() + " \nCost: " + olivePizza.cost());
    }
}
