/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package logika;


/**
 *  Třída PrikazVyzvedniPritelkyni implementuje pro hru příkaz vyzvedni_přítelkyni.
 *  Tato třída je součástí jednoduché textové hry.
 *
 * @author    František Fousek
 * @version   0.1
 */
public class PrikazVyzvedniPritelkyni implements IPrikaz {
    private static final String NAZEV = "vyzvedni_přítelkyni";
    private HerniPlan plan;
    private Hra hra;
    private int spravnyPocet;
    
    
    /**
     *  Konstruktor třídy
     *  
     *  @param plan herní plán, odkud si bereme tašku a zjišťujeme aktuální prostor
     */   
    public PrikazVyzvedniPritelkyni(HerniPlan plan) {
        this.plan = plan;
        this.hra =hra;
        spravnyPocet = 8;
    }


    /**
     *  Provádí příkaz "vyzvedni_přítelkyni". Zjišťuje zda se nacházíme v kavárně.
     *  Pokud ano kontroluje zda sedí obsah tašky s nákupním seznamem.
     *  Pokud ano hra končí výhrou.
     *  Pokud ne hra končí prohrou.
     *
     *@return zpráva, kterou vypíše hra hráči
     */   
    @Override
    public String provedPrikaz(String... parametry) {
        if (plan.jeKavarna() == false){
            return "Zde nemůžeš nikoho vyzvednout, nejsi v prostoru 'kavarna'";
        }
        Taska taska = plan.getTaska();
        int pocetSpravnych = taska.getSpravneVeci();
        if (pocetSpravnych < spravnyPocet){
            plan.setProhra(true);
            int pocetSpatnych = spravnyPocet - pocetSpravnych;
            return "Nenakoupil jsi správně všechny položky" + "\n" + "Počet chybějících/špatných položek:  " + pocetSpatnych;
        }
        plan.setVyhra(true);
        return "Nakoupil jsi vše, co bylo potřeba";

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
