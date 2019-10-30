/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package logika;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Testovací třída TaskaTest slouží ke komplexnímu otestování
 *
 * @author    Jarmila Pavlíčková
 * @version   pro skolní rok 2016/2017
 */
public class TaskaTest
{
    private Vec vec1;
    private Vec vec2;
    private Vec vec3;

    private Taska taska;
    

    /***************************************************************************
     * Inicializace předcházející spuštění každého testu a připravující tzv.
     * přípravek (fixture), což je sada objektů, s nimiž budou testy pracovat.
     */
    @Before
    public void setUp()
    {
        vec1 = new Vec("banán", true, 1, 1);
        vec2 = new Vec("kedlubna", true, 2, 2);
        vec3 = new Vec("okurka", true, 3, 3);
        taska = new Taska();
        
    }


    /***************************************************************************
     * Úklid po testu - tato metoda se spustí po vykonání každého testu.
     */
    @After
    public void tearDown()
    {
    }

    
    
    
    /**
     * Testuje, zda jdou do tašky vkládat a odebírat věci 
     * a zjišťuje jestli se v tašce nacházejí.
     */
    @Test
    public void testVlozeniAOdebrani(){
        assertEquals("V tašce nemáš nic", taska.getSeznamVeci());
        assertEquals(15,taska.getVolnaKapacita());
        
        assertEquals(vec1, taska.vlozVec(vec1));
        assertEquals(true, taska.obsahujeVec("banán"));
        assertEquals("V tašce máš: 1x banán (1Kč), ", taska.getSeznamVeci());
        assertEquals(vec1, taska.najdiVec("banán"));
        assertEquals(14,taska.getVolnaKapacita());
        
        
        assertEquals(vec1, taska.odeberVec("banán"));
        assertEquals("V tašce nemáš nic", taska.getSeznamVeci());
        assertEquals(15,taska.getVolnaKapacita());
    }

    /**
     * Testuje celkovou cenu věcí v tašce
     */    
    @Test
    public void testCen(){
        taska.vlozVec(vec1);
        assertEquals(1, taska.getCelkovaCena());
        taska.vlozVec(vec2);
        assertEquals(5, taska.getCelkovaCena());
        taska.vlozVec(vec3);
        assertEquals(14, taska.getCelkovaCena());
    
    }

    /**
     * Testuje maximální kapacitu tašky
     */      
    @Test
    public void testMaximalniKapacita(){
        
        Vec vec4= new Vec("vec4", true, 0, 0);
        Vec vec5 = new Vec("vec5", true, 0, 0);
        Vec vec6 = new Vec("vec6", true, 0, 0);
        Vec vec7 = new Vec("vec7", true, 0, 0);
        Vec vec8 = new Vec("vec8", true, 0, 0);
        Vec vec9 = new Vec("vec9", true, 0, 0);
        Vec vec10 = new Vec("vec10", true, 0, 0);
        Vec vec11 = new Vec("vec11", true, 0, 0);
        Vec vec12 = new Vec("vec12", true, 0, 0);
        Vec vec13 = new Vec("vec13", true, 0, 0);
        Vec vec14 = new Vec("vec14", true, 0, 0);
        Vec vec15 = new Vec("vec15", true, 0, 0);
        Vec vec16 = new Vec("vec16", true, 0, 0);

        
        
        taska.vlozVec(vec1);
        taska.vlozVec(vec2);
        taska.vlozVec(vec3);
    
        assertEquals(vec1, taska.vlozVec(vec1));
        assertEquals(vec2, taska.vlozVec(vec2));
        assertEquals(vec3, taska.vlozVec(vec3));
        assertEquals(vec4, taska.vlozVec(vec4));
        assertEquals(vec5, taska.vlozVec(vec5));
        assertEquals(vec6, taska.vlozVec(vec6));
        assertEquals(vec7, taska.vlozVec(vec7));
        assertEquals(vec8, taska.vlozVec(vec8));
        assertEquals(vec9, taska.vlozVec(vec9));
        assertEquals(vec10, taska.vlozVec(vec10));
        assertEquals(vec11, taska.vlozVec(vec11));
        assertEquals(vec12, taska.vlozVec(vec12));
        assertEquals(vec13, taska.vlozVec(vec13));
        assertEquals(vec14, taska.vlozVec(vec14));
        assertEquals(vec15, taska.vlozVec(vec15));
        assertEquals(null, taska.vlozVec(vec16));

    
    
    }
    
    //== PŘÍSTUPOVÉ METODY VLASTNOSTÍ INSTANCÍ =================================
    //== OSTATNÍ NESOUKROMÉ METODY INSTANCÍ ====================================
    //== SOUKROMÉ A POMOCNÉ METODY TŘÍDY =======================================
    //== SOUKROMÉ A POMOCNÉ METODY INSTANCÍ ====================================
    //== INTERNÍ DATOVÉ TYPY ===================================================
    //== VLASTNÍ TESTY =========================================================
    //
    //     /********************************************************************
    //      *
    //      */
    //     @Test
    //     public void testXxx()
    //     {
    //     }
}
