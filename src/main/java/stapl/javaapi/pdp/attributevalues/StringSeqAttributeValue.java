package stapl.javaapi.pdp.attributevalues;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import stapl.core.Attribute;
import stapl.core.ConcreteValue;
import stapl.core.StringSeqImpl;
import scala.collection.immutable.$colon$colon$;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.Seq;

public class StringSeqAttributeValue extends AttributeValue {
	
	private List<String> values = new LinkedList<String>();
	
	public StringSeqAttributeValue(Attribute attribute, String... values) {
		this(attribute, Arrays.asList(values));
	}
	
	public StringSeqAttributeValue(Attribute attribute, List<String> values) {
		super(attribute);
		this.values = values;
	}

	@Override
	public ConcreteValue getConcreteValue() {
		scala.collection.immutable.List list = Nil$.MODULE$; // the empty list
		for(String s: values) {
			list = $colon$colon$.MODULE$.apply(s, list); // 1::nil			
		}
		return new StringSeqImpl((Seq<String>) list.reverse());
	}	

}
