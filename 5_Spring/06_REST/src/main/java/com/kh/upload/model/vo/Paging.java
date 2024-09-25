package com.kh.upload.model.vo;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class Paging {

	private int page = 1; // 현재 페이지
	
	private int offset = 0; // 시작 위치
	private int limit = 10; // 레코드 수
	
	private int pageSize = 10; // 한 페이지 당 페이지 개수
	private int endPage = this.pageSize; // 한 페이지의 마지막 페이지 수
	private int startPage = this.page; // 한 페이지의 첫 페이지 수
	
	private boolean prev;
	private boolean next;
	
	public Paging(int page, int total) {
		/*
		 * page : 1 ~ 10 -> endPage : 10
		 * page : 11 ~ 20 -> endPage : 20
		 * page : 21 ~ 30 -> endPage : 30
		 * */
		this.page = page;
		this.endPage = (int) Math.ceil((double) this.page / this.pageSize) * this.pageSize;
		this.startPage = this.endPage - this.pageSize + 1;
		
		// 전체 개수를 통해서 마지막 페이지
		int lastPage = (int)Math.ceil((double) total / this.limit);
		
		if(lastPage < this.endPage) {
			this.endPage = lastPage;
		}
		

		this.prev = this.startPage > 1;
		this.next = this.endPage < lastPage;
	}
	
	public static void main(String[] args) {
		int total = 86; // -> 9
		System.out.println((int)Math.ceil((double) total / 10));
		 
	
	}
}
