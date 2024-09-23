package mapper;

import org.apache.ibatis.annotations.Mapper;

import com.kh.youtube.model.vo.Subscribe;

@Mapper
public interface SubscribeMapper {
	Subscribe check(Subscribe vo);
	int count(int code);
	void subs(Subscribe vo);
	void cancel(int code);
}
