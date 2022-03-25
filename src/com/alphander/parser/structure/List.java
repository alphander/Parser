package com.alphander.parser.structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class List extends Part implements Iterable<Part>
{
	private ArrayList<Part> list = new ArrayList<Part>();

	@Override
	public Part get(Object... objects) 
	{
		if(objects.length == 0) return this;

		if(!(objects[0] instanceof Integer)) throw new IllegalArgumentException();
		int index = (Integer) objects[0];

		if(list.size() <= index) throw new IllegalArgumentException();

		Part part = get(index);
		return part.get(Arrays.copyOfRange(objects, 1, objects.length));
	}
	
	public void add(Part part)
	{
		list.add(part);
	}
	
	public void add(String value)
	{
		list.add(new Leaf(value));
	}
	
	public void add(double value)
	{
		list.add(new Leaf(value));
	}
	
	public void add(boolean value)
	{
		list.add(new Leaf(value));
	}
	
	public Part get(int index)
	{
		return list.get(index);
	}
	
	public int size()
	{
		return list.size();
	}

	@Override
	public Iterator<Part> iterator()
	{
		return list.iterator();
	}
}
