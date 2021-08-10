
package waluty.wygenerowane;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import waluty.model.*;

/**
 * &lt;p&gt;Java class for anonymous complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{}ExchangeRatesTable"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "exchangeRatesTable"
})
@XmlRootElement(name = "pobierzBiezaceKursyResponse")
public class PobierzBiezaceKursyResponse {

    @XmlElement(name = "ExchangeRatesTable", required = true)
    protected ExchangeRatesTable exchangeRatesTable;

    /**
     * Gets the value of the exchangeRatesTable property.
     * 
     * @return
     *     possible object is
     *     {@link ExchangeRatesTable }
     *     
     */
    public ExchangeRatesTable getExchangeRatesTable() {
        return exchangeRatesTable;
    }

    /**
     * Sets the value of the exchangeRatesTable property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExchangeRatesTable }
     *     
     */
    public void setExchangeRatesTable(ExchangeRatesTable value) {
        this.exchangeRatesTable = value;
    }

}
