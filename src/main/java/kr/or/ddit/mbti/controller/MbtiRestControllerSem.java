package kr.or.ddit.mbti.controller;

import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.mbti.service.MbtiService;
import kr.or.ddit.mbti.service.MbtiServiceImpl;
import kr.or.ddit.vo.MbtiVO;

@WebServlet("/rest/sem/mbti/*")
public class MbtiRestControllerSem extends HttpServlet{
	private MbtiService service = new MbtiServiceImpl();
	Gson gson = new Gson();
//	
//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		// CORS 헤더 설정
//		resp.setHeader("Access-Control-Allow-Origin", "http://localhost:6060");
//	    resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
//	    resp.setHeader("Access-Control-Allow-Headers", "Content-Type");
//		resp.setContentType("application/json");
//		super.service(req, resp);
//	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		List<MbtiVO> list = service.readMbtiList();
		gson.toJson(list, resp.getWriter()); 
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MbtiVO newMbti = gson.fromJson(req.getReader(), MbtiVO.class);
		service.createMbti(newMbti);
		resp.sendRedirect(req.getContextPath() + "/rest/sem/mbti");
	}
	

	
}
