//package hello.servlet.web.frontcontroller.v5;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import hello.servlet.web.frontcontroller.ModelView;
//import hello.servlet.web.frontcontroller.MyView;
//import hello.servlet.web.frontcontroller.v3.ControllerV3;
//import hello.servlet.web.frontcontroller.v3.controller.MemberFormControllerV3;
//import hello.servlet.web.frontcontroller.v3.controller.MemberListControllerV3;
//import hello.servlet.web.frontcontroller.v3.controller.MemberSaveControllerV3;
//import hello.servlet.web.frontcontroller.v5.adapter.ControllerV3HandlerAdapter;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//@WebServlet(name="frontControllerServletV5", urlPatterns="/front-controller/v5/*")
//public class FrontControllerServletV5 extends HttpServlet{
//	
//	//private Map<String, ControllerV4> controllerMap = new HashMap<>();
//	private final Map<String, Object> handlerMappingMap = new HashMap<>();
//	private final List<MyHandlerAdapter> handlerAdadpters = new ArrayList();
//
//	public FrontCotrollerServletV5() {
//		initHandlerMappingMap();
//		initHandlerAdapters();
//	}
//
//	private void initHandlerAdapters() {
//		handlerMappingMap.put("/front-controller/v3/members/new-form", new MemberFormControllerV3());
//		handlerMappingMap.put("/front-controller/v3/members/save", new MemberSaveControllerV3());
//		handlerMappingMap.put("/front-controller/v3/members", new MemberListControllerV3());
//		
//	}
//
//	private void initHandlerMappingMap() {
//		handlerAdadpters.add(new ControllerV3HandlerAdapter());
//	}
//	
//	@Override
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//		
//		Object handler = getHandler(request);
//		
//		if(controller==null) {
//			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
//			return;
//		}
//		
//		//paramMap
//		Map<String, String> paramMap = createParamMap(request);
//		
//		ModelView mv = controller.process(paramMap);
//		
//		String viewName = mv.getViewName(); //논리 이름 new-form
//		MyView view = viewResolver(viewName); //path 메소드
//		
//		view.render(mv.getModel(),request,response);
//		}
//
//	private Object getHandler(HttpServletRequest request) {
//		String requestURI = request.getRequestURI();
//		return handlerMappingMap.get(requestURI);
//		}
//	}
//}
