package com.sdrc;

import java.util.ArrayList;
import java.util.List;

public class TestMain {
	
	public static void main(String args[])
	{
		List<String> l1=new ArrayList<String>();
        l1.add("aaa");
        l1.add("bbb");
        List<String> l2=new ArrayList<String>();
        l2.add("aaa");
        l2.add("ddd");
        System.out.println("l1.retainAll(l2)= "+l1.retainAll(l2));
        System.out.println("l1= "+l1);
        System.out.println("l2= "+l2);
	}

}
