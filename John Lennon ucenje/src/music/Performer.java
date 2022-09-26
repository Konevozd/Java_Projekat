package music;

import java.io.Serializable;

import util.Nationality;

public abstract class Performer implements Serializable{

	protected String name;
    protected boolean alive;
    protected int age;
    protected Nationality nationality;
    
    public Performer(){
    	super();
    }

    public String getName() {
        return name;
    }
	
    public abstract void perform();
    
    public void setName(String name) {
        this.name = name;
    }
    public boolean isAlive() {
        return alive;
    }
    public void setAlive(boolean alive) {
        this.alive = alive;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public Nationality getNationality() {
        return nationality;
    }
    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }
    
}
