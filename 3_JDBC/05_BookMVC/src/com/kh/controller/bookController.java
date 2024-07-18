package com.kh.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.model.Book;

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

	public boolean idCheck(String bk_title, String bk_author) throws SQLException {
		
		Connection conn = getConnect();
		String query = "SELECT bk_title, bk_author FROM book WHERE bk_title =?, bk_author =?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, bk_title);
		ps.setString(2, bk_author);
		ResultSet rs = ps.executeQuery();
		String checkId = null;

		if (rs.next())
			checkId = rs.getString("id");
		close(rs, ps, conn);

		if (checkId != null)
			return true;
		return false;
	}

	//public boolean registerBook(Book book) throws SQLException {
	public boolean registerBook(String bk_title, String bk_author) throws SQLException {
		if (!idCheck(bk_title, bk_author)) {
			Connection conn = getConnect();
			String query = "INSERT INTO book(bk_title, bk_author, bk_price, bk_pub_no) VALUES(?, ?, ?, ?)";
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

	private String getBk_author() {
		return null;
	}

	private String getBk_title() {
		return null;
	}


}
