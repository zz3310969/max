/*
package org.max.hello;

import org.jasig.cas.client.validation.Cas20ProxyTicketValidator;
import org.max.web.user.DefaultRolesUserDetailsService;
import org.max.web.user.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.cas.ServiceProperties;
import org.springframework.security.cas.authentication.CasAuthenticationProvider;
import org.springframework.security.cas.web.CasAuthenticationFilter;
import org.springframework.security.cas.web.authentication.ServiceAuthenticationDetailsSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.servlet.Filter;

@Configuration
@EnableWebSecurity
@ImportResource("classpath:spring-cas.xml")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private DefaultRolesUserDetailsService defaultRolesUserDetailsService;

    @Autowired
    private Filter casFilter;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilter(casFilter)
               ;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(getUserDetailsService());
                */
/*.inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");*//*

    }
                      
    @Bean(name = "userDetailsService")
    public UserDetailsService getUserDetailsService(){
        return new UserDetailsServiceImpl();
    }

    */
/*@Bean
    public Filter CasFilter(){
        CasAuthenticationFilter filter = new CasAuthenticationFilter();
        filter.setServiceProperties(ServiceProperties());
        filter.setAuthenticationDetailsSource(authenticationDetailsSource());
        return filter;
    }
    @Bean
    public ServiceProperties ServiceProperties(){
        ServiceProperties serviceProperties = new ServiceProperties();
        serviceProperties.setAuthenticateAllArtifacts(true);
        return  serviceProperties;
    }

    @Bean
    public ServiceAuthenticationDetailsSource authenticationDetailsSource(){
        ServiceAuthenticationDetailsSource serviceAuthenticationDetailsSource = new ServiceAuthenticationDetailsSource(ServiceProperties());
        return serviceAuthenticationDetailsSource;
    }

    @Bean
    public CasAuthenticationProvider casAuthenticationProvider(){
        CasAuthenticationProvider casAuthenticationProvider = new CasAuthenticationProvider();
        casAuthenticationProvider.setTicketValidator(true);
        return  casAuthenticationProvider;
    }

    @Bean
    public Cas20ProxyTicketValidator ticketValidator(){
        Cas20ProxyTicketValidator cas20ProxyTicketValidator = new Cas20ProxyTicketValidator("http://localhost:9443/cas");
        cas20ProxyTicketValidator.setProxyCallbackUrl("http://localhost:9443/cas");
        return  cas20ProxyTicketValidator;
    }*//*


}*/
