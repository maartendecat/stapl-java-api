package stapl.javaapi.pdp.attributevalues;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import stapl.core.Attribute;
import stapl.core.BoolSeqImpl;
import stapl.core.ConcreteValue;
import scala.collection.Seq;
import scala.collection.immutable.$colon$colon$;
import scala.collection.immutable.Nil$;

public class BooleanSeqAttributeValue extends AttributeValue {
	
	private List<Boolean> values = new LinkedList<Boolean>();
	
	public BooleanSeqAttributeValue(Attribute attribute, Boolean... values) {
		this(attribute, Arrays.asList(values));
	}
	
	public BooleanSeqAttributeValue(Attribute attribute, List<Boolean> values) {
		super(attribute);
		this.values = values;
	}

	@Override
	public ConcreteValue getConcreteValue() {
		scala.collection.immutable.List list = Nil$.MODULE$; // the empty list
		for(Boolean b: values) {
			list = $colon$colon$.MODULE$.apply(b, list); // 1::nil			
		}
		return new BoolSeqImpl((Seq<Object>) list.reverse());
	}	

}
