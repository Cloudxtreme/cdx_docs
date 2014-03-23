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
 * Home object for domain model class TestAccession.
 * @see com.cardiodx.db.waban.table.TestAccession
 * @author Hibernate Tools
 */
public class TestAccessionHome {

	private static final Log log = LogFactory.getLog(TestAccessionHome.class);

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

	public void persist(TestAccession transientInstance) {
		log.debug("persisting TestAccession instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(TestAccession instance) {
		log.debug("attaching dirty TestAccession instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TestAccession instance) {
		log.debug("attaching clean TestAccession instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(TestAccession persistentInstance) {
		log.debug("deleting TestAccession instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TestAccession merge(TestAccession detachedInstance) {
		log.debug("merging TestAccession instance");
		try {
			TestAccession result = (TestAccession) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TestAccession findById(java.math.BigDecimal id) {
		log.debug("getting TestAccession instance with id: " + id);
		try {
			TestAccession instance = (TestAccession) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.TestAccession", id);
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

	public List<TestAccession> findByExample(TestAccession instance) {
		log.debug("finding TestAccession instance by example");
		try {
			List<TestAccession> results = (List<TestAccession>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.TestAccession")
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
