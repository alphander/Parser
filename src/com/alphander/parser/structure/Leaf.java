package com.alphander.parser.structure;

public class Leaf extends Part
{	
	private static final char string = '"';
	private static final char space = ' ';
	
	private String value = "";
	private Type type = Type.None;
	
	public Leaf(String value)
	{
		setString(value);
	}
	
	public Leaf(Double value)
	{
		setDouble(value);
	}
	
	public Leaf(Boolean value)
	{
		setBoolean(value);
	}
	
	public Leaf()
	{
		
	}
	
	public void setString(String value)
	{
		this.value = value;
		this.type = Type.String;
	}
	
	public void setDouble(Double value)
	{
		this.value = "" + value;
		this.type = Type.Number;
	}
	
	public void setBoolean(Boolean value)
	{
		this.value = "" + value;
		this.type = Type.Boolean;
	}
	
	public void set(String str)
	{
		this.value = str;
	}
	
	public String get()
	{
		return value;
	}
	
	public String getString()
	{
		if(this.type != Type.String) return null;
		
		return string + value + string;
	}
	
	public Double getNumber()
	{
		if(this.type != Type.Number) return null;
		
		return Double.parseDouble(value);
	}
	
	public Boolean getBoolean()
	{
		if(this.type != Type.Boolean) return null;
		
		return Boolean.parseBoolean(value);
	}
	
	public Type getType()
	{
		return this.type;
	}
	
	private String stringIt()
	{
		if(this.type != Type.None) return null;
		
		String str = value;
		char[] chars = str.toCharArray();
		
		if(chars.length < 2) return null;
		
		int start = 0, end = 0;
		for(int i = 0; i < chars.length; i++)
			if(chars[i] != space)
			{
				if(chars[i] == string)
				{
					start = i + 1;
					break;
				}
				return null;
			}
		
		for(int i = chars.length - 1; i >= 0; i--)
			if(chars[i] != space)
			{
				if(chars[i] == string)
				{
					end = i - 1;
					break;
				}
				return null;
			}
		
		str = "";
		for(int i = start; i <= end; i++)
			str += chars[i];
		
		this.type = Type.String;
		this.value = str;
		return str;
	}
	
	private Double numIt()
	{
		if(this.type != Type.None) return null;
		
		String str = value;
		char[] chars = str.toCharArray();
		
		if(chars.length < 1) return null;
		
		try
		{
			Double d =  Double.parseDouble(str);
			this.type = Type.Number;
			value = str;
			return d;
		}
		catch(NullPointerException | NumberFormatException e)
		{
			return null;
		}
	}
	
	private Boolean boolIt()
	{
		if(this.type != Type.None) return null;
		
		String str = value;
		char[] chars = str.toCharArray();
		
		if(chars.length < 1) return null;
		
		int start = 0, end = 0;
		for(int i = 0; i < chars.length; i++)
			if(chars[i] != space)
			{
				start = i;
				break;
			}
		
		for(int i = chars.length - 1; i >= 0; i--)
			if(chars[i] != space)
			{
				end = i;
				break;
			}
		
		str = "";
		for(int i = start; i <= end; i++)
			str += chars[i];
		
		if("true".equals(str) || "false".equals(str))
		{
			this.type = Type.Boolean;
			value = str;
			return Boolean.parseBoolean(str);
		}
		return null;
	}
	
	private boolean isNone()
	{
		if(value.length() == 0) 
			return true;
		return false;
	}
	
	public static Leaf leaf(String str)
	{
		Leaf leaf = new Leaf();
		leaf.set(str);
		if(leaf.stringIt() == null && leaf.numIt() == null && leaf.boolIt() == null && !leaf.isNone())
			return null;
		return leaf;	
	}
}
