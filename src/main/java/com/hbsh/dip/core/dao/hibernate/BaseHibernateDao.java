package com.hbsh.dip.core.dao.hibernate;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.hbsh.dip.core.entity.BaseEntity;

@Repository
@SuppressWarnings({ "unchecked", "rawtypes" })
public class BaseHibernateDao extends HibernateDaoSupport implements
		IHibernateEntityDao {

	public void save(BaseEntity entity) {
		getHibernateTemplate().save(entity);
	}

	public void update(BaseEntity entity) {
		getHibernateTemplate().merge(entity);
	}

	public void saveOrUpdate(BaseEntity entity) {
		getHibernateTemplate().saveOrUpdate(entity);
	}

	public void delete(BaseEntity entity) {
		getHibernateTemplate().delete(entity);
	}

	public void delete(Class<? extends BaseEntity> clazz, String objectId) {
		BaseEntity entity = get(clazz, objectId);
		delete(entity);
	}

	public void delete(Collection<? extends BaseEntity> entityList) {
		getHibernateTemplate().deleteAll(entityList);
	}

	public BaseEntity get(Class<? extends BaseEntity> clazz, String objectId) {
		return (BaseEntity) getHibernateTemplate().get(clazz, objectId);
	}

	public BaseEntity get(String entityName, String objectId) throws Exception {
		return (BaseEntity) getHibernateTemplate().get(
				Class.forName(entityName), objectId);
	}

	public List list(String hql) {
		return getHibernateTemplate().find(hql);
	}

	public List list(String hql, Object... param) {
		return getHibernateTemplate().find(hql, param);
	}

	public List list(String hql, int start, int limit, Object[] params) {
		Query query = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createQuery(hql);
		query.setFirstResult(start);
		query.setMaxResults(limit);
		for (int i = 0; i < params.length; i++) {
			Object object = params[i];
			query.setParameter(i, object);
		}
		return query.list();
	}

	public List listSql(String sql, int start, int limit, Object[] params) {
		Session session = getHibernateTemplate().getSessionFactory()
				.getCurrentSession();
		Query query = session.createSQLQuery(sql);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		query.setFirstResult(start);
		query.setMaxResults(limit);
		return query.list();
	}

	public List listSql(String sql, Object[] params) {
		Session session = getHibernateTemplate().getSessionFactory()
				.getCurrentSession();
		Query query = session.createSQLQuery(sql);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		return query.list();
	}

	public List<Object> listCharacterText(Class<? extends BaseEntity> clazz,
			String character, String alphabet, final String keyword,
			final int limit) {
		final String hql = "select " + character + " from " + clazz.getName()
				+ " where " + character + " like ? or " + alphabet + " like ?"
				+ " order by " + character;

		return getHibernateTemplate().execute(
				new HibernateCallback<List<Object>>() {
					public List<Object> doInHibernate(Session session)
							throws HibernateException, SQLException {
						return session.createQuery(hql)
								.setString(0, "%" + keyword + "%")
								.setString(1, "%" + keyword + "%")
								.setFirstResult(0).setMaxResults(limit).list();
					}
				});
	}

	public void executeHql(final String hql) {
		getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				query.executeUpdate();
				return null;
			}
		});
	}

	public void execute(HibernateCallback hibernateCallback) {
		getHibernateTemplate().execute(hibernateCallback);
	}

	public Criteria createCriteria(Class<BaseEntity> entityClass,
			Criterion... criterions) {
		Criteria criteria = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(entityClass);
		for (Criterion c : criterions) {
			criteria.add(c);
		}
		return criteria;
	}

	public Criteria createCriteria(Class<BaseEntity> entityClass,
			String orderBy, boolean isAsc, Criterion... criterions) {
		if ((orderBy == null) || orderBy.trim().equals("")) {
			return createCriteria(entityClass, criterions);
		} else {
			Criteria criteria = createCriteria(entityClass, criterions);

			if (isAsc) {
				criteria.addOrder(Order.asc(orderBy));
			} else {
				criteria.addOrder(Order.desc(orderBy));
			}

			return criteria;
		}
	}

	public Query createQuery(String hql, Object... values) {
		Query query = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createQuery(hql);
		for (int i = 0; i < values.length; i++) {
			query.setParameter(i, values[i]);
		}
		return query;
	}

	public void deleteAll(Collection<BaseEntity> entities)
			throws DataAccessException {
		getHibernateTemplate().deleteAll(entities);
	}

	public List<BaseEntity> findAll(Class<BaseEntity> entityClass)
			throws DataAccessException {
		return getHibernateTemplate().loadAll(entityClass);
	}

	public void flush() throws DataAccessException {
		this.getHibernateTemplate().flush();
	}

	public Integer getCount(Class entityClass) {
		return this.getCount(this.createCriteria(entityClass));
	}

	public Integer getCount(Criteria criteria) {
		Object result = criteria.setProjection(Projections.rowCount())
				.uniqueResult();
		return ((Number) result).intValue();
	}

	public Integer getCount(String hql, Object... values) {
		String result = createQuery(hql, values).uniqueResult().toString();
		return Integer.valueOf(result);
	}

	/**
	 * 判断是否需要进行条件搜索.
	 * 
	 * @param filterTxt
	 *            name
	 * @param filterValue
	 *            value
	 * @return if need filter
	 */
	protected boolean needFilter(String filterTxt, String filterValue) {
		return (filterTxt != null) && (filterValue != null)
				&& (!filterTxt.trim().equals(""))
				&& (!filterValue.trim().equals(""));
	}
}