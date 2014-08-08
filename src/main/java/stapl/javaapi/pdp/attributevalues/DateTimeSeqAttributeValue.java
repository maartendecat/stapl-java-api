package stapl.javaapi.pdp.attributevalues;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.joda.time.LocalDateTime;

import stapl.core.Attribute;
import stapl.core.BoolSeqImpl;
import stapl.core.ConcreteValue;
import scala.collection.Seq;
import scala.collection.immutable.$colon$colon$;
import scala.collection.immutable.Nil$;

public class DateTimeSeqAttributeValue extends AttributeValue {
	
	private List<LocalDateTime> values = new LinkedList<LocalDateTime>();
	
	public DateTimeSeqAttributeValue(Attribute attribute, LocalDateTime... values) {
		this(attribute, Arrays.asList(values));
	}
	
	public DateTimeSeqAttributeValue(Attribute attribute, List<LocalDateTime> values) {
		super(attribute);
		this.values = values;
	}

	@Override
	public ConcreteValue getConcreteValue() {
		scala.collection.immutable.List list = Nil$.MODULE$; // the empty list
		for(LocalDateTime dt: values) {
			list = $colon$colon$.MODULE$.apply(dt, list); // 1::nil			
		}
		return new BoolSeqImpl((Seq<Object>) list.reverse());
	}	

}
