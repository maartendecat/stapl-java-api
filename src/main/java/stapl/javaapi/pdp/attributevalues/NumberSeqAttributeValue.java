package stapl.javaapi.pdp.attributevalues;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import stapl.core.Attribute;
import stapl.core.ConcreteValue;
import stapl.core.DoubleSeqImpl;
import stapl.core.StringSeqImpl;
import scala.collection.JavaConversions;
import scala.collection.immutable.*;

public class NumberSeqAttributeValue extends AttributeValue {
	
	private List<Double> values = new LinkedList<Double>();
	
	public NumberSeqAttributeValue(Attribute attribute, Double... values) {
		this(attribute, Arrays.asList(values));
	}
	
	public NumberSeqAttributeValue(Attribute attribute, List<Double> values) {
		super(attribute);
		this.values = values;
	}

	@Override
	public ConcreteValue getConcreteValue() {
		scala.collection.immutable.List list = Nil$.MODULE$; // the empty list
		for(Double d: values) {
			list = $colon$colon$.MODULE$.apply(d, list); // 1::nil			
		}
		return new DoubleSeqImpl((Seq<Object>) list.reverse());
	}	

}
