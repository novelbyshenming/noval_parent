import org.junit.Test;

import java.text.DateFormat;
import java.util.Date;

/**
 * @author LX
 * @date 2019/5/11 - 17:04
 */
public class UserTest {

    @Test
    public void tetset(){

        long l = System.currentTimeMillis();

        System.out.println(l);

        Date date = new Date(l);

        System.out.println(date);

    }
}
