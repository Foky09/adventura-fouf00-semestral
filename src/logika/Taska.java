/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package logika;

import java.util.Map;
import java.util.HashMap;

/*******************************************************************************
 * Třída Taska - popisuje jednotlivé věci
 * 
 * Tato třída je součástí jednoduché textové hry
 *
 * @author    František Fousek
 * @version   0.1
 */
public class Taska 
{

    private Map <String, Vec> seznamVeci;
    private Vec vec;
    private static final int KAPACITA = 15 ;

    /**
     * Konstruktor seznamu věcí v tašce
     */    
    public Taska()
    {
        seznamVeci = new HashMap<>();
        this.vec = vec;
    }

    
    /**
     * Vrací seznam věcí v tašce, kde je u každé věci množství, název a celková cena
     * Pokud se v tašce nic nenachází, vrací hlášení "V tašce nemáš nic"
     */    
    public String getSeznamVeci(){
        if(seznamVeci.isEmpty()){
            return "V tašce nemáš nic";}
        else{
            String veciVTasce = "V tašce máš: ";
            for(Vec vec : seznamVeci.values()){
                String nazevMnozstviCena = vec.getNazevMnozstviCena();
                veciVTasce += nazevMnozstviCena + ", ";

            }

            return veciVTasce;
        }
    }

    /**
     * Vrací počet správných položek z tašky, které jsou v nákupním seznamu
     */    
    public int getSpravneVeci(){
        int pocetSpravnych = 0;
        int pocetVeci = 0;
        String hledanaVec = null ;
        for(Vec vec : seznamVeci.values()){
            hledanaVec = vec.getNazev();
            pocetVeci = vec.getMnozstvi();

            if ("banán".equals(hledanaVec) && pocetVeci>= 6){
                pocetSpravnych += 1;
            }
            if ("vanička_jahod".equals(hledanaVec) ||"avokádo".equals(hledanaVec) || "brokolice".equals(hledanaVec) || "šunka_krůtí_balení".equals(hledanaVec) || "smetana".equals(hledanaVec) && pocetVeci>= 1){
                pocetSpravnych += 1;
            } 

            if ("rajče".equals(hledanaVec) && pocetVeci>= 4){
                pocetSpravnych += 1;
            } 

            if ("celozrnný_rohlík".equals(hledanaVec) && pocetVeci>= 4){
                pocetSpravnych += 1;
            }  
        }    
        return pocetSpravnych;
    }

    /**
     * Vrací celkovou cenu za všechny věci v tašce
     */  
    public int getCelkovaCena(){
        int celkovaCena = 0;
        for(Vec vec : seznamVeci.values()){
            int mnozstviAVec = vec.getCenaSMnozstvim();
            celkovaCena += mnozstviAVec;

        }
        return celkovaCena;
    }

    /**
     * Vrací zda se daná věc již nachází nebo nenachází v tašce
     */    
    public boolean obsahujeVec(String nazevVeci) {
        return seznamVeci.containsKey(nazevVeci);
    }

    /**
     * Vrací Vec z tašky
     */     
    public Vec najdiVec (String nazevVeci) {
        Vec nalezenaVec;
        if (seznamVeci.containsKey(nazevVeci)) {
            nalezenaVec = seznamVeci.get(nazevVeci);
            return nalezenaVec;
        }
        return null;
    }

    /**
     * Vkládá věc do tašky
     */     
    public Vec vlozVec(Vec vec) {
        if (seznamVeci.size() < KAPACITA ) {

            seznamVeci.put(vec.getNazev(), vec);
            if(obsahujeVec(vec.getNazev())){
                return vec;}
            else{
                return null;
            }
        }

        return null;
    }

    /**
     * Odebírá věc z tašky
     */      
    public Vec odeberVec(String nazevVeci) {

        return seznamVeci.remove(nazevVeci);
    }

    /**
     * Vrací volnou kapacitu v tašce
     */      
    public int getVolnaKapacita() {
        return KAPACITA-seznamVeci.size();

    }
    
}
