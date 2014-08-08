package stapl.javaapi.pdp.attributevalues;

import stapl.core.Attribute;
import stapl.core.ConcreteValue;
import stapl.core.StringImpl;

public class StringAttributeValue extends AttributeValue {
	
	private String value;
	
	public StringAttributeValue(Attribute attribute, String value) {
		super(attribute);
		this.value = value;
	}

	@Override
	public ConcreteValue getConcreteValue() {
		return new StringImpl(value);
	}	

}
