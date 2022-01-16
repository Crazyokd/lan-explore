package oct.rekord.spring5.aopanno;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)   // 设置增强类优先级
public class PersonProxy {
    //后置通知（返回通知）
    @Before(value = "execution(* oct.rekord.spring5.aopanno.User.add(..))")
    public void afterReturning() {
        System.out.println("Person Before.........");
    }
}
