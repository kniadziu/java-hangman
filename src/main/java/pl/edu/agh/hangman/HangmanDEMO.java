package pl.edu.agh.hangman;


public class HangmanDEMO {

    public static void main(String[] args) {
//        Word word = new pl.edu.agh.hangman.Word(30);
//        String wordd = word.getFile("src/main/resources/slowa.txt");
        JsonParser randomWord = new JsonParser();
        String wordd=randomWord.getWordFromJSON("http://api.wordnik.com/v4/words.json/randomWords?hasDictionaryDef=true&minCorpusCount=0&minLength=5&maxLength=15&limit=1&api_key=a2a73e7b926c924fad7001ca3111acd55af2ffabf50eb4ae5");


        Hangman hangman = new Hangman(wordd);
        hangman.run();
    }
}
