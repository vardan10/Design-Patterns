interface Command {
    public void execute();    
}

class LightOnCommand implements Command {
    Light light;
    
    LightOnCommand(Light light){
        this.light = light;
    }
    
    public void execute(){
        light.on();
    }
}

class GarageDoorOpenCommand implements Command {
    GarageDoor garageDoor;
    
    GarageDoorOpenCommand(GarageDoor garageDoor){
        this.garageDoor = garageDoor;
    }
    
    public void execute(){
        garageDoor.up();
    }
}

class Light{
    Light(){}
    
    public void on(){
        System.out.println("Light on \n");
    }
    
    public void off(){
        System.out.println("Light off \n");
    }
}

class GarageDoor {
    GarageDoor() {}
    
    public void up() {
		System.out.println("Garage Door is Open");
	}
}

class SimpleRemoteControl {
    Command cmd;
    
    SimpleRemoteControl(){};
    
    void setCommand(Command cmd){
        this.cmd = cmd;
    }
    
    void buttonWasPressed(){
        this.cmd.execute();
    }
}

class CommandPattern {
    public static void main(String[] args) {
        SimpleRemoteControl remote = new SimpleRemoteControl();
		Light light = new Light();
		GarageDoor garageDoor = new GarageDoor();
		LightOnCommand lightOn = new LightOnCommand(light);
		GarageDoorOpenCommand garageOpen = 
		    new GarageDoorOpenCommand(garageDoor);
 
		remote.setCommand(lightOn);
		remote.buttonWasPressed();
		remote.setCommand(garageOpen);
		remote.buttonWasPressed();
    }
}
