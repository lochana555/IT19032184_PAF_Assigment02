package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AdminAPI")
public class AdminAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	AdminAccount uObj = new AdminAccount();
	
    public AdminAPI() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
				String output = uObj.insertAdminDetails(request.getParameter("uname"), 
						 request.getParameter("password"), 
						request.getParameter("email"), 
						request.getParameter("age"),
						request.getParameter("address")); 
						response.getWriter().write(output);
	}

	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map paras = getParasMap(request); 
		 String output = uObj.updateAdminDetails(paras.get("hidUIDSave").toString(), 
		 paras.get("uname").toString(), 
		 paras.get("password").toString(), 
		paras.get("email").toString(), 
		paras.get("age").toString(), 
		paras.get("address").toString()); 
		response.getWriter().write(output);
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map paras = getParasMap(request); 
		 String output = uObj.deleteAdminDetails(paras.get("uid").toString()); 
		response.getWriter().write(output);
	}
	
	// Convert request parameters to a Map
			 private static Map getParasMap(HttpServletRequest request) 
			    { 
			     Map<String, String> map = new HashMap<String, String>(); 
			    try
			     { 
			     Scanner scanner = new Scanner(request.getInputStream(), "UTF-8"); 
			     String queryString = scanner.hasNext() ? 
			     scanner.useDelimiter("\\A").next() : ""; 
			     scanner.close(); 
			     String[] params = queryString.split("&"); 
			     for (String param : params) 
			     {
			    	 String[] p = param.split("=");
			    	 map.put(p[0], p[1]); 
			    	 } 
			    	 } 
			    	catch (Exception e) 
			    	 { 
			    	 } 
			    	return map; 
			    	}

}
