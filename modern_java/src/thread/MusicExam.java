package thread;

public class MusicExam {
    public static void main(String[] args) {
        MusicBox musicBox = new MusicBox();
        MusicPlayer player1 = new MusicPlayer(1, musicBox);
        MusicPlayer player2 = new MusicPlayer(2, musicBox);
        MusicPlayer player3 = new MusicPlayer(3, musicBox);

        player1.start();
        player2.start();
        player3.start();
    }
}
