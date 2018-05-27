package fr.univavignon.rodeo.api;

import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

public class IGameStateProviderTest {
	private IGameStateProvider gamestateprovider;
	public static IGameStateProvider createNew() {
		IGameStateProvider gamestateprovider = Mockito.mock(IGameStateProvider.class);
		IGameState n = IGameStateTest.createNew();
		when(gamestateprovider.get(any())).thenReturn(n);
		when(gamestateprovider.get(null)).thenThrow(IllegalArgumentException.class);
		return gamestateprovider;
	}
	@Before
	public void doTestInit() {
		this.gamestateprovider = createNew();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void doTestGetWithNULLExpectIllegalArgumentException() {
		this.gamestateprovider.get(null);
	}
	
	@Test
	public void doTestGetWithNotNULL() {
		assertNotNull(this.gamestateprovider.get("Name"));
	}
}
