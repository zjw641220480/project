package cn.itcast.zjw.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

/**
 *
 * <p>Title:FetchMap.java</p>
 * <p>Description:各种取出map中数据的方法</p>
 * @author TOM
 * @date 2017年2月23日下午3:38:02
 */
public class MapFetch {
	Map<String, String> map = new HashMap<String, String>();

	@Before
	public void prepareMap() {
		map.put("1", "v1");
		map.put("2", "v2");
		map.put("3", "v3");
		map.put("4", "v4");
	}

	/**
	 * 
	 * @MethodName:forMap
	 * @Description:标准for循环来取出map中的数据,此种方式无法取出数据
	 * @Time:2017年2月23日下午3:46:38
	 * @author:Tom
	 */
	@Test
	public void forMap() {
		Set<String> set = map.keySet();
		for (int i = 0; i < set.size(); i++) {
			//转化为set集合,但是set没有下标,此种方式不可行
		}
	}

	/**
	 * 
	 * @MethodName:foreachMap
	 * @Description:使用foreach来取出map中的数据
	 * @Time:2017年2月23日下午3:49:17
	 * @author:Tom
	 */
	@Test
	public void foreachMap() {
		Set<String> set = map.keySet();
		for (String s : set) {
			//根据键来取值
			System.out.println(map.get(s));
		}
	}

	/**
	 * 
	 * @MethodName:iterateMap
	 * @Description:使用迭代器来循环取出map中的数据
	 * @Time:2017年2月23日下午3:52:08
	 * @author:Tom
	 */
	@Test
	public void iterateMap() {
		Set<String> set = map.keySet();
		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {
			System.out.println(map.get(iterator.next()));
		}
	}

	/**
	 * 
	 * @MethodName:entrySetMap
	 * @Description:Map特有的通过Entry来直接整体获取键值对,不过后面也需要使用Iterator来进行迭代取出每一个键值对
	 * @Time:2017年2月23日下午4:10:07
	 * @author:Tom
	 */
	@Test
	public void entrySetMap() {
		Set<Entry<String, String>> entries = map.entrySet();
		Iterator<Entry<String, String>> iterator = entries.iterator();
		while (iterator.hasNext()) {
			Entry<String, String> entry = iterator.next();
			System.out.println("从Entry中获取的map的  键  为:\t" + entry.getKey() + "\t其值为:\t" + entry.getValue());
		}
	}
}
