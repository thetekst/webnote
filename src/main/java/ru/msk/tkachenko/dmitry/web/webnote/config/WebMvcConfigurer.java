package ru.msk.tkachenko.dmitry.web.webnote.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import ru.msk.tkachenko.dmitry.web.webnote.data.UserDao;
import ru.msk.tkachenko.dmitry.web.webnote.data.UserDaoImpl;
import ru.msk.tkachenko.dmitry.web.webnote.model.Animal;
import ru.msk.tkachenko.dmitry.web.webnote.model.User;

@Configuration
@ComponentScan(basePackages = "ru.msk.tkachenko.dmitry.web.webnote")
@EnableWebMvc
@PropertySource("classpath:db.properties")
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {
	
	@Autowired
	private Environment env;
	
	public WebMvcConfigurer(Environment env) {
		this.env = env;
		System.out.println("00000000000000 " + env.getProperty("${jdbc.drivers}"));
	}

	@Bean(name = "viewResolver")
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
//        resolver.setViewClass(org.springframework.web.servlet.view.InternalResourceViewResolver.class);

        return resolver;
    }
    
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
    	configurer.enable();
    }
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
    
    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/webnote_db");
        dataSource.setUsername("root");
        dataSource.setPassword("good35");
         
        return dataSource;
    }
    
    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(getDataSource());
    }
     
//    @Bean
//    public UserDao getUserDao() { // UserDao
//    	DataSource ds = getDataSource();
//    	return new UserDaoImpl(ds);
//    }
    
    @Bean
    public Animal getUser() {
    	Animal animal = new Animal();
    	
    	animal.setAge(15);
    	animal.setName("dog");
		
		return animal;
    }
    
    @Bean
    public String getword() {
    	return "Super";
    }
}
