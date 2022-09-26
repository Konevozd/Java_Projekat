package music;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import util.Nationality;

public class HallOfFameRockMusician extends RockMusician {

	private GregorianCalendar inducted;

	public HallOfFameRockMusician(String name, boolean alive, int age, Nationality nationality, Genre genre,GregorianCalendar inducted) {
		super(name, alive, age, nationality, genre);
		this.inducted = inducted;
	}
	
	public HallOfFameRockMusician() {
		super();
	}
	
	@Override
	public String toString() {
		return super.toString() + "; inducted: " + new SimpleDateFormat("EEE, MMM dd, YYYY").format(inducted.getTime());
	}

	public GregorianCalendar getInducted() {
		return inducted;
	}

	public void setInducted(GregorianCalendar inducted) {
		this.inducted = inducted;
	}
	
}
