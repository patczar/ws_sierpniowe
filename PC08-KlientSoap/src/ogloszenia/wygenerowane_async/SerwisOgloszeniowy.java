
package ogloszenia.wygenerowane_async;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.Future;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.Response;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "SerwisOgloszeniowy", targetNamespace = "http://soap.ogloszenia/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface SerwisOgloszeniowy {


    /**
     * 
     * @param ogloszenie
     * @throws BladBazyDanych_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "zapiszOgloszenie", targetNamespace = "http://soap.ogloszenia/", className = "ogloszenia.wygenerowane_async.ZapiszOgloszenie")
    @ResponseWrapper(localName = "zapiszOgloszenieResponse", targetNamespace = "http://soap.ogloszenia/", className = "ogloszenia.wygenerowane_async.ZapiszOgloszenieResponse")
    public void zapiszOgloszenie(
        @WebParam(name = "ogloszenie", targetNamespace = "")
        Samochodowe ogloszenie)
        throws BladBazyDanych_Exception
    ;

    /**
     * 
     * @param id
     * @return
     *     returns javax.xml.ws.Response<ogloszenia.wygenerowane_async.OdczytajJednoOgloszenieResponse>
     */
    @WebMethod(operationName = "odczytajJednoOgloszenie", action = "http://ogloszenia.com/jedno")
    @RequestWrapper(localName = "odczytajJednoOgloszenie", targetNamespace = "http://soap.ogloszenia/", className = "ogloszenia.wygenerowane_async.OdczytajJednoOgloszenie")
    @ResponseWrapper(localName = "odczytajJednoOgloszenieResponse", targetNamespace = "http://soap.ogloszenia/", className = "ogloszenia.wygenerowane_async.OdczytajJednoOgloszenieResponse")
    public Response<OdczytajJednoOgloszenieResponse> odczytajJednoOgloszenieAsync(
        @WebParam(name = "id", targetNamespace = "")
        int id);

    /**
     * 
     * @param id
     * @param asyncHandler
     * @return
     *     returns java.util.concurrent.Future<? extends java.lang.Object>
     */
    @WebMethod(operationName = "odczytajJednoOgloszenie", action = "http://ogloszenia.com/jedno")
    @RequestWrapper(localName = "odczytajJednoOgloszenie", targetNamespace = "http://soap.ogloszenia/", className = "ogloszenia.wygenerowane_async.OdczytajJednoOgloszenie")
    @ResponseWrapper(localName = "odczytajJednoOgloszenieResponse", targetNamespace = "http://soap.ogloszenia/", className = "ogloszenia.wygenerowane_async.OdczytajJednoOgloszenieResponse")
    public Future<?> odczytajJednoOgloszenieAsync(
        @WebParam(name = "id", targetNamespace = "")
        int id,
        @WebParam(name = "asyncHandler", targetNamespace = "")
        AsyncHandler<OdczytajJednoOgloszenieResponse> asyncHandler);

    /**
     * 
     * @param id
     * @return
     *     returns ogloszenia.wygenerowane_async.Samochodowe
     * @throws BladBazyDanych_Exception
     * @throws NieznanyRekord_Exception
     */
    @WebMethod(action = "http://ogloszenia.com/jedno")
    @WebResult(name = "ogloszenie", targetNamespace = "")
    @RequestWrapper(localName = "odczytajJednoOgloszenie", targetNamespace = "http://soap.ogloszenia/", className = "ogloszenia.wygenerowane_async.OdczytajJednoOgloszenie")
    @ResponseWrapper(localName = "odczytajJednoOgloszenieResponse", targetNamespace = "http://soap.ogloszenia/", className = "ogloszenia.wygenerowane_async.OdczytajJednoOgloszenieResponse")
    public Samochodowe odczytajJednoOgloszenie(
        @WebParam(name = "id", targetNamespace = "")
        int id)
        throws BladBazyDanych_Exception, NieznanyRekord_Exception
    ;

    /**
     * 
     * @return
     *     returns java.util.List<ogloszenia.wygenerowane_async.Samochodowe>
     * @throws BladBazyDanych_Exception
     */
    @WebMethod
    @WebResult(name = "ogloszenie", targetNamespace = "")
    @RequestWrapper(localName = "odczytajWszystkieOgloszenia", targetNamespace = "http://soap.ogloszenia/", className = "ogloszenia.wygenerowane_async.OdczytajWszystkieOgloszenia")
    @ResponseWrapper(localName = "odczytajWszystkieOgloszeniaResponse", targetNamespace = "http://soap.ogloszenia/", className = "ogloszenia.wygenerowane_async.OdczytajWszystkieOgloszeniaResponse")
    public List<Samochodowe> odczytajWszystkieOgloszenia()
        throws BladBazyDanych_Exception
    ;

    /**
     * 
     * @param ogloszenie
     * @return
     *     returns ogloszenia.wygenerowane_async.Samochodowe
     * @throws BladBazyDanych_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "zapiszOgloszenie3", targetNamespace = "http://soap.ogloszenia/", className = "ogloszenia.wygenerowane_async.ZapiszOgloszenie3")
    @ResponseWrapper(localName = "zapiszOgloszenie3Response", targetNamespace = "http://soap.ogloszenia/", className = "ogloszenia.wygenerowane_async.ZapiszOgloszenie3Response")
    public Samochodowe zapiszOgloszenie3(
        @WebParam(name = "ogloszenie", targetNamespace = "")
        Samochodowe ogloszenie)
        throws BladBazyDanych_Exception
    ;

    /**
     * 
     * @param ogloszenie
     * @return
     *     returns java.lang.Integer
     * @throws BladBazyDanych_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "zapiszOgloszenie2", targetNamespace = "http://soap.ogloszenia/", className = "ogloszenia.wygenerowane_async.ZapiszOgloszenie2")
    @ResponseWrapper(localName = "zapiszOgloszenie2Response", targetNamespace = "http://soap.ogloszenia/", className = "ogloszenia.wygenerowane_async.ZapiszOgloszenie2Response")
    public Integer zapiszOgloszenie2(
        @WebParam(name = "ogloszenie", targetNamespace = "")
        Samochodowe ogloszenie)
        throws BladBazyDanych_Exception
    ;

    /**
     * 
     * @param min
     * @param max
     * @return
     *     returns java.util.List<ogloszenia.wygenerowane_async.Samochodowe>
     * @throws BladBazyDanych_Exception
     */
    @WebMethod
    @WebResult(name = "ogloszenie", targetNamespace = "")
    @RequestWrapper(localName = "odczytajOgloszeniaWedlugCeny", targetNamespace = "http://soap.ogloszenia/", className = "ogloszenia.wygenerowane_async.OdczytajOgloszeniaWedlugCeny")
    @ResponseWrapper(localName = "odczytajOgloszeniaWedlugCenyResponse", targetNamespace = "http://soap.ogloszenia/", className = "ogloszenia.wygenerowane_async.OdczytajOgloszeniaWedlugCenyResponse")
    public List<Samochodowe> odczytajOgloszeniaWedlugCeny(
        @WebParam(name = "min", targetNamespace = "")
        BigDecimal min,
        @WebParam(name = "max", targetNamespace = "")
        BigDecimal max)
        throws BladBazyDanych_Exception
    ;

    /**
     * 
     * @param id
     * @return
     *     returns javax.xml.ws.Response<ogloszenia.wygenerowane_async.FotoResponse>
     */
    @WebMethod(operationName = "foto")
    @RequestWrapper(localName = "foto", targetNamespace = "http://soap.ogloszenia/", className = "ogloszenia.wygenerowane_async.Foto")
    @ResponseWrapper(localName = "fotoResponse", targetNamespace = "http://soap.ogloszenia/", className = "ogloszenia.wygenerowane_async.FotoResponse")
    public Response<FotoResponse> fotoAsync(
        @WebParam(name = "id", targetNamespace = "")
        int id);

    /**
     * 
     * @param id
     * @param asyncHandler
     * @return
     *     returns java.util.concurrent.Future<? extends java.lang.Object>
     */
    @WebMethod(operationName = "foto")
    @RequestWrapper(localName = "foto", targetNamespace = "http://soap.ogloszenia/", className = "ogloszenia.wygenerowane_async.Foto")
    @ResponseWrapper(localName = "fotoResponse", targetNamespace = "http://soap.ogloszenia/", className = "ogloszenia.wygenerowane_async.FotoResponse")
    public Future<?> fotoAsync(
        @WebParam(name = "id", targetNamespace = "")
        int id,
        @WebParam(name = "asyncHandler", targetNamespace = "")
        AsyncHandler<FotoResponse> asyncHandler);

    /**
     * 
     * @param id
     * @return
     *     returns byte[]
     * @throws NieznanyRekord_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "foto", targetNamespace = "http://soap.ogloszenia/", className = "ogloszenia.wygenerowane_async.Foto")
    @ResponseWrapper(localName = "fotoResponse", targetNamespace = "http://soap.ogloszenia/", className = "ogloszenia.wygenerowane_async.FotoResponse")
    public byte[] foto(
        @WebParam(name = "id", targetNamespace = "")
        int id)
        throws NieznanyRekord_Exception
    ;

}