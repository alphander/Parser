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
	
	public void put(String key, Part value)
	{
		map.put(new Leaf(key), value);
	}
	
	public void put(String key, String value)
	{
		map.put(new Leaf(key), new Leaf(value));
	}
	
	public void put(String key, Double value)
	{
		map.put(new Leaf(key), new Leaf(value));
	}
	
	public void put(String key, Boolean value)
	{
		map.put(new Leaf(key), new Leaf(value));
	}
	
	public Part get(String key)
	{
		return map.get(new Leaf(key));
	}

	@Override
	public Iterator<Entry<Leaf, Part>> iterator()
	{
		return map.entrySet().iterator();
	}
}
