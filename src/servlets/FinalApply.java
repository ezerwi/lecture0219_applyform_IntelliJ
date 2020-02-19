package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;
import model.Model;

@WebServlet("/finalapply")
public class FinalApply extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FinalApply() {
        super();
    }
    DAO d = null;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		this.d = new DAO();
		
		HttpSession ss = request.getSession();
		Model m = (Model) ss.getAttribute("m");
		
//		System.out.println("finalApply_getMakeDate__" + m.getMakedate());
		d.insert_one(m);
		
		response.sendRedirect("main.jsp");
	}

}
