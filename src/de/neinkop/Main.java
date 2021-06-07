package de.neinkop;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        //Fehlerausgabe mittels try-catch (sonst wird man nie den Fehler finden)
        try {
            // Datei erstellen
            BufferedWriter fw = new BufferedWriter(new FileWriter("txt1.txt"));
            // Inhalt der Datei schreiben
            fw.write("Übung für Informatik du depp\n" + //erste Zeile
                    "Java ist einfach Hallo\n" + // zweite Zeile
                    "Ich bin sehr dumm und heiße Lehrer"); // dritte Zeile
            // Schließen
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



        StringBuilder alles  = new StringBuilder();

        //Fehlerausgabe mittels try-catch (sonst wird man nie den Fehler finden)
        try {

            // Datei zum Lesen öffnen
            BufferedReader fr = new BufferedReader(new FileReader("txt1.txt"));
            String line;

            while ((line = fr.readLine()) != null) {
                alles.append(line);
            }

            //Schließen
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int spalten = 4;

        String [][] table = new String[((alles.toString().split("").length/spalten) + 1)][spalten];
        String[] splitted = alles.toString().split("");

        int zeile = 0;
        int spalte = 0;
        for (int i = 0; i < (splitted.length-1); ) {
            for (spalte = 0; spalte < spalten; spalte++) { //HIER

                table[zeile][spalte] = splitted[i];
                i++;
                if (spalte == spalten-1) zeile++; //HIER
            }
        }

        String c = "";
        for (int i = 0; i < spalten; i++) {
            for (int y = 0; y < table.length; y++) {
                if (table[y][i] != null) c += table[y][i];
            }
        }
        System.out.println(c);

    }
}
