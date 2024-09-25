package com.kh.upload.controller;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kh.upload.model.dto.BoardDTO;
import com.kh.upload.model.vo.Board;
import com.kh.upload.model.vo.Paging;
import com.kh.upload.service.BoardService;

import lombok.Locked.Write;

/*
 * REST(Representational State Transfer)
 *  : API를 설계하는 아키텍처
 *  
 * RESTful : REST 원칙을 준수하는 방식 
 * API(Application Programming Interface)
 *  : 서로 다른 애플리케이션들이 서로 데이터를 주고받을수 있게 하는 도구
 * */

@RestController
@RequestMapping("/api/*") // http://localhost:8080/api/
public class BoardController {

	private String path = "\\\\192.168.10.51\\upload\\";
	
	@Autowired
	private BoardService service;

	
	@PostMapping("/upload")
	public String upload(MultipartFile file) throws IllegalStateException, IOException {
		System.out.println("upload!");
		System.out.println("파일 이름 : " + file.getOriginalFilename());
		System.out.println("파일 사이즈 : " + file.getSize());
		System.out.println("파일 파라미터명 : " + file.getName());
		
		// 중복방지를 위한 UUID 적용. 같은 사진이여도 매번 다른 값이 적용됨
		UUID uuid = UUID.randomUUID();
		String fileName = uuid.toString() + "_" + file.getOriginalFilename();
		
		File copyFile = new File("D:\\upload\\" + fileName); 
		file.transferTo(copyFile); // 업로드한 파일이 지정한 path 위치로 저장
		
		return "redirect:/";
	}
	
	public String fileUpload(MultipartFile file) throws IllegalStateException, IOException {
		UUID uuid = UUID.randomUUID();
		String fileName = uuid.toString() + "_" + file.getOriginalFilename();
		
		File copyFile = new File("\\\\192.168.10.51\\upload\\" + fileName); 
		file.transferTo(copyFile); // 업로드한 파일이 지정한 path 위치로 저장
		
		return fileName;
	}
	// CRUD : Create - Post, Read - Get, Update - Put, Delete - Delete
	
	// Create - Post
	@PostMapping("/board")
	public ResponseEntity write(Board vo) throws IllegalStateException, IOException { 
		// 1. 파일 업로드 처리
//		String url = fileUpload(vo.getFile());
//		vo.setUrl(url);
		 
		// 2. 해당 파일 URL과 함께 title, content DB에 저장
		service.insert(vo);
		
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	// Read - Get : 전체 목록 보기
	@GetMapping("/board")
	public ResponseEntity list(Paging paging) {
		
		List<Board> list = service.selectAll(paging);
		
		for(Board b : list) {
			LocalDateTime date = b.getDate();
			Date formatDate = Date.from(date.atZone(ZoneId.systemDefault()).toInstant());
			b.setFormatDate(formatDate);
		}
		
//		model.addAttribute("list", list);
//		model.addAttribute("paging", new Paging(paging.getPage(), service.total()));
		
		return ResponseEntity.status(HttpStatus.OK).body(new BoardDTO(list, new Paging(paging.getPage(), service.total())));
	}
	
	// Read - Get : 1개 가져오기
	@GetMapping("/board/{no}")
	public ResponseEntity view(@PathVariable int no) {
		Board board = service.select(no);
		if(board!=null) {
			return ResponseEntity.status(HttpStatus.OK).body(board);
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	// Update - Put
	@PutMapping("/board")
	public ResponseEntity update(Board vo) throws IllegalStateException, IOException {
		if(vo.getFile().isEmpty()) {
			// 파일이 비어있다면 기존 이미지 url 그대로 DB에 저장\
			if(vo.getUrl()!=null) {
				File file = new File(path + vo.getUrl());
				file.delete();
			}

		} else {
			// 파일이 비어있지 않다면 기존 이미지 삭제, 새 이미지 등록
			File file = new File(path + vo.getUrl());
			
			String url= fileUpload(vo.getFile());
			vo.setUrl(url);
		}
		
		// title, content, url, no 
		service.update(vo);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	// Delete - Delete
	@DeleteMapping("/board/{no}")
	public ResponseEntity delete(@PathVariable int no) {
		
		// 업로드한 파일 삭제 (필요한 건 URL)
		Board board = service.select(no);
			if(board.getUrl()!=null) { // 기존 이미지가 null이 아닌 경우
				File file = new File(path + board.getUrl());
				file.delete(); 
			}
		
		service.delete(no);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
}
