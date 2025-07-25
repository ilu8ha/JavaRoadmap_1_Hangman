package ilu8ha.hangman;
import java.nio.charset.Charset;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameWordsPool.Init();
        PrintUtils.printWelcomeMessage();
        PrintUtils.printMainMenuNavigationMessage();
        try(Scanner scanner = new Scanner(System.in, Charset.forName("windows-1251"))){
            while (true){
                String input = scanner.nextLine().toLowerCase();
//                System.out.println(input); //debug
//                System.out.println((int)input.toCharArray()[0]); //debug

                switch (input){
                    case "играть" :{
                        GameEngine.startGame(scanner);
                        PrintUtils.printMainMenuNavigationMessage();
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
                        PrintUtils.printMainMenuNavigationMessage();
                        break;
                    }
                }
            }
        } catch (Exception ex){
            //TODO: moveThisToLogger
            ex.printStackTrace();
            System.exit(1);
        }


    }
}