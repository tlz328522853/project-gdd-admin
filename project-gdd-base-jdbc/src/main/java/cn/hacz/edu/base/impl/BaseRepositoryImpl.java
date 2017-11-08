package cn.hacz.edu.base.impl;


import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import cn.hacz.edu.base.BaseRepository;
import cn.hacz.edu.hibernate.BaseEntity;
import cn.hacz.edu.hibernate.PageHelper;


@SuppressWarnings("unchecked")
@Repository
public class BaseRepositoryImpl<T extends BaseEntity> implements BaseRepository<T> {
	
	@PersistenceContext
	private EntityManager entityManager;

	public Session getCurrentSession() {
		return entityManager.unwrap(Session.class);
	}

	@Override
	public Serializable save(T o) {
		o.setCreateDateTime(LocalDateTime.now());
		o.setModifyDateTime(LocalDateTime.now());
		o.setDeleted(false);
		return getCurrentSession().save(o);
	}
	

	@Override
	public T get(Class<T> c, Serializable id) {
		return (T) getCurrentSession().get(c, id);
	}

	@Override
	public T get(String hql) {
		Query q = getCurrentSession().createQuery(hql);
		List<T> l = q.list();
		if (l != null && l.size() > 0) {
			return l.get(0);
		}
		return null;
	}

