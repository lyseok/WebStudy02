package kr.or.ddit.mbti.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.mapper.MbtiMapper;
import kr.or.ddit.mapper.impl.MbtiMapperImpl;
import kr.or.ddit.vo.MbtiVO;

@WebServlet("/rest/mbti/*")
public class MbtiRestController extends HttpServlet{
	private MbtiMapper mapper = new MbtiMapperImpl();
	Gson gson = new Gson();
	
	private void resultWriter(HttpServletResponse resp, int res) throws IOException {
		Gson gson = new Gson();
		Map<String, String> result = new HashMap<String, String>();
		if(res >= 1) {
			result.put("result", "success");
			try (PrintWriter out = resp.getWriter()) {
				out.print(gson.toJson(result));
			}
		} else {
			result.put("result", "fail");
			try (PrintWriter out = resp.getWriter()) {
				out.print(gson.toJson(result));
			}				
		}
	}
	
	private boolean validation(Map<String, String> errors, MbtiVO mbti) {
		boolean valid = true;
		
		// 2. 파라미터 검증
		if(StringUtils.isBlank(mbti.getMtType()) || mbti.getMtType().length() > 4) {
			errors.put("type", "type 값이 누락되거나 유효하지 않음");
			valid = false;
		} 
		if(StringUtils.isBlank(mbti.getMtTitle())) {
			errors.put("title", "title 값이 누락되거나 유효하지 않음");
			valid = false;
		}
		if(StringUtils.isBlank(mbti.getMtContent())) {
			errors.put("content", "content 값이 누락되거나 유효하지 않음");
			valid = false;
		}
		return valid;
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// CORS 헤더 설정
		resp.setHeader("Access-Control-Allow-Origin", "http://localhost:6060");
	    resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
	    resp.setHeader("Access-Control-Allow-Headers", "Content-Type");
		resp.setContentType("application/json");
		super.service(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getPathInfo();
		
		if (path == null || path.equals("/")) {
			List<MbtiVO> list = mapper.selectMbtiList();
			gson.toJson(list, resp.getWriter());			
		} else {
			String type = path.substring(1);
    		if(StringUtils.isBlank(type) || type.length() > 4) {
    			resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "type 값이 누락되거나 유효하지 않음");
    		} else {
    			MbtiVO mbti = mapper.selectMbti(type);
    			gson.toJson(mbti, resp.getWriter());  			
    		}
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. 파라미터 받기
		BufferedReader br = req.getReader();
		MbtiVO mbti = gson.fromJson(br, MbtiVO.class);
		
		Map<String, String> errors = new HashMap<String, String>();
		
		if(validation(errors, mbti)) {
			// 3. service 메서드 호출
			int res = mapper.insertMbti(mbti);
			// 4. insert상태 응답
			resultWriter(resp, res);
		} else {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST, errors.toString());
		}
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getPathInfo();
		
		// 1. 파라미터 받기
		BufferedReader br = req.getReader();
		MbtiVO mbti = gson.fromJson(br, MbtiVO.class);
		mbti.setMtType(path.substring(1));

		Map<String, String> errors = new HashMap<String, String>();
		
		if(validation(errors, mbti)) {
			int res = mapper.updateMbti(mbti);
			resultWriter(resp, res);
		} else {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST, errors.toString());
		}
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getPathInfo();
		String type = path.substring(1);
		
		// 2. 파라미터 검증
		if(StringUtils.isBlank(type) || type.length() > 4) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "type 값이 누락되거나 유효하지 않음");
		} else {
			int res = mapper.deleteMbti(type);
			resultWriter(resp, res);
		}
	}
	
	
}
