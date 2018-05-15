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
		List<String> ll = ((l == null) ? DEFAULT_ENVIRONMENTLIST : l);
		Map<String, IEnvironment> mm = ((m == null) ? DEFAULT_ENVIRONMENTS : m);
		IEnvironmentProvider environmentprovider = Mockito.mock(IEnvironmentProvider.class);
		when(environmentprovider.getAvailableEnvironments()).thenReturn(ll);
		for (Map.Entry<String, IEnvironment> entry : mm.entrySet()) {
			when(environmentprovider.getEnvironment(entry.getKey())).thenReturn(entry.getValue());
		}
		
		return environmentprovider;
	}
	@Before
	public void doTest_Init() {
		environmentprovider = createNew(null, null);
	}
}
