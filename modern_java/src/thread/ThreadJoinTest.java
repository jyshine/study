package thread;

public class ThreadJoinTest {
    public static void main(String[] args) {
        MusicBox musicBox = new MusicBox();
        MusicPlayer player1 = new MusicPlayer(3, musicBox);
        MusicPlayer player2 = new MusicPlayer(2, musicBox);
        MusicPlayer player3 = new MusicPlayer(1, musicBox);

        System.out.println("시작");
        player1.start();
        player2.start();
        player3.start();

        try {
            player1.join();
            player2.join();
            player3.join();
            System.out.println("끝");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
