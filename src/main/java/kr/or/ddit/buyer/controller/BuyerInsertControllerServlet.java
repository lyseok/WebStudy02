package kr.or.ddit.buyer.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.jsoup.internal.StringUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.or.ddit.buyer.service.BuyerService;
import kr.or.ddit.buyer.service.impl.BuyerServiceImpl;
import kr.or.ddit.validate.InsertGroup;
import kr.or.ddit.validate.util.ValidateUtils;
import kr.or.ddit.vo.BuyerVO;


/**
 *  /buyer/buyerInsert.do(GET, POST)
 */
@WebServlet("/buyer/buyerInsert.do")
public class BuyerInsertControllerServlet extends HttpServlet {
	private BuyerService service = new BuyerServiceImpl();
	/**
	 * 등록  form 제공
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		BuyerVO buyer = (BuyerVO)session.getAttribute("buyer");
		session.removeAttribute("buyer");
		Map<String, String> errors = (Map<String, String>)session.getAttribute("errors");
		session.removeAttribute("errors");
		
		req.setAttribute("buyer", buyer);
		req.setAttribute("errors", errors);
		
		String view = "/WEB-INF/views/buyer/buyerForm.jsp";
		req.getRequestDispatcher(view).forward(req, resp);
	}
	
	/**
	 * form 으로 입력받은 데이터 처리
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BuyerVO buyer = new BuyerVO();
		try {
			BeanUtils.populate(buyer, req.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			throw new ServletException(e);
		}
		// BuyerVO (comand object) 가 검증 대상
//		if(StringUtil.isBlank(buyer.getBuyerName())) {
//			
//		}
//		Map<String, String> errors = new HashMap<String, String>();
//		boolean valid = vaildate(buyer, errors);
		Map<String, String> errors = ValidateUtils.validate(buyer, InsertGroup.class);
		if(errors.isEmpty()) {
			service.createBuyer(buyer);
			// PRG
			resp.sendRedirect(req.getContextPath() + "/buyer/buyerList.do");			
		} else {
			// /buyer/buyerInsert.do
			HttpSession session = req.getSession();
			session.setAttribute("buyer", buyer);
			session.setAttribute("errors", errors);
			resp.sendRedirect(req.getContextPath() + "/buyer/buyerInsert.do");
		}
	}

	private boolean vaildate(BuyerVO buyer, Map<String, String> errors) {
		boolean valid = true;
		
		if(StringUtil.isBlank(buyer.getBuyerName())) {
			valid = false;
			errors.put("buyerName", "제조사 이름 누락");
		}
		if(StringUtil.isBlank(buyer.getLprodGu())) {
			valid = false;
			errors.put("lpordGu", "제조사 분류 누락");
		}
		if(StringUtil.isBlank(buyer.getBuyerBank())) {
			valid = false;
			errors.put("buyerBank", "계좌 누락");
		}
		if(StringUtil.isBlank(buyer.getBuyerBankname())) {
			valid = false;
			errors.put("buyerBankname", "계좌주 누락");
		}
		if(StringUtil.isBlank(buyer.getBuyerBankno())) {
			valid = false;
			errors.put("buyerBankno", "계좌 번호 누락");
		}
		if(StringUtil.isBlank(buyer.getBuyerComtel())) {
			valid = false;
			errors.put("buyerComtel", "연락처 누락");
		}
		if(StringUtil.isBlank(buyer.getBuyerMail())) {
			valid = false;
			errors.put("buyerMail", "메일 누락");
		}
		if(StringUtil.isBlank(buyer.getBuyerCharger())) {
			valid = false;
			errors.put("buyerCharger", "담당자 누락");
		}
		
		return valid;
	}
}
