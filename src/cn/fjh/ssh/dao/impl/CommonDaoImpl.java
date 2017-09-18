package cn.fjh.ssh.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.fjh.ssh.dao.CommonDao;
import cn.fjh.ssh.unit.GenericSupperClass;

/**
 * DAO层的公共接口实现类
 * 
 * @author fang jie hui
 * 
 * @param <T>
 */
public class CommonDaoImpl<T> extends HibernateDaoSupport implements
		CommonDao<T> {
	// 获取当前类的泛型类型
	@SuppressWarnings("rawtypes")
	private Class clazz = (Class) GenericSupperClass.getClass(this.getClass());

	// 给HibernateTemplate注入sessionFactory
	@Resource(name = "sessionFactory")
	public final void setSessionFactoryDI(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	public void save(T t) {
		this.getHibernateTemplate().save(t);
	}

	public void update(T t) {
		this.getHibernateTemplate().update(t);
	}

	@SuppressWarnings("unchecked")
	public T findObjectByID(Serializable id) {
		return (T) this.getHibernateTemplate().get(clazz, id);
	}

	public void deleteObjectByIDs(Serializable[] ids) {
		for (int i = 0; ids != null && i < ids.length; i++) {
			Serializable id = ids[i];
			Object object = (Object) this.getHibernateTemplate().get(clazz, id);
			this.getHibernateTemplate().delete(object);
		}
	}

	public void deleteObjectByCollection(Collection<T> list) {
		this.getHibernateTemplate().deleteAll(list);
	}

	public List<T> findCollectionByCondition(String hqlwhere,
			final Object[] params, LinkedHashMap<String, String> orderby) {
		String hql = "from " + clazz.getSimpleName() + " o  where 1=1";
		// 组织排序语句
		String hqlOrderBy = this.orderByCondition(orderby);
		hql = hql + hqlwhere + hqlOrderBy;
		final String finalHql = hql;
		@SuppressWarnings("unchecked")
		List<T> list = (List<T>) this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(finalHql);
						setParams(query, params);
						return query.list();
					}
				});
		return list;
	}

	// 对where条件中的参数设置参数值
	private void setParams(Query query, Object[] params) {
		for (int i = 0; params != null && i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
	}

	// 组织排序语句
	private String orderByCondition(LinkedHashMap<String, String> orderby) {
		StringBuffer buffer = new StringBuffer();
		if (orderby != null) {
			buffer.append(" order by ");
			for (Map.Entry<String, String> map : orderby.entrySet()) {
				buffer.append(" " + map.getKey() + " " + map.getValue() + " ,");
			}
			buffer.deleteCharAt(buffer.length() - 1);
		}
		return buffer.toString();
	}
}
