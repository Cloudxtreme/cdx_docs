package com.cardiodx.db.waban.audit;

// Generated Jul 14, 2011 1:33:02 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class AudChecklistComment.
 * @see com.cardiodx.db.waban.audit.AudChecklistComment
 * @author Hibernate Tools
 */
public class AudChecklistCommentHome {

	private static final Log log = LogFactory
			.getLog(AudChecklistCommentHome.class);

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

	public void persist(AudChecklistComment transientInstance) {
		log.debug("persisting AudChecklistComment instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AudChecklistComment instance) {
		log.debug("attaching dirty AudChecklistComment instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AudChecklistComment instance) {
		log.debug("attaching clean AudChecklistComment instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AudChecklistComment persistentInstance) {
		log.debug("deleting AudChecklistComment instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AudChecklistComment merge(AudChecklistComment detachedInstance) {
		log.debug("merging AudChecklistComment instance");
		try {
			AudChecklistComment result = (AudChecklistComment) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AudChecklistComment findById(java.math.BigDecimal id) {
		log.debug("getting AudChecklistComment instance with id: " + id);
		try {
			AudChecklistComment instance = (AudChecklistComment) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.audit.AudChecklistComment",
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

	public List<AudChecklistComment> findByExample(AudChecklistComment instance) {
		log.debug("finding AudChecklistComment instance by example");
		try {
			List<AudChecklistComment> results = (List<AudChecklistComment>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.audit.AudChecklistComment")
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
