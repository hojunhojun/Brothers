package com.mjcbrothers.dronetoyou.c2c;

import java.io.File;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjcbrothers.dronetoyou.SiteOption;
import com.mjcbrothers.dronetoyou.member.Member;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class C2CDAO {
	
	@Autowired
	private SqlSession ss;
	
	@Autowired
	private SiteOption so;
	
	public int allC2CCount;
	
	public int C2CPageCount;
	
	public void reg(C2C c, HttpServletRequest request) {
		String path = request.getSession().getServletContext().getRealPath("resources/img");
		MultipartRequest mr = null;
		try {
			mr = new MultipartRequest(request, path, 20 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			String token = mr.getParameter("token");
			String oldSuccessToken = (String) request.getSession().getAttribute("successToken");
			
			if (oldSuccessToken != null && token.equals(oldSuccessToken)) {
				return;				
			}
			String photo = (String) mr.getFilesystemName("dc_photo1");
			Member m = (Member) request.getSession().getAttribute("loginMember");
			String y1 = mr.getParameter("y1");
			int m1 = Integer.parseInt(mr.getParameter("m1"));
			int d1 = Integer.parseInt(mr.getParameter("d1"));
			String in1 = String.format("%s%02d%02d", y1, m1, d1);
			String y2 = mr.getParameter("y2");
			int m2 = Integer.parseInt(mr.getParameter("m2"));
			int d2 = Integer.parseInt(mr.getParameter("d2"));
			String in2 = String.format("%s%02d%02d", y2, m2, d2);
			
			c.setDc_cate(mr.getParameter("dc_cate"));
			c.setDc_title(mr.getParameter("dc_title"));
			c.setDc_txt(mr.getParameter("dc_txt").replace("\r\n", "<br>"));
			c.setDc_writer(m.getDm_id());
			c.setDc_interval(in1+"-"+in2);
			c.setDc_photo1(photo);
			
			if (ss.getMapper(C2CMapper.class).regC2C(c) == 1) {
				request.getSession().setAttribute("successToken", token);
				allC2CCount++;
			}
		} catch (Exception e) {
			e.printStackTrace();
			new File(path + "/" + mr.getFilesystemName("dm_photo1")).delete();
		}
		
	}
	
	public void get(int page, HttpServletRequest request) {
		try {
			int C2CCount = allC2CCount;
			
			String search = (String) request.getSession().getAttribute("search");
			C2CSelector ccs = new C2CSelector(null, null, search);
			if (search == null) {
				ccs.setSearch("");
			} else { // 검색중
				C2CCount = ss.getMapper(C2CMapper.class).getC2CCount(ccs); // 검색해서 나온거수
			}
			int pageCount = (int) Math.ceil(C2CCount / (double) so.getC2CPerPage());
			request.setAttribute("pageCount", pageCount);
			
			request.setAttribute("page", page);
			BigDecimal start = new BigDecimal((page - 1) * so.getC2CPerPage() + 1);
			BigDecimal end = new BigDecimal(so.getC2CPerPage() * page);
			ccs.setStart(start);
			ccs.setEnd(end);
			
			List<C2C> c2cs = ss.getMapper(C2CMapper.class).get(ccs);
			request.setAttribute("c2cs", c2cs);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setAllC2CCount() {
		C2CSelector ccs = new C2CSelector(null, null, "");
		allC2CCount = ss.getMapper(C2CMapper.class).getC2CCount(ccs);
	}
	
	public void search(HttpServletRequest request) {
		String search = request.getParameter("search");
		request.getSession().setAttribute("search", search);
	}
	
	public void searchClear(HttpServletRequest request) {
		C2CSelector ccs = new C2CSelector(null, null, "");
		allC2CCount = ss.getMapper(C2CMapper.class).getC2CCount(ccs);
	}

	public void delete(C2C c, HttpServletRequest request) {
		try {
			if (ss.getMapper(C2CMapper.class).delete(c) == 1) {
				request.setAttribute("result", "삭제성공");
				allC2CCount--;
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "삭제실패");
		}
	}
	
	public void update(C2C c, HttpServletRequest request) {
		String path = request.getSession().getServletContext().getRealPath("resources/img");
		MultipartRequest mr = null;
		try {
			mr = new MultipartRequest(request, path, 20 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			String token = mr.getParameter("token");
			String oldSuccessToken = (String) request.getSession().getAttribute("successToken");
			
			if (oldSuccessToken != null && token.equals(oldSuccessToken)) {
				return;				
			}
			String photo = (String) mr.getFilesystemName("dc_photo1");
			String y1 = mr.getParameter("y1");
			int m1 = Integer.parseInt(mr.getParameter("m1"));
			int d1 = Integer.parseInt(mr.getParameter("d1"));
			String in1 = String.format("%s%02d%02d", y1, m1, d1);
			String y2 = mr.getParameter("y2");
			int m2 = Integer.parseInt(mr.getParameter("m2"));
			int d2 = Integer.parseInt(mr.getParameter("d2"));
			String in2 = String.format("%s%02d%02d", y2, m2, d2);
			BigDecimal bd1 = new BigDecimal(mr.getParameter("dc_no"));
			c.setDc_no(bd1);
			c.setDc_title(mr.getParameter("dc_title"));
			c.setDc_txt(mr.getParameter("dc_txt").replace("\r\n", "<br>"));
			c.setDc_interval(in1+"-"+in2);
			c.setDc_photo1(photo);
			if (ss.getMapper(C2CMapper.class).update(c) == 1) {
				System.out.println("수정 성공");
				request.setAttribute("result", "수정성공");
				new File(path + "/" + mr.getFilesystemName("oldPhoto"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "수정실패");
			new File(path + "/" + mr.getFilesystemName("dc_photo1")).delete();
		}
	}

	public void doSubmitRequest(C2CRequest ccr, HttpServletRequest request) {
		try {
			String token = request.getParameter("token");
			String oldSuccessToken = (String) request.getSession().getAttribute("successToken");
			
			if (oldSuccessToken != null && token.equals(oldSuccessToken)) {
				return;				
			}
			Member m = (Member) request.getSession().getAttribute("loginMember");
			
			ccr.setDcr_txt(request.getParameter("dcr_txt"));
			ccr.setDcr_responser(request.getParameter("dcr_writer"));
			ccr.setDcr_writer(m.getDm_id());
			
			if (ss.getMapper(C2CMapper.class).submitRequest(ccr) == 1) {
				request.getSession().setAttribute("successToken", token);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getSubmitRequest(C2CRequest ccr, HttpServletRequest request) {
		try {
			Member m = (Member) request.getSession().getAttribute("loginMember");
			ccr.setDcr_responser(m.getDm_id());
			
			List<C2CRequest> ccrs = ss.getMapper(C2CMapper.class).getSubmitRequest(ccr);
			request.setAttribute("ccrs", ccrs);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertCserviceRequest(HttpServletRequest request) {
		
	}
}
