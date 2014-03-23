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
 * Home object for domain model class AnonymizationBusinessRule.
 * @see com.cardiodx.db.waban.table.AnonymizationBusinessRule
 * @author Hibernate Tools
 */
public class AnonymizationBusinessRuleHome {

	private static final Log log = LogFactory
			.getLog(AnonymizationBusinessRuleHome.class);

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

	public void persist(AnonymizationBusinessRule transientInstance) {
		log.debug("persisting AnonymizationBusinessRule instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AnonymizationBusinessRule instance) {
		log.debug("attaching dirty AnonymizationBusinessRule instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AnonymizationBusinessRule instance) {
		log.debug("attaching clean AnonymizationBusinessRule instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AnonymizationBusinessRule persistentInstance) {
		log.debug("deleting AnonymizationBusinessRule instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AnonymizationBusinessRule merge(
			AnonymizationBusinessRule detachedInstance) {
		log.debug("merging AnonymizationBusinessRule instance");
		try {
			AnonymizationBusinessRule result = (AnonymizationBusinessRule) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AnonymizationBusinessRule findById(
			com.cardiodx.db.waban.table.AnonymizationBusinessRuleId id) {
		log.debug("getting AnonymizationBusinessRule instance with id: " + id);
		try {
			AnonymizationBusinessRule instance = (AnonymizationBusinessRule) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.table.AnonymizationBusinessRule",
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

	public List<AnonymizationBusinessRule> findByExample(
			AnonymizationBusinessRule instance) {
		log.debug("finding AnonymizationBusinessRule instance by example");
		try {
			List<AnonymizationBusinessRule> results = (List<AnonymizationBusinessRule>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.AnonymizationBusinessRule")
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
