package music;

import util.PerformingArt;

public interface Artist {

	public String getArt();
	default public void display() {
		System.out.println(PerformingArt.MUSIC.toString().toLowerCase());
	}//ovo da ne bismo morali u svakoj klasi koja implementira da dzaba ubacujemo,zato ide default,a mozemo da redefinisemo u klasi
	
}
