package com.kh.mybatis.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kh.mybatis.model.dto.SearchDTO;
import com.kh.mybatis.model.vo.Member;

import mapper.MemberMapper;

@Service
public class MemberService { // Mapper에서 받아온 후 service를 거쳐 controller로 이동(서비스는 선택) 
	
	private MemberMapper mapper;
	
	public MemberService(MemberMapper memberMapper) {
		this.mapper = memberMapper;
	}
	
	public void register(Member member) {
		mapper.register(member); // memberMapper로 이동 Mapper랑 1:1매치되어있음
	}
	
	public List<Member> allMember() {
		return mapper.allMember();
	}
	
	public Member login(Member member) {
		return mapper.login(member);
	}
	
	public void update(Member member) {
		mapper.update(member);
	}

	public List<Member> search(SearchDTO dto) {
		return mapper.search(dto);
	}
	
	public void delete(List<String> idList) {
		for(String id : idList) {
			mapper.delete(id);
		}
	}
}
