package music;

//import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Playlist {

	private String title;
	private List<Song> songs = new ArrayList<Song>();
	private List<Boolean> alreadyplayed = new ArrayList<Boolean>();
	private boolean repeat = false;
	private boolean shuffle = false;
	
	public Playlist(String title, List<Song> songs, List<Boolean> alreadyplayed, boolean repeat, boolean shuffle) {
		super();
		this.title = title;
		this.songs = songs;
		this.alreadyplayed = alreadyplayed;
		this.repeat = repeat;
		this.shuffle = shuffle;
	}
	
	public Playlist() {
		super();
	}
	
	//sve je ovo sad signatura metode u redu 29
	public void playSong(Song song) throws SongNotInListException, AlreadyPlayedException{ //moze da generise ovaj izuzetak
		int i = this.songs.indexOf(song); //ako nije u listi,onda vrati -1
//		if(this.songs.contains(song)) {
		if(i >= 0 && i <= this.songs.size()) {
			if (this.alreadyplayed.get(i)) {
				if(repeat) {
					System.out.println("Playing: " + song);
				}
				else {
					throw new AlreadyPlayedException(song);
				}
			}
			else {
				System.out.println("Playing: " + song);
				this.alreadyplayed.set(i, true);
			}
		}
//		else {
//			throw new SongNotInListException(song,this);
//		} //pa smo izabrali add throws declaration pa se pojavilo gore kod f-je
		else {
			throw new SongNotInListException(song,this);
		}
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Song> getSongs() {
		return songs;
	}
	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}
	public List<Boolean> getAlreadyplayed() {
		return alreadyplayed;
	}
	public void setAlreadyplayed(List<Boolean> alreadyplayed) {
		this.alreadyplayed = alreadyplayed;
	}
	public boolean isRepeat() {
		return repeat;
	}
	public void setRepeat(boolean repeat) {
		this.repeat = repeat;
	}
	public boolean isShuffle() {
		return shuffle;
	}
	public void setShuffle(boolean shuffle) {
		this.shuffle = shuffle;
	}
	
}
