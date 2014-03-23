package com.demo.persistence.impl;



import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import org.hibernate.HibernateException;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.util.ClassUtils;



/**
 * A session factory bean that finds entity classes on the class path and registers their mappings
 * with a Hibernate configuration. This scanning is restricted to the packages listed in the
 * <code>annotatedPackages</code> property.
 * 
 * @author multipleauths
 * @version $Revision: 1$
 */
public class ScanningAnnotationSessionFactoryBean extends AnnotationSessionFactoryBean {
	/** Inner handle. */
	private String[] annotatedPackages;
	/** Inner handle. */
	private ClassLoader beanClassLoader;



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean#setAnnotatedPackages(java.lang.String[])
	 */
	@Override
	public void setAnnotatedPackages(String[] annotatedPackages) {

		// Set package list in parent.
		super.setAnnotatedPackages(annotatedPackages);

		// Keep reference to package list for post processing.
		this.annotatedPackages = annotatedPackages;
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.springframework.orm.hibernate3.LocalSessionFactoryBean#setBeanClassLoader(java.lang.ClassLoader)
	 */
	@Override
	public void setBeanClassLoader(ClassLoader beanClassLoader) {
		this.beanClassLoader = beanClassLoader;
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean
	 * #postProcessAnnotationConfiguration(org.hibernate.cfg.AnnotationConfiguration)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void postProcessAnnotationConfiguration(AnnotationConfiguration annotationConfiguration)
	throws HibernateException {

		// Initialise a class path scanner to look for entity classes.
		ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);
		scanner.setResourceLoader(new PathMatchingResourcePatternResolver(this.beanClassLoader));
		scanner.addIncludeFilter(new AnnotationTypeFilter(Entity.class));

		// Find entity classes in the specified packages.
		List<Class<?>> entityClasses = new ArrayList<Class<?>>();
		for (String annotatedPackage : this.annotatedPackages) {
			// use a class that won't be overridden by Junit
			ClassLoader systemCl =  BeanDefinition.class.getClassLoader();
			// we're running the default classloader
			if (this.beanClassLoader.equals(systemCl)) {
				for (BeanDefinition beanDefinition : scanner.findCandidateComponents(annotatedPackage)) {
					Class<?> entityClass = ClassUtils.resolveClassName(beanDefinition.getBeanClassName(), this.beanClassLoader);
					entityClasses.add(entityClass);
				}
			} else {
				Method method;
				List<String> result = null;
				try {
					method = this.beanClassLoader.getClass().getMethod("getJarEntries", String.class);
					result = (List<String>) method.invoke(this.beanClassLoader, new Object[]{annotatedPackage});

					for (String clazz : result) {
						Class<?> entityClass = ClassUtils.resolveClassName(clazz, this.beanClassLoader);
						entityClasses.add(entityClass);
					}
				} catch (Exception e) {
					throw new HibernateException(e);
				}
				

			}
		}

		// Add entity classes to the Hibernate configuration.
		for (Class<?> entityClass : entityClasses) {
			annotationConfiguration.addAnnotatedClass(entityClass);
		}
	}



}
