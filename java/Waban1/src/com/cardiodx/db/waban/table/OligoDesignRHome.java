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
 * Home object for domain model class OligoDesignR.
 * @see com.cardiodx.db.waban.table.OligoDesignR
 * @author Hibernate Tools
 */
public class OligoDesignRHome {

	private static final Log log = LogFactory.getLog(OligoDesignRHome.class);

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

	public void persist(OligoDesignR transientInstance) {
		log.debug("persisting OligoDesignR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(OligoDesignR instance) {
		log.debug("attaching dirty OligoDesignR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(OligoDesignR instance) {
		log.debug("attaching clean OligoDesignR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(OligoDesignR persistentInstance) {
		log.debug("deleting OligoDesignR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public OligoDesignR merge(OligoDesignR detachedInstance) {
		log.debug("merging OligoDesignR instance");
		try {
			OligoDesignR result = (OligoDesignR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public OligoDesignR findById(com.cardiodx.db.waban.table.OligoDesignRId id) {
		log.debug("getting OligoDesignR instance with id: " + id);
		try {
			OligoDesignR instance = (OligoDesignR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.OligoDesignR", id);
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

	public List<OligoDesignR> findByExample(OligoDesignR instance) {
		log.debug("finding OligoDesignR instance by example");
		try {
			List<OligoDesignR> results = (List<OligoDesignR>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.OligoDesignR")
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
