/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package logika;



/**
 *  Třída PrikazZaplat implementuje pro hru příkaz zaplať.
 *  Tato třída je součástí jednoduché textové hry.
 *
 * @author    František Fousek
 * @version   0.1
 */
class PrikazZaplat implements IPrikaz {
    private static final String NAZEV = "zaplať";
    private HerniPlan plan;
    /**
     *  Konstruktor třídy
     *  
     *  @param plan herní plán, odkud si bereme tašku a zjišťujeme aktuální prostor
     */    
    public PrikazZaplat(HerniPlan plan) {
        this.plan = plan;
    }

    /**
     *  Provádí příkaz "zaplať". Zjišťuje zda se nacházíme v prostoru pokladna.
     *  Pokud ano, zjišťuje zda celková cena všech věcí v tašce nepřekračuje hranici 350Kč.
     *  Pokud přesáhne hra končí.
     *  
     *@return zpráva, kterou vypíše hra hráči
     */     
    @Override
    public String provedPrikaz(String... parametry) {
        Taska taska = plan.getTaska();

        if (plan.jePokladna() == false){
            return "Zde nemůžeš zaplatit, nejsi v prostoru 'pokladna'";
        }

        int celkovaCena = taska.getCelkovaCena();
        if (celkovaCena > 350){
            plan.setProhra(true);
            return"Cena nákupu přesáhla množství peněz v tvé peněžence";

        }
        Prostor dalsiProstor = plan.getProstorZaPokladnou();
        plan.setAktualniProstor(dalsiProstor);

        return("Nákup tě stál " + celkovaCena + "Kč." +  '\n' + dalsiProstor.dlouhyPopis());

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
