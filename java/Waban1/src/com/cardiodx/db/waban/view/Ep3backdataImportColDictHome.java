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
 * Home object for domain model class Ep3backdataImportColDict.
 * @see com.cardiodx.db.waban.view.Ep3backdataImportColDict
 * @author Hibernate Tools
 */
public class Ep3backdataImportColDictHome {

	private static final Log log = LogFactory
			.getLog(Ep3backdataImportColDictHome.class);

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

	public void persist(Ep3backdataImportColDict transientInstance) {
		log.debug("persisting Ep3backdataImportColDict instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Ep3backdataImportColDict instance) {
		log.debug("attaching dirty Ep3backdataImportColDict instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Ep3backdataImportColDict instance) {
		log.debug("attaching clean Ep3backdataImportColDict instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Ep3backdataImportColDict persistentInstance) {
		log.debug("deleting Ep3backdataImportColDict instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Ep3backdataImportColDict merge(
			Ep3backdataImportColDict detachedInstance) {
		log.debug("merging Ep3backdataImportColDict instance");
		try {
			Ep3backdataImportColDict result = (Ep3backdataImportColDict) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Ep3backdataImportColDict findById(java.lang.String id) {
		log.debug("getting Ep3backdataImportColDict instance with id: " + id);
		try {
			Ep3backdataImportColDict instance = (Ep3backdataImportColDict) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.view.Ep3backdataImportColDict",
							id);
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

	public List<Ep3backdataImportColDict> findByExample(
			Ep3backdataImportColDict instance) {
		log.debug("finding Ep3backdataImportColDict instance by example");
		try {
			List<Ep3backdataImportColDict> results = (List<Ep3backdataImportColDict>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.Ep3backdataImportColDict")
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
