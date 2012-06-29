package ceylon.language;

import java.util.Arrays;

import com.redhat.ceylon.compiler.java.metadata.Annotation;
import com.redhat.ceylon.compiler.java.metadata.Annotations;
import com.redhat.ceylon.compiler.java.metadata.Ceylon;
import com.redhat.ceylon.compiler.java.metadata.Ignore;

@Ignore
@Ceylon(major = 1)
class ArrayOfSome<Element> extends Array<Element> implements Some<Element> {

    public ArrayOfSome(char... array) {
        super(array);
    }
    
    public ArrayOfSome(byte... array) {
        super(array);
    }
    
    public ArrayOfSome(short... array) {
        super(array);
    }
    
    public ArrayOfSome(int... array) {
        super(array);
    }
    
    public ArrayOfSome(long... array) {
        super(array);
    }
    
    public ArrayOfSome(float... array) {
        super(array);
    }
    
    public ArrayOfSome(double... array) {
        super(array);
    }
    
    public ArrayOfSome(boolean... array) {
        super(array);
    }

    public ArrayOfSome(java.lang.String... array) {
        super(array);
    }

    public ArrayOfSome(Element... array) {
        super(array);
    }
    
    @Override
    public FixedSized<? extends Element> getRest() {
        if (getSize() == 1) {
            return $arrayOfNone.<Element>arrayOfNone();
        } else {
            if (array instanceof char[]) {
                return new ArrayOfSome<Element>(Arrays.copyOfRange((char[])array, 1, (int)getSize()));
            } else if (array instanceof byte[]) {
                return new ArrayOfSome<Element>(Arrays.copyOfRange((byte[])array, 1, (int)getSize()));
            } else if (array instanceof short[]) {
                return new ArrayOfSome<Element>(Arrays.copyOfRange((short[])array, 1, (int)getSize()));
            } else if (array instanceof int[]) {
                return new ArrayOfSome<Element>(Arrays.copyOfRange((int[])array, 1, (int)getSize()));
            } else if (array instanceof long[]) {
                return new ArrayOfSome<Element>(Arrays.copyOfRange((long[])array, 1, (int)getSize()));
            } else if (array instanceof float[]) {
                return new ArrayOfSome<Element>(Arrays.copyOfRange((float[])array, 1, (int)getSize()));
            } else if (array instanceof double[]) {
                return new ArrayOfSome<Element>(Arrays.copyOfRange((double[])array, 1, (int)getSize()));
            } else if (array instanceof boolean[]) {
                return new ArrayOfSome<Element>(Arrays.copyOfRange((boolean[])array, 1, (int)getSize()));
            } else if (array instanceof java.lang.String[]) {
                return new ArrayOfSome<Element>(Arrays.copyOfRange((java.lang.String[])array, 1, (int)getSize()));
            } else {
                return new ArrayOfSome<Element>(Arrays.copyOfRange((Element[])array, 1, (int)getSize()));
            }
        }
    }

    @Override
    public boolean getEmpty() {
        return false;
    }
    
    @Override
    @Annotations({ @Annotation("actual") })
    public Array<? extends Element> getReversed() {
    	// TODO!!!!!!!!!!
    	return null;
    }

    /*@Override
    public FixedSized<? extends Element> getRest() {
        return span(Integer.instance(1), null);
    }*/
    
    @Override
    public Element getFirst() {
        return unsafeItem(0); //FixedSized$impl._getFirst(this);
    }
    
    @Override 
    @Ignore 
    public Iterable<? extends Element> getSequence() { 
        return Iterable$impl._getSequence(this); 
    }
}