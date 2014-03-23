package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:46 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class TypeListR.
 * @see com.cardiodx.db.waban.table.TypeListR
 * @author Hibernate Tools
 */
public class TypeListRHome {

	private static final Log log = LogFactory.getLog(TypeListRHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext()
					.lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(TypeListR transientInstance) {
		log.debug("persisting TypeListR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(TypeListR instance) {
		log.debug("attaching dirty TypeListR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TypeListR instance) {
		log.debug("attaching clean TypeListR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(TypeListR persistentInstance) {
		log.debug("deleting TypeListR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TypeListR merge(TypeListR detachedInstance) {
		log.debug("merging TypeListR instance");
		try {
			TypeListR result = (TypeListR) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TypeListR findById(com.cardiodx.db.waban.table.TypeListRId id) {
		log.debug("getting TypeListR instance with id: " + id);
		try {
			TypeListR instance = (TypeListR) sessionFactory.getCurrentSession()
					.get("com.cardiodx.db.waban.table.TypeListR", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<TypeListR> findByExample(TypeListR instance) {
		log.debug("finding TypeListR instance by example");
		try {
			List<TypeListR> results = (List<TypeListR>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.TypeListR")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
