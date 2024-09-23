package mapper;

import org.apache.ibatis.annotations.Mapper;

import com.kh.youtube.model.vo.VideoLike;

@Mapper
public interface VideoLikeMapper {
	void like(VideoLike vo);
	VideoLike check(VideoLike vo);
	void unlike(int code);
}
