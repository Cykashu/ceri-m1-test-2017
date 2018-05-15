package fr.univavignon.rodeo.api;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

public class IEnvironmentProviderTest {
	protected static final List<String> DEFAULT_ENVIRONMENTLIST = new ArrayList();
	protected static final Map<String, IEnvironment> DEFAULT_ENVIRONMENTS = new HashMap<>();
	
	protected List<String> EXPECTED_ENVIRONMENTLIST = DEFAULT_ENVIRONMENTLIST;
	protected Map<String, IEnvironment> EXPECTED_ENVIRONMENTS = DEFAULT_ENVIRONMENTS;
	protected IEnvironmentProvider environmentprovider;
	public static IEnvironmentProvider createNew(List<String> l, Map<String, IEnvironment> m) {
		if (l == null) {l = DEFAULT_ENVIRONMENTLIST;}
		if (m == null) {m = DEFAULT_ENVIRONMENTS;}
		IEnvironmentProvider environmentprovider = Mockito.mock(IEnvironmentProvider.class);
		when(environmentprovider.getAvailableEnvironments()).thenReturn(l);
		for (Map.Entry<String, IEnvironment> entry : m.entrySet()) {
			when(environmentprovider.getEnvironment(entry.getKey())).thenReturn(entry.getValue());
		}
		
		return environmentprovider;
	}
	@Before
	public void doTest_Init() {
		environmentprovider = createNew(null, null);
	}
}
