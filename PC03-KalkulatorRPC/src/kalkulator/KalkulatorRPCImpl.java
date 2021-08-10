package kalkulator;


import javax.jws.WebService;
import javax.xml.ws.Holder;

@WebService(serviceName = "KalkulatorRPC",
	endpointInterface = "kalkulator.KalkulatorRPC",
	targetNamespace = "http://www.example.org/KalkulatorRPC/")
public class KalkulatorRPCImpl implements KalkulatorRPC {
	public int sub(int arg1, int arg2) {
		return arg1-arg2;
	}

	public int add(int arg1, int arg2) {
		return arg1+arg2;
	}

	public int mul(int arg1, int arg2) {
		return arg1*arg2;
	}

	public int inc(int incRequest) {
		return incRequest+1;
	}

	public void div(int arg1, int arg2, Holder<Integer> quotient, Holder<Integer> rest) {
		quotient.value = arg1 / arg2;
		rest.value = arg1 % arg2;		
	}

	public float avg(ListaIntow args) {
		// return args.getArg().stream().mapToInt(x->x).average().getAsDouble();
		
		float suma = 0;
		for(int x : args.getArg()) {
			suma += x;
		}
		return suma / args.getArg().size();
	}
}
