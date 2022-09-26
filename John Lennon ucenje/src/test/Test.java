package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import music.Album;
import music.AlreadyPlayedException;
import music.Artist;
import music.Band;
import music.Dancer;
import music.Genre;
import music.HallOfFameRockMusician;
import music.HipHopMusician;
import music.Musician;
import music.Performer;
import music.Playlist;
import music.RockMusician;
import music.Song;
import music.SongNotInListException;
import util.Nationality;
import util.Utility;

public class Test {

	public static final Scanner IN = new Scanner(System.in);
    
    public void testPrintln() {
        System.out.println("John Lennon" + " was one of the greatest men of the 20th century" + '\n' + 
                            "and his life and work have inspired this class.");
    }
    
    public void testScanner() {
        System.out.print("Read a line: ");
        String s = IN.nextLine();
        System.out.println("You entered: " + s);
    }
    
    public void testMusician() {
    	Musician johnLennon = new Musician("John", false, 80, Nationality.UK);
        System.out.println(johnLennon.getName() + " was 40 when he got assassinated.");
        johnLennon.setName("John Lennon");
        System.out.print(johnLennon.getName());
        if (johnLennon.isAlive()) {
            System.out.println(" (" + johnLennon.getAge() + ")");
        } else {
            System.out.println(" (passed away)");
        }
//        System.out.println(johnLennon.getName() + " was 40 when he got assassinated.");
        System.out.println(johnLennon);
    }
    
    public void testSong() {
    	Musician johnLennon = new Musician("John Lennon", false, 80, Nationality.UK);
        Song imagine = new Song("Imagine", johnLennon, 1971);
        System.out.println(imagine);
    }
    
    public void testStatic() {
        Musician johnLennon = new Musician("John Lennon", false, 80, Nationality.UK);
        johnLennon.showDefinition();    // OK, but not typical
        Musician.showDefinition();      // typical
        System.out.println();
        
//        System.out.println(johnLennon.definition);        // no, definition is private
        System.out.println(johnLennon.getDefinition());     // OK, but not typical
        System.out.println();
        
        Musician paulMcCartney = new Musician("Paul McCartney", true, 78, Nationality.UK);
        paulMcCartney.setDefinition("An artist who performs music.");
        System.out.println(johnLennon.getDefinition());
        System.out.println();
        
        System.out.println(Math.PI);
    }
    
    public void testArrays() {
        int[] a = new int[3];
        for (int i = 0; i < a.length; i++) {
            a[i] = i + 1;
            System.out.println("a[" + i + "] = " + a[i]);
        }
    }
    
    public void testLoops() {
        System.out.println("for loop:");
        int[] a = new int[3];
        for (int i = 0; i < a.length; i++) {
            a[i] = i + 1;
            System.out.println("a[" + i + "] = " + a[i]);
        }
        System.out.println();
        
        System.out.println("while loop:");
        int i = 0;
        while (i < a.length) {
            System.out.println("a[" + i + "] = " + a[i]);
            i = i + 1;
        }
        System.out.println();
        
        System.out.println("do-while loop:");
        i = 0;
        do {
            System.out.println("a[" + i + "] = " + a[i]);
            i++;
        } while (i < a.length);
        System.out.println();
        
        System.out.println("'for each' loop:");
        for (int j : a) {
            System.out.println(j);
            System.out.println("a[" + (j - 1) + "] = " + j);
        }
    }
    
    public void testBreakAndContinue() {
        System.out.println("for loop:");
        int[] a = new int[3];
        for (int i = 0; i < a.length; i++) {
            a[i] = i + 1;
            if (i == 1) {
//                break;
                continue;
            }
            System.out.println("a[" + i + "] = " + a[i]);
        }
    }
    
