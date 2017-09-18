package cn.fjh.ssh.unit;

import java.lang.reflect.ParameterizedType;

/**
 * 获取当前类的泛型类型
 * 
 * @author fang jie hui
 * 
 */
public class GenericSupperClass {
	@SuppressWarnings("rawtypes")
	public static Class getClass(Class tClass) {
		// 拿到该类的泛型类型
		ParameterizedType pt = (ParameterizedType) tClass
				.getGenericSuperclass();
		// 返回第一个泛型类型
		return (Class) pt.getActualTypeArguments()[0];
	}
}
