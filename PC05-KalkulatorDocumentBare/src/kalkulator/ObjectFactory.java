
package kalkulator;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the kalkulator package. 
 * &lt;p&gt;An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: kalkulator
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link IncInput }
     * 
     */
    public IncInput createIncInput() {
        return new IncInput();
    }

    /**
     * Create an instance of {@link IncOutput }
     * 
     */
    public IncOutput createIncOutput() {
        return new IncOutput();
    }

    /**
     * Create an instance of {@link AddInput }
     * 
     */
    public AddInput createAddInput() {
        return new AddInput();
    }

    /**
     * Create an instance of {@link AddOutput }
     * 
     */
    public AddOutput createAddOutput() {
        return new AddOutput();
    }

    /**
     * Create an instance of {@link SubInput }
     * 
     */
    public SubInput createSubInput() {
        return new SubInput();
    }

    /**
     * Create an instance of {@link SubOutput }
     * 
     */
    public SubOutput createSubOutput() {
        return new SubOutput();
    }

    /**
     * Create an instance of {@link MulInput }
     * 
     */
    public MulInput createMulInput() {
        return new MulInput();
    }

    /**
     * Create an instance of {@link MulOutput }
     * 
     */
    public MulOutput createMulOutput() {
        return new MulOutput();
    }

    /**
     * Create an instance of {@link DivInput }
     * 
     */
    public DivInput createDivInput() {
        return new DivInput();
    }

    /**
     * Create an instance of {@link DivOutput }
     * 
     */
    public DivOutput createDivOutput() {
        return new DivOutput();
    }

    /**
     * Create an instance of {@link AvgInput }
     * 
     */
    public AvgInput createAvgInput() {
        return new AvgInput();
    }

    /**
     * Create an instance of {@link AvgOutput }
     * 
     */
    public AvgOutput createAvgOutput() {
        return new AvgOutput();
    }

}
