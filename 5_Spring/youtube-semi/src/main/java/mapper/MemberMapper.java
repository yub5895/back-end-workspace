package mapper;

import org.apache.ibatis.annotations.Mapper;

import com.kh.youtube.model.vo.Member;

@Mapper
public interface MemberMapper {
	
	Member check(String id);
	void signup(Member vo);
}
