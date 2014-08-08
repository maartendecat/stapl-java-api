package stapl.javaapi.pdp.attributevalues;

import scala.util.Left;
import stapl.core.Attribute;
import stapl.core.BoolImpl;
import stapl.core.ConcreteValue;
import stapl.core.NumberImpl;

public class NumberAttributeValue extends AttributeValue {
	
	private Double value;
	
	public NumberAttributeValue(Attribute attribute, Double value) {
		super(attribute);
		this.value = value;
	}

	@Override
	public ConcreteValue getConcreteValue() {
		return new NumberImpl(new Left<Object, Object>(value));
	}	

}
