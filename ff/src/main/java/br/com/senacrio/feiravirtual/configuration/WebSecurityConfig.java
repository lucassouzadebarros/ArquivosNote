package br.com.senacrio.feiravirtual.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    //private static String[] PUBLIC_MATCHERS = {"/statics/**", "/h2-console/**", "/login", "/usuario/**", "/**"};
    //private static String[] PUBLIC_MATCHERS_GET = {"/login/**"};

    private static String[] PUBLIC_MATCHERS_GET = { "/usuario/registro", "/usuario/politicaLgpd", "/usuario/validaEmail", "/vaga/vagas", "/empresa/empresas", "/usuario/cadastraUsuario", "/usuario/salvaUsuario", "/usuario/politicaModal", "/vaga/cadastraVaga", "/vaga/salvaVaga" };
    private static String[] PUBLIC_MATCHERS_POST = { "/usuario/salvaUsuario" };
    private static String[] PRIVATE_MATCHERS_GET = { "/vaga/cadastraVaga", "/inicio", "/**" };
    private static String[] PRIVATE_MATCHERS_POST = { "/vaga/salvaVaga", "/inicio", "/**" };
    private static String[] RELATORIO_MATCHERS_POST = {"/relatorio/**", "/**"};
    //>>>>>>>>>>>>>>>>>
    @Autowired
    private CurrentUserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests().antMatchers(HttpMethod.GET, PUBLIC_MATCHERS_GET)
                .permitAll().antMatchers(HttpMethod.POST, PUBLIC_MATCHERS_POST)
                .permitAll().antMatchers(HttpMethod.POST, RELATORIO_MATCHERS_POST)
                .permitAll().antMatchers(HttpMethod.GET, PRIVATE_MATCHERS_GET)
                .hasAnyRole("ADMIN", "ADMINEMP", "USER").antMatchers(HttpMethod.POST, PRIVATE_MATCHERS_POST)
                .hasAnyRole("ADMIN", "ADMINEMP").anyRequest().authenticated()
                .and().formLogin().loginProcessingUrl("/signin").loginPage("/login").permitAll().usernameParameter("txtUsername").passwordParameter("txtPassword").permitAll()
                .defaultSuccessUrl("/inicio", true).permitAll().
                and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
    }

    @Override
    public void configure(WebSecurity web) throws Exception{
        //web.ignoring().antMatchers("/**","/statics/css/**", "/statics/js/**");
        web.ignoring().antMatchers("/statics/**","/statics/highchart/**","/statics/css/**","/statics/js/**","/statics/plugins/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        //PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        //auth.inMemoryAuthentication().withUser("admin").password(encoder.encode("123")).roles("ADMIN");
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

}
