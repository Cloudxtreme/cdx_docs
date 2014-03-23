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
 * Home object for domain model class GeneInterpretation.
 * @see com.cardiodx.db.waban.table.GeneInterpretation
 * @author Hibernate Tools
 */
public class GeneInterpretationHome {

	private static final Log log = LogFactory
			.getLog(GeneInterpretationHome.class);

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

	public void persist(GeneInterpretation transientInstance) {
		log.debug("persisting GeneInterpretation instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(GeneInterpretation instance) {
		log.debug("attaching dirty GeneInterpretation instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(GeneInterpretation instance) {
		log.debug("attaching clean GeneInterpretation instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(GeneInterpretation persistentInstance) {
		log.debug("deleting GeneInterpretation instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public GeneInterpretation merge(GeneInterpretation detachedInstance) {
		log.debug("merging GeneInterpretation instance");
		try {
			GeneInterpretation result = (GeneInterpretation) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public GeneInterpretation findById(
			com.cardiodx.db.waban.table.GeneInterpretationId id) {
		log.debug("getting GeneInterpretation instance with id: " + id);
		try {
			GeneInterpretation instance = (GeneInterpretation) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.GeneInterpretation",
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

	public List<GeneInterpretation> findByExample(GeneInterpretation instance) {
		log.debug("finding GeneInterpretation instance by example");
		try {
			List<GeneInterpretation> results = (List<GeneInterpretation>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.GeneInterpretation")
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
