import java.util.Scanner;

public class KeyboardListener {
    private Scanner in = new Scanner(System.in);
    private char key;
    KeyboardListener(){

    }

    public void listen(){
        while(true){
            System.out.println("Your move: ");
            String inputString = in.next().toUpperCase();

            boolean isValid = true;
            if(inputString.length() == 1){
                key = inputString.charAt(0);

                if(key != Settings.UP_KEY && key != Settings.DOWN_KEY && key != Settings.LEFT_KEY && key != Settings.RIGHT_KEY){
                    isValid = false;
                }
            }
            else{
                isValid = false;
            }

            if(!isValid) System.out.println("Your move is invalid !");
            else{
                break;
            }
        }


    }

    public char getKey(){ return key;}
}
