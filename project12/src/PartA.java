import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Collections;

public class PartA {
	public static void main(String[] args) {
		boolean running = true;
		final String SONGFILE = "./songs.txt";

		ArrayList<Song> songList = getSongList(SONGFILE);

		while (running) {
			running = programLoop(songList);
		}

		writeSongFile(songList, SONGFILE);
		System.out.println();
		System.out.println("All changes saved.");
		System.out.println("Done.");
	}

	// Program Loop
	public static boolean programLoop(ArrayList<Song> songList) {
		boolean running = true;

		// Store the options as an array of strings
		String[] choices = { "Search by Song", "Search by Artist",
				"Search by Album", "Add New Song", "Sort Songs By Artist",
				"Exit" };

		System.out.println("My Song List");
		System.out.println("------------");

		for (int i = 0; i < choices.length; i++) {
			System.out.println((i + 1) + ". " + choices[i]);
		}

		// Get the action the user wants to perform

		int userChoice = promptIntInRange("[1, 6]: ", 1, 6);
		userChoice = userChoice - 1;

		switch (userChoice) {
		case 0:
			searchBySong(songList);
			break;
		case 1:
			searchByArtist(songList);
			break;
		case 2:
			searchByAlbum(songList);
			break;
		case 3:
			addNewSong(songList);
			break;
		case 4:
			sortSongsByArtist(songList);
			break;
		case 5:
			running = false;
			break;
		default:
			break;
		}

		return running;
	}

	/*
	 * Methods that describe user actions
	 */

	// Search functionality

	// Search by Song
	public static void searchBySong(ArrayList<Song> songList) {
		String query = prompt("Select a song to search by");

		int currentIndex = 0;
		ArrayList<Integer> songLocations = new ArrayList<Integer>();

		Iterator<Song> songIter = songList.iterator();

		while (songIter.hasNext()) {
			String songName = songIter.next().getName();

			if (query.equals(songName)) {
				songLocations.add(currentIndex);
			}

			currentIndex++;
		}

		printSelective(songList, songLocations);
	}

	// Search by Artist
	public static void searchByArtist(ArrayList<Song> songList) {
		String query = prompt("Select an artist to search by");

		int currentIndex = 0;
		ArrayList<Integer> songLocations = new ArrayList<Integer>();

		Iterator<Song> songIter = songList.iterator();

		while (songIter.hasNext()) {
			String songArtist = songIter.next().getBand();

			if (query.equals(songArtist)) {
				songLocations.add(currentIndex);
			}

			currentIndex++;
		}

		printSelective(songList, songLocations);
	}

	// Search by Album
	public static void searchByAlbum(ArrayList<Song> songList) {
		String query = prompt("Select an album to search by");

		int currentIndex = 0;
		ArrayList<Integer> songLocations = new ArrayList<Integer>();

		Iterator<Song> songIter = songList.iterator();

		while (songIter.hasNext()) {
			String songAlbum = songIter.next().getAlbum();

			if (query.equals(songAlbum)) {
				songLocations.add(currentIndex);
			}

			currentIndex++;
		}

		printSelective(songList, songLocations);
	}

	// Add a new song to the list
	public static void addNewSong(ArrayList<Song> songList) {
		// Get the information
		String name = prompt("Enter song name");
		String band = prompt("Enter song arist");
		String album = prompt("Enter song album");
		String time = prompt("Enter song duration");

		// Make the class then add to list
		Song song = new Song(name, band, album, time);
		songList.add(song);

		System.out.println("\nSong has been added\n");
	}

	// Sorting the Songs by Artists
	public static void sortSongsByArtist(ArrayList<Song> songList) {
		int length = songList.size();
		int location = 1;

		while (location < length) {
			Song currentSong = songList.get(location);
			Song previousSong = songList.get(location - 1);

			if (currentSong.getBand().compareTo(previousSong.getBand()) > 0) {
				location++;
			} else if (currentSong.getBand().compareTo(previousSong.getBand()) == 0) {
				
				if (currentSong.getName().compareTo(previousSong.getName()) < 0) {
					Song temp = songList.get(location);
					songList.set(location, songList.get(location - 1));
					songList.set(location - 1, temp);
				} 
				
				location++;
			} else {
				// Swap
				Song temp = songList.get(location);
				songList.set(location, songList.get(location - 1));
				songList.set(location - 1, temp);

				if (location > 1) {
					location--;
				} else {
					location++;
				}
			}

		}
		printAllSongs(songList);
	}

	/*
	 * Helper methods
	 */

	// Prints songs from a list
	public static void printAllSongs(ArrayList<Song> songList) {
		System.out.println(Song.getHeader());
		Iterator<Song> songIter = songList.iterator();

		while (songIter.hasNext()) {
			System.out.println(songIter.next().getFormatSongLine());
		}
		System.out.println();
	}

	// Makes a new list with selected elements from a list and prints them
	public static void printSelective(ArrayList<Song> songList,
			ArrayList<Integer> songLocations) {

		if (songLocations.size() > 0) {
			System.out.println(Song.getHeader());
			Iterator<Integer> intIter = songLocations.iterator();

			while (intIter.hasNext()) {
				System.out.println(songList.get(intIter.next())
						.getFormatSongLine());
			}
		} else {
			System.out.println("No Songs Found.");
		}
		System.out.println();
	}

	public static String prompt(String prompt) {
		Scanner in = new Scanner(System.in);
		System.out.print(prompt + ": ");
		return in.nextLine();
	}

	/*
	 * File I/O
	 */

	// Reads the song file an returns an ArrayList
	public static ArrayList<Song> getSongList(String songfile) {
		ArrayList songList = new ArrayList<Song>();

		// Read the file
		try {
			// Iterate through the file and place all the data into Song objects
			Scanner read = new Scanner(new FileReader(songfile));
			do {
				String fileLine = read.nextLine();
				String[] songArray = fileLine.split("[,]");
				if (songArray.length == 4) {
					Song song = new Song(songArray[0], songArray[1],
							songArray[2], songArray[3]);
					songList.add(song);
				}
			} while (read.hasNext());

			read.close();
		}

		catch (FileNotFoundException fnf) {
			System.out.println("File was not found");
		}

		return songList;
	}

	// Writes the new song file
	public static void writeSongFile(ArrayList<Song> songList, String songfile) {

		String output = "";

		// Write the new list to file
		try {
			PrintWriter writer = new PrintWriter(songfile);
			Iterator<Song> songIter = songList.iterator();

			while (songIter.hasNext()) {
				writer.println(songIter.next().getSongLine());
			}

			writer.close();
		}

		catch (FileNotFoundException fnf) {
			System.out.println("File was not found");
		}
	}

	/*
	 * Prompts a user for valid integer and returns it an integer. Checks to see
	 * if it is in a range also.
	 */

	public static int promptIntInRange(String prompt, int min, int max) {
		Scanner in = new Scanner(System.in);

		int out = 0;
		String miscInput = "";
		String error = "Please enter a valid integer value within [" + min
				+ "," + max + "]:";
		boolean valid = false;

		if (min == max) {
			error = "Please enter: " + min;
		}

		System.out.print(prompt);
		while (!valid) {
			if (in.hasNextInt()) {
				out = in.nextInt();
				if (out >= min && out <= max) {
					valid = true;
				} else {
					System.out.print(error);
				}
			} else {
				miscInput = in.next();
				System.out.print(error);
			}
		}

		return out;
	}

}
