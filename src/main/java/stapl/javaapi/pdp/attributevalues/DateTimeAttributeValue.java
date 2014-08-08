package stapl.javaapi.pdp.attributevalues;

import org.joda.time.LocalDateTime;

import stapl.core.Attribute;
import stapl.core.BoolImpl;
import stapl.core.ConcreteValue;
import stapl.core.DateTimeImpl;
import stapl.core.NumberImpl;

public class DateTimeAttributeValue extends AttributeValue {
	
	private LocalDateTime value;
	
	public DateTimeAttributeValue(Attribute attribute, LocalDateTime value) {
		super(attribute);
		this.value = value;
	}

	@Override
	public ConcreteValue getConcreteValue() {
		return new DateTimeImpl(value);
	}	

}
