package util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import music.Musician;

public class Utility {

	public static String getProjectDir() {
		File f = new File("."); // . - trenutni folder
//		String projectDir = f.getAbsolutePath(); //ako kazemo getName onda ce vratiti ime,a ovako celu putanju ukljucujuci i .
		StringBuffer projectDir =new StringBuffer(f.getAbsolutePath());
		projectDir.delete(projectDir.length() - 1, projectDir.length()); //da se obrise .
		return projectDir.toString();
	}
	
	public static String getSubDir(String subdir) {
//		File(String parent,String child)
		
		File f = new File(getProjectDir(), subdir); //nismo napravili jos uvek podfolder
		//folder i fajl je isto sa strane os ili jave
		
		f.mkdirs(); //u mnozini zato sto subdir moze da sadrzi vise razlicitih podfoldera,ovako ih sve napravi
		
		return f.getAbsolutePath() + "\\";
	}
	
	public static String getResourcesDir() {
		return getSubDir("\\resources");
	}
	
	public static ArrayList<String> getPhotoFileNames(){
		ArrayList<String> photoFileNames = new ArrayList<String>();
		File[] files = new File(getResourcesDir()).listFiles(); //vektor svih tih fajlova iz naseg direktorijuma resources
		
		for(File f : files) {
			if(!f.getName().toLowerCase().endsWith(".txt")) {
				photoFileNames.add(f.getName());
			}
		}
		
		return photoFileNames;
	}
	
	public static Musician findMusician(String name, List<Musician> musicians) {
		for(Musician m : musicians) {
			if(m.getName().equals(name))
				return m;
		}
		
		return null;
	}
	
}
