package com.address.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.address.po.Address;
import com.address.service.AddressService;
import com.util.JsonUtil;
import com.sxt.util.ResultInfo;
import com.sxt.util.User;

/**
		}
 * Servlet implementation class AddressServlet
 */
@WebServlet("/addressServlet")
public class AddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AddressService addressService = new AddressService();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String actionName = request.getParameter("actionName");
		
		if("searchAddress".equals(actionName)){
			searchAddress(request,response);
		}else if("deleteAddresss".equals(actionName)){
			deleteAddresss(request,response);
		}else if("addOrUpdate".equals(actionName)){
			addOrUpdate(request,response);
		}else if("checkAddress".equals(actionName)){
			checkAddress(request,response);
		}
	}

	/**
	 * 前台添加和修改地址, 都会调用此方法
	 * 当 aid 为空, 则为添加; 否则为修改
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException 
	 */
	private void addOrUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String address=request.getParameter("address");
		
		//地址id
		String aid=request.getParameter("aid");
		String isdefault=request.getParameter("isdefault");
		Integer uid =((User)request.getSession().getAttribute("user")).getUid();
		
		//调用下层执行业务
		ResultInfo<List<Address>> resultInfo=addressService.addorupdate(address,aid,isdefault,uid);
		
		//调用下层显示当前用户的所有 地址信息
		List<Address> list =addressService.findAddressList(uid);
		resultInfo.setResult(list);
		
		JsonUtil.toJson(response, resultInfo);
		
	}

	// 添加地址时, 验证地址重复性, 调用此方法
	private void checkAddress(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String isdefault=request.getParameter("isdefault");
		String aid=request.getParameter("aid");
		String address=request.getParameter("address");
		
		Integer uid =((User)request.getSession().getAttribute("user")).getUid();
		ResultInfo <Address> resultInfo=addressService.checkaddress(uid,address,aid);
		JsonUtil.toJson(response, resultInfo);
	}

	//前台点击删除地址, 调用此方法
	private void deleteAddresss(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String aid=request.getParameter("aid");
		Integer uid =((User)request.getSession().getAttribute("user")).getUid();
		ResultInfo<Address> resultInfo=addressService.deleteAddress(aid, uid);
		
		JsonUtil.toJson(response, resultInfo);
	}

	//加载我的地址时, 调用此方法, 让前台自动回显 List<Address>
	private void searchAddress(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer uid =((User)request.getSession().getAttribute("user")).getUid();
		String orderid =request.getParameter("orderid");
		
		ResultInfo<List<Address>>resultInfo=addressService.findAddress(uid);
		request.setAttribute("resultInfo", resultInfo);
		
		request.getRequestDispatcher("address.jsp").forward(request, response);
		
	}

}
