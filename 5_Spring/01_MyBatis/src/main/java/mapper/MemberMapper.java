package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.mybatis.model.dto.SearchDTO;
import com.kh.mybatis.model.vo.Member;

@Mapper
public interface MemberMapper {
	void register(Member member); // 이게 member랑 1:1로 연동되어있음 -> 서비스에서 받은걸 member로 보냄
	List<Member> allMember();
	Member login(Member member);
	void update(Member member);
	List<Member> search(SearchDTO dto);
	void delete(List<String> idList);
}

