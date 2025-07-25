# Hangman Game in Java

---

This is a small project developed as part of learning Java and implementing the classic "Hangman" game. The game is built in Java and can be run from the command line.

## Game Description

"Hangman" is a word-guessing game where the player needs to guess a hidden word, letter by letter. For each incorrect guess, a part of the "hangman" gallows is drawn. If the gallows are fully drawn before the word is guessed, the player loses.

## Technologies Used

* **Java**: The primary programming language.
* **Gradle**: The build automation system.

## How to Run the Game

To run the game from the command line (e.g., PowerShell or CMD), follow these steps:

1.  **Set Character Encoding**: Before running, ensure your console uses **Windows-1251** encoding for correct display of Cyrillic characters. You can do this by executing the following command:
    ```bash
    chcp 1251
    ```
2.  **Launch the Project**: After setting the encoding, you can launch the game from the project's root directory using the Gradle command:
    ```bash
    gradlew run
    ```

---