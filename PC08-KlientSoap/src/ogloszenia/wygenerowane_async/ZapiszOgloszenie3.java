
package ogloszenia.wygenerowane_async;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for zapiszOgloszenie3 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="zapiszOgloszenie3">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ogloszenie" type="{http://soap.ogloszenia/}samochodowe" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "zapiszOgloszenie3", propOrder = {
    "ogloszenie"
})
public class ZapiszOgloszenie3 {

    protected Samochodowe ogloszenie;

    /**
     * Gets the value of the ogloszenie property.
     * 
     * @return
     *     possible object is
     *     {@link Samochodowe }
     *     
     */
    public Samochodowe getOgloszenie() {
        return ogloszenie;
    }

    /**
     * Sets the value of the ogloszenie property.
     * 
     * @param value
     *     allowed object is
     *     {@link Samochodowe }
     *     
     */
    public void setOgloszenie(Samochodowe value) {
        this.ogloszenie = value;
    }

}
