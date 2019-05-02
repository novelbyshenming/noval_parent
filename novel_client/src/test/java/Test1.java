import bean.User;
import mapper.UserMapper;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author LX
 * @date 2019/4/13 - 21:07
 */
public class Test1 {

    @Test
    public void test1(){

        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserMapper bean = ac.getBean("userMapper",UserMapper.class);

        User user = new User();

        user.setPassword("1");

        user.setUsername("1");

        System.out.println(bean.selForLogin(user));
    }
}
