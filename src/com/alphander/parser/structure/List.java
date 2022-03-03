package com.alphander.parser.structure;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class List extends Part implements Iterable<Part>
{
	private LinkedHashSet<Part> set = new LinkedHashSet<Part>();
	
	public void add(Part part)
	{
		set.add(part);
	}

	@Override
	public Iterator<Part> iterator()
	{
		return set.iterator();
	}
}
