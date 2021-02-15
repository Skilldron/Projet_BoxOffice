public class FilmChaine extends Film{
    // Attributs
    private FilmChaine next;

    // Constructeurs
    public FilmChaine(Film f,FilmChaine n) {
        super(f);
        next=n;
    }

    public FilmChaine(Film f){
        this(f,null);
    }

    public FilmChaine getNext(){
        return next;
    }
}
