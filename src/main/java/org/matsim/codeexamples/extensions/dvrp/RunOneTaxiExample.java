/**
 * 
 */
package org.matsim.codeexamples.extensions.dvrp;

/**
 * Maybe somewhat in contrast to intuition, this example is not the simplest one, since it already plugs 3 things together:<ul>
 * <li> the optimizer (which optimizes the dispatch)
 * <li> the request creator (which creates the request that is ultimately received by the optimizer)
 * <li> the action creator (which decides what the taxi actually should do based on what the optimizer decides).
 * </ul>
 * An even simpler starting point, only replacing the optimizer, is contained in {@link RunTaxiExample}.
  * <br/>
 * This is a pointer to example code in the contrib.
* 
 * @author kainagel
 */
public class RunOneTaxiExample {

	public static void main(String[] args) {
		org.matsim.contrib.dvrp.examples.onetaxi.RunOneTaxiExample.main() ;
	}

}
