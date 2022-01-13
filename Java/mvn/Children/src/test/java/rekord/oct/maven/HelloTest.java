package rekord.oct.maven;
import org.junit.Test;
import static org.junit.Assert.*;
public class HelloTest {
    @Test
    public void testHello(){
        Hello hello = new Hello();
        assertEquals("Hello litingwei!", hello.sayHello("litingwei"));
    }
    
}