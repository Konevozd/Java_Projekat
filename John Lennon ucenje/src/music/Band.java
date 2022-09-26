package music;

import java.util.ArrayList;

public class Band {

	private String name;
//	private ArrayList<Musician> members = new ArrayList<Musician>(); //moze ovako,a moze i u konstruktoru
	private ArrayList<Musician> members;
	
	public Band(String name, ArrayList<Musician> members) {
		super();
		this.name = name;
		if(this.members == null) {
			this.members = new ArrayList<Musician>();
		}
		this.members = members;
	}
	
	public Band() {
		super();
		this.members = new ArrayList<Musician>();
		//ne moze na null listu da se pozove f-ja
	}
	
	public boolean addMember(Musician m) {
		if(this.members.contains(m)) {
			return false;
		}
		return this.members.add(m);
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for(Musician m : members) {
			sb.append(m.getName()).append(", ");
		}
		sb.delete(sb.length() - 2, sb.length());
		return this.name + " (" + sb + ")";
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Band))
			return false;
		Band b = (Band) obj;
		if(this.name.equals(b.getName()))
			return true;
		return false;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Musician> getMembers() {
		return members;
	}

	public void setMembers(ArrayList<Musician> members) {
		this.members = members;
	}
}
