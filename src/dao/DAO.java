package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.Model;

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

	public void insert_one (Model m) {
		this.connOracle();
		
		String q = "insert into PERSONAL (NAME_KO, Makedate, Name_en, Refer_name, Birth, Addr, Email, Phone, Photo_URL)"
				+ " values (?, to_date(?, 'YYYY. MM. DD.'), ?, ?, to_date(?, 'YYYYMM'), ?, ?, ?, ?)";
//				+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
//				+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
//				+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
//				+ "?)";
		
		try {
			this.pstmt = this.conn.prepareStatement(q);
			
			this.pstmt.setString(1, m.getName_ko());
			this.pstmt.setString( 2, m.getMakedate());
			this.pstmt.setString( 3, m.getName_en());
			this.pstmt.setString( 4, m.getRefer_name());
			this.pstmt.setString( 5, m.getBirth());
			this.pstmt.setString( 6, m.getAddr());
			this.pstmt.setString( 7, m.getEmail());
			this.pstmt.setString( 8, m.getPhone());
			this.pstmt.setString( 9, m.getPhoto_url());
//			
//			
//			this.pstmt.setString( 10, m.getHighs_year_f()+m.getHighs_month_f());
//			this.pstmt.setString( 11, m.getHighs_year_l()+m.getHighs_month_l());
//			this.pstmt.setString( 12, m.getHighs_name());
//			
//			this.pstmt.setString( 13, m.getCol_year_f()+m.getCol_month_f());
//			this.pstmt.setString( 14, m.getCol_year_l()+m.getCol_month_l());
//			this.pstmt.setString( 15, m.getCol_name());
//			this.pstmt.setString( 16, m.getCol_maj());
//			this.pstmt.setString( 17, m.getCol_loc());
//			this.pstmt.setString( 18, m.getCol_addmaj());
//			this.pstmt.setString( 19, m.getCol_addmaj_name());
//			
//			this.pstmt.setString( 20, m.getUniv_year_f()+m.getUniv_month_f());
//			this.pstmt.setString( 21, m.getUniv_year_l()+m.getUniv_month_l());
//			this.pstmt.setString( 22, m.getUniv_name());
//			this.pstmt.setString( 23, m.getUniv_maj());
//			this.pstmt.setString( 24, m.getUniv_loc());
//			this.pstmt.setString( 25, m.getUniv_addmaj());
//			this.pstmt.setString( 26, m.getUniv_addmaj_name());
//			
//			this.pstmt.setString( 27, m.getMas_year_f()+m.getMas_month_f());
//			this.pstmt.setString( 28, m.getMas_year_l()+m.getMas_month_l());
//			this.pstmt.setString( 29, m.getMas_name());
//			this.pstmt.setString( 30, m.getMas_maj());
//			this.pstmt.setString( 31, m.getMas_loc());
//			
//			this.pstmt.setString( 32, m.getDoc_year_f()+m.getDoc_month_f());
//			this.pstmt.setString( 33, m.getDoc_year_l()+m.getDoc_month_l());
//			this.pstmt.setString( 34, m.getDoc_name());
//			this.pstmt.setString( 35, m.getDoc_maj());
//			this.pstmt.setString( 36, m.getDoc_loc());
//			
//			this.pstmt.setString( 37, m.getGrad_maj());
//			this.pstmt.setString( 38, m.getArticle());
//			this.pstmt.setString( 39, m.getPause_year_f()+m.getPause_month_f());
//			this.pstmt.setString( 40, m.getPause_year_l()+m.getPause_month_l());
//			this.pstmt.setString( 41, m.getPause_reason());
			
//			this.pstmt = this.conn.prepareStatement("commit");
//			int n2 = this.pstmt.executeUpdate();
			
//			if(n2>0) System.out.println("SUCCESS_Oracle_insert");
//			else System.out.println("FAIL_Oracle_insert");
			int n = this.pstmt.executeUpdate();
			
			this.conn.commit();
			
		} catch (SQLException e) {
			System.out.println("ERR_insert_one__"+e.getMessage());
		} finally {
			try {
				this.pstmt.close();
				this.conn.close();
			} catch (SQLException e) {
				System.out.println("ERR_insert_one_finally_"+e.getMessage());
			}
			
		}
	}
	// insert_one()

}
