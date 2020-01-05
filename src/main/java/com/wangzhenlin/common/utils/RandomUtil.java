package com.wangzhenlin.common.utils;

import java.util.Random;

/**
 * 随机工具类
 * @author Administrator
 *
 */
public class RandomUtil {

	/**
	 * 获得指定区间的随机数
	 * @param min
	 * @param max
	 * @return
	 */
	public static int random(int min,int max){
		Random random = new Random();
		int nextInt = random.nextInt(max-min+1);
		if(nextInt<min) {
			return random(min,max);
		}
		return nextInt;
	}
	
	/**
	 * @Title: random   
	 * @Description: 获得最小数和最大数之间的多个随机数
	 * @param: @param min
	 * @param: @param max
	 * @param: @param num
	 * @param: @return      
	 * @return: int[]      
	 * @throws
	 */
	public static int[] random(int min,int max,int num) {
		int[] intArray = new int[num];
		for (int i = 0; i < num; i++) {
			intArray[i] = random(min, max);
		}
		return intArray;
	}
	
	public static void main(String[] args) {
		for(int i=0;i<100;i++) {
			System.out.println(random(1,2));
		}
	}
	
}
