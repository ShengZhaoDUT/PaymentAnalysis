package com.degree.analysis.mapred.sina.utils;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


public class HadoopIOUtils 
{
	
	public static void stringArrayWrite(ArrayList<String> list,DataOutput out) throws IOException
	{
		if(list==null)
		{
			out.writeInt(0);
			return;
		}
		out.writeInt(list.size());
		for(String elem : list)
		{
			out.writeUTF(elem);
		}
	}
	
	public static ArrayList<String> stringArrayRead(DataInput in) throws IOException
	{
		int size_t = in.readInt();
		if(size_t==0) return null;
		ArrayList<String> ret = new ArrayList<>(size_t);
		for(int i=0;i<size_t;i++)
		{
			ret.add(in.readUTF());
		}
		return ret;
	}
	
	public static void intArrayWrite(ArrayList<Integer> list,DataOutput out) throws IOException
	{
		if(list==null)
		{
			out.writeInt(0);
			return;
		}
		out.writeInt(list.size());
		for(int i:list)
		{
			out.writeInt(i);
		}
	}
	
	public static ArrayList<Integer> intArrayRead(DataInput in) throws IOException
	{
		int size_t = in.readInt();
		if(size_t==0) return null;
		ArrayList<Integer> ret = new ArrayList<>(size_t);
		for(int i=0;i<size_t;i++)
		{
			ret.add(in.readInt());
		}
		if(ret.size()==0) return null;
		return ret;
		
	}
	
	
	public static void doubleArrayWrite(ArrayList<Double> list,DataOutput out) throws IOException
	{
		if(list==null)
		{
			out.writeInt(0);
			return;
		}
		out.writeInt(list.size());
		for(double i:list)
		{
			out.writeDouble(i);
		}
	}
	
	public static ArrayList<Double> doubleArrayRead(DataInput in) throws IOException
	{
		int size_t = in.readInt();
		if(size_t==0) return null;

		ArrayList<Double> ret = new ArrayList<>(size_t);
		for(double i=0;i<size_t;i++)
		{
			ret.add(in.readDouble());
		}
		return ret;
		
	}
	
	
	public static void intDoubleMapFloat(Map<Integer, Float> map,DataOutput out) throws IOException
	{
		if(map==null)
		{
			out.writeInt(0);
			return;
		}
		else
		{
			out.writeInt(map.size());
			for(Integer keys : map.keySet())
			{
				out.writeInt(keys);
				out.writeFloat(map.get(keys));
			}
		}
	}
	
	
	public static HashMap<Integer,Float> intFloatMapRead(DataInput in) throws IOException
	{
		int size = in.readInt();
		if(size==0) return null;
		HashMap<Integer, Float> map =new HashMap<>(size);
		for(int i=0;i<size;i++)
		{
			int key = in.readInt();
			float value = in.readFloat();
			map.put(key, value);
		}
		return map;
	}
	
	public static void shortByteMapWrite(TreeMap<Short, Byte> map, DataOutput out) throws IOException
	{
		if(map==null)
		{
			out.writeInt(0);
			return;
		}
		
		int size = map.size();
		out.writeInt(size);
		for(short key : map.keySet())
		{
			out.writeShort(key);
			out.writeLong(map.get(key));
		}
	}
	
	
	public static TreeMap<Short, Byte> shortByteMapRead(DataInput in) throws IOException
	{
		
		int size = in.readInt();
		if(size==0) return null;
		TreeMap<Short, Byte> ret = new TreeMap<>();
		
		for(int i=0;i<size;i++)
		{
			short key = in.readShort();
			byte val = in.readByte();
			ret.put(key, val);
		}
		
		return ret;
	}
	
	
	
	public static void byteMapWrite(HashMap<Byte, Byte> map, DataOutput out) throws IOException
	{
		
		if(map==null)
		{
			out.writeInt(0);
			return;
		}
		int size = map.size();
		out.writeInt(size);
		for(byte key : map.keySet())
		{
			out.writeByte(key);
			out.writeByte(map.get(key));
		}
	}
	
	
	public static HashMap<Byte, Byte> byteMapRead(DataInput in) throws IOException
	{
		
		int size = in.readInt(); 
		if(size==0) return null;
		
		HashMap<Byte, Byte> ret= new HashMap<>(size);
		
		for(int i=0;i<size;i++)
		{
			byte key = in.readByte();
			byte value = in.readByte();
			ret.put(key, value);
		}
		return ret;
	}
	
	public static void stringIntegerMapWrite(HashMap<String, Integer> map, DataOutput out) throws IOException
	{
		if(map==null)
		{
			out.writeInt(0);
		}
		int size = map.size();
		out.writeLong(size);
		for(String key : map.keySet())
		{
			out.writeUTF(key);
			out.writeInt(map.get(key));
		}
		
	}
	
	
	public static HashMap<String, Integer> stringIntegerMapRead(DataInput in) throws IOException
	{
		int size = in.readInt();
		if(size==0) return null;
		HashMap<String, Integer> ret = new HashMap<>(size);
		for(int i=0;i<size;i++)
		{
			String key = in.readUTF();
			int value= in.readInt();
			ret.put(key, value);
		}
		return ret;
	}
	
	public static HashMap<String, Float> stringFloatMapRead(DataInput in) throws IOException
	{
		int size = in.readInt();
		if(size==0) return null;
		HashMap<String, Float> ret = new HashMap<>(size);
		for(int i =0; i<size;i++)
		{
			String key = in.readUTF();
			Float value = in.readFloat();
			ret.put(key, value);
		}
		return ret;
	}
	
	
	public static void stringFloatMapWrite(HashMap<String, Float> map,DataOutput out) throws IOException
	{
		if(map==null)
		{
			out.writeInt(0);
			return;
		}
		for(String str : map.keySet())
		{
			out.writeUTF(str);
			out.writeFloat(map.get(str));
		}
		
	}
	
	public static void longIntegerMapWrite(HashMap<Long, Integer> map,DataOutput out) throws IOException
	{
		if(map==null)
		{
			out.writeInt(0);
			return;
		}
		out.writeLong(map.size());
		for(long key : map.keySet())
		{
			out.writeLong(key);
			out.writeInt(map.get(key));
		}
		
	}
	
	public static HashMap<Long, Integer> longIntegerMapRead(DataInput in) throws IOException
	{
		int size = in.readInt();
		if(size==0) return null;
		
		HashMap<Long, Integer> ret = new HashMap<>();
		for(int i=0;i<size;i++)
		{
			long key = in.readLong();
			int value = in.readInt();
			ret.put(key,value);
		}
		
		return ret;
	}
	
	
	
	
}
