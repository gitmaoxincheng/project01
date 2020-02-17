package ap.ide.base;

import java.util.HashSet;
import java.util.Set;
/**
 * @author luo.hp
 *
 */
public class ConstMapAndList {
	
	// Reserved Key for JavaDict Message (__RCVPCK__)
	public final static Set<String> IDE_JAVADICT_PT = new HashSet<String>(){{
		 add("RPC");
	}};
	
	// Reserved Key for JavaDict Message (Nothing to Parse)
    public final static Set<String> IDE_NO_PARSE_PT = new HashSet<String>(){{
         add("SVC");
    }};

}
