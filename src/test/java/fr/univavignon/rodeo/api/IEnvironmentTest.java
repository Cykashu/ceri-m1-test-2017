package fr.univavignon.rodeo.api;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.thenReturn;

public class IEnvironmentTest<T extends IEnvironment> {
	protected static final int DEFAULT_AREAS = 0;
	protected static final List<ISpecies> DEFAULT_SPECIES = new ArrayList<>();
	
	protected int EXPECTED_AREAS;
	protected List<ISpecies> EXPECTED_SPECIES;
	protected IEnvironment environment;
	public static IEnvironment createNew(Integer i, List<ISpecies> l) {
		Integer ii = ((i == null) ? DEFAULT_AREAS : i);
		List<ISpecies> ll = ((l == null) ? DEFAULT_SPECIES : l);
		IEnvironment environment = Mockito.mock(IEnvironment.class);
		when(environment.getAreas()).thenReturn(ii);
		when(environment.getSpecies()).thenReturn(ll);
		return environment;
	}
	@Before
	public void doTestInit() {
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
