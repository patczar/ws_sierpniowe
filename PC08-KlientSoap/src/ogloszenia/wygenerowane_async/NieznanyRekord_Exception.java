
package ogloszenia.wygenerowane_async;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "NieznanyRekord", targetNamespace = "http://soap.ogloszenia/")
public class NieznanyRekord_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private NieznanyRekord faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public NieznanyRekord_Exception(String message, NieznanyRekord faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public NieznanyRekord_Exception(String message, NieznanyRekord faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: ogloszenia.wygenerowane_async.NieznanyRekord
     */
    public NieznanyRekord getFaultInfo() {
        return faultInfo;
    }

}
