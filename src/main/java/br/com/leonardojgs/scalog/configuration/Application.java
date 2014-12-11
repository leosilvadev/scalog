package br.com.leonardojgs.scalog.configuration;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class Application implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext applicationContext = buildApplicationContext();
		
		ServletRegistration.Dynamic appServlet = servletContext.addServlet("appServlet", new DispatcherServlet(applicationContext));
		appServlet.setLoadOnStartup(1);
		appServlet.addMapping("/");
		
		FilterRegistration.Dynamic filter = servletContext.addFilter("openEntityManagerInViewFilter", buildOpenEntityManagerFilter());
		filter.addMappingForUrlPatterns(getDispatcherTypes(), false, "/");
		
		servletContext.addListener(new ContextLoaderListener(applicationContext));
	}

	private OpenEntityManagerInViewFilter buildOpenEntityManagerFilter() {
		OpenEntityManagerInViewFilter openEntityManagerInViewFilter = new OpenEntityManagerInViewFilter();
		openEntityManagerInViewFilter.setEntityManagerFactoryBeanName("entityManagerFactory");
		return openEntityManagerInViewFilter;
	}

	private AnnotationConfigWebApplicationContext buildApplicationContext() {
		AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
		webApplicationContext.setConfigLocation(getClass().getPackage().getName());
		return webApplicationContext;
	}
	
	private EnumSet<DispatcherType> getDispatcherTypes() {
		return EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE, DispatcherType.ASYNC);
	}
	
}
