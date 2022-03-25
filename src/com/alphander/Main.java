package com.alphander;

import com.alphander.parser.Parser;
import com.alphander.parser.structure.Leaf;
import com.alphander.parser.structure.Part;

public class Main
{
	public static void main(String[] args)
	{
		String str = "{\"test\" : [\"tat\", 0124.125, false], \"brbd\" : []}";
		Parser p = new Parser();
		Part root = p.load(str);

		Leaf leaf = (Leaf) root.get("test", 1);

		double doub = leaf.getNumber();

		String out = p.save(root);
		System.out.print(doub);
	}
}
