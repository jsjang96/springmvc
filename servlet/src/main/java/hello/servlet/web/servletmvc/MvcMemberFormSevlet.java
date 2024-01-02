package hello.servlet.web.servletmvc;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "mvcMemberFormServlet", urlPatterns="/servlet-mvc/members/new-form")
public class MvcMemberFormSevlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String viewPath ="/WEB-INF/views/new-form.jsp";
		//view에 던지는 방법
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
		//다른 서블릿이나 JSP로 이동할 수 있는 기능, 서버 내부에서 다시 호출이 발생
		dispatcher.forward(request, response);
	}
}