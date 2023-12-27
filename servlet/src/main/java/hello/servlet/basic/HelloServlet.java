package hello.servlet.basic;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		System.out.println("HelloServlet.service");
		System.out.println("request = " + request);
		System.out.println("response = " + response);
		
		//쿼리 파라미터를 읽는 역할 
		String username = request.getParameter("username");
		System.out.println("username= " + username);
		
		//응답 메세지를 보내는 방법 => response에 보내야 함
		//head에 들어감
		response.setContentType("text/plain");
		response.setCharacterEncoding("utf-8");
		//body에 들어감
		response.getWriter().write("hello " + username);
	}
}
