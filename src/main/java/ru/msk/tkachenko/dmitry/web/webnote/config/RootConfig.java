package ru.msk.tkachenko.dmitry.web.webnote.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(
		basePackages={"ru.msk.tkachenko.dmitry.web.webnote"},
		excludeFilters={@Filter(type=FilterType.ANNOTATION, value=EnableWebMvc.class)}
)
public class RootConfig {

}
