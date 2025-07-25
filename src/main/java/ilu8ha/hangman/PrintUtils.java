package ilu8ha.hangman;

import java.util.HashSet;
import java.util.Iterator;

public class PrintUtils {

    public static void printWelcomeMessage(){
        System.out.println("Приветствую в игре \"Виселица\"");
    }

    public static void printGoodbyeMessage(){
        System.out.println("До следующих игр!");
    }
    public static void printMainMenuNavigationMessage(){
        System.out.println("Ввeдите \"Играть\" для старта новой игры");
        System.out.println("Ввeдите \"Выход\" для выхода");
    }


    public static void printScreenDivideMessage(){
        System.out.println("                                                           ");
        System.out.println("===========================================================");
        System.out.println("                                                           ");
    }

    public static void printInvalidInputMessage(){
        System.out.println("Неккоректный ввод!");
    }

    public static void printRulesMessage(){
        System.out.println("Вы пытаетесь угадать скрытое слово, предлагая по одной букве за ход.");
        System.out.println("За каждую неверно угаданную букву часть виселицы рисуется.");
        System.out.println("Если виселица нарисована полностью до того, как вы угадаете слово, вы проигрываете");
    }

    public static void printGameNavigationMessage(){
        System.out.println("Введите букву: ");
    }

    public static void printCurrentStateMessage(GameState state){
        System.out.println("Ошибок: " + state.getErrorsCount());
        System.out.println(errorStages[state.getErrorsCount()]);
        if(state.isGameEnd()){
            if(state.isGameWon()){
                System.out.printf(getWonTemplate(),state.getTargetWord().toUpperCase());
            } else {
                System.out.printf(getLoseTemplate(),state.getTargetWord().toUpperCase());
            }
        } else {
            System.out.println("Слово: "
                    + getStyledWord(state.getTargetWord(), state.getInputs())
                    + "\tВведенные ранее символы: "
                    + getStyledInputs(state.getInputs()));
            printGameNavigationMessage();
        }
    }

    private static String getStyledWord(String word, HashSet<Character> reviledChar){
        StringBuilder builder = new StringBuilder();
        String placeholder = "_";
        for (Character c : word.toCharArray()){
            if(reviledChar.contains(c)){
                builder.append(c);
            } else {
                builder.append(placeholder);
            }
        }
        return builder.toString().toUpperCase();
    }

    private static String getStyledInputs(HashSet<Character> characters){
        StringBuilder builder = new StringBuilder();
        Iterator<Character> iterator = characters.iterator();
        while (iterator.hasNext()){
            Character c = iterator.next();
            builder.append(c);
            if(iterator.hasNext()){
                builder.append(',');
            }
        }
        return builder.toString().toUpperCase();
    }
    private static final String[] errorStages = { //это сделала нейронка.
            "  +---+\n" +
                    "  |   |\n" +
                    "  |    \n" +
                    "  |    \n" +
                    "  |    \n" +
                    "  |    \n" +
                    " ---",
            "  +---+\n" +
                    "  |   |\n" +
                    "  |   O\n" +
                    "  |    \n" +
                    "  |    \n" +
                    "  |    \n" +
                    " ---",
            "  +---+\n" +
                    "  |   |\n" +
                    "  |   O\n" +
                    "  |   |\n" +
                    "  |    \n" +
                    "  |    \n" +
                    " ---",
            "  +---+\n" +
                    "  |   |\n" +
                    "  |   O\n" +
                    "  |  /|\n" +
                    "  |    \n" +
                    "  |    \n" +
                    " ---",
            "  +---+\n" +
                    "  |   |\n" +
                    "  |   O\n" +
                    "  |  /|\\\n" +
                    "  |    \n" +
                    "  |    \n" +
                    " ---",
            "  +---+\n" +
                    "  |   |\n" +
                    "  |   O\n" +
                    "  |  /|\\\n" +
                    "  |  /\n" +
                    "  |    \n" +
                    " ---",
            "  +---+\n" +
                    "  |   |\n" +
                    "  |   O\n" +
                    "  |  /|\\\n" +
                    "  |  / \\\n" +
                    "  |    \n" +
                    " ---"
    };
    private static String getWonTemplate(){
        return "Вы разгадали слово \"%s\", поздравляю!\n";
    }
    private static String getLoseTemplate(){
        return "К сожалению, сейчас вам не удалось разгадать слово \"%s\". Повезет в следующий раз!\n";
    }
}