	@Override
	public T get(String hql, Map<String, Object> params) {
		Query q = getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				Object obj = params.get(key);
				// 这里考虑传入的参数是什么类型，不同类型使用的方法不同
				if (obj instanceof Collection<?>) {
					q.setParameterList(key, (Collection<?>) obj);
				} else if (obj instanceof Object[]) {
					q.setParameterList(key, (Object[]) obj);
				} else {
					q.setParameter(key, obj);
				}
			}
		}
		List<T> l = q.list();
		if (l != null && l.size() > 0) {
			return l.get(0);
		}
		return null;
	}

	@Override
	public void delete(T o) {
		if (o != null) {
			getCurrentSession().delete(o);
		}
	}

	@Override
	public void update(T o) {
		o.setModifyDateTime(LocalDateTime.now());
		getCurrentSession().update(o);
	}

	@Override
	public List<T> find(String hql) {
		Query q = getCurrentSession().createQuery(hql);
		return q.list();
	}

	@Override
	public List<T> find(String hql, Map<String, Object> params) {
		Query q = getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				Object obj = params.get(key);
				// 这里考虑传入的参数是什么类型，不同类型使用的方法不同
				if (obj instanceof Collection<?>) {
					q.setParameterList(key, (Collection<?>) obj);
				} else if (obj instanceof Object[]) {
					q.setParameterList(key, (Object[]) obj);
				} else {
					q.setParameter(key, obj);
				}
			}
		}
		return q.list();
	}

	@Override
	public List<T> find(String hql, Map<String, Object> params, PageHelper ph) {
		Query q = getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				Object obj = params.get(key);
				// 这里考虑传入的参数是什么类型，不同类型使用的方法不同
				if (obj instanceof Collection<?>) {
					q.setParameterList(key, (Collection<?>) obj);
				} else if (obj instanceof Object[]) {
					q.setParameterList(key, (Object[]) obj);
				} else {
					q.setParameter(key, obj);
				}
			}
		}
		return q.setFirstResult((ph.getPage() - 1) * ph.getRows()).setMaxResults(ph.getRows()).list();
	}

	@Override
	public List<T> find(String hql, PageHelper ph) {
		Query q = getCurrentSession().createQuery(hql);
		return q.setFirstResult((ph.getPage() - 1) * ph.getRows()).setMaxResults(ph.getRows()).list();
	}

	@Override
	public Long count(String hql) {
		Query q = getCurrentSession().createQuery(hql);
		return (Long) q.uniqueResult();
	}

	@Override
	public Long count(String hql, Map<String, Object> params) {
		Query q = getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				Object obj = params.get(key);
				// 这里考虑传入的参数是什么类型，不同类型使用的方法不同
				if (obj instanceof Collection<?>) {
					q.setParameterList(key, (Collection<?>) obj);
				} else if (obj instanceof Object[]) {
					q.setParameterList(key, (Object[]) obj);
				} else {
					q.setParameter(key, obj);
				}
			}
		}
		return (Long) q.uniqueResult();
	}

	@Override
	public int execute(String hql) {
		Query q = getCurrentSession().createQuery(hql);
		return q.executeUpdate();
	}

	@Override
	public int execute(String hql, Map<String, Object> params) {
		Query q = getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				Object obj = params.get(key);
				// 这里考虑传入的参数是什么类型，不同类型使用的方法不同
				if (obj instanceof Collection<?>) {
					q.setParameterList(key, (Collection<?>) obj);
				} else if (obj instanceof Object[]) {
					q.setParameterList(key, (Object[]) obj);
				} else {
					q.setParameter(key, obj);
				}
			}
		}
		return q.executeUpdate();
	}

	@Override
	public List<?> findBySql(String sql) {
		SQLQuery q = getCurrentSession().createSQLQuery(sql);
		return q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
	}

	@Override
	public List<?> findBySql(String sql, PageHelper ph) {
		SQLQuery q = getCurrentSession().createSQLQuery(sql);
		return  q.setFirstResult((ph.getPage() - 1) * ph.getRows()).setMaxResults(ph.getRows()).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
	}

	@Override
	public List<?> findBySql(String sql, Map<String, Object> params) {
		SQLQuery q = getCurrentSession().createSQLQuery(sql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				Object obj = params.get(key);
				// 这里考虑传入的参数是什么类型，不同类型使用的方法不同
				if (obj instanceof Collection<?>) {
					q.setParameterList(key, (Collection<?>) obj);
				} else if (obj instanceof Object[]) {
					q.setParameterList(key, (Object[]) obj);
				} else {
					q.setParameter(key, obj);
				}
			}
		}
		return q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
	}

	@Override
	public List<?> findBySql(String sql, Map<String, Object> params, PageHelper ph) {
		SQLQuery q = getCurrentSession().createSQLQuery(sql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				Object obj = params.get(key);
				// 这里考虑传入的参数是什么类型，不同类型使用的方法不同
				if (obj instanceof Collection<?>) {
					q.setParameterList(key, (Collection<?>) obj);
				} else if (obj instanceof Object[]) {
					q.setParameterList(key, (Object[]) obj);
				} else {
					q.setParameter(key, obj);
				}
			}
		}
		return  q.setFirstResult((ph.getPage() - 1) * ph.getRows()).setMaxResults(ph.getRows()).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
	}

	@Override
	public int executeSql(String sql) {
		SQLQuery q = getCurrentSession().createSQLQuery(sql);
		return q.executeUpdate();
	}

	@Override
	public int executeSql(String sql, Map<String, Object> params) {
		SQLQuery q = getCurrentSession().createSQLQuery(sql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				Object obj = params.get(key);
				// 这里考虑传入的参数是什么类型，不同类型使用的方法不同
				if (obj instanceof Collection<?>) {
					q.setParameterList(key, (Collection<?>) obj);
				} else if (obj instanceof Object[]) {
					q.setParameterList(key, (Object[]) obj);
				} else {
					q.setParameter(key, obj);
				}
			}
		}
		return q.executeUpdate();
	}

	@Override
	public BigInteger countBySql(String sql) {
		SQLQuery q = getCurrentSession().createSQLQuery(sql);
		return (BigInteger) q.uniqueResult();
	}

	@Override
	public BigInteger countBySql(String sql, Map<String, Object> params) {
		SQLQuery q = getCurrentSession().createSQLQuery(sql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				Object obj = params.get(key);
				// 这里考虑传入的参数是什么类型，不同类型使用的方法不同
				if (obj instanceof Collection<?>) {
					q.setParameterList(key, (Collection<?>) obj);
				} else if (obj instanceof Object[]) {
					q.setParameterList(key, (Object[]) obj);
				} else {
					q.setParameter(key, obj);
				}
			}
		}
		//return q.uniqueResult();
		return new BigInteger(String.valueOf(q.uniqueResult()));
	}

	@Override
	public T get(String hql, Object... params) {
		Query q = getCurrentSession().createQuery(hql);
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				q.setParameter(i, params[i]);
			}
		}
		List<T> l = q.list();
		if (l != null && l.size() > 0) {
			return l.get(0);
		}
		return null;
	}

	@Override
	public List<T> find(String hql, Object... params) {
		Query q = getCurrentSession().createQuery(hql);
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				q.setParameter(i, params[i]);
			}
		}
		return q.list();
	}

	@Override
	public Long count(String hql, Object... params) {
		Query q = getCurrentSession().createQuery(hql);
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				q.setParameter(i, params[i]);
			}
		}
		return (Long) q.uniqueResult();
	}

	@Override
	public int execute(String hql, Object... params) {
		Query q = getCurrentSession().createQuery(hql);
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				q.setParameter(i, params[i]);
			}
		}
		return q.executeUpdate();
	}

	@Override
	public List<?> findBySql(String sql, List<Object> params) {
		SQLQuery q = getCurrentSession().createSQLQuery(sql);
		if (params != null && params.size() > 0) {
			for (int i = 0; i < params.size(); i++) {
				q.setParameter(i, params.get(i));
			}
		}
		return q.setFirstResult(0).setMaxResults(10).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
	}

	
}
