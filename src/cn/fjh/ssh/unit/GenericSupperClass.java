package cn.fjh.ssh.unit;

import java.lang.reflect.ParameterizedType;

/**
 * ��ȡ��ǰ��ķ�������
 * 
 * @author fang jie hui
 * 
 */
public class GenericSupperClass {
	@SuppressWarnings("rawtypes")
	public static Class getClass(Class tClass) {
		// �õ�����ķ�������
		ParameterizedType pt = (ParameterizedType) tClass
				.getGenericSuperclass();
		// ���ص�һ����������
		return (Class) pt.getActualTypeArguments()[0];
	}
}
