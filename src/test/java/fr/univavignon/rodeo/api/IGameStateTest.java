package fr.univavignon.rodeo.api;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

public class IGameStateTest {
	protected IGameState gamestate;
	public static IGameState createNew() {
		IGameState gamestate = Mockito.mock(IGameState.class);
		doThrow(IllegalArgumentException.class).when(gamestate).catchAnimal(null);
		when(gamestate.getSpeciesLevel(null)).thenThrow(IllegalArgumentException.class);
		when(gamestate.getProgression()).thenReturn(0);
		return gamestate;
	}
	@Before
	public void doTestInit() {
		this.gamestate = createNew();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void doTestCatchAnimal() {
		gamestate.catchAnimal(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void doTestGetSpecieLevelForNULL() {
		gamestate.getSpeciesLevel(null);
	}
	
	@Test
	public void doTestGetProgression() {
		int progression = this.gamestate.getProgression();
		assertTrue(((progression >= 0) && (progression <= 100)));
	}
}
