import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.util.Date;

/**
 * @author LX
 * @date 2019/5/11 - 15:26
 */
public class DateTest {

    @Test
    public void dateTest(){

        Date date = new Date(1501349912000l);

        System.out.println(date+"  "+System.currentTimeMillis());

    }
}
