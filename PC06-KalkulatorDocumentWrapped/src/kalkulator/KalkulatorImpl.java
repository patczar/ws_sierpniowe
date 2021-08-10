package kalkulator;


import javax.jws.WebService;
import javax.xml.ws.Holder;

@WebService(serviceName = "Kalkulator",
	portName = "KalkulatorSOAP",
	wsdlLocation = "/WEB-INF/wsdl/KalkulatorWrapped.wsdl",
	endpointInterface = "kalkulator.Kalkulator",
	targetNamespace = "http://www.example.org/Kalkulator/")
public class KalkulatorImpl implements Kalkulator {
	public int inc(int incRequest) {
		return incRequest+1;
	}
	
	public int add(int arg1, int arg2) {
		return arg1+arg2;
	}
	
	public int sub(int arg1, int arg2) {
		return arg1-arg2;
	}

	public int mul(int arg1, int arg2) {
		return arg1*arg2;
	}

	public void div(int arg1, int arg2, Holder<Integer> quotient, Holder<Integer> rest) {
		quotient.value = arg1 / arg2;
		rest.value = arg1 % arg2;		
	}

	public float avg(java.util.List<java.lang.Integer> args) {
		float suma = 0;
		for(int x : args) {
			suma += x;
		}
		return suma / args.size();
	}

}