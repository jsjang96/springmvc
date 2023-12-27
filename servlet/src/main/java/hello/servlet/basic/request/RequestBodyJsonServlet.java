package hello.servlet.basic.request;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.springframework.util.StreamUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import hello.servlet.basic.HelloData;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "requestBodyJsonServlet", urlPatterns = "/request-body-json")
public class RequestBodyJsonServlet extends HttpServlet{
	
	//json결과를 파싱해서 사용할 수 있는 자바 객체러 변환하기 위한 라이브러리
	private ObjectMapper objectMapper = new ObjectMapper();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ServletInputStream inputStream = request.getInputStream();
		String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8) ;
		
		System.out.println("messageBody = " + messageBody);
		
		//json형식
		HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);
		//HelloData.class => 변환하려는 JSON 데이터의 구조를 나타내는 Java클래스입ㄴ디ㅏ. HelloData 클래스의 인스턴스를 생성하여 JSON 데이터를 해당 클래스의 객체로 변환
		
		System.out.println("helloData.username = " + helloData.getUsername());
		System.out.println("helloData.age = " + helloData.getAge());
		
		response.getWriter().write("ok");
		
	}

}
