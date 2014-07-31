package stapl.javalib.pdp.attributevalues;

import stapl.core.Attribute;
import stapl.core.BoolImpl;
import stapl.core.ConcreteValue;

public class BooleanAttributeValue extends AttributeValue {
	
	private Boolean value;
	
	public BooleanAttributeValue(Attribute attribute, Boolean value) {
		super(attribute);
		this.value = value;
	}

	@Override
	public ConcreteValue getConcreteValue() {
		return new BoolImpl(value);
	}	

}
