package com.hbsh.dip.core.dao.hibernate;

import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.springframework.dao.DataAccessException;

import com.hbsh.dip.core.entity.BaseEntity;

public interface IHibernateEntityDao {
	/**
	 *插入数据
	 *
	 * @param entity
	 * @throws DataAccessException
	 */
	public abstract void save(BaseEntity entity);

	/**
	 * 更新数据
	 *
	 * @param entity
	 * @throws DataAccessException
	 */
	public abstract void update(BaseEntity entity);

	/**
	 * 根据id检查是否插入或是更新数据
	 *
	 * @param entity
	 * @throws DataAccessException
	 */
	public abstract void saveOrUpdate(BaseEntity entity);

	/**
	 * 删除数据
	 *
	 * @param entity
	 * @throws DataAccessException
	 */
	public abstract void delete(BaseEntity entity);

	/**
	 * 删除数据
	 *
	 * @param clazz
	 * @param objectId
	 */
	public abstract void delete(Class<? extends BaseEntity> clazz,
			String objectId);

	/**
	 * 删除数据
	 *
	 * @param entityList
	 */
	public abstract void delete(Collection<? extends BaseEntity> entityList);

	/**
	 *根据objectId获取实体对象
	 *
	 * @param clazz
	 * @param objectId
	 * @return
	 */
	public abstract BaseEntity get(Class<? extends BaseEntity> clazz,
			String objectId);

	/**
	 *根据objectId获取实体对象
	 *
	 * @param entityName
	 * @param objectId
	 * @return
	 * @throws Exception
	 */
	public abstract BaseEntity get(String entityName, String objectId)
			throws Exception;

	/**
	 *执行hql语句 返回实体列表
	 *
	 * @param hql
	 * @return
	 */
	public abstract List<?> list(String hql);

	/**
	 *执行hql语句 返回实体列表
	 *
	 * @param hql
	 * @param param
	 * @return
	 */
	public abstract List<?> list(String hql, Object... param);

	/**
	 *执行hql语句 返回实体列表
	 *
	 * @param hql
	 * @param start
	 * @param limit
	 * @param params
	 * @return
	 */
	public abstract List<?> list(String hql, int start, int limit, Object[] params);

	/**
	 * 执行sql语句 返回实体列表
	 *
	 * @param sql
	 * @param start
	 * @param limit
	 * @param params
	 * @return
	 */
	public abstract List<?> listSql(String sql, int start, int limit,
			Object[] params);

	/**
	 * 执行sql语句 返回实体列表
	 *
	 * @param sql
	 * @param params
	 * @return
	 */
	public abstract List<?> listSql(String sql, Object[] params);

	/**
	 *
	 * @param clazz
	 * @param character
	 * @param alphabet
	 * @param keyword
	 * @param limit
	 * @return
	 */
	public abstract List<Object> listCharacterText(
			Class<? extends BaseEntity> clazz, String character,
			String alphabet, final String keyword, final int limit);
	/**
	 * 执行hql语句
	 * @param hql
	 */
	public abstract void executeHql(final String hql);

	/**
	 * 根据entityClass生成对应类型的Criteria.
	 *
	 * @param entityClass
	 *            实体类型
	 * @param criterions
	 *            条件
	 * @return Criteria
	 */
	public abstract Criteria createCriteria(Class<BaseEntity> entityClass,
			Criterion... criterions);

	/**
	 * 根据entityClass，生成带排序的Criteria.
	 *
	 * @param <P>
	 *            实体类型
	 * @param entityClass
	 *            类型
	 * @param orderBy
	 *            排序字段名
	 * @param isAsc
	 *            是否正序
	 * @param criterions
	 *            条件
	 * @return Criteria
	 */
	public abstract Criteria createCriteria(Class<BaseEntity> entityClass,
			String orderBy, boolean isAsc, Criterion... criterions);

	/**
	 * 生成一个Query.
	 *
	 * @param hql
	 *            HQL语句
	 * @param values
	 *            参数
	 * @return Query
	 */
	public abstract Query createQuery(String hql, Object... values);

	/**
	 * 删除传入的数据
	 *
	 * @param entities
	 * @throws DataAccessException
	 */
	public abstract void deleteAll(Collection<BaseEntity> entities)
			throws DataAccessException;

	/**
	 * 查找所有数据
	 *
	 * @param entityClass
	 * @return
	 * @throws DataAccessException
	 */
	public abstract List<BaseEntity> findAll(Class<BaseEntity> entityClass)
			throws DataAccessException;

	public abstract void flush() throws DataAccessException;

	/**
	 * 获得总记录数.
	 *
	 * @param entityClass
	 *            实体类型
	 * @return 总数
	 */
	public abstract Integer getCount(Class<?> entityClass);

	/**
	 * 获得总记录数.
	 *
	 * @param criteria
	 *            条件
	 * @return 总数
	 */
	public abstract Integer getCount(Criteria criteria);

	/**
	 * 获得总记录数.
	 *
	 * @param hql
	 *            HQL字符串
	 * @param values
	 *            参数
	 * @return 总数
	 */
	public abstract Integer getCount(String hql, Object... values);
 
}