package oct.rekord.spring5.test;

import oct.rekord.spring5.service.UserService;
import org.junit.Test;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

//@ExtendWith(SpringExtension.class)
//@ContextConfiguration("classpath:bean1.xml")

@SpringJUnitConfig(locations = "classpath:bean1.xml")
public class JTest5 {

    @Autowired
    private UserService userService;

    @Test
    public void test1() {
        userService.accountMoney();
    }
}
