package hello.servlet.web.springmvc.old;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("/springmvc/old-controller") //OldController 스프링 빈의 이름이 이게 됨. 스프링 빈의 이름을 url로 설정한 것임. // 이게 있으면 OldController라는 handler을 뽑아냄.
public class OldController implements Controller{

	@Override 
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("OldController.handleRequest");
		return new ModelAndView("new-form");
	}
}
