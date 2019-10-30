/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package logika;


/**
 *  Třída PrikazSeber implementuje pro hru příkaz seber.
 *  Tato třída je součástí jednoduché textové hry.
 *
 * @author    František Fousek
 * @version   0.1
 */
class PrikazSeber implements IPrikaz
{   private static final String NAZEV = "seber";
    private HerniPlan plan;

    /**
     *  Konstruktor třídy
     *  
     *  @param plan herní plán
     */   
    public PrikazSeber(HerniPlan plan)
    {
        this.plan = plan;
    }

    /**
     *  Provádí příkaz "seber". Zkouší se sebrat zadaná věc a její množství. Pokud se věc
     *  nachází v prostoru je přianá do tašky. Pokud v prostoru tato věc není, vypíše se chybová hláška
     *
     *@param parametry - jako  parametr obsahuje název věci a její množství,
     *                         které se má sebrat.
     *@return zpráva, kterou vypíše hra hráči
     */ 
    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length <= 1) {
            // pokud chybí druhé nebo třetí slovo (věc nebo množství), tak ....
            return "Co mám sebrat a kolik toho mám sebrat? Musíš zadat název věci a množství.";
        }

        String nazevVeci = parametry[0];
        int mnozstviVeci = Integer.parseInt(parametry[1]);
        Prostor aktualniProstor = plan.getAktualniProstor();
        Vec sbirana = aktualniProstor.getVec(nazevVeci);
        Taska taska=plan.getTaska();
        if (sbirana != null) {
            
            if(taska.getVolnaKapacita() == 0){
            return "Do tašky se ti už nic nevejde";
            }
            else {
            sbirana.setMnozstvi(mnozstviVeci);
            taska.vlozVec(sbirana);
            return "Do tašky jsi vložil " + mnozstviVeci + " x " + nazevVeci;
            }
        }
        else{

            if(aktualniProstor.jeVProstoru(nazevVeci)){
                aktualniProstor.setVec(sbirana);
                return "Tohle nelze odnést";
            }
            else {
                return "Tuto položku zde nenajdeš";

            }
        }
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

    //== Nesoukromé metody (instancí i třídy) ======================================

    //== Soukromé metody (instancí i třídy) ========================================

}
