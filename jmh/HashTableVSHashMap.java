package com.test.test2;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Warmup;

@Measurement(iterations=2)
@Warmup(iterations=2)
@Fork(value=2)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class HashTableVSHashMap {
 

  	    @Benchmark
	    public void useHashmap()
	    {
	    	Map map = new HashMap<String,String>();
			useMap(map);
	    }
	    
	    @Benchmark
	    public void useHashtable()
	    {
	    	Map map = new Hashtable<String,String>();
			useMap(map);
	    }

		private void useMap(Map map) {
			int base = 100;
			int insertions = 1* base;
			int search = 4* base;
			int range = 2* base;
			insert(map,insertions,range);
			search(map,range,search);
		}
		
		public static int found = 0;
		
		private void search(Map map, int range, int search) {
			for (int i =0;i<search;i++)
			{
				String key = String.valueOf((int)Math.random()*range);
				
				if(map.containsKey(key)) 
				{
					found++;
				} else 
				{
					found--;
				}
			}
		}

		@SuppressWarnings("unchecked")
		private void insert(Map map, int insertions, int range) {
			for (int i=0;i<insertions;i++) 
			{
				String key = String.valueOf((int)Math.random()*range);
				String value = String.valueOf((int)Math.random()*range*1000);
				map.put(key, value);
			}
		}
	    
	}
