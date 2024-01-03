package hello.servlet.web.frontcontroller;

import java.io.IOException;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyView {
	private String viewPath;
	
	public MyView(String viewPath) {
		this.viewPath = viewPath;
	}
	
	public void render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
		dispatcher.forward(request, response);
	}
	
	public void render(Map<String,Object> model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		modelToRequestAttribute(model, request);

		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
		dispatcher.forward(request, response);
	}

	//render가 오면 model에 있는 것을 다 꺼내서 setAttribute로 다 넣음.
	private void modelToRequestAttribute(Map<String, Object> model, HttpServletRequest request) {
		model.forEach((key, value) -> request.setAttribute(key, value));
		
	}
	

}
