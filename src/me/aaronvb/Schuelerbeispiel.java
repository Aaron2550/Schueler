package me.aaronvb;

public class Schuelerbeispiel {

    public static void main(String[] args) {

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
                new Schueler("Hanna", "Richter")
        };

        schuelerliste[0].noteHinzufuegen(Fach.Chemie, 3);
        schuelerliste[0].noteHinzufuegen(Fach.Chemie, 2);
        schuelerliste[0].noteHinzufuegen(Fach.Chemie, 4);
        schuelerliste[0].noteHinzufuegen(Fach.Chemie, 1);
        schuelerliste[0].noteHinzufuegen(Fach.Chemie, 1);

        schuelerliste[1].notenHinzufuegen(Fach.Deutsch, new int[]{1, 4, 3, 2, 6, 3, 7, 2, 4, 6, 2, 4 ,6 ,4 , 3, 4, 5, 4, 3}); //Noten > 6 werden ignoriert

        schuelerliste[0].noteHinzufuegen(Fach.Deutsch, Note.Ausreichend);
        schuelerliste[0].noteEntfernen(Fach.Chemie, 0);

        if (schuelerliste[0].istGesamtdurchschnittBesserAls(schuelerliste[1])) {
            //Ersten Schüler in der Liste mit dem zweiten Schüler in der Liste vergleichen
            System.out.println(schuelerliste[0].s_name + ", " + schuelerliste[0].s_vorname + " ist insgesamt besser als " + schuelerliste[1].s_name + ", " + schuelerliste[1].s_vorname);
        }

        if (schuelerliste[1].istDurchschnittBesserAls(schuelerliste[0], Fach.Deutsch)) {
            //Deutschnoten des zweiten Schülers in der Liste mit den Deustchnoten des ersten Schülers in der Liste vergleichen
            System.out.println(schuelerliste[1].s_name + ", " + schuelerliste[1].s_vorname + " ist besser in Deutsch als " + schuelerliste[0].s_name + ", " + schuelerliste[0].s_vorname);
        }

        schuelerlisteAusgeben(schuelerliste);
    }
    
    public static void schuelerlisteAusgeben(Schueler[] schuelerliste) {
        for (Schueler schueler : schuelerliste) {
            schueler.notenheftAusgeben();
            System.out.println();
        }
    }
}
