package com.kh.youtube.model.vo;

import java.time.LocalDateTime;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Video {
	private int videoCode; // video_code
	private String videoUrl;
	private String videoImg;
	private String videoTitle;
	private int videoCount;
	private LocalDateTime videoDate;
	private String videoDesc;
	//private int channelCode; // channel
	private Channel channel;
}