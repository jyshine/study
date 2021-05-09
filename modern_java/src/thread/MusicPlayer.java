package thread;

public class MusicPlayer extends Thread{
    int type;
    MusicBox musicBox;

    public MusicPlayer(int type, MusicBox musicBox) {
        this.type = type;
        this.musicBox = musicBox;
    }

    @Override
    public void run() {

        if (type == 1){
            musicBox.playMusicA();
        }else if (type == 2){
            musicBox.playMusicB();
        }else if (type == 3 ){
            musicBox.playMusicC();
        }

    }
}
