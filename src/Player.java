public class Player extends GameObject {
    private char renderer = Settings.PLAYER_RENDERER;

    private boolean win = false;

    Player(){

    }

    public boolean win(){ return win;}
    public void setWin(boolean value){ win = value;}


}
