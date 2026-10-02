package encapsulation.assigment_problems;

import java.util.Arrays;

public class Playlist {

    private final String[] songs;

    public Playlist(String[] songs) {
        this.songs = Arrays.copyOf(songs, songs.length);
    }

    public String[] getSongs() {
        return Arrays.copyOf(songs, songs.length);
    }

    public static void main(String[] args) {

        String[] originalSongs = {
            "Song A",
            "Song B",
            "Song C"
        };

        Playlist playlist = new Playlist(originalSongs);

        String[] returnedSongs = playlist.getSongs();

        returnedSongs[0] = "Changed Song";

        System.out.println("Original playlist:");

        for (String song : playlist.getSongs()) {
            System.out.println(song);
        }

        System.out.println("\nModified returned array:");

        for (String song : returnedSongs) {
            System.out.println(song);
        }
    }
}