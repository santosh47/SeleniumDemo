package com.tutorialsninja.automation.framework;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test
{


	@org.testng.annotations.Test
	public void test()
	{


		List<Integer> list= Arrays.asList(1, 5, 2);
		Collections.sort(list);
		System.out.println(list);
		Collections.reverse(list);
		System.out.println(list);


	}

}
