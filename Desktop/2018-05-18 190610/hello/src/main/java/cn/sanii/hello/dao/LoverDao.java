package cn.sanii.hello.dao;

import cn.sanii.hello.bean.Lover;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author sanii.cn
 * @Description: ${todo}
 * @date 2018/5/19 15:16
 */
public interface LoverDao extends JpaRepository<Lover, Integer> {

    List<Lover> getLoverByUrl(String url);
}
