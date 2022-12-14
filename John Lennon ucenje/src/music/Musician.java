package music;

import java.io.Serializable;

import javax.swing.Icon;

import util.Nationality;
import util.PerformingArt;

public class Musician extends Performer implements Artist, Serializable {

	private static String definition;
	public static final PerformingArt performingArt = PerformingArt.MUSIC;
	
	private Icon icon;
	
    static {
        definition = "A person who composes or performs music.";
    }
    
    public Musician(String name, boolean alive, int age, Nationality nationality,Icon icon) {
        super();
        this.name = name;
        this.alive = alive;
        this.age = age;
        this.nationality = nationality;
        this.icon = icon;
    }
    
    public Musician(String name, boolean alive, int age, Nationality nationality) {
        super();
        this.name = name;
        this.alive = alive;
        this.age = age;
        this.nationality = nationality;
    }
    
    public Musician(String name, int age, Nationality nationality) {
        super();
        this.name = name;
        this.age = age;
        this.nationality = nationality;
    }
    
    public Musician() {
        super();
    }

	@Override
	public void perform() {
		this.play();
	}

	@Override
	public String getArt() {
		return "music";
	}

//	@Override
//	public void display() {
//		System.out.println(this.name + ", musician");
//	}
    
    public static void showDefinition() {
        System.out.println(definition);
    }
    
    public void play() {
    	System.out.println(this.name + " is playing...");
    }
    
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.name + " (" + this.nationality.name() + "), " + (this.alive ? this.age : "passed away");
    }
    
    @Override
    	public boolean equals(Object obj) {
    		if(!(obj instanceof Musician))
    			return false;
    		Musician m = (Musician) obj; //class cast
    		if((this.name.equals(m.getName()) && (this.age == m.getAge()) && (this.nationality == m.getNationality())))
    			return true;
    		return false;
    	}
    
    public static String getDefinition() {
        return definition;
    }
    public static void setDefinition(String definition) {
        Musician.definition = definition;
    }

	public Icon getIcon() {
		return icon;
	}

	public void setIcon(Icon icon) {
		this.icon = icon;
	}

}
