package stapl.javaapi.pdp.attributevalues;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.joda.time.LocalDate;

import stapl.core.Attribute;
import stapl.core.BoolSeqImpl;
import stapl.core.ConcreteValue;
import scala.collection.Seq;
import scala.collection.immutable.$colon$colon$;
import scala.collection.immutable.Nil$;

public class DaySeqAttributeValue extends AttributeValue {
	
	private List<LocalDate> values = new LinkedList<LocalDate>();
	
	public DaySeqAttributeValue(Attribute attribute, LocalDate... values) {
		this(attribute, Arrays.asList(values));
	}
	
	public DaySeqAttributeValue(Attribute attribute, List<LocalDate> values) {
		super(attribute);
		this.values = values;
	}

	@Override
	public ConcreteValue getConcreteValue() {
		scala.collection.immutable.List list = Nil$.MODULE$; // the empty list
		for(LocalDate d: values) {
			list = $colon$colon$.MODULE$.apply(d, list); // 1::nil			
		}
		return new BoolSeqImpl((Seq<Object>) list.reverse());
	}	

}
