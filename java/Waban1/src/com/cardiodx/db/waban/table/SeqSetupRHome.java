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
 * Home object for domain model class SeqSetupR.
 * @see com.cardiodx.db.waban.table.SeqSetupR
 * @author Hibernate Tools
 */
public class SeqSetupRHome {

	private static final Log log = LogFactory.getLog(SeqSetupRHome.class);

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

	public void persist(SeqSetupR transientInstance) {
		log.debug("persisting SeqSetupR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(SeqSetupR instance) {
		log.debug("attaching dirty SeqSetupR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SeqSetupR instance) {
		log.debug("attaching clean SeqSetupR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(SeqSetupR persistentInstance) {
		log.debug("deleting SeqSetupR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SeqSetupR merge(SeqSetupR detachedInstance) {
		log.debug("merging SeqSetupR instance");
		try {
			SeqSetupR result = (SeqSetupR) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public SeqSetupR findById(com.cardiodx.db.waban.table.SeqSetupRId id) {
		log.debug("getting SeqSetupR instance with id: " + id);
		try {
			SeqSetupR instance = (SeqSetupR) sessionFactory.getCurrentSession()
					.get("com.cardiodx.db.waban.table.SeqSetupR", id);
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

	public List<SeqSetupR> findByExample(SeqSetupR instance) {
		log.debug("finding SeqSetupR instance by example");
		try {
			List<SeqSetupR> results = (List<SeqSetupR>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.SeqSetupR")
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
