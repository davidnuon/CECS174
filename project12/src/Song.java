
public class Song {
	private String name;
	private String band;
	private String album;
	private String time;
	private static String formatString = "%1$-35s | %2$-27s | %3$-38s | %4$-4s";
	
	public Song(String name, String band, String album, String time) {
		this.name = name;
		this.band = band;
		this.album = album;
		this.time = time;
		
	}
	
	public String getSongLine() {
		String songLine = "";
		
		songLine += this.name + ",";
		songLine += this.band + ",";
		songLine += this.album + ",";
		songLine += this.time;
		
		return songLine;
	}
	
	public static String getHeader() {
		// The header
		String out = String.format(formatString, "Name", "Band", "Album", "Duration");
		String line = "\n";
		out = out.replace("|", " ");
		
		// The separator
		
		for(int i = 0; i <= out.length(); i++) {
			line += "-";
		}
		
		out += line;
		
		
		return out;		
	}
	
	public String getFormatSongLine() {
		String out = String.format(formatString, this.name, this.band, this.album, this.time);
		return out;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the band
	 */
	public String getBand() {
		return band;
	}

	/**
	 * @return the album
	 */
	public String getAlbum() {
		return album;
	}

	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}
	
	
}
