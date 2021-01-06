package me.aaronvb;

class Schueler {
    String s_name;
    String s_vorname;
    int s_note;

    Schueler (String name, String vorname, int note) {
        s_name = name;
        s_vorname = vorname;
        s_note = note;
    }

    Schueler (String name, String vorname, Note note) {
        s_name = name;
        s_vorname = vorname;
        s_note = note.ordinal() + 1;
    }

    void notenheftAusgeben() {
        System.out.println("\n");
        System.out.println("Name:" + s_name);
        System.out.println("Vorname:" + s_vorname);
        System.out.println("Note:" + s_note);
    }

    void noteVerbessern (int um) {
        if (s_note >= 2) {
            s_note -= um;
        }
    }

    void noteVerschlechtern(int um) {
        if (s_note <= 5) {
            s_note += um;
        }
    }
}

