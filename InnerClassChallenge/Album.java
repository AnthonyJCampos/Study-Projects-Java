import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private SongList trackList;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.trackList = new SongList();
    }

    public boolean addSong(String title, double duration) {
        return trackList.add(title, duration);

    } // end of find

    private Song findSong(String title) {
        return trackList.find(title);
    } // end of find

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) {
        Song checkedSong = trackList.find(trackNumber);
        if(checkedSong != null){
            playList.add(checkedSong);
        }
        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playList) {
        Song checkedSong = trackList.find(title);
        if (checkedSong != null) {
            playList.add(checkedSong);
            return true;
        }
        System.out.println("The song " + title + " is not in this album");
        return false;
    }

    // inner class
    public class SongList{

        private ArrayList<Song> songs;

        public SongList(){

            this.songs = new ArrayList<Song>();

        } // end of default constructor

        private boolean add(String title, double duration){
            if (findSong(title) == null) {

                songs.add(new Song(title, duration));
                return true;

            } // end if
            return false;

        } // end of add

        private Song find(String title){

            for (Song checkedSong : this.songs) {

                if (checkedSong.getTitle().equals(title)) {

                    return checkedSong;

                } // end if

            } // end for

            return null;
        } // end of find

        private Song find(int trackNumber){

            int index = trackNumber -1;

            if(index > 0 && index < songs.size()){

                return songs.get(index);

            } // end if

            return null;
        } // end of find

    } // end of SongList

} // end of Album
