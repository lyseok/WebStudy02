package kr.or.ddit.prod.controller;

import java.io.IOException;

import org.jsoup.internal.StringUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.vo.ProdVO;

@WebServlet("/prod/prodDetail.do")
public class ProdDetailControllerServlet extends HttpServlet{
	ProdService service = new ProdServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String prodId = req.getParameter("what");
		if(StringUtil.isBlank(prodId)) {
			resp.sendError(400, "필수 파라미터 누락");
			return;
		}
		try {
			ProdVO prod = service.readProd(prodId)
								.orElseThrow(IllegalStateException::new);
			req.setAttribute("prod", prod);
			req.getRequestDispatcher("/WEB-INF/views/prod/ProdDetail.jsp").forward(req, resp);	
		} catch (IllegalStateException e) {
			resp.sendError(404);
		}
	}
}
