package music;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Song implements Serializable {
	
	/*ANY-ACCESS-MODIFIER*/ static final long serialVersionUID = 1204L;
	//prilikom serijalizacije ce da se upamti ovaj serialVersionUID,a u deserijalizaciji ce da procita lepo
	//jer smo in.readObject dodelili ovu nasu vrednost,a ne neku koju je java sama dodelila
	
	private String title;
 	private Musician author;
    private int year;
    
    public Song(String title, Musician author, int year) {
        super();
        this.title = title;
        this.author = author;
        this.year = year;
    }
    
    public Song(String title, int year) {
        super();
        this.title = title;
        this.year = year;
    }

    public Song() {
        super();
    }
    
    public void serialize(String filename) {
    	//za upisivanje celog songa u binarni fajl
    	try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File(filename)))) {
//    		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File(filename)));
    		out.writeObject(this); 
    		//za dati objekat upise u stream koja je klasa objekta, pa vrednosti...
    		//na kraju se dobije niz bajtova vezan za nas objekat,tj Song u ovom slucaju pa ide this
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //ovako sve sto smo ispisali nece raditi pa mora kod klase da se stavi da implementuje Serializable
    	//on je prazan jer samo njegovom implementacijom kazemo javi da zelimo to da serijalizujemo
    	//ni ovako nece raditi jer kaze da je u musician problem, pa u njemu i u performer-u moramo isto da odradimo
    }
    
    public static Song deserialize(String filename) {
    	Song s = null;
    	try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File(filename)))){
    		s = (Song) in.readObject(); //za njega je ClassNotFoundException
    	} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return s;
    }
    
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.title + " (" + this.year + "), " + this.author.getName();
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Song other = (Song) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

	public Musician getAuthor() {
		return author;
	}

	public void setAuthor(Musician author) {
		this.author = author;
	}
	
}
