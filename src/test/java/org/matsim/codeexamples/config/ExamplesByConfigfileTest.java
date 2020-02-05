/* *********************************************************************** *
 * project: org.matsim.*												   *
 *                                                                         *
 * *********************************************************************** *
 *                                                                         *
 * copyright       : (C) 2008 by the members listed in the COPYING,        *
 *                   LICENSE and WARRANTY file.                            *
 * email           : info at matsim dot org                                *
 *                                                                         *
 * *********************************************************************** *
 *                                                                         *
 *   This program is free software; you can redistribute it and/or modify  *
 *   it under the terms of the GNU General Public License as published by  *
 *   the Free Software Foundation; either version 2 of the License, or     *
 *   (at your option) any later version.                                   *
 *   See also COPYING, LICENSE and WARRANTY file                           *
 *                                                                         *
 * *********************************************************************** */
package org.matsim.codeexamples.config;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.matsim.core.config.Config;
import org.matsim.core.controler.OutputDirectoryHierarchy;
import org.matsim.core.utils.io.IOUtils;
import org.matsim.core.utils.io.UncheckedIOException;
import org.matsim.testcases.MatsimTestUtils;

/**
 * @author nagel
 *
 */
@RunWith(Parameterized.class)
public class ExamplesByConfigfileTest {
	@Rule public MatsimTestUtils utils = new MatsimTestUtils() ;
	
	private String configFile;

	public ExamplesByConfigfileTest(String configFile ) {
		this.configFile = configFile ;
	}
	
	@Parameters(name = "{index}: configFilename == {0};")
	public static Collection<Object[]> createTests() {
		Collection<Object[]> filesToRun = new ArrayList<>();

		filesToRun.add(new Object [] {"scenarios/equil/config.xml"});
		filesToRun.add(new Object [] {"scenarios/equil/config-with-mobsim.xml"});
		filesToRun.add(new Object [] {"scenarios/equil/example2-config.xml"});
		filesToRun.add(new Object [] {"scenarios/equil/example5-config.xml"});
 		filesToRun.add(new Object [] {"scenarios/equil/config-with-controlerListener.xml"});
		filesToRun.add(new Object [] {"scenarios/equil/config-with-pluggablePlanStrategy.xml"});

		filesToRun.add(new Object [] {"scenarios/equil-extended/config.xml"});
		filesToRun.add(new Object [] {"scenarios/equil-extended/config-with-lanes.xml"});
		filesToRun.add(new Object [] {"scenarios/equil-extended/config-with-network-change-events.xml"});

		filesToRun.add(new Object [] {"scenarios/equil-extended/config-with-subpopulation.xml"});
		filesToRun.add(new Object [] {"scenarios/equil-extended/config-with-trips.xml"});

		filesToRun.add(new Object [] {"scenarios/equil-mixedTraffic/config-with-mode-vehicles.xml"});
		filesToRun.add(new Object [] {"scenarios/equil-mixedTraffic/config-with-all-vehicles-from-file.xml"});

		filesToRun.add(new Object [] {"examples/tutorial/config/externalReplanning.xml"});

		return filesToRun;
		
		// the convention, I think, is that the output of the method marked by "@Parameters" is taken as input to the constructor
		// before running each test. kai, jul'16
	}


	/**
	 * Test method for {@link RunFromConfigfileExample#main(java.lang.String[])}.
	 */
	@SuppressWarnings("static-method")
	@Test
	public final void testMain() {
		RunFromConfigfileExample matsim = new RunFromConfigfileExample( new String [] { configFile } ) ;

		Config config = matsim.prepareConfig() ;
		config.controler().setOutputDirectory( utils.getOutputDirectory() );
		config.controler().setOverwriteFileSetting( OutputDirectoryHierarchy.OverwriteFileSetting.deleteDirectoryIfExists );

		matsim.run() ;
	}

}
