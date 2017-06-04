package spannerapp.config;

//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;
//
///**
// * Created by Siekacz on 03.06.2017.
// */
//@Configuration
//public class MvcConfig extends WebMvcConfigurerAdapter {
//
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry){
//        registry.addViewController("/menu").setViewName("menu");
//        registry.addViewController("/").setViewName("menu");
//        registry.addViewController("/index").setViewName("index");
//    }
//
//    @Bean(name = "dataSource")
//    public DriverManagerDataSource dataSource() {
//        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
//        driverManagerDataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        driverManagerDataSource.setUrl("jdbc:sqlserver://KOMBAJN-TURBO\\\\SQLEXPRESS:1433;databaseName=SpannerApp");
//        driverManagerDataSource.setUsername("sa");
//        driverManagerDataSource.setPassword("neiklot");
//        return driverManagerDataSource;
//    }
//
//    @Bean
//    public InternalResourceViewResolver viewResolver(){
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setPrefix("resources/static/");
//        resolver.setSuffix(".html");
//        return resolver;
//    }
//
//}

public class MvcConfig{}