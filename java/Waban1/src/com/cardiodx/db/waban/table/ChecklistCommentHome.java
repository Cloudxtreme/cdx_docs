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
 * Home object for domain model class ChecklistComment.
 * @see com.cardiodx.db.waban.table.ChecklistComment
 * @author Hibernate Tools
 */
public class ChecklistCommentHome {

	private static final Log log = LogFactory
			.getLog(ChecklistCommentHome.class);

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

	public void persist(ChecklistComment transientInstance) {
		log.debug("persisting ChecklistComment instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ChecklistComment instance) {
		log.debug("attaching dirty ChecklistComment instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ChecklistComment instance) {
		log.debug("attaching clean ChecklistComment instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ChecklistComment persistentInstance) {
		log.debug("deleting ChecklistComment instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ChecklistComment merge(ChecklistComment detachedInstance) {
		log.debug("merging ChecklistComment instance");
		try {
			ChecklistComment result = (ChecklistComment) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ChecklistComment findById(
			com.cardiodx.db.waban.table.ChecklistCommentId id) {
		log.debug("getting ChecklistComment instance with id: " + id);
		try {
			ChecklistComment instance = (ChecklistComment) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.ChecklistComment", id);
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

	public List<ChecklistComment> findByExample(ChecklistComment instance) {
		log.debug("finding ChecklistComment instance by example");
		try {
			List<ChecklistComment> results = (List<ChecklistComment>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.ChecklistComment")
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