    public void testArraysOfObjects() {
//        Musician[] theBeatles = new Musician[4];
//        theBeatles[0] = new Musician("John Lennon", false, 80, Nationality.UK);
//        theBeatles[1] = new Musician("Paul McCartney", true, 78, Nationality.UK);
//        theBeatles[2] = new Musician("George Harrison", false, 77, Nationality.UK);
//        theBeatles[3] = new Musician("Ringo Starr", true, 80, Nationality.UK);
        
        Musician johnLennon = new Musician("John Lennon", false, 80, Nationality.UK);
        Musician paulMcCartney = new Musician("Paul McCartney", true, 78, Nationality.UK);
        Musician georgeHarrison = new Musician("George Harrison", false, 77, Nationality.UK);
        Musician ringoStarr = new Musician("Ringo Starr", true, 80, Nationality.UK);
        Musician[] theBeatles = {johnLennon, paulMcCartney, georgeHarrison, ringoStarr};
        
        for (Musician m : theBeatles) {
            System.out.println(m);
        }
        
        System.out.println();
        
        Song mother = new Song("Mother", johnLennon, 1970); 
        Song lookAtMe = new Song("Look at Me", johnLennon, 1970); 
        Song god = new Song("God", johnLennon, 1970); 
        
        Song[] songs = {mother, lookAtMe, god};
        Album jLennon = new Album("John Lennon / Plastic Ono Band", songs);
        System.out.println(jLennon);
    }
    
    public void testSwitch() {
        System.out.print("Read an int between 1 and 4: ");
        int i = IN.nextInt();
        switch (i) {
            case 1: System.out.println("John"); break;
            case 2: System.out.println("Paul"); break;
            case 3: System.out.println("George"); break;
            case 4: System.out.println("Ringo"); break;
        }
    }
    
    public void testIntegerAndDouble() {
        Integer i = new Integer(2);
        Double d = new Double(3.8);
        
        System.out.println("i.doubleValue() = " + i.doubleValue());
        System.out.println("d.intValue() = " + d.intValue());
        System.out.println("d rounded = " + Math.round(d));
    }
    
    public void testNumberFormating() {
        NumberFormat nf = NumberFormat.getInstance();
        System.out.println(6 / 7);
        System.out.println((double) 6 / 7);
        nf.setMaximumFractionDigits(2);
        System.out.println(nf.format((double) 6 / 7));
        nf.setMaximumFractionDigits(3);
        System.out.println(nf.format((double) 6 / 7));
    }
    
    public void testStrings() {
        String john = "John Lennon";
        System.out.println(john.charAt(5));
        System.out.println(john.concat(" was born in Liverpool, UK."));
        System.out.println(john.endsWith("Lennon"));
        System.out.println(john.startsWith("John"));
        System.out.println(john.substring(5, john.length()));
        String[] words = john.split(" ");
        for (String word : words) {
            System.out.println(word);
        }
        System.out.println(String.join(" ", words));
        System.out.println();
        System.out.println(Integer.parseInt("123"));
        System.out.println(String.valueOf(123));
        System.out.println(String.format("%s%.2f", "6 / 7: ", (double) 6 / 7));
        System.out.printf(String.format("%s%.2f", "6 / 7: ", (double) 6 / 7));
    }
    
    public void testStringBuffers() {
        StringBuffer sb = new StringBuffer("John Lennon");
        sb.append(" was born in ");
        sb.append(1940).append(" in Liverpool !!!").delete(sb.length() - 4, sb.length()).append('.');
        System.out.println(sb);
        System.out.println();
        
        Musician johnLennon = new Musician("John Lennon", false, -1, Nationality.UK);
        Song mother = new Song("Mother", johnLennon, 1970); 
        Song lookAtMe = new Song("Look at Me", johnLennon, 1970); 
        Song god = new Song("God", johnLennon, 1970); 
        
        Song[] songs = {mother, lookAtMe, god};
        Album jLennon = new Album("John Lennon / Plastic Ono Band", songs);
        
        System.out.println(jLennon);
    }
    
    public void testEquals() {
    	String s1 = "John Lennon";
    	String s2 = "John Lennon";
    	if(s1.equals(s2))
    		System.out.println(true);
    	else
    		System.out.println(false); //radi ali nije pravilno,to je kada stavimo s1 == s2
    	
    	Musician johnLennon = new Musician("John Lennon", false, -1, Nationality.UK);
    	Musician johnL = new Musician("John Lennon", false, -1, Nationality.UK);
    	if(johnL.equals(johnLennon)) //a sa == kaze false
    		System.out.println(true);
    	else
    		System.out.println(false);
    	
    }
    
