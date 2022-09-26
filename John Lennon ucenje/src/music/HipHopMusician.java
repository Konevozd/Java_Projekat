package music;

import util.Nationality;

public class HipHopMusician extends Musician {

	private String category;

	public HipHopMusician(String name, boolean alive, int age, Nationality nationality,String category) {
		super(name, alive, age, nationality);
		this.category = category;
	}

	public HipHopMusician() {
		super();
	}

	@Override
	public String toString() {
		return super.toString() + "; category: " + this.category;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
}
