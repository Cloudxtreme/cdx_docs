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
 * Home object for domain model class QcReviewComment.
 * @see com.cardiodx.db.waban.table.QcReviewComment
 * @author Hibernate Tools
 */
public class QcReviewCommentHome {

	private static final Log log = LogFactory.getLog(QcReviewCommentHome.class);

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

	public void persist(QcReviewComment transientInstance) {
		log.debug("persisting QcReviewComment instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(QcReviewComment instance) {
		log.debug("attaching dirty QcReviewComment instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(QcReviewComment instance) {
		log.debug("attaching clean QcReviewComment instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(QcReviewComment persistentInstance) {
		log.debug("deleting QcReviewComment instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public QcReviewComment merge(QcReviewComment detachedInstance) {
		log.debug("merging QcReviewComment instance");
		try {
			QcReviewComment result = (QcReviewComment) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public QcReviewComment findById(
			com.cardiodx.db.waban.table.QcReviewCommentId id) {
		log.debug("getting QcReviewComment instance with id: " + id);
		try {
			QcReviewComment instance = (QcReviewComment) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.QcReviewComment", id);
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

	public List<QcReviewComment> findByExample(QcReviewComment instance) {
		log.debug("finding QcReviewComment instance by example");
		try {
			List<QcReviewComment> results = (List<QcReviewComment>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.QcReviewComment")
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
