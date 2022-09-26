package music;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.GregorianCalendar;

public class Album {
	    
		public static final GregorianCalendar FIRST_EVER = new GregorianCalendar(1909, 3, 10);
	
	    private String title;
	    private Song[] songs;
	    private GregorianCalendar releaseDate;
	    
	    public Album(String title, Song[] songs, GregorianCalendar releaseDate) {
			super();
			this.title = title;
			this.songs = songs;
			setReleaseDate(releaseDate);
		}

		public Album(String title, Song[] songs) {
	        super();
	        this.title = title;
	        this.songs = songs;
	    }

	    public Album(String title, int noOfSongs) {
	        super();
	        this.title = title;
	        this.songs = new Song[noOfSongs];
	        for (int i = 0; i < noOfSongs; i++) {
	            songs[i] = new Song();
	        }
	    }

	    public Album() {
	        super();
	    }
	    
	    @Override
	    public String toString() {
//	        return this.title + " (" + this.songs.length + " songs)";
	        StringBuffer s = new StringBuffer();
	        for (Song song : this.songs) {
	            s.append(song.toString() + "\n\t");
	        }
//	        return this.title + ":\n\t" + s.toString();
	        return this.title + " ("+ new SimpleDateFormat("EEE, MMM dd, YYYY").format(this.releaseDate.getTime()) + ")"
	        		+ "" + ":\n\t" + s.toString();
	    }

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((releaseDate == null) ? 0 : releaseDate.hashCode());
			result = prime * result + Arrays.hashCode(songs);
			result = prime * result + ((title == null) ? 0 : title.hashCode());
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
			Album other = (Album) obj;
			if (releaseDate == null) {
				if (other.releaseDate != null)
					return false;
			} else if (!releaseDate.equals(other.releaseDate))
				return false;
			if (!Arrays.equals(songs, other.songs))
				return false;
			if (title == null) {
				if (other.title != null)
					return false;
			} else if (!title.equals(other.title))
				return false;
			return true;
		}

		public String getTitle() {
	        return title;
	    }

	    public void setTitle(String title) {
	        this.title = title;
	    }

	    public Song[] getSongs() {
	        return songs;
	    }

	    public void setSongs(Song[] songs) {
	        this.songs = songs;
	    }

		public GregorianCalendar getReleaseDate() {
			return releaseDate;
		}

		public void setReleaseDate(GregorianCalendar releaseDate) {
			if(releaseDate.after(FIRST_EVER))
				this.releaseDate = releaseDate;
			else {
				System.out.println("Greska: Datum mora biti nakon 10.4.1909.");
//				releaseDate = null;
			}
		}
	
}
