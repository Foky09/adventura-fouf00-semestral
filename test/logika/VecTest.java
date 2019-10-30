/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package logika;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Testovací třída VecTest slouží ke komplexnímu otestování
 *
 * @author    Jarmila Pavlíčková
 * @version   pro skolní rok 2016/2017
 */
public class VecTest
{

    /***************************************************************************
     * Inicializace předcházející spuštění každého testu a připravující tzv.
     * přípravek (fixture), což je sada objektů, s nimiž budou testy pracovat.
     */
    @Before
    public void setUp()
    {
    }

    /***************************************************************************
     * Úklid po testu - tato metoda se spustí po vykonání každého testu.
     */
    @After
    public void tearDown()
    {
    }
    
    /**
     * Testuje, zda jsou věci přenositelné/nepřenositelné, nastavaní ceny množství
     * a vypsání množství ceny a názvu věci
     */
    @Test
    public void testPrenositelnostAMnozstvi(){
        Vec vec1 = new Vec ("jahoda", true, 0, 0);
        Vec vec2 = new Vec ("brambora", false, 3, 2);    
    
        
        assertEquals(true, vec1.isPrenositelnost());
        assertEquals(false, vec2.isPrenositelnost());
        vec1.setMnozstvi(4);
        assertEquals(4, vec1.getMnozstvi());
        assertEquals("3x brambora (6Kč)",vec2.getNazevMnozstviCena());
    }

}

