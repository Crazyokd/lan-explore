package oct.rekord.spring5.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"oct.rekord.spring5.aopanno"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ConfigAop {

}
