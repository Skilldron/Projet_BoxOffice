import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class BoxOfficeTableau extends BoxOffice {
    public final static int TAILLE_INITIALE = 100;
    static int taille_actual = TAILLE_INITIALE;
    private static int compteur=0;
    private Film[] elements;



    public BoxOfficeTableau(String listing) {
        super(listing);
    }


    @Override
    public void addFilm(String titre, String realisateur, int annee, int nbEntrees) {
        if(elements==null)  elements = new Film[TAILLE_INITIALE];

        Film f = new Film(titre,realisateur,annee,nbEntrees);

        if(compteur==taille_actual) {
            taille_actual *= 2;
            Film[] tab_tmp= elements.clone();
            elements = new Film[taille_actual];
            compteur=0;
            for (int i=0;i<tab_tmp.length;i++) {
                compteur++;
                elements[i] = tab_tmp[i];
            }
        }

        for (int i=0;i<compteur;i++){
            if (elements[i].getTitre().equals(titre)) {
                elements[i].setNbEntree(elements[i].getNbEntree() + nbEntrees);
                return;
            }
        }

        elements[compteur] =new Film(titre,realisateur,annee,nbEntrees);
        compteur++; // nb de films

        // Dois désormais trouver les 3 films avec le plus d'entrée en suivant l'affichage du sujet
    }

    public void top3(){
        int indiceM1=0;
        int indiceM2=0;
        int indiceM3=0;
        for (int i= 0;i<compteur;i++){
           if (elements[i].getNbEntree()>elements[indiceM1].getNbEntree()) {
               indiceM3 = indiceM2;
               indiceM2 = indiceM1;
               indiceM1 = i;
           }
           else if (elements[i].getNbEntree()>elements[indiceM2].getNbEntree()) {
               indiceM3 = indiceM2;
               indiceM2 = i;
           }
           else if (elements[i].getNbEntree()>elements[indiceM3].getNbEntree()){
               indiceM3=i;
           }
        }

        System.out.println("("+elements[indiceM1].getAnnee()+")  "+elements[indiceM1].getTitre()+"\t"+"entrées : "+elements[indiceM1].getNbEntree());
        System.out.println("("+elements[indiceM2].getAnnee()+")  "+elements[indiceM2].getTitre()+"\t"+"entrées : "+elements[indiceM2].getNbEntree());
        System.out.println("("+elements[indiceM3].getAnnee()+")  "+elements[indiceM3].getTitre()+"\t"+"entrées : "+elements[indiceM3].getNbEntree());

    }


    public void affichage(){
        for (int i= 0;i<3;i++){
            System.out.println("("+elements[i].getAnnee()+")  "+elements[i].getTitre()+"\t"+"entrées : "+elements[i].getNbEntree());
        }
    }


    public static void main(String[] args) {
        if (args.length!=1)
            System.out.println("Il faut 1 seul fichier en argument");
        else {
            BoxOfficeTableau box= new BoxOfficeTableau(args[0]);
            System.out.println("Fichier : " + args[0]);
            System.out.println("Nombre de lignes : "+box.getNbLignes());
            System.out.println("Nombre de film : "+box.compteur);
            System.out.println("-------------------------");
            System.out.println("Films comptabilisant le plus grand nombre d'entrées : ");

            box.top3();
        }
    }
}
