package jws.provider_xslt;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Provider;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceProvider;
import javax.xml.ws.handler.MessageContext;

import org.w3c.dom.Node;

@WebServiceProvider(wsdlLocation="WEB-INF/wsdl/Kalkulator.wsdl",
	targetNamespace="http://kalkulator.vavatech.pl",
	serviceName="Kalkulator", portName="KalkulatorXSLT")
public class RunXSLT implements Provider<Source> {
	@Resource
	private WebServiceContext wsContext;

	public Source invoke(Source request) {
		try {
			ServletContext servletContext = (ServletContext) wsContext.getMessageContext().get(MessageContext.SERVLET_CONTEXT);
			StreamSource xslt = new StreamSource(servletContext.getResourceAsStream("kalkulator.xsl"));

			// inne opcje, bez korzystania z WebServiceContext i ServletContext:
			// StreamSource xslt = new StreamSource("C:/katalog/aplikacja/kalkulator.xsl");
			// StreamSource xslt = new StreamSource("http://localhost:8080/PC10-Provider-1.0/kalkulator.xsl");
			
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer tr = tf.newTransformer(xslt);
			DOMResult result = new DOMResult();
			tr.transform(request, result);
			Node dom = result.getNode();
			DOMSource ultimateResult = new DOMSource(dom);
			return ultimateResult;
		} catch (Exception e) {
			throw new WebServiceException("XSLTProvider error",e);
		}
	}
}
