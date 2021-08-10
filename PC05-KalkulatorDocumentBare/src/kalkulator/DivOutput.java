
package kalkulator;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &amp;lt;element name="quotient" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="rest" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
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
    "quotient",
    "rest"
})
@XmlRootElement(name = "divOutput")
public class DivOutput {

    protected int quotient;
    protected int rest;

    /**
     * Gets the value of the quotient property.
     * 
     */
    public int getQuotient() {
        return quotient;
    }

    /**
     * Sets the value of the quotient property.
     * 
     */
    public void setQuotient(int value) {
        this.quotient = value;
    }

    /**
     * Gets the value of the rest property.
     * 
     */
    public int getRest() {
        return rest;
    }

    /**
     * Sets the value of the rest property.
     * 
     */
    public void setRest(int value) {
        this.rest = value;
    }

}
