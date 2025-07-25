package ilu8ha.hangman;

import java.util.HashSet;
import java.util.Random;



public class GameState {
    private int errorsCount;
    private HashSet<Character> inputs;
    private String targetWord;
    private boolean isGameEnd;
    private boolean isGameWon;

    public GameState(){
        this.isGameWon = false;
        this.isGameEnd = false;
        this.errorsCount = 0;
        this.inputs = new HashSet<>();
        this.targetWord = getRandomTargetWord();
    }
    public void newInput(Character character){
        inputs.add(character);
        if(targetWord.indexOf(character) == -1){
            errorsCount++;
            if(errorsCount >= 6){
                isGameEnd = true;
            }
        } else {
            isGameWon = isGameEnd = isWordFullyRevealed();
        }
    }
    private String getRandomTargetWord(){
        return GameWordsPool.getWordsPool().get(new Random().nextInt(GameWordsPool.getWordsPool().size())).toLowerCase();
    }
    private boolean isWordFullyRevealed(){
        boolean ret = true;
        for(char c : targetWord.toCharArray()){
            if(!inputs.contains(c)){
                ret = false;
                break;
            }
        }
        return ret;
    }
    public boolean isGameWon() {
        return isGameWon;
    }
    public int getErrorsCount() {
        return errorsCount;
    }
    public HashSet<Character> getInputs() {
        return new HashSet<>(inputs);
    }
    public String getTargetWord() {
        return targetWord;
    }
    public boolean isGameEnd() {
        return isGameEnd;
    }
}
