package com.cardiodx.db.waban.view;

// Generated Jul 14, 2011 1:33:57 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class TrgePolyExternRef.
 * @see com.cardiodx.db.waban.view.TrgePolyExternRef
 * @author Hibernate Tools
 */
public class TrgePolyExternRefHome {

	private static final Log log = LogFactory
			.getLog(TrgePolyExternRefHome.class);

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

	public void persist(TrgePolyExternRef transientInstance) {
		log.debug("persisting TrgePolyExternRef instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(TrgePolyExternRef instance) {
		log.debug("attaching dirty TrgePolyExternRef instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TrgePolyExternRef instance) {
		log.debug("attaching clean TrgePolyExternRef instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(TrgePolyExternRef persistentInstance) {
		log.debug("deleting TrgePolyExternRef instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TrgePolyExternRef merge(TrgePolyExternRef detachedInstance) {
		log.debug("merging TrgePolyExternRef instance");
		try {
			TrgePolyExternRef result = (TrgePolyExternRef) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TrgePolyExternRef findById(
			com.cardiodx.db.waban.view.TrgePolyExternRefId id) {
		log.debug("getting TrgePolyExternRef instance with id: " + id);
		try {
			TrgePolyExternRef instance = (TrgePolyExternRef) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.TrgePolyExternRef", id);
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

	public List<TrgePolyExternRef> findByExample(TrgePolyExternRef instance) {
		log.debug("finding TrgePolyExternRef instance by example");
		try {
			List<TrgePolyExternRef> results = (List<TrgePolyExternRef>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.TrgePolyExternRef")
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