    public void testArrayList() {
//    	//linkedlist je dvostruko spregnuta lista
//    	ArrayList<String> theBeatlesNames = new ArrayList<String>();//lista objekata tipa String,a cela lista je tip naseg objekta
//    	theBeatlesNames.add("John");
//    	theBeatlesNames.add("Paul");
//    	theBeatlesNames.add("George");
//    	theBeatlesNames.add("Ringo");
//    	System.out.println(theBeatlesNames);
//    	//odstampace kao toString odgovarajuce klase
//    	System.out.println();
//    	
//    	System.out.println(theBeatlesNames.get(0));
//    	System.out.println(String.join(", ", theBeatlesNames.toArray(new String[theBeatlesNames.size()])));//1. je cime razdvajamo(delimeter)
//    	//mora string vektor jer su elementi tipa String
//    	theBeatlesNames.remove(0);
//    	System.out.println(theBeatlesNames);
    	
    	 Musician johnLennon = new Musician("John Lennon", false, 80, Nationality.UK);
         Musician paulMcCartney = new Musician("Paul McCartney", true, 78, Nationality.UK);
         Musician georgeHarrison = new Musician("George Harrison", false, 77, Nationality.UK);
         Musician ringoStarr = new Musician("Ringo Starr", true, 80, Nationality.UK);
         
         Band theBeatles = new Band();
//       ArrayList<Musician> members = new ArrayList<Musician>();
         theBeatles.setName("The Beatles");
         
         theBeatles.addMember(johnLennon);
         theBeatles.addMember(paulMcCartney);
         theBeatles.addMember(georgeHarrison);
         theBeatles.addMember(ringoStarr);
         
         System.out.println(theBeatles);
    }
    
    public void testGregorianCalendar() {
//    	GregorianCalendar c = new GregorianCalendar();
////    	System.out.println(c);
//    	System.out.println(c.getTime()); //Pravilan ispis vremena
//    	System.out.println(c.get(Calendar.YEAR));
//    	System.out.println(c.get(Calendar.MONTH));
//    	//M - month,m - minute
//    	
//    	System.out.println((new SimpleDateFormat("EEE, MMM dd, YYYY")).format(c.getTime()));
//    	System.out.println((new SimpleDateFormat("dd.MM.YYYY.")).format(c.getTime()));
//    	
//    	GregorianCalendar jBirthday = new GregorianCalendar(1940,9,9);
//    	System.out.println((new SimpleDateFormat("EEE, MMM dd, YYYY")).format(jBirthday.getTime()));
//    	System.out.println();
//    
//    	System.out.println(jBirthday.after(c));
//    	System.out.println(jBirthday.before(c));
    	
    	 Musician johnLennon = new Musician("John Lennon", false, -1, Nationality.UK);
         Song mother = new Song("Mother", johnLennon, 1970); 
         Song lookAtMe = new Song("Look at Me", johnLennon, 1970); 
         Song god = new Song("God", johnLennon, 1970); 
         
         Song[] songs = {mother, lookAtMe, god};
         
         Album jLennon = new Album("John Lennon / Plastic Ono Band", songs,new GregorianCalendar(1970,11,11));
         Album johnL = new Album("John Lennon / Plastic Ono Band", songs,new GregorianCalendar(1970,11,11));
         System.out.println(jLennon);
         
         johnL.setReleaseDate(new GregorianCalendar(1990,11,23));
         System.out.println(johnL);
         johnL.setReleaseDate(new GregorianCalendar(1900,11,23));
         System.out.println(johnL);
         System.out.println(johnL.equals(jLennon));
    }
    
