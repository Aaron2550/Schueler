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
                new Schueler("Christian", "Wagner")
        };

        schuelerliste[0].noteHinzufuegen(Fach.Chemie, 3);
        schuelerliste[0].noteHinzufuegen(Fach.Chemie, 2);
        schuelerliste[0].noteHinzufuegen(Fach.Chemie, 4);
        schuelerliste[0].noteHinzufuegen(Fach.Chemie, 1);
        schuelerliste[0].noteHinzufuegen(Fach.Chemie, 1);

        schuelerliste[1].notenHinzufuegen(Fach.Deutsch, new int[] {1, 4, 3, 2, 6, 3, 7, 2, 4, 6, 2, 4 ,6 , 4, 3, 4, 5, 4, 3}); //Noten > 6 werden ignoriert
        schuelerliste[1].notenHinzufuegen(Fach.Chemie, new int[] {4, 3, 3, 3, 3, 4, 4, 1, 1, 2, 2, 5 ,4 , 5, 1, 1, 5, 1, 3});

        schuelerliste[2].notenHinzufuegen(Fach.Physik, new int[] {1, 4, 1, 2, 1, 2, 2, 2, 4, 6, 2, 4, 1, 1, 3, 4, 2, 1, 3});
        schuelerliste[3].notenHinzufuegen(Fach.Mathe, new int[] {1, 1, 3, 2, 1, 3, 2, 1, 4, 2, 2, 2 ,2 , 4, 3, 4, 2, 2, 4});

        schuelerliste[4].notenHinzufuegen(Fach.Informatik, new int[] {1, 1, 1, 2, 1, 1, 2, 2, 1, 1, 2, 2, 2 ,1, 2, 2, 2, 2, 3});
        schuelerliste[5].notenHinzufuegen(Fach.Deutsch, new int[] {1, 4, 3, 2, 6, 3, 2, 2, 4, 6, 2, 4, 6, 4, 3, 4, 5, 4, 3});

        schuelerliste[6].notenHinzufuegen(Fach.Ethik, new int[] {2, 2, 3, 2, 6, 2, 2, 2, 4, 6, 2, 4 ,6 , 4, 3, 4, 5, 4, 3});
        schuelerliste[6].notenHinzufuegen(Fach.Gemeindschaftskunde, new int[] {1, 4, 3, 2, 6, 1, 1, 2, 4, 6, 4, 4 ,4 , 4, 3, 4, 4, 4, 4});

        schuelerliste[0].noteHinzufuegen(Fach.Deutsch, Note.Ausreichend);
        schuelerliste[0].noteEntfernen(Fach.Chemie, 0);

        if (schuelerliste[0].istGesamtdurchschnittBesserAls(schuelerliste[1])) {
            //Ersten Schüler in der Liste mit dem zweiten Schüler in der Liste vergleichen
            System.out.println(schuelerliste[0].s_name + ", " + schuelerliste[0].s_vorname + " ist insgesamt besser als " + schuelerliste[1].s_name + ", " + schuelerliste[1].s_vorname);
        }

        if (schuelerliste[1].istDurchschnittBesserAls(schuelerliste[0], Fach.Deutsch)) {
            //Deutschnoten des zweiten Schülers in der Liste mit den Deutschnoten des ersten Schülers in der Liste vergleichen
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
