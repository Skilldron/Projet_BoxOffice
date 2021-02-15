public class BoxOfficeTest extends BoxOffice{
    public BoxOfficeTest(String listing) {
        super(listing);
    }

    @Override
    public void addFilm(String titre, String realisateur, int annee, int nbEntrees){
        System.out.println("("+annee+")  "+titre+"      Real.: "+realisateur+
                "      Entrees: "+nbEntrees);
    }

    public static void main(String[] args) {
        //if (args.length<1) System.out.println("Nom de fichier manquant");
        //else
            new BoxOfficeTest("easy_2010.box");
    }
}
