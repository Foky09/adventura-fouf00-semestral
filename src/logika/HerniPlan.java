package logika;

/**
 *  Class HerniPlan - třída představující mapu a stav adventury.
 * 
 *  Tato třída inicializuje prvky ze kterých se hra skládá:
 *  vytváří všechny prostory,
 *  propojuje je vzájemně pomocí východů 
 *  a pamatuje si aktuální prostor, ve kterém se hráč právě nachází.
 *
 *@author     Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova, František Fousek
 *@version    pro školní rok 2016/2017
 */
public class HerniPlan {

    private Prostor aktualniProstor;
    private Prostor prostorKVyzvednuti;
    private Prostor prostorKPlaceni;
    private Prostor prostorZaPokladnou;
    private Prostor vstup;
    private Taska taska;
    private boolean vyhra = false;
    private boolean prohra = false;
    /**
     *  Konstruktor který vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví halu.
     */
    public HerniPlan() {
        zalozProstoryHry();
        taska = new Taska();

    }

    /**
     *  Vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví domeček.
     */
    private void zalozProstoryHry() {
        // vytvářejí se jednotlivé prostory
        Prostor pred_obchodem = new Prostor("prostor_před_obchodem","Prostor před obchodem, kde nic není");
        Prostor vstup_do_obchodu = new Prostor("vstup_do_obchodu", "Vstup do obchodu, kde je reklama na okurky jen za 7Kč/ks");
        Prostor obchod = new Prostor("obchod","Obchod s varovnou cedulí - Výpadek terminálů, nepřijímáme platební karty");

        Prostor pecivo = new Prostor("pečivo","Sortiment s čerstvým voňavým pečivem");
        Prostor ovoce = new Prostor("ovoce","Sortiment s ovocem");
        Prostor zelenina = new Prostor("zelenina","Sortiment se zeleninou");
        Prostor drogerie = new Prostor("drogerie","Sortiment s hygienickými potřebami");
        Prostor uzeniny = new Prostor("uzeniny","Sortiment s uzeninami");
        Prostor chlazeneVyrobky = new Prostor("chlazené_výrobky","Sortiment s  mléčnými a chlazenými výrobky");

        Prostor pokladna = new Prostor("pokladna","Pokladna s milou prodavačkou");
        Prostor kavarna = new Prostor("kavárna","Kavarna s vaší milovanou přítelkyní");
        // přiřazují se průchody mezi prostory (sousedící prostory)
        pred_obchodem.setVychod(vstup_do_obchodu);
        pred_obchodem.setVychod(kavarna);
        vstup_do_obchodu.setVychod(obchod);
        obchod.setVychod(ovoce);
        obchod.setVychod(zelenina);
        obchod.setVychod(pecivo);
        obchod.setVychod(drogerie);
        obchod.setVychod(uzeniny);
        obchod.setVychod(chlazeneVyrobky);
        obchod.setVychod(pokladna);
        ovoce.setVychod(obchod);
        zelenina.setVychod(obchod);
        pecivo.setVychod(obchod);
        drogerie.setVychod(obchod);
        uzeniny.setVychod(obchod);
        chlazeneVyrobky.setVychod(obchod);
        kavarna.setVychod(pred_obchodem);

        aktualniProstor = pred_obchodem;  // hra začíná v prostoru před obchodem      
        vstup = vstup_do_obchodu;       //vstup do obchodu, který se po zaplacení zavře
        prostorKPlaceni = pokladna;     //prostor kde lze platit
        prostorKVyzvednuti = kavarna;   //prostor kde lze vyzvednout přítelkyni
        prostorZaPokladnou=pred_obchodem;   //prostor kam se postava přenese po zaplacení na pokladně

        Vec automobil = new Vec("automobil", false, 0, 200000);
        Vec banan = new Vec("banán",true, 0, 7);
        Vec jahoda = new Vec("vanička_jahod", true, 0, 55);
        Vec jablko = new Vec("jablko", true, 0, 5);
        Vec merunka = new Vec("meruňka", true, 0, 4);
        Vec pomeranc = new Vec("pomeranč", true, 0, 5);
        Vec avokado = new Vec("avokádo", true, 0, 38);
        Vec ananas = new Vec("ananas", true, 0, 55);
        Vec kiwi = new Vec("kiwi", true, 0, 6);        

        Vec okurka = new Vec("okurka", true, 0, 7);
        Vec rajce = new Vec("rajče", true, 0, 4);
        Vec ledovySalat = new Vec("ledový_salát", true, 0, 23);
        Vec paprika = new Vec("paprika", true, 0, 10);
        Vec cesnek = new Vec("česnek", true, 0, 7);
        Vec cibule = new Vec("cibule", true, 0, 3);
        Vec kvetak = new Vec("květák", true, 0, 45);
        Vec brokolice = new Vec("brokolice", true, 0, 28);
        Vec mrkev = new Vec("mrkev", true, 0, 5);
        Vec brambora = new Vec("brambora", true, 0, 4);       

        Vec rohlik = new Vec("rohlík", true, 0, 2);
        Vec celozrnnyRohlik = new Vec("celozrnný_rohlík", true, 0, 6);
        Vec houska = new Vec("houska", true, 0, 5);
        Vec chleb = new Vec("chléb", true, 0, 20);
        Vec croissant = new Vec("croissant", true, 0, 8);
        Vec kobliha = new Vec("kobliha", true, 0, 8);
        Vec kolacek = new Vec("koláček", true, 0, 12);

        Vec sunkaKureci = new Vec("šunka_kuřecí_balení", true, 0, 25);
        Vec sunkaKruti = new Vec("šunka_krůtí_balení", true, 0, 29);
        Vec sunkaVeprova = new Vec("šunka_vepřová_balení", true, 0, 25);
        Vec anglickaSlanina = new Vec("anglická_slanina_balení", true, 0, 20);
        Vec klobasa = new Vec("klobása", true, 0, 9);
        Vec parek = new Vec("párek", true, 0, 4);

        Vec bilyJogurt = new Vec("bílý_jogurt", true, 0, 7);
        Vec syrEidam = new Vec("sýr_Eidam_balení", true, 0, 25);
        Vec syrGouda = new Vec("sýr_Gouda_balení", true, 0, 35);
        Vec syrCheddar = new Vec("sýr_Cheddar_balení", true, 0, 35);
        Vec vejce = new Vec("vejce", true, 0, 4);
        Vec smetana = new Vec("smetana", true, 0, 18);
        Vec maslo = new Vec("máslo", true, 0, 58);

        Vec panskyDeodorant = new Vec("pánský_deodorant", true, 0, 65);
        Vec panskySprchovyGel = new Vec("pánský_sprchový_gel", true, 0, 70);
        Vec panskySampon = new Vec("pánský_šampon", true, 0, 80);
        Vec kartacek = new Vec("kartáček", true, 0, 65);
        Vec zubniPasta = new Vec("zubní_pasta", true, 0, 65);
        Vec damskyDeodorant = new Vec("dámský_deodorant", true, 0, 65);
        Vec damskySprchovyGel = new Vec("dámský_sprchový_gel", true, 0, 70);
        Vec damskySampon = new Vec("dámský_šampon", true, 0, 80);

        pred_obchodem.setVec(automobil);
        ovoce.setVec(banan);
        ovoce.setVec(jahoda);
        ovoce.setVec(jablko);
        ovoce.setVec(merunka);
        ovoce.setVec(pomeranc);
        ovoce.setVec(avokado);
        ovoce.setVec(ananas);
        ovoce.setVec(kiwi);

        zelenina.setVec(okurka);
        zelenina.setVec(rajce);
        zelenina.setVec(ledovySalat);
        zelenina.setVec(paprika);
        zelenina.setVec(cesnek);
        zelenina.setVec(cibule);
        zelenina.setVec(kvetak);
        zelenina.setVec(brokolice);
        zelenina.setVec(mrkev);
        zelenina.setVec(brambora);

        pecivo.setVec(rohlik);
        pecivo.setVec(celozrnnyRohlik);
        pecivo.setVec(houska);
        pecivo.setVec(chleb);
        pecivo.setVec(croissant);
        pecivo.setVec(kobliha);
        pecivo.setVec(kolacek);

        uzeniny.setVec(sunkaKureci);
        uzeniny.setVec(sunkaKruti);
        uzeniny.setVec(sunkaVeprova);
        uzeniny.setVec(anglickaSlanina);
        uzeniny.setVec(klobasa);
        uzeniny.setVec(parek);

        chlazeneVyrobky.setVec(bilyJogurt);
        chlazeneVyrobky.setVec(syrEidam);
        chlazeneVyrobky.setVec(syrGouda);
        chlazeneVyrobky.setVec(syrCheddar);
        chlazeneVyrobky.setVec(vejce);
        chlazeneVyrobky.setVec(smetana);
        chlazeneVyrobky.setVec(maslo);

        drogerie.setVec(panskyDeodorant);
        drogerie.setVec(panskySprchovyGel);
        drogerie.setVec(panskySampon);
        drogerie.setVec(kartacek);
        drogerie.setVec(zubniPasta);
        drogerie.setVec(damskyDeodorant);
        drogerie.setVec(damskySprchovyGel);
        drogerie.setVec(damskySampon);
    }

