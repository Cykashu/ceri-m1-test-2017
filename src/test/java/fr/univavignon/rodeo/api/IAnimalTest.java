package fr.univavignon.rodeo.api;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

public class IAnimalTest<T extends IAnimal> {
	protected static final String DEFAULT_NAME = "IAnimal";
	protected static final int DEFAULT_XP = 0;
	protected static final boolean DEFAULT_ISSECRET = false;
	protected static final boolean DEFAULT_ISENDANGERED = false;
	protected static final boolean DEFAULT_ISBOSS = false;
	
	protected String EXPECTED_NAME = DEFAULT_NAME;
	protected int EXPECTED_XP = DEFAULT_XP;
	protected boolean EXPECTED_ISSECRET = DEFAULT_ISSECRET;
	protected boolean EXPECTED_ISENDANGERED = DEFAULT_ISENDANGERED;
	protected boolean EXPECTED_ISBOSS = DEFAULT_ISBOSS;
	protected IAnimal animal;
	public static IAnimal createNew(Integer i, Boolean s, Boolean e, Boolean b) {
		Integer ii = ((i == null) ? DEFAULT_XP : i);
		Boolean ss = ((s == null) ? DEFAULT_ISSECRET : s);
		Boolean ee = ((e == null) ? DEFAULT_ISENDANGERED : e);
		Boolean bb = ((b == null) ? DEFAULT_ISBOSS : b);
		IAnimal animal = mock(IAnimal.class);
		when(animal.getXP()).thenReturn(ii);
		when(animal.isSecret()).thenReturn(ss);
		when(animal.isEndangered()).thenReturn(ee);
		when(animal.isBoss()).thenReturn(bb);
		return animal;
	}
	@Before
	public void doTestInit() {
		animal = createNew(null, null, null, null);
	}
	@Test
	public void doTestIAnimalGetXP() {
		assertEquals(EXPECTED_XP, animal.getXP());
	}
	@Test
	public void doTestIAnimalIsSecret() {
		assertEquals(EXPECTED_ISSECRET, animal.isSecret());
	}
	@Test
	public void doTestIAnimalIsEndangered() {
		assertEquals(EXPECTED_ISENDANGERED, animal.isEndangered());
	}
	@Test
	public void doTestIAnimalIsBoss() {
		assertEquals(EXPECTED_ISBOSS, animal.isBoss());
	}
	
}
