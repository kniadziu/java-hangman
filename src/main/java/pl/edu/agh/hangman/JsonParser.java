package pl.edu.agh.hangman;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonParser {

    //String myURL="https://carlofontanos.com/api/tutorials.php?data=all";

    public  String getWordFromJSON(String myURL) {
  // public static void main(String[] args) {
       //String myURL="http://api.wordnik.com/v4/words.json/randomWords?hasDictionaryDef=true&minCorpusCount=0&minLength=5&maxLength=15&limit=1&api_key=a2a73e7b926c924fad7001ca3111acd55af2ffabf50eb4ae5";
        JSONParser parser = new JSONParser();
        String slowo="";
        try {
            URL oracle = new URL(myURL); // URL to Parse
            URLConnection urlConn= oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                JSONArray a = (JSONArray) parser.parse(inputLine);
               // System.out.println("JSON: " + a); //wyswietl JSOna
                // Loop through each item
                for (Object o : a) {
                    JSONObject JSONDictionary = (JSONObject) o;

                    Long id = (Long) JSONDictionary.get("id");
                   // System.out.println("Post ID : " + id);

                    slowo = (String) JSONDictionary.get("word");
                    //System.out.println("Random word : " + slowo); //wyswietl slowo

                    System.out.println("\n");

                }

            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return slowo;
    }
}
