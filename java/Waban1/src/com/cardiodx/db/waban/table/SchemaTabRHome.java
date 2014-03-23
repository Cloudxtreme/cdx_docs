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
 * Home object for domain model class SchemaTabR.
 * @see com.cardiodx.db.waban.table.SchemaTabR
 * @author Hibernate Tools
 */
public class SchemaTabRHome {

	private static final Log log = LogFactory.getLog(SchemaTabRHome.class);

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

	public void persist(SchemaTabR transientInstance) {
		log.debug("persisting SchemaTabR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(SchemaTabR instance) {
		log.debug("attaching dirty SchemaTabR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SchemaTabR instance) {
		log.debug("attaching clean SchemaTabR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(SchemaTabR persistentInstance) {
		log.debug("deleting SchemaTabR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SchemaTabR merge(SchemaTabR detachedInstance) {
		log.debug("merging SchemaTabR instance");
		try {
			SchemaTabR result = (SchemaTabR) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public SchemaTabR findById(com.cardiodx.db.waban.table.SchemaTabRId id) {
		log.debug("getting SchemaTabR instance with id: " + id);
		try {
			SchemaTabR instance = (SchemaTabR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.SchemaTabR", id);
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

	public List<SchemaTabR> findByExample(SchemaTabR instance) {
		log.debug("finding SchemaTabR instance by example");
		try {
			List<SchemaTabR> results = (List<SchemaTabR>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.SchemaTabR")
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
