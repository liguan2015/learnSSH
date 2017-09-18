package cn.fjh.ssh.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * DAO层的公共接口
 * 
 * @author fang jie hui
 * 
 * @param <T>
 */
public interface CommonDao<T> {
	// 保存对象
	public void save(T t);

	// 更新对象
	public void update(T t);

	// 根据id返回一个对象
	public T findObjectByID(Serializable id);

	// 根据id删除一个或多个对象
	public void deleteObjectByIDs(Serializable[] ids);

	// 根据集合删除一个或多个对象
	public void deleteObjectByCollection(Collection<T> list);

	// 根据条件返回一个或对各对象
	public List<T> findCollectionByCondition(String hqlwhere, Object[] params,
			LinkedHashMap<String, String> orderby);
}
