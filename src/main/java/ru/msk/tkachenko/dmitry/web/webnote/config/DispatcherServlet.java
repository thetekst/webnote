package ru.msk.tkachenko.dmitry.web.webnote.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatcherServlet extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { WebMvcConfigurer.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/","/registration"};
	}

}
