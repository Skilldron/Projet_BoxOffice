public class Film {

    // Attributs
    private String titre;
    private String realisateur;
    private int annee;
    private int nbEntree;

    // Constructeurs
    public Film(String titre, String realisateur, int annee, int nbEntree) {
        this.titre = titre;
        this.realisateur = realisateur;
        this.annee = annee;
        this.nbEntree = nbEntree;
    }

    public Film(Film f){
        this.titre=f.getTitre();
        this.realisateur=f.getRealisateur();
        this.annee=f.getAnnee();
        this.nbEntree=f.getNbEntree();
    }


    // GETTER SETTER
    public String getTitre() {
        return titre;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public int getAnnee() {
        return annee;
    }

    public int getNbEntree() {
        return nbEntree;
    }

    public void setNbEntree(int nbEntree) {
        this.nbEntree = nbEntree;
    }
}
