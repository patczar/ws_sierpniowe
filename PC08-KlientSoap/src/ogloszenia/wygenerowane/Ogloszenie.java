
package ogloszenia.wygenerowane;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ogloszenie complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ogloszenie">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wystawione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cena" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="lokalizacja" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tytul" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="opis" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sprzedawca" type="{http://soap.ogloszenia/}sprzedawca" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="id-sprzedawcy" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ogloszenie", propOrder = {
    "wystawione",
    "cena",
    "lokalizacja",
    "tytul",
    "opis",
    "sprzedawca"
})
@XmlSeeAlso({
    Samochodowe.class
})
public class Ogloszenie {

    protected String wystawione;
    protected BigDecimal cena;
    protected String lokalizacja;
    protected String tytul;
    protected String opis;
    protected Sprzedawca sprzedawca;
    @XmlAttribute(name = "id")
    protected Integer id;
    @XmlAttribute(name = "id-sprzedawcy")
    protected Integer idSprzedawcy;

    /**
     * Gets the value of the wystawione property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWystawione() {
        return wystawione;
    }

    /**
     * Sets the value of the wystawione property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWystawione(String value) {
        this.wystawione = value;
    }

    /**
     * Gets the value of the cena property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCena() {
        return cena;
    }

    /**
     * Sets the value of the cena property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCena(BigDecimal value) {
        this.cena = value;
    }

    /**
     * Gets the value of the lokalizacja property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLokalizacja() {
        return lokalizacja;
    }

    /**
     * Sets the value of the lokalizacja property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLokalizacja(String value) {
        this.lokalizacja = value;
    }

    /**
     * Gets the value of the tytul property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTytul() {
        return tytul;
    }

    /**
     * Sets the value of the tytul property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTytul(String value) {
        this.tytul = value;
    }

    /**
     * Gets the value of the opis property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOpis() {
        return opis;
    }

    /**
     * Sets the value of the opis property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpis(String value) {
        this.opis = value;
    }

    /**
     * Gets the value of the sprzedawca property.
     * 
     * @return
     *     possible object is
     *     {@link Sprzedawca }
     *     
     */
    public Sprzedawca getSprzedawca() {
        return sprzedawca;
    }

    /**
     * Sets the value of the sprzedawca property.
     * 
     * @param value
     *     allowed object is
     *     {@link Sprzedawca }
     *     
     */
    public void setSprzedawca(Sprzedawca value) {
        this.sprzedawca = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setId(Integer value) {
        this.id = value;
    }

    /**
     * Gets the value of the idSprzedawcy property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdSprzedawcy() {
        return idSprzedawcy;
    }

    /**
     * Sets the value of the idSprzedawcy property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdSprzedawcy(Integer value) {
        this.idSprzedawcy = value;
    }

}
