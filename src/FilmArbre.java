public class FilmArbre extends Film {
    private FilmArbre gauche;
    private FilmArbre droite;

    public FilmArbre(Film f, FilmArbre g, FilmArbre d){
        super(f);
        gauche = g;
        droite = d;
    }

    public FilmArbre(Film f){
        this(f, null, null);
    }

    public int cle() {
        return getTitre().hashCode();
    }

}