package stapl.javalib.pdp.attributevalues;

import stapl.core.Attribute;
import stapl.core.ConcreteValue;

/**
 * Java class for representing the value of a certain attribute as given to the PDP.
 * 
 * @author Maarten Decat
 *
 */
public abstract class AttributeValue {
	
	private Attribute attribute;
	
	public Attribute getAttribute() {
		return this.attribute;
	}
	
	public AttributeValue(Attribute attribute) {
		this.attribute = attribute;
	}
	
	public abstract ConcreteValue getConcreteValue();
}
