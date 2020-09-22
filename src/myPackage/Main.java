package myPackage;
import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.BufferedReader;

public class Main {
    public static ArrayList<String> adjectives = new ArrayList<String>();
    public static ArrayList<String> nouns = new ArrayList<String>();

    public static void initializeAdjectives() {
        File file = new File("words/english-adjectives.txt");
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String string;

            while ((string = br.readLine()) != null) {
                adjectives.add(string);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initializeNouns() {
        File file = new File("words/english-nouns.txt");
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String string;

            while ((string = br.readLine()) != null) {
                nouns.add(string);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getRandomInt(int min, int max) {
        Random r = new Random();
        return r.nextInt(max - min) + min;
    }


    public static void main(String[] args) {
        initializeAdjectives();
        initializeNouns();

        Insult insult = new Insult();
        int indexAdj = getRandomInt(0, adjectives.size());
        int indexNoun = getRandomInt(0, nouns.size());
        insult.setAdjective(adjectives.get(indexAdj));
        insult.setNoun(nouns.get(indexNoun));

        System.out.println(insult.getAdjective() + " " + insult.getNoun());
        System.out.println();
    }


}

class Insult {
    private String adjective;
    private String noun;

    public Insult() {
        adjective = "";
        noun = "";
    }

    public void setAdjective(String _adjective) {
        this.adjective = _adjective;
    }
    public void setNoun(String _noun) {
        this.noun = _noun;
    }

    public String getAdjective() {
        return adjective;
    }
    public String getNoun() {
        return noun;
    }
}
