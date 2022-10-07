class HomeTheaterFacade {
    Amplifier amp;
    StreamingPlayer player;
    Lights lights;
    PopcornPopper popper;
    
    HomeTheaterFacade(Amplifier amp, StreamingPlayer player, Lights lights, PopcornPopper popper){
        this.amp = amp;
        this.player = player;
        this.lights = lights;
        this.popper = popper;
    }
    
    public void playMovie(String movie){
        System.out.println("Get ready to watch a movie...");
		popper.on();
		popper.pop();
		lights.dim(10);
		amp.on();
		amp.setStreamingPlayer(player);
		amp.setSurroundSound();
		amp.setVolume(5);
		player.on();
		player.play(movie);
    }
}

class Amplifier {
    String description;
	StreamingPlayer player;
    
    public Amplifier(String description) {
		this.description = description;
	}
 
	public void on() {
		System.out.println(description + " on");
	}
 
	public void off() {
		System.out.println(description + " off");
	}
 
	public void setStereoSound() {
		System.out.println(description + " stereo mode on");
	}
 
	public void setSurroundSound() {
		System.out.println(description + " surround sound on (5 speakers, 1 subwoofer)");
	}
 
	public void setVolume(int level) {
		System.out.println(description + " setting volume to " + level);
	}
  
	public void setStreamingPlayer(StreamingPlayer player) {
		System.out.println(description + " setting Streaming player to " + player);
		this.player = player;
	}
 
	public String toString() {
		return description;
	}
}

class Lights {
    String description;
    
    public Lights(String description) {
		this.description = description;
	}
	
	public void on() {
		System.out.println(description + " on");
	}

	public void off() {
		System.out.println(description + " off");
	}
	
	public void dim(int level) {
		System.out.println(description + " dimming to " + level  + "%");
	}
}

class StreamingPlayer {
	String description;
	int currentChapter;
	Amplifier amplifier;
	String movie;
	
	public StreamingPlayer(String description, Amplifier amplifier) {
		this.description = description;
		this.amplifier = amplifier;
	}
 
	public void on() {
		System.out.println(description + " on");
	}
 
	public void off() {
		System.out.println(description + " off");
	}
 
	public void play(String movie) {
		this.movie = movie;
		currentChapter = 0;
		System.out.println(description + " playing \"" + movie + "\"");
	}

	public void stop() {
		currentChapter = 0;
		System.out.println(description + " stopped \"" + movie + "\"");
	}
 
	public void pause() {
		System.out.println(description + " paused \"" + movie + "\"");
	}
 
	public String toString() {
		return description;
	}
}

class PopcornPopper {
	String description;
	
	public PopcornPopper(String description) {
		this.description = description;
	}
 
	public void on() {
		System.out.println(description + " on");
	}
 
	public void off() {
		System.out.println(description + " off");
	}

	public void pop() {
		System.out.println(description + " popping popcorn!");
	}
 
  
    public String toString() {
    	return description;
    }
}

class FancadePattern {
    public static void main(String[] args) {
        Amplifier amp = new Amplifier("Amplifier");
		StreamingPlayer player = new StreamingPlayer("Streaming Player", amp);
		Lights lights = new Lights("Theater Ceiling Lights");
		PopcornPopper popper = new PopcornPopper("Popcorn Popper");
 
		HomeTheaterFacade homeTheater = 
				new HomeTheaterFacade(amp, player, lights, popper);
 
		homeTheater.playMovie("Raiders of the Lost Ark");
    }
}
