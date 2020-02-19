package servlets;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.Model;

@WebServlet("/joinForm1Check")
public class JoinForm1Check extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JoinForm1Check() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 인적사항
		String name_ko = request.getParameter("name_ko");
		String makedate = request.getParameter("makedate");
		String name_en = request.getParameter("name_en");
		String refer_name = request.getParameter("refer_name");
		String birth = request.getParameter("birth");
		String addr = request.getParameter("addr");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		String photo_path = request.getRealPath("applies");
//			System.out.println(photo_path);
		int size = 10*1024*1024;
		String photo_name = "";
		String photo_url = "";
		try{
			MultipartRequest multi = new MultipartRequest(request, photo_path, size, "UTF-8", new DefaultFileRenamePolicy());
			Enumeration photo = multi.getFileNames();
			String photo_file = (String) photo.nextElement();
			photo_name = multi.getFilesystemName(photo_file);
		} catch (Exception e) {
			System.out.println("ERR_MultipartRequest__"+e.getMessage());
		}
		photo_url = photo_path+"\\"+photo_name;
		System.out.println("photo_url"+photo_url);
		
		// 학력사항
		String highs_year_f = request.getParameter("highs_year_f");
		String highs_month_f = request.getParameter("highs_month_f");
		String highs_year_l = request.getParameter("highs_year_l");
		String highs_month_l= request.getParameter("highs_month_l");
		String highs_name = request.getParameter("highs_name");
			
		System.out.println("highschool__"+highs_year_f + "__" +highs_month_f+ "__" +highs_year_l+ "__" +highs_month_l+ "__" +highs_name);
		
		String col_year_f = request.getParameter("col_year_f");
		String col_month_f = request.getParameter("col_month_f");
		String col_year_l = request.getParameter("col_year_l");
		String col_month_l = request.getParameter("col_month_l");
		String col_name = request.getParameter("col_name");
		String col_maj = request.getParameter("col_maj");
		String col_loc = request.getParameter("col_loc");
		String col_addmaj = request.getParameter("col_addmaj");
		String col_addmaj_name = request.getParameter("col_addmaj_name");
		
		String univ_year_f = request.getParameter("univ_year_f");
		String univ_month_f = request.getParameter("univ_month_f");
		String univ_year_l = request.getParameter("univ_year_l");
		String univ_month_l = request.getParameter("univ_month_l");
		String univ_name = request.getParameter("univ_name");
		String univ_maj = request.getParameter("univ_maj");
		String univ_loc = request.getParameter("univ_loc");
		String univ_addmaj = request.getParameter("univ_addmaj");
		String univ_addmaj_name = request.getParameter("univ_addmaj_name");
		
		String mas_year_f = request.getParameter("mas_year_f");
		String mas_month_f = request.getParameter("mas_month_f");
		String mas_year_l = request.getParameter("mas_year_l");
		String mas_month_l = request.getParameter("mas_month_l");
		String mas_name = request.getParameter("mas_name");
		String mas_maj = request.getParameter("mas_maj");
		String mas_loc = request.getParameter("mas_loc");
		
		String doc_year_f = request.getParameter("doc_year_f");
		String doc_month_f = request.getParameter("doc_month_f");
		String doc_year_l = request.getParameter("doc_year_l");
		String doc_month_l = request.getParameter("doc_month_l");
		String doc_name = request.getParameter("doc_name");
		String doc_maj = request.getParameter("doc_maj");
		String doc_loc = request.getParameter("doc_loc");
		
		String grad_maj = request.getParameter("grad_maj");
		String article = request.getParameter("article");
		
		String pause_year_f = request.getParameter("pause_year_f");
		String pause_month_f = request.getParameter("pause_month_f");
		String pause_year_l = request.getParameter("pause_year_l");
		String pause_month_l = request.getParameter("pause_month_l");
		String pause_reason = request.getParameter("pause_reason");
		
		Model m = new Model();
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
		
		RequestDispatcher rd = request.getRequestDispatcher("joinFinal.jsp");
		request.setAttribute("m", m);
		rd.forward(request, response);
		
	}

}
