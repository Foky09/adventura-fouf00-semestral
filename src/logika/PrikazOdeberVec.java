/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package logika;


/**
 *  Třída PrikazOdeberVec implementuje pro hru příkaz odeber.
 *  Tato třída je součástí jednoduché textové hry.
 *
 * @author    František Fousek
 * @version   0.1
 */
public class PrikazOdeberVec implements IPrikaz
{
    private static final String NAZEV = "odeber";
    private HerniPlan plan;
    /**
     *  Konstruktor třídy
     *  
     *  @param plan herní plán, odkud si bereme 
     */   
    public PrikazOdeberVec(HerniPlan plan)
    {
        this.plan = plan;
    }

    /**
     *  Provádí příkaz "odeber". Zkouší se odebrat zadaná věc a její množství. Pokud se věc
     *  nachází v tašce je zadané množství odebráno. Pokud v tašce věc není, vypíše se chybová hláška
     *
     *@param parametry - jako  parametr obsahuje název věci a její množství,
     *                         které se má sebrat.
     *@return zpráva, kterou vypíše hra hráči
     */ 
    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length <= 1) {
            return "Co přesně mám odebrat a kolik toho mám odebrat z tašky?";
        }
        String nazevVeci = parametry[0];
        // kontrola celého čísla
        try{
            Integer.parseInt(parametry[1]);

        }
        catch (NumberFormatException e){
            return "Špatně zadané mnozstvi";
        }
        int mnozstviVeci = Integer.parseInt(parametry[1]);

        if (mnozstviVeci <= 0){
            return "Musíš zadat kladné číslo";
        }
        Taska taska = plan.getTaska();                
        Vec odebiranaVec = taska.najdiVec(nazevVeci);
        if (odebiranaVec == null){
            return "Takovou věc ve své tašce nemáš";
        }
        if (mnozstviVeci > odebiranaVec.getMnozstvi()){
            return "Ve své tašce nemáš tolik množství této věci";
        }
        odebiranaVec.setMnozstvi(-mnozstviVeci);
        if (odebiranaVec.getMnozstvi() == 0){
            taska.odeberVec(nazevVeci);
        }

        return "Z tašky jsi právě odebral " + mnozstviVeci + "x " + nazevVeci;   
    }

    /**
     *  Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *  @ return nazev prikazu
     */        
    @Override
    public String getNazev() {
        return NAZEV;
    }
}
