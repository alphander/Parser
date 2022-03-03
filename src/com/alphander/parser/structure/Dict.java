package com.alphander.parser.structure;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class Dict extends Part implements Iterable<Entry<Leaf, Part>>
{
	private LinkedHashMap<Leaf, Part> map = new LinkedHashMap<Leaf, Part>();
	
	public void put(Leaf key, Part value)
	{
		map.put(key, value);
	}

	@Override
	public Iterator<Entry<Leaf, Part>> iterator()
	{
		return map.entrySet().iterator();
	}
}
