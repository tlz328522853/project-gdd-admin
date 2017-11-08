package cn.hacz.edu.base;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import cn.hacz.edu.hibernate.BaseEntity;
import cn.hacz.edu.hibernate.PageHelper;



public interface BaseRepository<T extends BaseEntity> {
	
	 Session getCurrentSession();
	
	/**
	 * 保存对象
	 * @param o
	 * @return 对象的ID
	 */
	 Serializable save(T o);
	
	/**
	 * 删除一个对象
	 * @param o 对象
	 */
	 void delete(T o);

	/**
	 * 更新一个对象
	 * @param o 对象
	 */
	 void update(T o);
	
	/**
	 * 通过主键获得对象
	 * @param c 类型
	 * @param id id
	 * @return 要获得的对象
	 */
	 T get(Class<T> c, Serializable id);
	
	
	/**
	 * 通过HQL语句获取一个对象
	 * @param hql HQL语句
	 * @param params 参数
	 * @return 对象
	 */
	 T get(String hql, Map<String, Object> params);
	 T get(String hql, Object...params);
	 T get(String hql);

	/**
	 * 通过HQL获得一个集合
	 * @param hql HQL语句
	 * @param params 参数
	 * @param page 开始页数
	 * @param rows 每页记录数
	 * @return
	 */
	 List<T> find(String hql, Map<String, Object> params, PageHelper ph);
	 List<T> find(String hql, Map<String, Object> params);
	 List<T> find(String hql, Object...params);
	 List<T> find(String hql, PageHelper ph);
	 List<T> find(String hql);
	
	/**
	 * 统计
	 * @param hql HQL语句
	 * @param params 参数
	 * @return 记录数
	 */
	 Long count(String hql, Map<String, Object> params);
	 Long count(String hql, Object...params);
	 Long count(String hql);
	
	/**
	 * 执行HQL语句
	 * @param hql HQL语句
	 * @param params 参数
	 * @return 影响的结果数目
	 */
	 int execute(String hql, Map<String, Object> params);
	 int execute(String hql, Object...params);
	 int execute(String hql);

	/**
	 * 通过SQL查询
	 * @param sql SQL语句
	 * @param params 参数
	 * @param page 开始页数
	 * @param rows 第页记录数
	 * @return
	 */
	 List<?> findBySql(String sql, Map<String, Object> params, PageHelper ph);
	 List<?> findBySql(String sql, Map<String, Object> params);
	 List<?> findBySql(String sql, List<Object> params);
	 List<?> findBySql(String sql, PageHelper ph);
	 List<?> findBySql(String sql);
	
	
	/**
	 * 统计
	 * @param sql SQL语句
	 * @return 数目
	 */
	 BigInteger countBySql(String sql, Map<String, Object> params);
	 BigInteger countBySql(String sql);

	/**
	 * 执行SQL语句
	 * @param sql
	 * @param params
	 * @return
	 */
	 int executeSql(String sql, Map<String, Object> params);
	 int executeSql(String sql);

}
