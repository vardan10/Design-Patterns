abstract class CaffeineBeverage {
    
    public void prepareRecipe(){
        boilWater();
		brew();
		pourInCup();
        
        if(customerWantsCondiments())
		    addCondiments();
    }
    
    private void boilWater(){
        System.out.println("Boiling water");
    }
    
    abstract void brew();
    
    private void pourInCup(){
        System.out.println("Pouring in cup");
    }
    
    abstract void addCondiments();
    
    private boolean customerWantsCondiments(){
        return true;
    }
}

class Tea extends CaffeineBeverage {
    void brew(){
        System.out.println("Steeping the tea");
    }
    
    void addCondiments(){
        System.out.println("Adding Lemon");
    }
    
    private boolean customerWantsCondiments(){
        return false;
    }
}

class Coffee extends CaffeineBeverage {
    void brew(){
        System.out.println("Dripping Coffee through filter");
    }
    
    void addCondiments(){
        System.out.println("Adding Sugar and Milk");
    }
}

class TemplatePattern {
    public static void main(String[] args) {
        Tea tea = new Tea();
		Coffee coffee = new Coffee();
 
		System.out.println("\nMaking tea...");
		tea.prepareRecipe();
 
		System.out.println("\nMaking coffee...");
		coffee.prepareRecipe();
    }
}
