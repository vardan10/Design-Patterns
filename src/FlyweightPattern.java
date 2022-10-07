import java.time.*;

interface Tree{
    public void display(int x, int y);
    
    public default boolean isWithinRange(LocalDate aDate) {
		Month month = aDate.getMonth();
		return (month.getValue() > 2) && (month.getValue() < 11);
	}
}

class ConiferTree implements Tree {
    public void display(int x, int y){
        System.out.println("Conifer tree is located at " + x + ", " + y);
    }
}

class DeciduousTree implements Tree {
    public void display(int x, int y){
        System.out.println("Deciduous tree is located at " + x + ", " + y);
        if(!this.isWithinRange(LocalDate.now())){
            System.out.println("The tree currently has no leaves");
        }
    }
}

class TreeFactory {
    ConiferTree c;
    DeciduousTree d;
    
    public TreeFactory() {
		this.d = new DeciduousTree();
		this.c = new ConiferTree();
	}

    public Tree getTree(String type) {
        if (type.equals("deciduous")) {
			return this.d;
		} else if (type.equals("conifer")) {
			return this.c;
		} else {
			return null;
		}
    }
}

public class FlyweightPattern {
    public static void main(String[] args) {
        int[][] deciduousLocations = {{1, 1}, {33, 50}, {100, 90}};
		int[][] coniferLocations = {{10, 87}, {24, 76}, {2, 64}};
		TreeFactory treeFactory = new TreeFactory();
		Tree d, c;
        
        d = treeFactory.getTree("deciduous");
        c = treeFactory.getTree("conifer");
        for (int[] location : deciduousLocations) {
            d.display(location[0],  location[1]);
        }
        for (int[] location : coniferLocations) {
            c.display(location[0],  location[1]);
        }
    }
}