    public void testInheritance() {
    	Musician john = new Musician("John Lennon", false, -1, Nationality.UK);
    	RockMusician JohnL = new RockMusician("John Lennon", false, -1, Nationality.UK, Genre.CLASSIC_ROCK);
    
    	System.out.println(john);
    	System.out.println(JohnL);
    	System.out.println(JohnL.equals(john));
    	
    	Musician johnLennon = new RockMusician("John Lennon", false, -1, Nationality.UK,Genre.CLASSIC_ROCK);
    	
//    	RockMusician jL = new Musician("John Lennon", false, -1, Nationality.UK); //ne moze 
//    	johnLennon.getAge();
//    	johnLennon.getGenre(); //nece moci
    
    	HallOfFameRockMusician johnLennonLennon =
    			new HallOfFameRockMusician("John Lennon", false, -1, Nationality.UK, Genre.CLASSIC_ROCK, new GregorianCalendar(1988, 0 ,19));
    	System.out.println(new SimpleDateFormat("EEE, MMM dd, YYYY").format(johnLennonLennon.getInducted().getTime()));
    	System.out.println(johnLennonLennon);
    	System.out.println();
    	johnLennonLennon.play();
    	System.out.println();
    	
    	HipHopMusician eminem = new HipHopMusician("Eminem", true, 50, Nationality.USA, "Detroit");
    	System.out.println(eminem);
    }
    
    public void testPolymorphism() {
    	Musician john = new Musician("John Lennon", false, -1, Nationality.UK);
    	RockMusician johnL = new RockMusician("John Lennon", false, -1, Nationality.UK, Genre.CLASSIC_ROCK);
    	
    	john.play();
    	System.out.println();
    	johnL.play();
    	System.out.println();
    	
    	Musician johnLennon = new RockMusician("John Lennon", false, -1, Nationality.UK,Genre.CLASSIC_ROCK);
    	johnLennon.play();
    }
    
    public void testAbstractClasses() {
//    	Performer p = new Performer(); //no, Performer is an abstract class
    	Musician john = new Musician("John Lennon", false, -1, Nationality.UK);
    	Performer p = new Musician("John Lennon", false, -1, Nationality.UK);
//    	p.play(); //ne moze
    	p.perform();
    	System.out.println();
    	
    	Performer d = new Dancer("D", true, 28, Nationality.CANADA);
    	d.perform();
    }
    
    public void testInterfaces() {
    	Artist john = new Musician("John Lennon", false, -1, Nationality.UK);
    	Artist d = new Dancer("D", true, 28, Nationality.CANADA);
    	
//    	john.getName(); //nece moci
    	System.out.println(john.getArt());
    	System.out.println(d.getArt());
    	john.display();
    	System.out.println();
    	
//    	List<String> theBeatlesNames = new ArrayList<String>();
    	List<String> theBeatlesNames = new LinkedList<String>();
    	theBeatlesNames.add("John");
    	theBeatlesNames.add("Paul");
    	theBeatlesNames.add("George");
    	theBeatlesNames.add("Ringo");
    	System.out.println(theBeatlesNames);
    }
    
    public void testIterators() {
    	List<String> theBeatlesNames = new LinkedList<String>();
    	theBeatlesNames.add("John");
    	theBeatlesNames.add("Paul");
    	theBeatlesNames.add("George");
    	theBeatlesNames.add("Ringo");
    	System.out.println(theBeatlesNames);
    	
    	Iterator<String> iter = theBeatlesNames.iterator();
//    	System.out.println(iter.next());
//    	System.out.println(iter.next());
//    	System.out.println(iter.next());
//    	System.out.println(iter.next());
//    	System.out.println(iter.next()); //iscrpeli smo pa nece moci
    	
    	System.out.println();
    	
//    	for(String s : theBeatlesNames) {
//    		if(iter.hasNext()) {
//    			System.out.println(iter.next());
//    		}
//    		else {
//    			System.out.println("Done");
//    		}
//    	}
//    	
//    	for(int i = 0; i < theBeatlesNames.size(); i++) {
//    		System.out.println(theBeatlesNames.get(i));
//    		theBeatlesNames.remove(i);
//    	} //ne valja ovako
    	
//    	for(int i = 0; i < theBeatlesNames.size(); i++) {
//    		if(iter.hasNext()) {
//    			System.out.println(iter.next());
//    			theBeatlesNames.remove(i);
//    		}
//    	} //ne valja ovako
    	
    	while(iter.hasNext()) {
    		System.out.println(theBeatlesNames);
    		iter.next(); //daje trenutni element,prodjemo kroz trenutni element
    		iter.remove();
    	}
    	
    }
    