    /**
     *  Metoda vrací odkaz na aktuální prostor, ve ktetém se hráč právě nachází.
     *
     *@return     aktuální prostor
     */

    public Prostor getAktualniProstor() {
        return aktualniProstor;
    }
    
    /**
     *  Metoda vrací zda je aktuální prostor pokladna
     */
    public boolean jePokladna(){
        return prostorKPlaceni.equals(aktualniProstor);
    }

    /**
     *  Metoda vrací zda je aktuální prostor kavarna
     */    
    public boolean jeKavarna(){
        return prostorKVyzvednuti.equals(aktualniProstor);
    }

    /**
     *  Metoda vrací prostor za pokladnou (kam se po zaplacení dostaneme)
     *  A odstraní vstup do obchodu, jelikož obchod bude už zavírat
     */ 
    public Prostor getProstorZaPokladnou() {
        prostorZaPokladnou.odeberVychod(vstup);
        return prostorZaPokladnou;
    }

    /**
     *  Metoda nastaví aktuální prostor, používá se nejčastěji při přechodu mezi prostory
     *
     *@param  prostor nový aktuální prostor
     */
    public void setAktualniProstor(Prostor prostor) {
        aktualniProstor = prostor;
    }

    /**
     *  Metoda vrací tašku
     *
     */
    public Taska getTaska(){
        return taska;
    }

    /**
     *  Metoda vrací zda jsme vyhráli
     *
     */
    public boolean jeVyhra() {
        return vyhra;
    }

    /**
     *  Metoda vrací zda jsme prohráli
     *
     */
    public boolean jeProhra() {
        return prohra;
    }

    /**
     *  Metoda nastavuje stav hry na prohru
     *
     */    
    public void setProhra(boolean stav) {
        this.prohra = stav;
    }

    /**
     *  Metoda nastavuje stav hry na výhru
     *
     */ 
    public void setVyhra(boolean stav) {
        this.vyhra = stav;
    }
}
