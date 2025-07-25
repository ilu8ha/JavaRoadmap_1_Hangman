package ilu8ha.hangman;
import java.nio.charset.Charset;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameWordsPool.Init();
        PrintUtils.printWelcomeMessage();
        try(Scanner scanner = new Scanner(System.in, Charset.forName("windows-1251"))){
            while (true){
                PrintUtils.printMainMenuNavigationMessage();
                String input = scanner.nextLine().toLowerCase();
                switch (input){
                    case "играть" :{
                        GameEngine.startGame(scanner);
                        break;
                    }
                    case "выход" :{
                        PrintUtils.printGoodbyeMessage();
                        System.exit(0);
                        break;
                    }
                    default :{
                        PrintUtils.printScreenDivideMessage();
                        PrintUtils.printInvalidInputMessage();
                        break;
                    }
                }
            }
        } catch (Exception ex){
            System.out.println("Error: " + ex.getMessage());
            System.exit(1);
        }


    }
}