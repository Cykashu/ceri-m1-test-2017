package fr.univavignon.rodeo.api;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

public class ISpeciesTest<T extends ISpecies> {
	protected static final int DEFAULT_AREA = 0;
	protected static final List<IAnimal> DEFAULT_ANIMALS = new ArrayList<>();
	
	protected int EXPECTED_AREA = DEFAULT_AREA;
	protected List<IAnimal> EXPECTED_ANIMALS = DEFAULT_ANIMALS;
	protected ISpecies species;
	public static ISpecies createNew(Integer i, List<IAnimal> l) {
		Integer ii = ((i == null) ? DEFAULT_AREA : i);
		List<IAnimal> ll = ((l == null) ? DEFAULT_ANIMALS : l);
		ISpecies species = Mockito.mock(ISpecies.class);
		when(species.getArea()).thenReturn(ii);
		when(species.getAnimals()).thenReturn(ll);
		return species;
	}
	@Before
	public void doTestInit() {
		species = Mockito.mock(ISpecies.class);
	}
	
	@Test
	public void doTestISpeciesGetAreas() {
		assertEquals(EXPECTED_AREA, species.getArea());
	}
	@Test
	public void doTestISpeciesGetSpecies() {
		assertEquals(EXPECTED_ANIMALS, species.getAnimals());
	}
}
