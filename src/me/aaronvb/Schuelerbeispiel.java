package me.aaronvb;

import java.util.Random;

public class Schuelerbeispiel {

    public static void main(String[] args) {
        Random random = new Random();
        Schueler[] schuelerliste = {
                new Schueler("Aaron", "Müller", random.nextInt(6) + 1),
                new Schueler("Abraham", "Schmidt", random.nextInt(6) + 1),
                new Schueler("Adam", "Schneider", random.nextInt(6) + 1),
                new Schueler("Andreas", "Fischer", random.nextInt(6) + 1),
                new Schueler("Anna", "Weber", random.nextInt(6) + 1),
                new Schueler("Balthasar", "Meyer", random.nextInt(6) + 1),
                new Schueler("Christian", "Wagner", random.nextInt(6) + 1),

                new Schueler("Daniel", "Schulz", Note.GUT),
                new Schueler("David", "Becker", Note.GUT),
                new Schueler("Delila", "Hoffmann", Note.GUT),
                new Schueler("Elias", "Schäfer", Note.GUT),
                new Schueler("Elisabeth", "Koch", Note.GUT),
                new Schueler("Eva", "Bauer", Note.GUT),
                new Schueler("Hanna", "Richter", Note.GUT),
        };

        schuelerlisteAusgeben(schuelerliste);
    }
    
    public static void schuelerlisteAusgeben(Schueler[] schuelerliste) {
        StringBuilder tabellenKopf = new StringBuilder();
        StringBuilder tabellenFuss = new StringBuilder();
        int laengsterName = 0;

        //Längsten Namen herausfinden
        for (Schueler schueler : schuelerliste) {
            int laengeDesNamens = (schueler.s_name + ", " + schueler.s_vorname).length();
            
            if (laengeDesNamens > laengsterName) {
                laengsterName = laengeDesNamens;
            }
        }

        //Wenn die Länge des längsten Namens ungleich ist, 1 addieren da sonst die Tabelle nicht zentriert ist
        if (laengsterName % 2 != 0) {
            laengsterName++;
        }

        tabellenKopf.append("╔══════");
        tabellenKopf.append("═".repeat(laengsterName));
        tabellenKopf.append("╦══════════════════╗");
        tabellenKopf.append(System.lineSeparator());
        tabellenKopf.append("║ ");
        tabellenKopf.append(" ".repeat(laengsterName / 2));
        tabellenKopf.append("Name");
        tabellenKopf.append(" ".repeat(laengsterName / 2));
        tabellenKopf.append(" ║       Note       ║");
        tabellenKopf.append(System.lineSeparator());
        tabellenKopf.append("╠══════");
        tabellenKopf.append("═".repeat(laengsterName));
        tabellenKopf.append("╬══════════════════╣");

        System.out.println(tabellenKopf.toString());

        //Jeden Schüler + Note bauen ausgeben
        for (Schueler schueler : schuelerliste) {
            StringBuilder platzhalterName = new StringBuilder();
            StringBuilder platzhalterNote = new StringBuilder();

            int laengeDesNamens = (schueler.s_name + ", " + schueler.s_vorname).length();
            int laengeDerNote = (schueler.s_note + " (" + Note.values()[schueler.s_note - 1].name() + ")").length();

            platzhalterName.append(" ".repeat(laengsterName - laengeDesNamens + 4));
            platzhalterNote.append(" ".repeat(16 - laengeDerNote));
            System.out.println("║ " + schueler.s_name + ", " + schueler.s_vorname + platzhalterName.toString() + " ║ " + schueler.s_note + " (" + Note.values()[schueler.s_note - 1].name() + ")" + platzhalterNote.toString() + " ║");
        }

        //Tabellenfuß bauen und ausgeben
        tabellenFuss.append("╚══════");
        tabellenFuss.append("═".repeat(laengsterName));
        tabellenFuss.append("╩══════════════════╝");

        System.out.println(tabellenFuss.toString());

    }
}
