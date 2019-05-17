package mapper;

import com.yc.bean.IntroductionNovel;
import org.apache.ibatis.annotations.Param;

/**
 * @author LX
 * @date 2019/5/12 - 19:18
 */
public interface IntroductionMapper {

    IntroductionNovel selNovelByNid(@Param("nid") long nid);
}
