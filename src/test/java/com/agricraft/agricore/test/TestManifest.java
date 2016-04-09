/*
 */
package com.agricraft.agricore.test;

import com.agricraft.agricore.core.AgriCore;
import com.agricraft.agricore.json.AgriLoader;
import com.agricraft.agricore.json.AgriManifest;
import com.agricraft.agricore.json.AgriManifestEntry;
import com.agricraft.agricore.json.AgriManifestEntryType;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author RlonRyan
 */
public class TestManifest {

	public TestManifest() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	// TODO add test methods here.
	// The methods must be annotated with annotation @Test. For example:
	//
	// @Test
	// public void hello() {}
	@Test
	public void testLoad() {
		
		AgriCore.init();
		
		AgriManifest manifest = AgriManifest.getEmptyManifest();
		
		manifest.elements.add(new AgriManifestEntry(AgriManifestEntryType.GROUP, "vanilla/vanilla_group.json", false));
		manifest.elements.add(new AgriManifestEntry(AgriManifestEntryType.PLANT, "vanilla/wheat_plant.json", false));
		manifest.elements.add(new AgriManifestEntry(AgriManifestEntryType.MUTATION, "vanilla/wheat_mutation.json", false));
		
		AgriManifest.save(Paths.get("config", "agricraft", "example.json"), manifest);

		Path p = Paths.get("config", "agricraft", "manifest.json");
		
		assertNotNull(p);

		AgriLoader.loadManifest(p, AgriCore.getPlants(), AgriCore.getMutations());

		AgriCore.getLogger().info(AgriCore.getPlants());

	}

}
