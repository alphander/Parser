package com.alphander.parser.structure;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class Dict extends Part implements Iterable<Entry<String, Part>>
{
	private LinkedHashMap<String, Part> map = new LinkedHashMap<String, Part>();

	@Override
	public Part get(Object... objects) 
	{
		if(objects.length == 0) return this;

		if(!(objects[0] instanceof String)) throw new IllegalArgumentException();
		String key = (String) objects[0];

		if(!map.containsKey(key)) throw new IllegalArgumentException();
		Part part = get(key);

		return part.get(Arrays.copyOfRange(objects, 1, objects.length));
	}
	
	public void put(String key, Part value)
	{
		map.put(key, value);
	}
	
	public void put(String key, String value)
	{
		Leaf leaf = new Leaf();
		leaf.setString(value);
		map.put(key, leaf);
	}
	
	public void put(String key, double value)
	{
		map.put(key, new Leaf(value));
	}
	
	public void put(String key, boolean value)
	{
		map.put(key, new Leaf(value));
	}
	
	public Part get(String key)
	{
		return map.get(key);
	}
	
	public int size()
	{
		return map.size();
	}

	@Override
	public Iterator<Entry<String, Part>> iterator()
	{
		return map.entrySet().iterator();
	}
}
