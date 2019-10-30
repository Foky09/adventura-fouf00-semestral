/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package logika;


/**
 * Třída Vec - popisuje jednotlivé věci
 * 
 * Tato třída je součástí jednoduché textové hry
 *
 *
 * @author    František Fousek
 * @version   0.1
 */
public class Vec
{

    private String nazev;
    private boolean prenositelnost;
    private int cena;
    private int mnozstvi;
    private String nazevAMnozstvi;


    /**
     *  Konstruktor
     */
    public Vec(String nazev, boolean prenositelnost, int mnozstvi, int cena)
    {
        this.nazev = nazev;
        this.prenositelnost = prenositelnost;
        this.cena = cena;
        this.mnozstvi = mnozstvi;
        this.nazevAMnozstvi = nazevAMnozstvi;
    }

    /**
     * Vrací název věci
     */    
    public String getNazev(){
        return nazev;
    }

    /**
     * Vrací celkovou cenu věci při započtení množství
     */     
    public int getCenaSMnozstvim(){
        return mnozstvi * cena;
    }
    
    /**
     * Vrací název, množství a celkovou cenu za věc
     */
    public String getNazevMnozstviCena(){
        nazevAMnozstvi= mnozstvi + "x " + nazev + " (" + getCenaSMnozstvim() + "Kč)";
        return nazevAMnozstvi;
    }

    /**
     * Vrací zda je věc přenositelná
     */    
    public boolean isPrenositelnost(){
        return prenositelnost;
    }

    /**
     * Vrací cenu věci
     */   
    public int getCena(){
        return cena;
    }

    
    /**
     * Nastaví množství ceny
     */      
    public void setMnozstvi(int mnozstvi){
        this.mnozstvi += mnozstvi;
    }

    /**
     * Vrací množství věci
     */     
    public int getMnozstvi(){
        return mnozstvi;
    }

}
