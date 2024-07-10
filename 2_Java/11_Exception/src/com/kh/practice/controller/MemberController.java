package com.kh.practice.controller;

import java.util.Arrays;

import com.kh.practice.exception.DuplicateNameException;
import com.kh.practice.exception.RecordNotFoundException;
import com.kh.practice.model.Member;

public class MemberController {
	
	private Member member = new Member();
	private Member[] mArr = new Member[3];
	public int count = 0;
	/* 완전 자유롭게! */
	
	// 멤버 추가
	public void insertMember (Member m) throws DuplicateNameException { // 보내기용 객체 m을 만들어서 한번에 쓰는 방법임 
		
		int index = checkId(m.getId());
		
		if(index == -1) {
			mArr[count++] = new Member(m.getId(), m.getName(), m.getPwd(),
					m.getEmail(), m.getGender(), m.getAge());
		} else {
			throw new DuplicateNameException();
		}
			
//		System.out.println(Arrays.toString(mArr));
	}
	// 멤버 아이디 검색 -> 멤버 index를 아이디로 조회
	public int checkId(String id) {
		for(int i = 0; i < mArr.length; i++) {
			if(mArr[i]!=null && mArr[i].getId().equals(id)) {
				// 기존 멤버 배열에 아이디가 있는 경우! 
				return i;
			}
		}
		// 아이디가 없는 경우
		return -1;
	}
	
	
	public int checkUpdateId(String id) throws RecordNotFoundException {
		for(int i = 0; i < mArr.length; i++) {
			if(mArr[i]!=null && mArr[i].getId().equals(id)) {
				// 기존 멤버 배열에 아이디가 있는 경우! 
				// return i;
			} else {
				throw new RecordNotFoundException();
			}
		}
		// 아이디가 없는 경우
		return -1;
	}
	
	
	// 멤버 수정
	public void updateMember(String id, String name, String email, String pwd) throws RecordNotFoundException {
		// 멤버의 index 찾기!
		int index = checkUpdateId(id);
		mArr[index].setName(name);
		mArr[index].setEmail(email);
		mArr[index].setPwd(pwd);
	}

	// 멤버 조회
	public Member[] printAll() {
		return mArr;
		}
	}
