package cn.com.agree.huanan.ap.tl.util;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 * @author luo.hp
 *
 */
public class JsonUtilTest {    
    /**
     * Json转Map
     */

//	@Test
    public void JsonString2Map()   {
		String jsonString = "{\"glossary\": {\"title\": \"example glossary\",\"GlossDiv\": {\"title\": \"S\",\"GlossList\": {\"GlossEntry\": {\"ID\": \"SGML\",\"SortAs\": \"SGML\",\"GlossTerm\": \"Standard Generalized Markup Language\",\"Acronym\": \"SGML\",\"Abbrev\": \"ISO 8879:1986\",\"GlossDef\": {\"para\": \"A meta-markup language, used to create markup languages such as DocBook.\",\"GlossSeeAlso\": [\"GML\",\"XML\"]},\"GlossSee\": \"markup\"}}}}}";
		Map<String, Object> jsonMap = new HashMap<String, Object>()
		{{
			put("glossary", new HashMap<String, Object>()
			{{
				put("title", "example glossary");
				put("GlossDiv", "example glossary");
				put("GlossList", new HashMap<String, Object>()
					{{
						put("GlossEntry", new HashMap<String, Object>(){{
							put("ID", "SGML");
							put("SortAs", "SGML");
							put("GlossTerm", "Standard Generalized Markup Language");
							put("Acronym", "SGML");
							put("Abbrev", "ISO 8879:1986");
							put("GlossDef", new HashMap<String, Object>(){{
								put("para", "A meta-markup language, used to create markup languages such as DocBook.");
								put("GlossSeeAlso", new ArrayList<Object>(){{
									add("GML");
									add("XML");
								}});
							}});
							put("GlossSee", "markup");
						}});
					}});
				put("title", "example glossary");
			}});
		}};
		assertThat(JsonUtil.getUtil().jsonStringToMap(jsonString), equalTo(jsonMap));
    }

}
