package music;

import util.Nationality;

public class RockMusician extends Musician {

	private Genre genre;

	public RockMusician(String name, boolean alive, int age, Nationality nationality,Genre genre) {
		super(name, alive, age, nationality);
		this.genre = genre;
	}
	
	public RockMusician(String name, boolean alive, int age, Nationality nationality) {
		this(name, alive, age, nationality, null); //odnosi se na konstruktor date klase (u zavisnosti od toga sta je u njoj)
//		super(name, alive, age, nationality);
	}

	public RockMusician(String name, int age, Nationality nationality) {
		this(name, false, age, nationality, null);
//		super(name, age, nationality);
	}
	
	public RockMusician() {
		super(); //pozovi prazan konstruktor iz nadklase
		// TODO Auto-generated constructor stub
	}

	public void play() {
		super.play();
		System.out.println("rock 'n' roll...");
	}
	
	public void play(String s) {
		super.play();
		System.out.println("rock 'n' roll...");
	}
	
	@Override
	public String toString() {
		return super.toString() + "; " + this.genre.toString().toLowerCase(); //moze i .name() umesto toString()
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof RockMusician))
			return super.equals(obj);
		RockMusician m = (RockMusician) obj;
		return this.name.equals(m.getName()) && this.age == m.getAge() && this.genre.equals(m.getGenre());
		//da je private ne bi radilo,pa mora protected u nadklasi
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	
}
