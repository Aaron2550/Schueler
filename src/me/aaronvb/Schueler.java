package me.aaronvb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Schueler {
    Map<Fach, ArrayList<Integer>> s_notenheft;
    String s_name;
    String s_vorname;

    Schueler (String name, String vorname) {
        s_name = name;
        s_vorname = vorname;
        s_notenheft = new HashMap<>();
    }

    void noteHinzufuegen(Fach fach, Note note) {
        if (s_notenheft.get(fach) == null) {
            ArrayList<Integer> noten = new ArrayList<>();

            //Note in neue ArrayList hinzufügen und die ArrayList zur Map hinzufügen
            noten.add(note.ordinal() + 1);
            s_notenheft.put(fach, noten);
        } else {
            ArrayList<Integer> noten = s_notenheft.get(fach);

            //Note in neue ArrayList hinzufügen und die ArrayList in der Map ersetzen
            noten.add(note.ordinal() + 1);
            s_notenheft.replace(fach, s_notenheft.get(fach), noten);
        }
    }

    void noteHinzufuegen(Fach fach, int note) {
        if (note <= 6 && note >= 1) {
            if (s_notenheft.get(fach) == null) {
                ArrayList<Integer> noten = new ArrayList<>();

                //Note in neue ArrayList hinzufügen und die ArrayList zur Map hinzufügen
                noten.add(note);
                s_notenheft.put(fach, noten);
            } else {
                ArrayList<Integer> noten = s_notenheft.get(fach);

                //Note in neue ArrayList hinzufügen und die ArrayList in der Map ersetzen
                noten.add(note);
                s_notenheft.replace(fach, s_notenheft.get(fach), noten);
            }
        }
    }

    void notenHinzufuegen(Fach fach, Note[] notenArray) {
        for (Note note : notenArray ) {
            if (s_notenheft.get(fach) == null) {
                ArrayList<Integer> noten = new ArrayList<>();

                //Note in neue ArrayList hinzufügen und die ArrayList zur Map hinzufügen
                noten.add(note.ordinal() + 1);
                s_notenheft.put(fach, noten);
            } else {
                ArrayList<Integer> noten = s_notenheft.get(fach);

                //Note in neue ArrayList hinzufügen und die ArrayList in der Map ersetzen
                noten.add(note.ordinal() + 1);
                s_notenheft.replace(fach, s_notenheft.get(fach), noten);
            }
        }
    }

    void notenHinzufuegen(Fach fach, int[] notenArray) {
        for (int note : notenArray ) {
            if (note <= 6 && note >= 1) {
                if (s_notenheft.get(fach) == null) {
                    ArrayList<Integer> noten = new ArrayList<>();

                    //Note in neue ArrayList hinzufügen und die ArrayList zur Map hinzufügen
                    noten.add(note);
                    s_notenheft.put(fach, noten);
                } else {
                    ArrayList<Integer> noten = s_notenheft.get(fach);

                    //Note in neue ArrayList hinzufügen und die ArrayList in der Map ersetzen
                    noten.add(note);
                    s_notenheft.replace(fach, s_notenheft.get(fach), noten);
                }
            }
        }
    }

    boolean letzteNoteEntfernen(Fach fach) {
        //Rüclgabe: true wenn erfolgreich
        if (s_notenheft.get(fach) != null) {
            ArrayList<Integer> noten = s_notenheft.get(fach);

            //Note aus ArrayList entfernen und ArrayList in der Map ersetzen
            noten.remove(noten.size() - 1);
            s_notenheft.replace(fach, s_notenheft.get(fach), noten);

            return true;
        } else {
            return false;
        }
    }

    boolean noteEntfernen(Fach fach, int index) {
        //Rückgabe: true wenn erfolgreich
        if (s_notenheft.get(fach) != null) {
            ArrayList<Integer> noten = s_notenheft.get(fach);

            if (index < noten.size()) {
                //Note aus ArrayList entfernen und ArrayList in der Map ersetzen
                noten.remove(index);
                s_notenheft.replace(fach, s_notenheft.get(fach), noten);
            }

            return true;
        } else {
            return false;
        }
    }

    boolean istDurchschnittBesserAls(Schueler schueler, Fach fach) {
        //Rückgabe: true wenn besser
        float durchschnittSchuelerEins = durchschnittGenauBerechnen(fach);
        float durchschnittSchuelerZwei = schueler.durchschnittGenauBerechnen(fach);

        return durchschnittSchuelerEins < durchschnittSchuelerZwei;
    }

    boolean istGesamtdurchschnittBesserAls(Schueler schueler) {
        //Rückgabe: true wenn besser
        float durchschnittSchuelerEins = 0, durchschnittSchuelerZwei = 0;
        int anzahlFaecher = 0;

        for (Fach fach : Fach.values()) {
            durchschnittSchuelerEins += durchschnittGenauBerechnen(fach);
            anzahlFaecher++;
        }

        durchschnittSchuelerEins = durchschnittSchuelerEins / anzahlFaecher;
        anzahlFaecher = 0;

        for (Fach fach : Fach.values()) {
            durchschnittSchuelerZwei += schueler.durchschnittGenauBerechnen(fach);
            anzahlFaecher++;
        }

        durchschnittSchuelerZwei = durchschnittSchuelerZwei / anzahlFaecher;

        return durchschnittSchuelerEins > durchschnittSchuelerZwei;
    }

    boolean notenheftAusgeben(Fach fach) {
        //Rückgabe: true wenn erfolgreich
        if (s_notenheft.get(fach) != null) {
            StringBuilder notenliste = new StringBuilder();

            for (int note : s_notenheft.get(fach)) {
                //Am Ende hängt dann ein extra Leerzeichen dran, aber das fällt ja niemandem auf :))))))))))))))
                notenliste.append(note).append(" ");
            }

            System.out.println("Name: " + s_name + ", " + s_vorname);
            System.out.println("    Noten (" + fach.name() + "): " + notenliste);

            return true;
        } else {
            return false;
        }
    }

    void notenheftAusgeben() {
        int summeAllerNoten = 0;
        System.out.println("Name: " + s_name + ", " + s_vorname);

        for (Map.Entry<Fach, ArrayList<Integer>> eintrag : s_notenheft.entrySet()) {
            StringBuilder notenliste = new StringBuilder();

            for (int note : s_notenheft.get(eintrag.getKey())) {
                //Am Ende hängt dann ein extra Leerzeichen dran, aber das fällt ja niemandem auf :))))))))))))))
                notenliste.append(note).append(" ");
                summeAllerNoten += note;
            }
            System.out.println("    " + eintrag.getKey().name() + ": " + notenliste + "   Ø: " + durchschnittGenauBerechnen(eintrag.getKey()));
        }

        if (anzahlNoten() == 0) {
            System.out.println("    Insgesamt Ø: Schüler hat keine Noten!");
        } else {
            System.out.println("    Insgesamt Ø: " + ((float) summeAllerNoten / anzahlNoten()));
        }
    }

    int anzahlNoten() {
        //Rückgabe: Anzahl der Noten
        int anzahlNoten = 0;

        for (Fach fach : Fach.values()) {
            try {
                anzahlNoten += s_notenheft.get(fach).size();
            } catch(NullPointerException ignored) {
                //Schüler hat keine Noten in diesem Fach, Fehler kann ignoriert werden.
                anzahlNoten += 0;
            }
        }

        return anzahlNoten;
    }

    Map<Fach, ArrayList<Integer>> notenheftErhalten() {
        return s_notenheft;
    }
    
    int durchschnittBerechnen(Fach fach) {
        //Rückgabe: Ungenauer Durchschnitt
        int summe = 0;

        if (s_notenheft.get(fach) == null) {
            return summe;
        }

        for (int note : s_notenheft.get(fach)) {
            summe += note;
        }
        
        return summe / s_notenheft.get(fach).size();
    }

    float durchschnittGenauBerechnen(Fach fach) {
        //Rückgabe: Genauer Durchschnitt
        float summe = 0f;

        if (s_notenheft.get(fach) == null) {
            return summe;
        }

        for (int note : s_notenheft.get(fach)) {
            summe += note;
        }

        return summe / s_notenheft.get(fach).size();
    }
}

