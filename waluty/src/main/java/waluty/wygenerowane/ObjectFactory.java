
package waluty.wygenerowane;

import javax.xml.bind.annotation.XmlRegistry;
import waluty.model.*;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the waluty.wygenerowane package. 
 * &lt;p&gt;An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: waluty.wygenerowane
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ExchangeRatesTable }
     * 
     */
    public ExchangeRatesTable createExchangeRatesTable() {
        return new ExchangeRatesTable();
    }

    /**
     * Create an instance of {@link ArrayOfExchangeRatesTable }
     * 
     */
    public ArrayOfExchangeRatesTable createArrayOfExchangeRatesTable() {
        return new ArrayOfExchangeRatesTable();
    }

    /**
     * Create an instance of {@link Rate }
     * 
     */
    public Rate createRate() {
        return new Rate();
    }

    /**
     * Create an instance of {@link PobierzTabeleDlaDaty }
     * 
     */
    public PobierzTabeleDlaDaty createPobierzTabeleDlaDaty() {
        return new PobierzTabeleDlaDaty();
    }

    /**
     * Create an instance of {@link PobierzTabeleDlaDatyResponse }
     * 
     */
    public PobierzTabeleDlaDatyResponse createPobierzTabeleDlaDatyResponse() {
        return new PobierzTabeleDlaDatyResponse();
    }

    /**
     * Create an instance of {@link PobierzBiezaceKursy }
     * 
     */
    public PobierzBiezaceKursy createPobierzBiezaceKursy() {
        return new PobierzBiezaceKursy();
    }

    /**
     * Create an instance of {@link PobierzBiezaceKursyResponse }
     * 
     */
    public PobierzBiezaceKursyResponse createPobierzBiezaceKursyResponse() {
        return new PobierzBiezaceKursyResponse();
    }

    /**
     * Create an instance of {@link PobierzPrzedzial }
     * 
     */
    public PobierzPrzedzial createPobierzPrzedzial() {
        return new PobierzPrzedzial();
    }

    /**
     * Create an instance of {@link PobierzPrzedzialResponse }
     * 
     */
    public PobierzPrzedzialResponse createPobierzPrzedzialResponse() {
        return new PobierzPrzedzialResponse();
    }

}
