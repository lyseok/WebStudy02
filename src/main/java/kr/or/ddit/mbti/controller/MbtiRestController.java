package kr.or.ddit.mbti.controller;

import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.mapper.MbtiMapper;
import kr.or.ddit.mapper.impl.MbtiMapperImpl;
import kr.or.ddit.vo.MbtiVO;

@WebServlet("/rest/mbti")
public class MbtiRestController extends HttpServlet{
	private MbtiMapper mapper = new MbtiMapperImpl();
	Gson gson = new Gson();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// CORS 헤더 설정
		resp.setHeader("ACCESS-CONTROL-ALLOW-ORIGIN", "http://localhost:6060");
		
		resp.setContentType("application/json");
		List<MbtiVO> list = mapper.selectMbtiList();
		gson.toJson(list, resp.getWriter());
	}
}
