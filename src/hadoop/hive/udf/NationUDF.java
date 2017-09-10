package hadoop.hive.udf;

import java.util.HashMap;
import java.util.Map;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;

public class NationUDF extends UDF {
	public static Map<String, String> nationMap = new HashMap<String, String>();
	static {
		nationMap.put("China", "中国");
		nationMap.put("Japan", "日本");
		nationMap.put("America", "美国");
	}
	Text t = new Text();
	// 10000 sum(income)
	// 中国  getNation(nation)
	public Text evaluate(Text nation) {
		String nation_e = nation.toString();
		String name = nationMap.get(nation_e);
		if (name == null) {
			name = "火星人";
		}
		t.set(name);
		return t;
	}
}
