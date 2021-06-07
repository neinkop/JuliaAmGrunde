package de.neinkop;

import java.io.*;

public class Test {

    public static void main(String[] args) {

        //Fehlerausgabe mittels try-catch (sonst wird man nie den Fehler finden)
        try {
            // Datei erstellen
            BufferedWriter fw = new BufferedWriter(new FileWriter("txt1.txt"));
            // Inhalt der Datei schreiben
            fw.write("Übung für Informatik Du depp\n" + //erste Zeile
                    "Java ist einfach Hallo \n" + // dritte Zeile
                    "Ich bin sehr dumm und heiße Lehrer"); // dritte Zeile
            // Schließen
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        String[] lines = null;

        //Fehlerausgabe mittels try-catch (sonst wird man nie den Fehler finden)
        try {
            //Anzahl der Zeilen auslesen um die Größe des Array´s (lines) zu bestimmen
            BufferedReader fr1 = new BufferedReader(new FileReader("txt1.txt"));
            int size = (int) fr1.lines().count();
            lines = new String[size + 1];
            fr1.close();

            // Datei zum Lesen öffnen
            BufferedReader fr = new BufferedReader(new FileReader("txt1.txt"));

            String line;
            int counter = 0;


            while ((line = fr.readLine()) != null) {
                lines[counter] = line;
                counter++;
            }

            //Schließen
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int spalten = lines[0].split("").length;
        for (int i = 0; i < (lines.length-1); i++) {

            if (spalten < lines[i].split("").length) {
                spalten = lines[i].split("").length;
            }
        }
        System.out.println(spalten);

        int zeilen = lines.length;
        String [][] table = new String [zeilen][spalten];

        for (int zeile = 0; zeile < (lines.length - 1); zeile++) {
            int spalte = 0;
            while (spalte < (lines[zeile].split("").length)) {
                System.out.println(zeile + " " + spalte + ": " + lines[zeile].split("")[spalte]);
                table[zeile][spalte] = lines[zeile].split("")[spalte];
                spalte++;
            }

        }
        String c = "";
        for (int i = 0; i < (table.length-1); i++) {
            for (int i1 = 0; i1 < (table[i].length-1); i1++) {
                System.out.println(i1 + " " + i);
                c += table[i1][i];
            }
        }
        System.out.println(c);


    }
}
