package music;

public class SongNotInListException extends RuntimeException {

	//treba da bude u paketu gde je i klasa gde se moze desiti greska
	//bitni su konstruktori kod exception-a zbog super();
	
	private Song song;
	private Playlist playlist;
	
	public SongNotInListException(Song song, Playlist playlist) {
		super();
		this.song = song;
		this.playlist = playlist;
	}
	
	@Override
	public String getMessage() {
		return "song " + this.song.getTitle() + " not in " + this.playlist.getTitle() + " playlist";
	}
	
	public SongNotInListException() {
		super();
	}
	
	public Song getSong() {
		return song;
	}
	public void setSong(Song song) {
		this.song = song;
	}
	public Playlist getPlaylist() {
		return playlist;
	}
	public void setPlaylist(Playlist playlist) {
		this.playlist = playlist;
	}
	
}
