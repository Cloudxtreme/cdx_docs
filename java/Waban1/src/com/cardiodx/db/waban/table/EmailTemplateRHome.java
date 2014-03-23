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
 * Home object for domain model class EmailTemplateR.
 * @see com.cardiodx.db.waban.table.EmailTemplateR
 * @author Hibernate Tools
 */
public class EmailTemplateRHome {

	private static final Log log = LogFactory.getLog(EmailTemplateRHome.class);

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

	public void persist(EmailTemplateR transientInstance) {
		log.debug("persisting EmailTemplateR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(EmailTemplateR instance) {
		log.debug("attaching dirty EmailTemplateR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(EmailTemplateR instance) {
		log.debug("attaching clean EmailTemplateR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(EmailTemplateR persistentInstance) {
		log.debug("deleting EmailTemplateR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public EmailTemplateR merge(EmailTemplateR detachedInstance) {
		log.debug("merging EmailTemplateR instance");
		try {
			EmailTemplateR result = (EmailTemplateR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public EmailTemplateR findById(
			com.cardiodx.db.waban.table.EmailTemplateRId id) {
		log.debug("getting EmailTemplateR instance with id: " + id);
		try {
			EmailTemplateR instance = (EmailTemplateR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.EmailTemplateR", id);
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

	public List<EmailTemplateR> findByExample(EmailTemplateR instance) {
		log.debug("finding EmailTemplateR instance by example");
		try {
			List<EmailTemplateR> results = (List<EmailTemplateR>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.EmailTemplateR")
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
