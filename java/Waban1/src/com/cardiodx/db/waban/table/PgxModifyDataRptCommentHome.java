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
 * Home object for domain model class PgxModifyDataRptComment.
 * @see com.cardiodx.db.waban.table.PgxModifyDataRptComment
 * @author Hibernate Tools
 */
public class PgxModifyDataRptCommentHome {

	private static final Log log = LogFactory
			.getLog(PgxModifyDataRptCommentHome.class);

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

	public void persist(PgxModifyDataRptComment transientInstance) {
		log.debug("persisting PgxModifyDataRptComment instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(PgxModifyDataRptComment instance) {
		log.debug("attaching dirty PgxModifyDataRptComment instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PgxModifyDataRptComment instance) {
		log.debug("attaching clean PgxModifyDataRptComment instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(PgxModifyDataRptComment persistentInstance) {
		log.debug("deleting PgxModifyDataRptComment instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PgxModifyDataRptComment merge(
			PgxModifyDataRptComment detachedInstance) {
		log.debug("merging PgxModifyDataRptComment instance");
		try {
			PgxModifyDataRptComment result = (PgxModifyDataRptComment) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PgxModifyDataRptComment findById(java.math.BigDecimal id) {
		log.debug("getting PgxModifyDataRptComment instance with id: " + id);
		try {
			PgxModifyDataRptComment instance = (PgxModifyDataRptComment) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.table.PgxModifyDataRptComment",
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

	public List<PgxModifyDataRptComment> findByExample(
			PgxModifyDataRptComment instance) {
		log.debug("finding PgxModifyDataRptComment instance by example");
		try {
			List<PgxModifyDataRptComment> results = (List<PgxModifyDataRptComment>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.PgxModifyDataRptComment")
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
