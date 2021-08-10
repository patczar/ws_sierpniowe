
package ogloszenia.wygenerowane;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for samochodowe complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="samochodowe">
 *   &lt;complexContent>
 *     &lt;extension base="{http://soap.ogloszenia/}ogloszenie">
 *       &lt;sequence>
 *         &lt;element name="marka" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="model" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="generacja" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="kolor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rocznik" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="przebieg" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pojemnosc" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="moc" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="paliwo" type="{http://soap.ogloszenia/}paliwo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "samochodowe", propOrder = {
    "marka",
    "model",
    "generacja",
    "kolor",
    "rocznik",
    "przebieg",
    "pojemnosc",
    "moc",
    "paliwo"
})
public class Samochodowe
    extends Ogloszenie
{

    protected String marka;
    protected String model;
    protected String generacja;
    protected String kolor;
    protected int rocznik;
    protected int przebieg;
    protected float pojemnosc;
    protected float moc;
    @XmlSchemaType(name = "string")
    protected Paliwo paliwo;

    /**
     * Gets the value of the marka property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMarka() {
        return marka;
    }

    /**
     * Sets the value of the marka property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMarka(String value) {
        this.marka = value;
    }

    /**
     * Gets the value of the model property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets the value of the model property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModel(String value) {
        this.model = value;
    }

    /**
     * Gets the value of the generacja property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGeneracja() {
        return generacja;
    }

    /**
     * Sets the value of the generacja property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGeneracja(String value) {
        this.generacja = value;
    }

    /**
     * Gets the value of the kolor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKolor() {
        return kolor;
    }

    /**
     * Sets the value of the kolor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKolor(String value) {
        this.kolor = value;
    }

    /**
     * Gets the value of the rocznik property.
     * 
     */
    public int getRocznik() {
        return rocznik;
    }

    /**
     * Sets the value of the rocznik property.
     * 
     */
    public void setRocznik(int value) {
        this.rocznik = value;
    }

    /**
     * Gets the value of the przebieg property.
     * 
     */
    public int getPrzebieg() {
        return przebieg;
    }

    /**
     * Sets the value of the przebieg property.
     * 
     */
    public void setPrzebieg(int value) {
        this.przebieg = value;
    }

    /**
     * Gets the value of the pojemnosc property.
     * 
     */
    public float getPojemnosc() {
        return pojemnosc;
    }

    /**
     * Sets the value of the pojemnosc property.
     * 
     */
    public void setPojemnosc(float value) {
        this.pojemnosc = value;
    }

    /**
     * Gets the value of the moc property.
     * 
     */
    public float getMoc() {
        return moc;
    }

    /**
     * Sets the value of the moc property.
     * 
     */
    public void setMoc(float value) {
        this.moc = value;
    }

    /**
     * Gets the value of the paliwo property.
     * 
     * @return
     *     possible object is
     *     {@link Paliwo }
     *     
     */
    public Paliwo getPaliwo() {
        return paliwo;
    }

    /**
     * Sets the value of the paliwo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Paliwo }
     *     
     */
    public void setPaliwo(Paliwo value) {
        this.paliwo = value;
    }

}
