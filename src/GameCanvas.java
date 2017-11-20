import java.util.ArrayList;
import java.util.Random;

public class GameCanvas {
    private Player player;
    private Key key;
    private Exit exit;
    private KeyboardListener keyboardListener;

    GameCanvas(){
        keyboardListener = new KeyboardListener();
        setupGameObject();
    }

    public Player getPlayer(){ return player;}
    public Key getKey(){ return key;}
    public Exit getExit(){ return exit;}

    public void setupKeyboardListener(KeyboardListener e){ keyboardListener = e; }

    private void setupGameObject() {
        ArrayList<Vector2D> availablePosition = getAvailablePositions(3);

        // player
        player = new Player();
        player.setPosition(availablePosition.get(0));

        // exit
        exit = new Exit();
        exit.setPosition(availablePosition.get(1));

        // key
        key = new Key();
        key.setPosition(availablePosition.get(2));

    }

    private ArrayList<Vector2D> getAvailablePositions(int k){
        Random r = new Random();
        ArrayList<Vector2D> tmpList = new ArrayList<>();
        if(k<1) return tmpList;


        Vector2D tmpPosition = new Vector2D(r.nextInt(Settings.GAME_WIDTH), r.nextInt(Settings.GAME_HEIGHT));

        tmpList.add(tmpPosition);

        for(int i=1; i<k; i++){
            while(true){
                tmpPosition = new Vector2D(r.nextInt(Settings.GAME_WIDTH), r.nextInt(Settings.GAME_HEIGHT));
                boolean isValid = true;
                for(Vector2D v: tmpList){
                    if(tmpPosition.equals(v)){
                        isValid = false;
                        break;
                    }
                }

                if(isValid) {
                    tmpList.add(tmpPosition);
                    break;
                }
            }

        }

        return tmpList;

    }

    public void render(){
        StringBuilder sb = new StringBuilder();

        for(int row=0; row<Settings.GAME_HEIGHT; row++){
            for(int col=0; col<Settings.GAME_WIDTH; col++){
                Vector2D currentPosition = new Vector2D(col, row);

                if(currentPosition.equals(player.getPosition())){
                    sb.append(Settings.PLAYER_RENDERER);
                }
                else if(currentPosition.equals(exit.getPosition())){
                    sb.append(Settings.EXIT_RENDERER);
                }
                else if(key != null && currentPosition.equals(key.getPosition())){
                        sb.append(Settings.KEY_RENDERER);
                }
                else{
                    sb.append(Settings.EMPTY_RENDERER);
                }

                sb.append(' ');
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    public void run() {
        switch (keyboardListener.getKey()){
            case Settings.UP_KEY: {
                player.moveUp();
                break;
            }
            case Settings.DOWN_KEY: {
                player.moveDown();
                break;
            }
            case Settings.LEFT_KEY: {
                player.moveLeft();
                break;
            }
            case Settings.RIGHT_KEY: {
                player.moveRight();
                break;
            }
        }

        if(key != null && player.getPosition().equals(key.getPosition())){
            key = null;

            System.out.println("You got the key !");
        }
        if(player.getPosition().equals(exit.getPosition())){
            if(key == null){
                player.setWin(true);

                System.out.println("YOU WIN!");
            }
            else{
                switch (keyboardListener.getKey()){
                    case Settings.UP_KEY: {
                        player.moveDown();
                        break;
                    }
                    case Settings.DOWN_KEY: {
                        player.moveUp();
                        break;
                    }
                    case Settings.LEFT_KEY: {
                        player.moveRight();
                        break;
                    }
                    case Settings.RIGHT_KEY: {
                        player.moveLeft();
                        break;
                    }
                }

                System.out.println("You must get the key first !");
            }
        }

    }

    public KeyboardListener getKeyboardListener() {
        return keyboardListener;
    }
}
