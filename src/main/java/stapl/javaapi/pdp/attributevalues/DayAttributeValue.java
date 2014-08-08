package stapl.javalib.pdp.attributevalues;

import org.joda.time.LocalDate;
import stapl.core.Attribute;
import stapl.core.ConcreteValue;
import stapl.core.DayImpl;

public class DayAttributeValue extends AttributeValue {
	
	private LocalDate value;
	
	public DayAttributeValue(Attribute attribute, LocalDate value) {
		super(attribute);
		this.value = value;
	}

	@Override
	public ConcreteValue getConcreteValue() {
		return new DayImpl(value);
	}	

}
