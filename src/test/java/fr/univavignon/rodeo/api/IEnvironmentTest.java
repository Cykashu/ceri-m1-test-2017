package fr.univavignon.rodeo.api;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

public class IEnvironmentTest<T extends IEnvironment> {
	protected static final int DEFAULT_AREAS = 0;
	protected static final List<ISpecies> DEFAULT_SPECIES = new ArrayList<>();
	
	protected int EXPECTED_AREAS;
	protected List<ISpecies> EXPECTED_SPECIES;
	protected IEnvironment environment;
	public static IEnvironment createNew(Integer i, List<ISpecies> l) {
		if (i == null) {i = DEFAULT_AREAS;}
		if (l == null) {l = DEFAULT_SPECIES;}
		IEnvironment environment = Mockito.mock(IEnvironment.class);
		when(environment.getAreas()).thenReturn(i);
		when(environment.getSpecies()).thenReturn(l);
		return environment;
	}
	@Before
	public void doTest_Init() {
		environment = createNew(null, null);
	}
	
	@Test
	public void doTestIEnvironmentGetAreas() {
		assertEquals(EXPECTED_AREAS, environment.getAreas());
	}
	@Test
	public void doTestIEnvironmentGetSpecies() {
		assertEquals(EXPECTED_SPECIES, environment.getSpecies());
	}
}
