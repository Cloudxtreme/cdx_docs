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
 * Home object for domain model class ContainerR.
 * @see com.cardiodx.db.waban.table.ContainerR
 * @author Hibernate Tools
 */
public class ContainerRHome {

	private static final Log log = LogFactory.getLog(ContainerRHome.class);

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

	public void persist(ContainerR transientInstance) {
		log.debug("persisting ContainerR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ContainerR instance) {
		log.debug("attaching dirty ContainerR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ContainerR instance) {
		log.debug("attaching clean ContainerR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ContainerR persistentInstance) {
		log.debug("deleting ContainerR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ContainerR merge(ContainerR detachedInstance) {
		log.debug("merging ContainerR instance");
		try {
			ContainerR result = (ContainerR) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ContainerR findById(com.cardiodx.db.waban.table.ContainerRId id) {
		log.debug("getting ContainerR instance with id: " + id);
		try {
			ContainerR instance = (ContainerR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.ContainerR", id);
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

	public List<ContainerR> findByExample(ContainerR instance) {
		log.debug("finding ContainerR instance by example");
		try {
			List<ContainerR> results = (List<ContainerR>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.ContainerR")
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
