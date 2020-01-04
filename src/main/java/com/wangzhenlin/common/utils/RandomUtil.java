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
	
	public static void main(String[] args) {
		for(int i=0;i<100;i++) {
			System.out.println(random(1,2));
		}
	}
	
}
