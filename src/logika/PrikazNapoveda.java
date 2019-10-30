package logika;

/**
 *  Třída PrikazNapoveda implementuje pro hru příkaz napoveda.
 *  Tato třída je součástí jednoduché textové hry.
 *  
 *@author     Jarmila Pavlickova, Luboš Pavlíček, František Fousek
 *@version    pro školní rok 2016/2017
 *  
 */
class PrikazNapoveda implements IPrikaz {

    private static final String NAZEV = "nápověda";
    private SeznamPrikazu platnePrikazy;

    /**
     *  Konstruktor třídy
     *  
     *  @param platnePrikazy seznam příkazů,
     *                       které je možné ve hře použít,
     *                       aby je nápověda mohla zobrazit uživateli. 
     */    
    public PrikazNapoveda(SeznamPrikazu platnePrikazy) {
        this.platnePrikazy = platnePrikazy;
    }

    /**
     *  Vrací základní nápovědu po zadání příkazu "napoveda". Nyní se vypisuje
     *  vcelku primitivní zpráva a seznam dostupných příkazů.
     *  
     *  @return napoveda ke hre
     */
    @Override
    public String provedPrikaz(String... parametry) {
        return "Tvým úkolem je nakoupit veškeré položky z nákupního listu \n"
        + "a poté vyzvednout svoji přítelkyni v kavárně\n"
        + "\n"
        + "Nákupní seznam:\n"
        + "               6 banánů\n"
        + "               1 vanička jahod\n"
        + "               1 avokádo\n"
        + "               4 rajčata\n"
        + "               1 brokolice\n"
        + "               4 celozrnné rohlíky\n"
        + "               1 balení krůtí šunky\n"
        + "               1 smetana\n"
        + "\n"
        + "Můžeš zadat tyto příkazy:\n"
        + platnePrikazy.vratNazvyPrikazu()
        + "\n"
        + "U příkazu seber a odeber je nutné zadat množství za název věci."
        + "Věc můžeš odebrat kdekoliv, ale sebrat ji můžeš pouze ve správném oddělení v obchodě."
        + "Můžeš nakoupit i další věci, pokud budeš chtít."
        + "V prostoru pokladna lze pouze zaplatit, nelze jít dál, nebo se vrátit."
        ;
    }

    /**
     *  Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *  
     *  @ return nazev prikazu
     */
    @Override
    public String getNazev() {
        return NAZEV;
    }

}
