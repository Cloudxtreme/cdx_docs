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
 * Home object for domain model class TrgeVarLitRel.
 * @see com.cardiodx.db.waban.view.TrgeVarLitRel
 * @author Hibernate Tools
 */
public class TrgeVarLitRelHome {

	private static final Log log = LogFactory.getLog(TrgeVarLitRelHome.class);

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

	public void persist(TrgeVarLitRel transientInstance) {
		log.debug("persisting TrgeVarLitRel instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(TrgeVarLitRel instance) {
		log.debug("attaching dirty TrgeVarLitRel instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TrgeVarLitRel instance) {
		log.debug("attaching clean TrgeVarLitRel instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(TrgeVarLitRel persistentInstance) {
		log.debug("deleting TrgeVarLitRel instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TrgeVarLitRel merge(TrgeVarLitRel detachedInstance) {
		log.debug("merging TrgeVarLitRel instance");
		try {
			TrgeVarLitRel result = (TrgeVarLitRel) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TrgeVarLitRel findById(com.cardiodx.db.waban.view.TrgeVarLitRelId id) {
		log.debug("getting TrgeVarLitRel instance with id: " + id);
		try {
			TrgeVarLitRel instance = (TrgeVarLitRel) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.TrgeVarLitRel", id);
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

	public List<TrgeVarLitRel> findByExample(TrgeVarLitRel instance) {
		log.debug("finding TrgeVarLitRel instance by example");
		try {
			List<TrgeVarLitRel> results = (List<TrgeVarLitRel>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.view.TrgeVarLitRel")
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
