package rekord.oct.maven;	
import static junit.framework.Assert.assertEquals;
import org.junit.Test;
import rekord.oct.maven.Hello;

public class HelloFriendTest {
	@Test
	public void testHelloFriend(){
		HelloFriend helloFriend = new HelloFriend();
		String results = helloFriend.sayHelloToFriend("litingwei");
		assertEquals("Hello litingwei! I am John",results);	
	}
}