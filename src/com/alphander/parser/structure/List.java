package com.alphander.parser.structure;

import java.util.ArrayList;
import java.util.Iterator;

public class List extends Part implements Iterable<Part>
{
	private ArrayList<Part> set = new ArrayList<Part>();
	
	public void add(Part part)
	{
		set.add(part);
	}
	
	public void add(String value)
	{
		set.add(new Leaf(value));
	}
	
	public void add(Double value)
	{
		set.add(new Leaf(value));
	}
	
	public void add(Boolean value)
	{
		set.add(new Leaf(value));
	}
	
	public Part get(int index)
	{
		return set.get(index);
	}

	@Override
	public Iterator<Part> iterator()
	{
		return set.iterator();
	}
}
