package fr.univavignon.rodeo.api;

import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

public class IGameStateProviderTest {
	private IGameStateProvider gamestateprovider;
	public static IGameStateProvider createNew() {
		IGameStateProvider gamestateprovider = Mockito.mock(IGameStateProvider.class);
		when(gamestateprovider.get(null)).thenThrow(IllegalArgumentException.class);
		when(gamestateprovider.get(any())).thenReturn(IGameStateTest.createNew());
		return gamestateprovider;
	}
	@Before
	public void doTest_Init() {
		this.gamestateprovider = createNew();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void doTest_GetNULL() {
		this.gamestateprovider.get(null);
	}
	
	@Test
	public void doTest_GetNotNULL() {
		assertNotNull(this.gamestateprovider.get("Name"));
	}
}
