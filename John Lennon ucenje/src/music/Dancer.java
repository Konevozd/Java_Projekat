package music;

import util.Nationality;

public class Dancer extends Performer implements Artist {

	@Override
	public void perform() {
		System.out.println(this.name + ": I am dancing");
	}
	
	public Dancer(String name, boolean alive, int age, Nationality nationality) {
        super();
        this.name = name;
        this.alive = alive;
        this.age = age;
        this.nationality = nationality;
    }
    
    public Dancer() {
        super();
    }

	@Override
	public String getArt() {
		return "dancing";
	}

	@Override
	public void display() {
		System.out.println(this.name + ", dancer");
	}
}
