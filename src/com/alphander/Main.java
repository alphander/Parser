package com.alphander;

import com.alphander.parser.Parcer;
import com.alphander.parser.structure.Part;

public class Main
{
	public static void main(String[] args)
	{
		String str = "{\"test\" : true}";
		Parcer p = new Parcer();
		Part root = p.load(str);
		String out = p.save(root);
		System.out.print(out);
		System.out.print(out);
	}
}
