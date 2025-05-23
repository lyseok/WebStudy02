package kr.or.ddit.buyer.controller;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.buyer.service.BuyerService;
import kr.or.ddit.buyer.service.impl.BuyerServiceImpl;
import kr.or.ddit.exception.ResponseStateExcetion;
import kr.or.ddit.vo.BuyerVO;
import lombok.extern.slf4j.Slf4j;

/**
 * 제조사 상세 조회용 컨트롤러
 * 1. 요청 수신 : /buyer/buyerDetail.do
 * 2. 요청 검증 : what 검증 (누락 : 400)
 * 3. 로직을 실행하고, 로직으로부터 모델을 수신
 * 4. 모델을 scope를 이용해 뷰로 전달 model : buyer
 * 5. 뷰 선택
 * 6. 뷰로 이동(forward, redirect)
 */
@Slf4j
@WebServlet("/buyer/buyerDetail.do")
public class BuyerDetailControllerServlet extends HttpServlet{
	BuyerService service = new BuyerServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String buyerId = req.getParameter("what");
		log.info("param: {}", buyerId);
		if(StringUtils.isBlank(buyerId)) {
			resp.sendError(400, "필수 파라미터 누락");
			return;
		}
		try {
			BuyerVO buyer = service.readBuyer(buyerId)
						.orElseThrow(() -> new ResponseStateExcetion(404, "그런 제조사 없음"));			
			req.setAttribute("buyer", buyer);
			req.getRequestDispatcher("/WEB-INF/views/buyer/buyerDetail.jsp").forward(req, resp);
		} catch (ResponseStateExcetion e) {
			resp.sendError(e.getStatus(), e.getMessage());
		}
		
	}
}
