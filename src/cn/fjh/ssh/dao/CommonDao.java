package cn.fjh.ssh.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * DAO��Ĺ����ӿ�
 * 
 * @author fang jie hui
 * 
 * @param <T>
 */
public interface CommonDao<T> {
	// �������
	public void save(T t);

	// ���¶���
	public void update(T t);

	// ����id����һ������
	public T findObjectByID(Serializable id);

	// ����idɾ��һ����������
	public void deleteObjectByIDs(Serializable[] ids);

	// ���ݼ���ɾ��һ����������
	public void deleteObjectByCollection(Collection<T> list);

	// ������������һ����Ը�����
	public List<T> findCollectionByCondition(String hqlwhere, Object[] params,
			LinkedHashMap<String, String> orderby);
}
