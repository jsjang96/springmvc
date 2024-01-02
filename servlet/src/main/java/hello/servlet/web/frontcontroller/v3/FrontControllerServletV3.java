package hello.servlet.web.frontcontroller.v3;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v3.controller.MemberFormControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberListControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberSaveControllerV3;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "frontControllerServletV2", urlPatterns = "/front-controller/v2/*")
public class FrontControllerServletV3 extends HttpServlet{
	
	private Map<String, ControllerV3> controllerMap = new HashMap<>();
	
	public FrontControllerServletV3() {
		controllerMap.put("/front-controller/v3/members/new-form", new MemberFormControllerV3());
		controllerMap.put("/front-controller/v3/members/save", new MemberSaveControllerV3());
		controllerMap.put("/front-controller/v3/members", new MemberListControllerV3());
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String requestURI = request.getRequestURI();
		ControllerV3 controller = controllerMap.get(requestURI);
		if(controller==null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
		//paramMap
		
		Map<String, String> paramMap = new HashMap<>();
		request.getParameterNames().asIterator().forEachRemaining((paramName -> paramMap.put(paramName, request.getParameter(paramName)));
		
		ModelView mv = controller.process(paramMap);
		//여기서부터 다시
		view.render(request, response);
	}

}
