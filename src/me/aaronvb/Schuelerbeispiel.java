package me.aaronvb;

public class Schuelerbeispiel {

    public static void main(String[] args) {

        //Fill in my data parameters, INITIALIZATION
        //Set up our new world and lets begin the SIMULATION
        //Shoutout wenn sie das Lied kennen :P

        Schueler[] schuelerliste = {
                new Schueler("Aaron", "Müller"),
                new Schueler("Abraham", "Schmidt"),
                new Schueler("Adam", "Schneider"),
                new Schueler("Andreas", "Fischer"),
                new Schueler("Anna", "Weber"),
                new Schueler("Balthasar", "Meyer"),
                new Schueler("Christian", "Wagner"),

                new Schueler("Daniel", "Schulz"),
                new Schueler("David", "Becker"),
                new Schueler("Delila", "Hoffmann"),
                new Schueler("Elias", "Schäfer"),
                new Schueler("Elisabeth", "Koch"),
                new Schueler("Eva", "Bauer"),
                new Schueler("Hanna", "Richter"),
        };

        schuelerliste[0].noteHinzufuegen(Fach.Chemie, 3);
        schuelerliste[0].noteHinzufuegen(Fach.Chemie, 2);
        schuelerliste[0].noteHinzufuegen(Fach.Chemie, 4);
        schuelerliste[0].noteHinzufuegen(Fach.Chemie, 1);
        schuelerliste[0].noteHinzufuegen(Fach.Chemie, 1);

        schuelerliste[0].noteHinzufuegen(Fach.Deutsch, Note.Ausreichend);
        schuelerliste[0].noteEntfernen(Fach.Chemie, 0);

        schuelerlisteAusgeben(schuelerliste);
    }
    
    public static void schuelerlisteAusgeben(Schueler[] schuelerliste) {
        for (Schueler schueler : schuelerliste) {
            schueler.notenheftAusgeben();
            System.out.println();
        }
    }
}
