import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        boolean isRunning = true;

        while(isRunning){
            System.out.println(Settings.GAME_TITLE);

            GameCanvas gameCanvas = new GameCanvas();

            gameCanvas.render();

            while(!gameCanvas.getPlayer().win()){
                gameCanvas.getKeyboardListener().listen();
                gameCanvas.run();
                gameCanvas.render();

            }

            while(true){
                System.out.println("Do you want to play again ? <y/n>: ");
                String ans = in.next().toLowerCase();
                if(ans.equals("n") || ans.equals("no")){
                    isRunning = false;
                    break;
                }
                else if(ans.equals("y") || ans.equals("yes")){
                    break;
                }
                else{
                    System.out.println("Sorry, i didn't catch that.");
                }
            }


        }

    }
}
