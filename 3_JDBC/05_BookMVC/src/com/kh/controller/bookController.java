package com.kh.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.jar.Attributes.Name;

import com.kh.model.Book;
import com.kh.model.member;

public class bookController {

	public bookController() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnect() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root", "qwer1234");

	}

	public void close(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();
	}

	public void close(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		rs.close();
		ps.close();
		conn.close();
	}

	public ArrayList<Book> printBookAll() throws SQLException {
		Connection conn = getConnect();
		String query = "SELECT * FROM book";
		PreparedStatement ps = conn.prepareStatement(query);

		ResultSet rs = ps.executeQuery();
		ArrayList<Book> list = new ArrayList<>();

		while (rs.next()) {
			Book book = new Book();
			book.setBk_title(rs.getString("bk_title"));
			book.setBk_author(rs.getString("bk_author"));
			book.setBk_price(rs.getInt("bk_price"));
			book.setBk_pub_no(rs.getInt("bk_pub_no"));
			list.add(book);
		}
		close(rs, ps, conn);

		return list;
	}
	
	public Book printBook(String bk_title) throws SQLException {
		Connection conn = getConnect();
		
		String query = "SELECT * FROM book WHERE bk_title = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, bk_title);
		
		ResultSet rs = ps.executeQuery();
		
		Book book = null;
		
		if(rs.next()) {
			book = new Book(rs.getString("bk_title"));
		}
		
		close(rs, ps, conn);
		
		return book;
		
	}

	public boolean bookCheck(String bk_title, String bk_author) throws SQLException {
		
		Connection conn = getConnect();
		String query = "SELECT bk_title AND bk_author FROM book WHERE bk_title =? AND bk_author =?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, bk_title);
		ps.setString(2, bk_author);
		ResultSet rs = ps.executeQuery();
		int checkBook = 0;

		if (rs.next())
			checkBook = rs.getInt("bk_no");
		close(rs, ps, conn);

		if (checkBook != 0)
			return true;
		return false;
	}
	
	
	

	//public boolean registerBook(Book book) throws SQLException {
	public boolean registerBook(String bk_title, String bk_author) throws SQLException {
		if (!bookCheck(bk_title, bk_author)) {
			Connection conn = getConnect();
			String query = "INSERT INTO book(bk_title, bk_author) VALUES(?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			// ps.setString(1, book.getBk_title());
			// ps.setString(2, book.getBk_Author());
			ps.setString(1, bk_title);
			ps.setString(2, bk_author);

			ps.executeUpdate();

			close(ps, conn);

			return true;
		}
		return false;
	}

	public boolean sellBook(String bk_title) throws SQLException {
		 
		Connection conn = getConnect();
		
		Book book = printBook(bk_title);
		String bk_title1 = null;
		
		String query = "DELETE FROM book WHERE bk_title = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		System.out.println(ps);
		ps.setString(1, bk_title);

		if(ps.executeUpdate() == 1) {
			bk_title1 = book.getBk_title();
		}
		
		
		close(ps,conn);
		
		return true;
	 
	}
	
	
	public boolean idCheck(String id, String pwd, String name) throws SQLException {
		Connection conn = getConnect();
		String query = "SELECT member_id, member_pwd, member_name FROM member WHERE member_id = ? AND member_pwd = ? AND member_name = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, id);
		ps.setString(2, pwd);
		ps.setString(3, name);
		
		ResultSet rs = ps.executeQuery();
		String checkId = null;
		if(rs.next()) checkId = rs.getString("id");
		close(rs, ps, conn);
		
		if(checkId!=null) return true;
		return false;

	}
	
	
	public boolean registerMember(String id, String pwd, String name) throws SQLException {
		if (!idCheck(id, pwd, name)) {
			Connection conn = getConnect();
			String query = "INSERT INTO member(member_id, member_pwd, member_name) VALUES(?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ps.setString(2, pwd);
			ps.setString(3, name);

			ps.executeUpdate();

			close(ps, conn);

			return true;
		}
		return false;
	}

	
	public String login(String id, String pwd) throws SQLException {
		Connection conn = getConnect();
		String query = "SELECT member_id, member_pwd, member_name FROM member WHERE member_id =? AND member_pwd = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, id);
		ps.setString(2, pwd);

		ResultSet rs = ps.executeQuery();
		String name = null;
		
		if(rs.next()) name = rs.getString("member_name");
		
		close(rs, ps, conn);
		if(name!=null) return name;
		return name;
		}
	
	
	
}

