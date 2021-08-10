
package waluty.wygenerowane;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


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
 *         &amp;lt;element name="poczatek" type="{http://www.w3.org/2001/XMLSchema}token"/&amp;gt;
 *         &amp;lt;element name="koniec" type="{http://www.w3.org/2001/XMLSchema}token"/&amp;gt;
 *         &amp;lt;element name="tabela" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/&amp;gt;
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
    "poczatek",
    "koniec",
    "tabela"
})
@XmlRootElement(name = "pobierzPrzedzial")
public class PobierzPrzedzial {

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String poczatek;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String koniec;
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String tabela;

    /**
     * Gets the value of the poczatek property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPoczatek() {
        return poczatek;
    }

    /**
     * Sets the value of the poczatek property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPoczatek(String value) {
        this.poczatek = value;
    }

    /**
     * Gets the value of the koniec property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKoniec() {
        return koniec;
    }

    /**
     * Sets the value of the koniec property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKoniec(String value) {
        this.koniec = value;
    }

    /**
     * Gets the value of the tabela property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTabela() {
        return tabela;
    }

    /**
     * Sets the value of the tabela property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTabela(String value) {
        this.tabela = value;
    }

}
