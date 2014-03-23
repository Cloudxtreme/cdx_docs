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
 * Home object for domain model class ContainerMapR.
 * @see com.cardiodx.db.waban.table.ContainerMapR
 * @author Hibernate Tools
 */
public class ContainerMapRHome {

	private static final Log log = LogFactory.getLog(ContainerMapRHome.class);

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

	public void persist(ContainerMapR transientInstance) {
		log.debug("persisting ContainerMapR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ContainerMapR instance) {
		log.debug("attaching dirty ContainerMapR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ContainerMapR instance) {
		log.debug("attaching clean ContainerMapR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ContainerMapR persistentInstance) {
		log.debug("deleting ContainerMapR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ContainerMapR merge(ContainerMapR detachedInstance) {
		log.debug("merging ContainerMapR instance");
		try {
			ContainerMapR result = (ContainerMapR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ContainerMapR findById(com.cardiodx.db.waban.table.ContainerMapRId id) {
		log.debug("getting ContainerMapR instance with id: " + id);
		try {
			ContainerMapR instance = (ContainerMapR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.ContainerMapR", id);
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

	public List<ContainerMapR> findByExample(ContainerMapR instance) {
		log.debug("finding ContainerMapR instance by example");
		try {
			List<ContainerMapR> results = (List<ContainerMapR>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.ContainerMapR")
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
