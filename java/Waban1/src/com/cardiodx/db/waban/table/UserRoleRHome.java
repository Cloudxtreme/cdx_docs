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
 * Home object for domain model class UserRoleR.
 * @see com.cardiodx.db.waban.table.UserRoleR
 * @author Hibernate Tools
 */
public class UserRoleRHome {

	private static final Log log = LogFactory.getLog(UserRoleRHome.class);

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

	public void persist(UserRoleR transientInstance) {
		log.debug("persisting UserRoleR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(UserRoleR instance) {
		log.debug("attaching dirty UserRoleR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(UserRoleR instance) {
		log.debug("attaching clean UserRoleR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(UserRoleR persistentInstance) {
		log.debug("deleting UserRoleR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public UserRoleR merge(UserRoleR detachedInstance) {
		log.debug("merging UserRoleR instance");
		try {
			UserRoleR result = (UserRoleR) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public UserRoleR findById(com.cardiodx.db.waban.table.UserRoleRId id) {
		log.debug("getting UserRoleR instance with id: " + id);
		try {
			UserRoleR instance = (UserRoleR) sessionFactory.getCurrentSession()
					.get("com.cardiodx.db.waban.table.UserRoleR", id);
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

	public List<UserRoleR> findByExample(UserRoleR instance) {
		log.debug("finding UserRoleR instance by example");
		try {
			List<UserRoleR> results = (List<UserRoleR>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.UserRoleR")
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
