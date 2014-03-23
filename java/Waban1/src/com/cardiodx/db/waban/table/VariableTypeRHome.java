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
 * Home object for domain model class VariableTypeR.
 * @see com.cardiodx.db.waban.table.VariableTypeR
 * @author Hibernate Tools
 */
public class VariableTypeRHome {

	private static final Log log = LogFactory.getLog(VariableTypeRHome.class);

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

	public void persist(VariableTypeR transientInstance) {
		log.debug("persisting VariableTypeR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(VariableTypeR instance) {
		log.debug("attaching dirty VariableTypeR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(VariableTypeR instance) {
		log.debug("attaching clean VariableTypeR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(VariableTypeR persistentInstance) {
		log.debug("deleting VariableTypeR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public VariableTypeR merge(VariableTypeR detachedInstance) {
		log.debug("merging VariableTypeR instance");
		try {
			VariableTypeR result = (VariableTypeR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public VariableTypeR findById(com.cardiodx.db.waban.table.VariableTypeRId id) {
		log.debug("getting VariableTypeR instance with id: " + id);
		try {
			VariableTypeR instance = (VariableTypeR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.VariableTypeR", id);
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

	public List<VariableTypeR> findByExample(VariableTypeR instance) {
		log.debug("finding VariableTypeR instance by example");
		try {
			List<VariableTypeR> results = (List<VariableTypeR>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.VariableTypeR")
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
