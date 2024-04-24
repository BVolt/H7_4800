package Proxy;

import java.util.List;

public class MusicStreamingApp {
    public static void main(String[] args) {
        SongServer songServer = new SongServer();
        ProxySongServer proxySongServer = new ProxySongServer(songServer);

        songServer.addSong(1, new Song("Come As You Are", "Nirvana", "Nevermind", 219));
        songServer.addSong(2, new Song("Bohemian Rhapsody", "Queen", "A Night at the Opera", 354));
        songServer.addSong(3, new Song("Smells Like Teen Spirit", "Nirvana", "Nevermind", 301));
        songServer.addSong(4, new Song("Yellow", "Coldplay", "Parachutes", 269));
        songServer.addSong(5, new Song("Yellow", "Amarillo", "Greatest Hits", 252));  // Another "Yellow" song

        System.out.println("\nInitial search for song by ID 1 (should reach server)");
        long start = System.currentTimeMillis();
        Song songById = proxySongServer.searchById(1);
        System.out.println(songById);
        long end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end - start) + " ms");

        System.out.println("\nInitial search for song by title 'Yellow' (should reach server)");
        start = System.currentTimeMillis();
        List<Song> songsByTitle = proxySongServer.searchByTitle("Yellow");
        songsByTitle.forEach(System.out::println);
        end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end - start) + " ms");

        System.out.println("\nInitial search for songs from album 'Nevermind' (should reach server)");
        start = System.currentTimeMillis();
        List<Song> songsByAlbum = proxySongServer.searchByAlbum("Nevermind");
        songsByAlbum.forEach(System.out::println);
        end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end - start) + " ms");

        System.out.println("\nRepeating search for song by ID 1 (should hit proxy)");
        start = System.currentTimeMillis();
        songById = proxySongServer.searchById(1);
        System.out.println(songById);
        end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end - start) + " ms");

        System.out.println("\nRepeating search for song by title 'Yellow' (should hit proxy)");
        start = System.currentTimeMillis();
        songsByTitle = proxySongServer.searchByTitle("Yellow");
        songsByTitle.forEach(System.out::println);
        end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end - start) + " ms");

        System.out.println("\nRepeating search for songs from album 'Nevermind' (should hit proxy)");
        start = System.currentTimeMillis();
        songsByAlbum = proxySongServer.searchByAlbum("Nevermind");
        songsByAlbum.forEach(System.out::println);
        end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end - start) + " ms");
    }
}