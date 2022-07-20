package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Database.MessageDAO;
import Service.GlobalService;

@WebServlet("/GlobalController")
public class GlobalController extends HttpServlet {
	MessageDAO message=new MessageDAO();
	GlobalService globalservice=new GlobalService();
	private static final long serialVersionUID = 1L;
    public GlobalController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/plain");
		HttpSession session=request.getSession();
		session.setAttribute("Name", "Amrish");
		globalservice.InsertMessage((String)session.getAttribute("Name"), request.getParameter("message"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int maxid=globalservice.GetMaxid();
		 int currentId=Integer.parseInt(request.getParameter("currentId"));
		 PrintWriter out=response.getWriter();
		 String result="";
		 if(maxid>currentId) {
			 result=globalservice.GetnewMessage(currentId, maxid);
		 }
		 out.write(result);
	}

}
