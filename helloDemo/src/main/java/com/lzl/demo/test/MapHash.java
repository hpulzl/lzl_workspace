package com.lzl.demo.test;

public class MapHash {

	public static int getRandomIndex(int size,String key){
        Long index=0l;
		if(size>1){
			index=hash (size,key);
		}
		return index.intValue();
	}
	private static long hash(int size,String key)
	{
	    long hash = -2078137563;
	    int FNV_64_PRIME = 435;
	    byte[] keybyte = key.getBytes();
	    for (byte val : keybyte) {
	      hash ^= val;
	      hash *= FNV_64_PRIME;
	    }
	    hash=(hash & 0xFFFFFFFFL) % 420000L;

	    return hash=Math.abs(  hash%size);
	}

	public static void main(String[] args) {
		int s = MapHash.getRandomIndex(16,"43554352235342");
		System.out.println("s = " + s);
	}
}
