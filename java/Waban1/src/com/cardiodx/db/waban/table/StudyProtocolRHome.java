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
 * Home object for domain model class StudyProtocolR.
 * @see com.cardiodx.db.waban.table.StudyProtocolR
 * @author Hibernate Tools
 */
public class StudyProtocolRHome {

	private static final Log log = LogFactory.getLog(StudyProtocolRHome.class);

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

	public void persist(StudyProtocolR transientInstance) {
		log.debug("persisting StudyProtocolR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(StudyProtocolR instance) {
		log.debug("attaching dirty StudyProtocolR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(StudyProtocolR instance) {
		log.debug("attaching clean StudyProtocolR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(StudyProtocolR persistentInstance) {
		log.debug("deleting StudyProtocolR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public StudyProtocolR merge(StudyProtocolR detachedInstance) {
		log.debug("merging StudyProtocolR instance");
		try {
			StudyProtocolR result = (StudyProtocolR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public StudyProtocolR findById(
			com.cardiodx.db.waban.table.StudyProtocolRId id) {
		log.debug("getting StudyProtocolR instance with id: " + id);
		try {
			StudyProtocolR instance = (StudyProtocolR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.StudyProtocolR", id);
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

	public List<StudyProtocolR> findByExample(StudyProtocolR instance) {
		log.debug("finding StudyProtocolR instance by example");
		try {
			List<StudyProtocolR> results = (List<StudyProtocolR>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.StudyProtocolR")
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
