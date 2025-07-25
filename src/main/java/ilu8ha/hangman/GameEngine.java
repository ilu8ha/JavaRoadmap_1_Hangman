package ilu8ha.hangman;

import java.util.Scanner;

public class GameEngine {
    private static GameState gameState;
    public static void startGame(Scanner scanner){
        gameState = new GameState();
        PrintUtils.printScreenDivideMessage();
        PrintUtils.printRulesMessage();
        PrintUtils.printCurrentGameStateMessage(gameState);
        do {
            String input = scanner.nextLine();
            if(isInputValid(input)){
                char c = input.toLowerCase().toCharArray()[0];
                if(isInputUnique(c)){
                    gameState.newInput(c);
                    PrintUtils.printCurrentGameStateMessage(gameState);
                    continue;
                }
            }
                PrintUtils.printInvalidInputMessage();
                PrintUtils.printGameNavigationMessage();
        }
        while (!gameState.isGameEnd());

    }

    private static boolean isInputValid(String input){
        String regex = "^[А-Яа-яЁё]$";
        return input.matches(regex);
    }
    private static boolean isInputUnique(Character c){
        return !gameState.getInputs().contains(c);
    }
}
