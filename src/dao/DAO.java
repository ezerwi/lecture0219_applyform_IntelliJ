package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DAO {
	
	public DAO() {
		
	}

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
			
	public void connOracle() {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
			this.conn = ds.getConnection();
			System.out.println("SUCCESS_DB_Connection__"+conn);
		} catch (NamingException e) {
			System.out.println("ERR_DBC_NamingException__"+e.getMessage());
		} catch (SQLException e) {
			System.out.println("ERR_DBC_SQLException__"+e.getMessage());
		}	
	}

	public void insert_one () {
		this.connOracle();
		
		String q = "insert into ";
		
		try {
			this.pstmt = this.conn.prepareStatement(q);
			
		} catch (SQLException e) {
			System.out.println("ERR_insert_one__"+e.getMessage());
		}
	}
}