    public void testExceptions() {
//    	int[] a = {1, 2, 3};
//    	for(int i = 0; i <= a.length; i++) {
//    		System.out.println(a[i]);
//    	}
    	
    	Musician johnLennon = new Musician("John Lennon", false, -1, Nationality.UK);
        Song mother = new Song("Mother", johnLennon, 1970); 
        Song lookAtMe = new Song("Look at Me", johnLennon, 1970); 
        Song god = new Song("God", johnLennon, 1970); 
        Song isolation = new Song("Isolation", johnLennon, 1970);
        
        List<Song> songs = new ArrayList<Song>();
        songs.add(mother);
        songs.add(lookAtMe);
        songs.add(god);
        
        List<Boolean> alreadyPlayed = new ArrayList<Boolean>();
        alreadyPlayed.add(false);
        alreadyPlayed.add(false);
        alreadyPlayed.add(false);
        
        Playlist playlist = new Playlist("John Lennon / Plastic Ono Band", songs, alreadyPlayed, false, false);
        
//      AKO NE ZELIMO NON STOP DA PISEMO TRY/CATCH BLOK,ONDA STAVIMO DA SE NASLEDJUJE IZ RUNTIME EXCEPTION
        
//      playlist.playSong(mother); //ako zelimo da reagujemo ovde,onda surround with try/catch

//      playlist.playSong(isolation);
        
//      try {
//			playlist.playSong(mother);
//		} catch (SongNotInListException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} //posto smo dodali alreadyplayed sada add catch to surrounding try
        
        try {
			playlist.playSong(mother);
		} catch (SongNotInListException e) {
			e.printStackTrace();
		} catch (AlreadyPlayedException e) {
			e.printStackTrace();
		} finally { //uvek se izvrsava
			System.out.println();
			System.out.println("Song played");
			System.out.println("It's a good one :)");
		}
    	System.out.println();
        
        try {
			playlist.playSong(isolation);
		} catch (SongNotInListException e) { //exception handler
			e.printStackTrace();
//			System.err.println("Song not in list, play another one");
//			System.err.println(e.getMessage());
		} catch (AlreadyPlayedException e) { //moze umesto ova 2 exceptiona da se stavi exception,ali bolje da bude konkretan
			e.printStackTrace();
		}
        
        System.out.println();
        playlist.setRepeat(true);
        try {
			playlist.playSong(mother);
		} catch (SongNotInListException | AlreadyPlayedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
    
    public void testIO() {
    	Musician johnLennon = new Musician("John Lennon", false, -1, Nationality.UK);
        Song mother = new Song("Mother", johnLennon, 1970);
        Song lookAtMe = new Song("Look at Me", johnLennon, 1970);
        
//    	File f;
//    	PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(new File("test.txt")))); //pa surround with try/catch
    	
        try {
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(new File("test.txt"))));
			out.println(mother.getTitle());
			out.println(mother.getYear());
			out.println(lookAtMe.getTitle());
			out.println(lookAtMe.getYear());
			out.flush(); //ciscenje bafera sa podacima
			out.close();
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("Done");
		}
        
        BufferedReader in = null;
		Song s1 = new Song();
		Song s2 = new Song();
        try {
			in = new BufferedReader(new FileReader(new File("test.txt")));
			s1.setTitle(in.readLine()); //add catch clause to surrounding try za 2 catch
			s1.setYear(Integer.parseInt(in.readLine()));
			s2.setTitle(in.readLine()); 
			s2.setYear(Integer.parseInt(in.readLine()));
			in.close();
        } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("Songs read (if no exception occured),but no song authors are set");
		}
        
        s1.setAuthor(johnLennon);
        s2.setAuthor(johnLennon);
        System.out.println(s1);
        System.out.println(s2);
        
    }
    
    public void testSerialization() {
    	Musician johnLennon = new Musician("John Lennon", false, -1, Nationality.UK);
        Song mother = new Song("Mother", johnLennon, 1970);
        
        mother.serialize("mother.serialized");
        
    }
    
    public void testDeserialization() {
    	Song mother = Song.deserialize("mother.serialized");
    	System.out.println(mother);
    }
    
    public void testDirs() {
    	System.out.println(Utility.getProjectDir());
    	System.out.println(Utility.getSubDir("\\sd\\sd1\\sd2")); //moze 1,moze vise,koliko zelimo
    	//izbrisali smo jer je bilo samo isprobavanje
    }
    
}
