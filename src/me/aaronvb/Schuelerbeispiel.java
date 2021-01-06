package me.aaronvb;

import java.util.Random;

public class Schuelerbeispiel {

    public static void main(String[] args) {
        Random random = new Random();

        Schueler aaronMueller = new Schueler("Aaron", "Müller", random.nextInt(6) + 1); //+1 weil: von inklusive 0 bis 6 und so
        Schueler abrahamSchmidt = new Schueler("Abraham", "Schmidt", random.nextInt(6) + 1);
        Schueler adamSchneider = new Schueler("Adam", "Schneider", random.nextInt(6) + 1);
        Schueler andreasFischer = new Schueler("Andreas", "Fischer", random.nextInt(6) + 1);
        Schueler annaWeber = new Schueler("Anna", "Weber", random.nextInt(6) + 1);
        Schueler balthasarMeyer = new Schueler("Balthasar", "Meyer", random.nextInt(6) + 1);
        Schueler christianWagner = new Schueler("Christian", "Wagner", random.nextInt(6) + 1);

        Schueler danielSchulz = new Schueler("Daniel", "Schulz", Note.GUT);
        Schueler davidBecker = new Schueler("David", "Becker", Note.GUT);
        Schueler delilaHoffmann = new Schueler("Delila", "Hoffmann", Note.GUT);
        Schueler eliasSchaefer = new Schueler("Elias", "Schäfer", Note.GUT);
        Schueler ElisabethKoch = new Schueler("Elisabeth", "Koch", Note.GUT);
        Schueler evaBauer = new Schueler("Eva", "Bauer", Note.GUT);
        Schueler hannaRichter = new Schueler("Hanna", "Richter", Note.GUT);

    }
}
