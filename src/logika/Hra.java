package logika;

/**
 *  Třída Hra - třída představující logiku adventury.
 * 
 *  Toto je hlavní třída  logiky aplikace.  Tato třída vytváří instanci třídy HerniPlan, která inicializuje mistnosti hry
 *  a vytváří seznam platných příkazů a instance tříd provádějící jednotlivé příkazy.
 *  Vypisuje uvítací a ukončovací text hry.
 *  Také vyhodnocuje jednotlivé příkazy zadané uživatelem.
 *
 *@author     Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova, František Fousek
 *@version    pro školní rok 2016/2017
 */

public class Hra implements IHra {
    private SeznamPrikazu platnePrikazy;    // obsahuje seznam přípustných příkazů
    private HerniPlan herniPlan;
    private boolean konecHry = false;

    /**
     *  Vytváří hru a inicializuje místnosti (prostřednictvím třídy HerniPlan) a seznam platných příkazů.
     */
    public Hra() {
        herniPlan = new HerniPlan();
        platnePrikazy = new SeznamPrikazu();
        platnePrikazy.vlozPrikaz(new PrikazNapoveda(platnePrikazy));
        platnePrikazy.vlozPrikaz(new PrikazJdi(herniPlan));
        platnePrikazy.vlozPrikaz(new PrikazSeber(herniPlan));
        platnePrikazy.vlozPrikaz(new PrikazObsahTasky(herniPlan));
        platnePrikazy.vlozPrikaz(new PrikazOdeberVec(herniPlan));
        platnePrikazy.vlozPrikaz(new PrikazZaplat(herniPlan));
        platnePrikazy.vlozPrikaz(new PrikazVyzvedniPritelkyni(herniPlan));
        platnePrikazy.vlozPrikaz(new PrikazKonec(this));
    }

    /**
     *  Vrátí úvodní zprávu pro hráče.
     */
    public String vratUvitani() {
        return "Vítejte!\n" 
               + "Při cestě do obchodu s vaší přítelkyní\n" 
               + "se vaše přítelkyně potkává s její nejlepší kamarádkou ze střední. \n"
               + "Ty dvě si mají určitě co povídat, tak je necháváte zajít do blízké kavárny. \n"
               + "A vrháte se nakoupit sám. \n"
               +"\n" 
               + "Přítelkyně vám nechala nákupní seznam s věcmi, které musíte koupit. \n"
               +"\n" 
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
               + "V peněžence máš pouze 350Kč v hotovosti a v obchodě neberou platební karty"
               + "\n"
               + "Do tašky se ti vejde pouze " + herniPlan.getTaska().getVolnaKapacita() + " různých položek"
               + "\n"
               + "Zvládneš všechno nakoupit?"
               + "\n"
               + "Napište 'nápověda', pokud si nevíte rady, jak hrát dál.\n"
               + "\n" + "\n"   
               + herniPlan.getAktualniProstor().dlouhyPopis();
    }
    
    /**
     *  Vrátí závěrečnou zprávu pro hráče.
     */
    public String vratEpilog() {
        return "Dík, že jste si zahráli.  Ahoj.";
    }
    
    /** 
     * Vrací true, pokud hra skončila.
     */
     public boolean konecHry() {
        return konecHry;
    }

    /**
     *  Metoda zpracuje řetězec uvedený jako parametr, rozdělí ho na slovo příkazu a další parametry.
     *  Pak otestuje zda příkaz je klíčovým slovem  např. jdi.
     *  Pokud ano spustí samotné provádění příkazu.
     *
     *@param  radek  text, který zadal uživatel jako příkaz do hry.
     *@return          vrací se řetězec, který se má vypsat na obrazovku
     */
     public String zpracujPrikaz(String radek) {
        String [] slova = radek.split("[ \t]+");
        String slovoPrikazu = slova[0];
        String []parametry = new String[slova.length-1];
        for(int i=0 ;i<parametry.length;i++){
            parametry[i]= slova[i+1];   
        }
        String textKVypsani=" .... ";
        if (platnePrikazy.jePlatnyPrikaz(slovoPrikazu)) {
            IPrikaz prikaz = platnePrikazy.vratPrikaz(slovoPrikazu);
            textKVypsani = prikaz.provedPrikaz(parametry);
        
            
        }
        
        else {
            textKVypsani="Nevím co tím myslíš? Tento příkaz neznám. ";
        }
        
        if (herniPlan.jeVyhra()){
                textKVypsani += "\n" + "Zvítězil jsi";
                konecHry = true;
            
            }
            
        if (herniPlan.jeProhra()){
                textKVypsani += "\n" + "Prohrál jsi";
                konecHry = true;
            
            }
            
        return textKVypsani;
    }
    
    
     /**
     *  Nastaví, že je konec hry, metodu využívá třída PrikazKonec,
     *  mohou ji použít i další implementace rozhraní Prikaz.
     *  
     *  @param  konecHry  hodnota false= konec hry, true = hra pokračuje
     */
    void setKonecHry(boolean konecHry) {
        this.konecHry = konecHry;
    }
    
     /**
     *  Metoda vrátí odkaz na herní plán, je využita hlavně v testech,
     *  kde se jejím prostřednictvím získává aktualní místnost hry.
     *  
     *  @return     odkaz na herní plán
     */
     public HerniPlan getHerniPlan(){
        return herniPlan;
     }
    
}

