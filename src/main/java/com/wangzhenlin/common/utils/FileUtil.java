package com.wangzhenlin.common.utils;

/**
 * 文件工具类
 * @author Administrator
 *
 */
public class FileUtil {

	public String getExtName(String str){
		if (StringUtil.isNull(str)) {
			return null;
		}
		return str.substring(str.indexOf("."));
	}
	
}
