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
 * Home object for domain model class ContainerBatchR.
 * @see com.cardiodx.db.waban.table.ContainerBatchR
 * @author Hibernate Tools
 */
public class ContainerBatchRHome {

	private static final Log log = LogFactory.getLog(ContainerBatchRHome.class);

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

	public void persist(ContainerBatchR transientInstance) {
		log.debug("persisting ContainerBatchR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ContainerBatchR instance) {
		log.debug("attaching dirty ContainerBatchR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ContainerBatchR instance) {
		log.debug("attaching clean ContainerBatchR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ContainerBatchR persistentInstance) {
		log.debug("deleting ContainerBatchR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ContainerBatchR merge(ContainerBatchR detachedInstance) {
		log.debug("merging ContainerBatchR instance");
		try {
			ContainerBatchR result = (ContainerBatchR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ContainerBatchR findById(
			com.cardiodx.db.waban.table.ContainerBatchRId id) {
		log.debug("getting ContainerBatchR instance with id: " + id);
		try {
			ContainerBatchR instance = (ContainerBatchR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.ContainerBatchR", id);
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

	public List<ContainerBatchR> findByExample(ContainerBatchR instance) {
		log.debug("finding ContainerBatchR instance by example");
		try {
			List<ContainerBatchR> results = (List<ContainerBatchR>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.ContainerBatchR")
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
