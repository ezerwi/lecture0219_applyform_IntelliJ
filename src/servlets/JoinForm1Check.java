package servlets;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.Model;

@WebServlet("/joinForm1Check")
public class JoinForm1Check extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public JoinForm1Check() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String photo_path = request.getRealPath("applies");
//		System.out.println(photo_path);
		int size = 10*1024*1024;
		String photo_name = "";
		String photo_url = "";
	
		Model m = new Model();
		
		try{
		MultipartRequest multi = new MultipartRequest(request, photo_path, size, "UTF-8", new DefaultFileRenamePolicy());
		
		// 인적사항
		String name_ko = multi.getParameter("name_ko");
//			System.out.println("name_ko__"+name_ko);
		String makedate = multi.getParameter("makedate");
		String name_en = multi.getParameter("name_en");
		String refer_name = multi.getParameter("refer_name");
			if( refer_name==null) refer_name = "";
		String birth = multi.getParameter("birth");
		String addr = multi.getParameter("addr");
		if( addr==null)addr = "";
		String email = multi.getParameter("email");
		if( email==null) email= "";
		String phone = multi.getParameter("phone");
		if( phone==null) phone= "";
		

		Enumeration photo = multi.getFileNames();
		String photo_file = (String) photo.nextElement();
		photo_name = multi.getFilesystemName(photo_file);
		photo_url = photo_path+"\\"+photo_name;
//		System.out.println("photo_url"+photo_url);
		
		// 학력사항
		String highs_year_f = multi.getParameter("highs_year_f");
		if( highs_year_f==null)highs_year_f = "";
		String highs_month_f = multi.getParameter("highs_month_f");
		if( highs_month_f==null)highs_month_f = "";
		String highs_year_l = multi.getParameter("highs_year_l");
		if(highs_year_l ==null)highs_year_l = "";
		String highs_month_l= multi.getParameter("highs_month_l");
		if( highs_month_l==null) highs_month_l= "";
		String highs_name = multi.getParameter("highs_name");
		if( highs_name==null)highs_name = "";
			
//		System.out.println("highschool__"+highs_year_f + "__" +highs_month_f+ "__" +highs_year_l+ "__" +highs_month_l+ "__" +highs_name);
		
		String col_year_f = multi.getParameter("col_year_f");
		if(col_year_f ==null)col_year_f = "";
		String col_month_f = multi.getParameter("col_month_f");
		if(col_month_f ==null) col_month_f= "";
		String col_year_l = multi.getParameter("col_year_l");
		if( col_year_l==null)col_year_l = "";
		String col_month_l = multi.getParameter("col_month_l");
		if( col_month_l==null) col_month_l= "";
		String col_name = multi.getParameter("col_name");
		if(col_name ==null)col_name = "";
		String col_maj = multi.getParameter("col_maj");
		if( col_maj==null)col_maj = "";
		String col_loc = multi.getParameter("col_loc");
		if( col_loc==null) col_loc= "";
		String col_addmaj = multi.getParameter("col_addmaj");
		if( col_addmaj==null) col_addmaj= "";
		String col_addmaj_name = multi.getParameter("col_addmaj_name");
		if(col_addmaj_name ==null)col_addmaj_name = "";
		
		String univ_year_f = multi.getParameter("univ_year_f");
		if(univ_year_f ==null) univ_year_f= "";
		String univ_month_f = multi.getParameter("univ_month_f");
		if( univ_month_f==null) univ_month_f= "";
		String univ_year_l = multi.getParameter("univ_year_l");
		if( univ_year_l==null) univ_year_l= "";
		String univ_month_l = multi.getParameter("univ_month_l");
		if( univ_month_l==null) univ_month_l= "";
		String univ_name = multi.getParameter("univ_name");
		if( univ_name==null) univ_name= "";
		String univ_maj = multi.getParameter("univ_maj");
//		if( ==null) = "";
		String univ_loc = multi.getParameter("univ_loc");
//		if( ==null) = "";
		String univ_addmaj = multi.getParameter("univ_addmaj");
//		if( ==null) = "";
		String univ_addmaj_name = multi.getParameter("univ_addmaj_name");
//		if( ==null) = "";
		
		String mas_year_f = multi.getParameter("mas_year_f");
//		if( ==null) = "";
		String mas_month_f = multi.getParameter("mas_month_f");
//		if( ==null) = "";
		String mas_year_l = multi.getParameter("mas_year_l");
//		if( ==null) = "";
		String mas_month_l = multi.getParameter("mas_month_l");
//		if( ==null) = "";
		String mas_name = multi.getParameter("mas_name");
//		if( ==null) = "";
		String mas_maj = multi.getParameter("mas_maj");
//		if( ==null) = "";
		String mas_loc = multi.getParameter("mas_loc");
//		if( ==null) = "";
		
		String doc_year_f = multi.getParameter("doc_year_f");
//		if( ==null) = "";
		String doc_month_f = multi.getParameter("doc_month_f");
//		if( ==null) = "";
		String doc_year_l = multi.getParameter("doc_year_l");
//		if( ==null) = "";
		String doc_month_l = multi.getParameter("doc_month_l");
//		if( ==null) = "";
		String doc_name = multi.getParameter("doc_name");
//		if( ==null) = "";
		String doc_maj = multi.getParameter("doc_maj");
//		if( ==null) = "";
		String doc_loc = multi.getParameter("doc_loc");
//		if( ==null) = "";
		
		String grad_maj = multi.getParameter("grad_maj");
//		if( ==null) = "";
		String article = multi.getParameter("article");
//		if( ==null) = "";
		
		String pause_year_f = multi.getParameter("pause_year_f");
//		if( ==null) = "";
		String pause_month_f = multi.getParameter("pause_month_f");
//		if( ==null) = "";
		String pause_year_l = multi.getParameter("pause_year_l");
//		if( ==null) = "";
		String pause_month_l = multi.getParameter("pause_month_l");
//		if( ==null) = "";
		String pause_reason = multi.getParameter("pause_reason");
//		if( ==null) = "";
		
		
		m.setName_ko(name_ko);
		m.setMakedate(makedate);
		m.setName_en(name_en);
		m.setRefer_name(refer_name);
		m.setBirth(birth);
		m.setAddr(addr);
		m.setEmail(email);
		m.setPhone(phone);
		m.setPhoto_url(photo_url);
		
		m.setHighs_year_f(highs_year_f);
		m.setHighs_month_f(highs_month_f);
		m.setHighs_year_l(highs_year_l);
		m.setHighs_month_l(highs_month_l);
		m.setHighs_name(highs_name);
		
		m.setCol_year_f(col_year_f);
		m.setCol_month_f(col_month_f);
		m.setCol_year_l(col_year_l);
		m.setCol_month_l(col_month_l);
		m.setCol_name(col_name);
		m.setCol_maj(col_maj);
		m.setCol_loc(col_loc);
		m.setCol_addmaj(col_addmaj);
		m.setCol_addmaj_name(col_addmaj_name);
		
		m.setUniv_year_f(univ_year_f);
		m.setUniv_month_f(univ_month_f);
		m.setUniv_year_l(univ_year_l);
		m.setUniv_month_l(univ_month_l);
		m.setUniv_name(univ_name);
		m.setUniv_maj(univ_maj);
		m.setUniv_loc(univ_loc);
		m.setUniv_addmaj(univ_addmaj);
		m.setUniv_addmaj_name(univ_addmaj_name);
		
		m.setMas_year_f(mas_year_f);
		m.setMas_month_f(mas_month_f);
		m.setMas_year_l(mas_year_l);
		m.setMas_month_l(mas_month_l);
		m.setMas_name(mas_name);
		m.setMas_maj(mas_maj);
		m.setMas_loc(mas_loc);
		
		m.setDoc_year_f(doc_year_f);
		m.setDoc_month_f(doc_month_f);
		m.setDoc_year_l(doc_year_l);
		m.setDoc_month_l(doc_month_l);
		m.setDoc_name(doc_name);
		m.setDoc_maj(doc_maj);
		m.setDoc_loc(doc_loc);
		
		m.setGrad_maj(grad_maj);
		m.setArticle(article);
		m.setPause_year_f(pause_year_f);
		m.setPause_year_l(pause_year_l);
		m.setPause_month_f(pause_month_f);
		m.setPause_month_l(pause_month_l);
		m.setPause_reason(pause_reason);

		} catch (Exception e) {
			System.out.println("ERR_MultipartRequest__"+e.getMessage());
		}

		HttpSession ss = request.getSession();
		ss.setAttribute("m", m);
		
		response.sendRedirect("joinFinal.jsp");
		
//		RequestDispatcher rd = request.getRequestDispatcher("joinFinal.jsp");
//		request.setAttribute("m", m);
//		rd.forward(request, response);
		
	}

}
