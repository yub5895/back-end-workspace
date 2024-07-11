package com.kh.practice.model;

public class Song {

	private String song;
	private String singer;
	
	public Song() {
	}
	public Song(String song, String singer) {
		this.song = song;
		this.singer = singer;
	}
	public String getSong() {
		return song;
	}
	public void setSong(String song) {
		this.song = song;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	@Override
	public String toString() {
		return "Song [song=" + song + ", singer=" + singer + "]";
	}



	
}
