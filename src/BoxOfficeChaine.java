public class BoxOfficeChaine extends BoxOffice{
    // Attributs
    private FilmChaine elements;
    private int compteur;

    // Constructeurs
    public BoxOfficeChaine(String listing) {
        super(listing);
    }

    // Methodes
    @Override
    public void addFilm(String titre, String realisateur, int annee, int nbEntrees) {
        if (elements==null) {
            elements = new FilmChaine(new Film(titre, realisateur, annee, nbEntrees));
            compteur++;
        }

        FilmChaine tmp = elements;
        while (tmp!=null){
            if (tmp.getTitre().equals(titre)) {
                tmp.setNbEntree(tmp.getNbEntree() + nbEntrees);
                return;
            }
            tmp = tmp.getNext();
        }

        elements = new FilmChaine(new Film(titre, realisateur, annee, nbEntrees), elements);
        compteur++;
    }

    public void top3(){
        FilmChaine m1 = elements;
        FilmChaine m2 = elements;
        FilmChaine m3 = elements;

        FilmChaine tmp = elements;
        while(tmp!=null){
            if (tmp.getNbEntree()>m1.getNbEntree()) {
                m3 = m2;
                m2 = m1;
                m1 = tmp;
            }
            else if (tmp.getNbEntree()>m2.getNbEntree()) {
                m3 = m2;
                m2 = tmp;
            }
            else if (tmp.getNbEntree()>m3.getNbEntree()){
                m3=tmp;
            }

            tmp = tmp.getNext();

        }

        System.out.println("("+m1.getAnnee()+")  "+m1.getTitre()+"\t"+"entrées : "+m1.getNbEntree());
        System.out.println("("+m2.getAnnee()+")  "+m2.getTitre()+"\t"+"entrées : "+m2.getNbEntree());
        System.out.println("("+m3.getAnnee()+")  "+m3.getTitre()+"\t"+"entrées : "+m3.getNbEntree());

    }

    public int getCompteur() {
        return compteur;
    }

    public static void main(String[] args) {
        if (args.length != 1)
            System.out.println("Il faut 1 seul fichier en argument");
        else {
            BoxOfficeChaine box = new BoxOfficeChaine(args[0]);

            System.out.println("Fichier : " + args[0]);
            System.out.println("Nombre de lignes : " + box.getNbLignes());
            System.out.println("Nombre de film : " + box.getCompteur());
            System.out.println("-------------------------");
            System.out.println("Films comptabilisant le plus grand nombre d'entrées : ");
            box.top3();

        }
    }
}

