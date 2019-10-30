/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package logika;



/*******************************************************************************
 * Instance třídy {@code PrikazObsahTasky} představují ...
 *
 * @author    František Fousek
 * @version   0.1
 */
public class PrikazObsahTasky implements IPrikaz
{

    private static final String NAZEV = "obsah_tašky";
    private HerniPlan plan;

    /***************************************************************************
     * Konsturktor
     * @param plan herní plán
     */    
    public PrikazObsahTasky(HerniPlan plan)
    {
        this.plan = plan;
    }


    /**
     *  Provádí příkaz "obsah_tašky"    
     *@return vrací veci v tašce, celkovou cenu věcí a volnou kapacitu tašky
     */     
    @Override
    public String provedPrikaz(String... parametry) {
        Taska taska = plan.getTaska();
        String veci = taska.getSeznamVeci();
        int celkovaCena = taska.getCelkovaCena();
        int volnaKapacita = taska.getVolnaKapacita();
        return veci + '\n' + "Celkem máš ve své tašce nákup za " + celkovaCena + "Kč" + '\n' + "Tvá volná kapacita: " + volnaKapacita + " položek" ;

    }

    /**
     *  Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *  @ return nazev prikazu
     */    
    public String getNazev() {
        return NAZEV;
    }

}
