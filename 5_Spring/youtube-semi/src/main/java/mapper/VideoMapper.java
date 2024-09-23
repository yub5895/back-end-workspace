package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.youtube.model.vo.Paging;
import com.kh.youtube.model.vo.Video;

@Mapper
public interface VideoMapper {
	List<Video> allVideo(Paging paging);
	Video detail(int videoCode);
	
}
