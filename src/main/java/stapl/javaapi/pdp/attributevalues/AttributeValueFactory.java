package stapl.javaapi.pdp.attributevalues;

import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;

import stapl.core.Attribute;

/**
 * Class bundling some static helper methods for constructing attribute values when
 * calling the PDP.  
 * 
 * @author Maarten Decat
 *
 */
public class AttributeValueFactory {
	
	public static AttributeValue simple(Attribute attribute, String value) {
		return new StringAttributeValue(attribute, value);
	}
	
	public static AttributeValue simple(Attribute attribute, Double value) {
		return new NumberAttributeValue(attribute, value);
	}
	
	public static AttributeValue simple(Attribute attribute, LocalDate value) {
		return new DayAttributeValue(attribute, value);
	}
	
	public static AttributeValue simple(Attribute attribute, LocalDateTime value) {
		return new DateTimeAttributeValue(attribute, value);
	}
	
	public static AttributeValue simple(Attribute attribute, Boolean value) {
		return new BooleanAttributeValue(attribute, value);
	}
	
	public static AttributeValue list(Attribute attribute, String... values) {
		return new StringSeqAttributeValue(attribute, values);
	}
	
	public static AttributeValue list(Attribute attribute, Double... values) {
		return new NumberSeqAttributeValue(attribute, values);
	}
	
	public static AttributeValue list(Attribute attribute, LocalDate... values) {
		return new DaySeqAttributeValue(attribute, values);
	}
	
	public static AttributeValue list(Attribute attribute, LocalDateTime... values) {
		return new DateTimeSeqAttributeValue(attribute, values);
	}
	
	public static AttributeValue list(Attribute attribute, Boolean... values) {
		return new BooleanSeqAttributeValue(attribute, values);
	}

}
