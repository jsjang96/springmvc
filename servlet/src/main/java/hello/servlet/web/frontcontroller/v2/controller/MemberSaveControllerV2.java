package hello.servlet.web.frontcontroller.v2.controller;

import java.io.IOException;

import hello.servlet.domain.member.Member;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v2.ControllerV2;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MemberSaveControllerV2 implements ControllerV2{

	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String username = request.getParameter("username");
		int age = Integer.parseInt(request.getParameter("age"));
		
		Member member = new Member(username, age);
		
		//Model에 데이터 보관
		request.setAttribute("member", member);	
		
		return new MyView("/WEB-INF/views/save-result.jsp");
	}
}
