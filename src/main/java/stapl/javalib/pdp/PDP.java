package stapl.javalib.pdp;

import java.util.Arrays;
import java.util.List;

import scala.Tuple2;
import scala.collection.immutable.$colon$colon$;
import scala.collection.immutable.Nil$;
import stapl.core.AbstractPolicy;
import stapl.core.Attribute;
import stapl.core.ConcreteValue;
import stapl.core.Result;
import stapl.core.pdp.AttributeFinder;
import stapl.javalib.pdp.attributevalues.AttributeValue;

/**
 * Java wrapper for the Scala PDP class. The Scala class can be used directly
 * in a Java project, but this class adds some cleaner methods. 
 * 
 * @author Maarten Decat
 *
 */
public class PDP {
	
	private stapl.core.pdp.PDP pdp;
	
	/**
	 * Initialize this new PDP with given policy and attribute finder.
	 * 
	 * @param policy
	 * @param attributeFinder
	 */
	public PDP(AbstractPolicy policy, AttributeFinder attributeFinder) {
		pdp = new stapl.core.pdp.PDP(policy, attributeFinder);
	}
	
	/**
	 * Initialize this new PDP with given policy and empty attribute finder (i.e.,
	 * no attribute finder modules).
	 * 
	 * @param policy
	 */
	public PDP(AbstractPolicy policy) {
		this(policy, new AttributeFinder());
	}
	
	public Result evaluate(String subjectId, String actionId, String resourceId, AttributeValue... attributeValues) {
		return evaluate(subjectId, actionId, resourceId, Arrays.asList(attributeValues));
	}
	
	public Result evaluate(String subjectId, String actionId, String resourceId, List<AttributeValue> attributeValues) {
		scala.collection.immutable.List list = Nil$.MODULE$; // the empty list
		for(AttributeValue av: attributeValues) {
			list = $colon$colon$.MODULE$.apply(new Tuple2<Attribute, ConcreteValue>(av.getAttribute(), av.getConcreteValue()) , list); // 1::nil			
		}
		
		return pdp.evaluate(subjectId, actionId, resourceId, list);
	}

}
