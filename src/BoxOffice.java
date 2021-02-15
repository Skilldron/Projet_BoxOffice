import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

public abstract class BoxOffice {
    private String listing;
    private int nbLignes= 0;

    public abstract void addFilm(String titre, String realisateur, int annee,int nbEntrees);


    public BoxOffice(String listing) {
        String titre, realisateur, ville;
        int annee,entree;
        Scanner scanner = null;
        try {
            Scanner in = new Scanner(new File(listing));
            while (in.hasNextLine()) { // On boucle sur chaque ligne
                int nblignes = 0;
                String line = in.nextLine();
                String[] tab=line.split("\t");
                if (line.length()<5)
                    break;
                titre = tab[0];
                titre = titre.substring(7);
                realisateur = tab[1];
                realisateur = realisateur.substring(14);
                String tmp = tab[2].substring(8);
                annee = Integer.parseInt(tmp);
                ville= tab[3];
                ville = ville.substring(8);
                String tmp2 = tab[4].substring(9);
                entree = Integer.parseInt(tmp2);
                nbLignes++;
                addFilm(titre,realisateur,annee,entree);
            }
            in.close();
        } catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public int getNbLignes() {
        return nbLignes;
    }
}
