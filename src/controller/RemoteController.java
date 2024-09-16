package controller;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import db.DAOQuires;



/**
 * Servlet implementation class Business
 */
public class RemoteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoteController() {
        super();
        // TODO Auto-generated constructor stub
    }
static String username ="";
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	Map<String,String> respMap= new HashMap<String, String>();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nextpath="";
		
		String UPLOAD_DIRECTORY = "C:";                 	
		String action=request.getParameter("action");
		String strName=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		System.out.println("Action="+action);
		HttpSession session = request.getSession(true);
		if("addComplaint".equals(action))
		{			
			new DAOQuires().insertComplaint(strName, email, password);
			respMap.put("error", "true");
			respMap.put("status", "true");
			sendResponseToApp(request,response);
		}
		if("close".equals(action))
		{			
			String item=request.getParameter("IMEI");
			new DAOQuires().update(item);
			respMap.put("error", "true");
			respMap.put("status", "true");
			sendResponseToApp(request,response);
		}
		if("getList".equalsIgnoreCase(action))
		{			
			String list = new DAOQuires().getList();
			respMap.put("status", list);
	      
	      	sendResponseToApp(request,response);
		}
		if(strName != null)
		{
			UPLOAD_DIRECTORY+="//"+username;
			System.out.println("Path="+request.getAttribute("emailid"));
			File file = new File(UPLOAD_DIRECTORY);
			if (!file.exists()) {
				if (file.mkdir()) {
					System.out.println("Directory is created!");
				} else {
					System.out.println("Failed to create directory!");
				}
			}
			if(new DAOQuires().insertReg(strName,email,password) == false)
			{
					respMap.put("error", "true");
					respMap.put("error_msg", "Unable to insert the record");
			}
			else{
					respMap.put("error", "false");
			}
			sendResponseToApp(request,response);
			
			
		}else if(email != null){
			username = email;
			if(new DAOQuires().checkLogin(email,password) == null)
			{
				//session.setAttribute("emailid",email);
				respMap.put("error", "true");
					respMap.put("error_msg", "Unable to insert the record");
			}
			else{
				respMap.put("error", "false");
				//session.setAttribute("emailid",email);
			}
			sendResponseToApp(request,response);
		}
		
		respMap.put("status", "false");
		sendResponseToApp(request,response);
     
	}
	private String prepareParametersToSend() {		
		Gson gson = new Gson();
		Type respMapType = new TypeToken<Map<String,String>>() {}.getType();
		return gson.toJson(respMap,respMapType);
	}
	public void sendResponseToApp(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{		
		try {
			String respString = prepareParametersToSend();
			
			 DataInputStream in = 
		                new DataInputStream((InputStream)request.getInputStream());
		        response.setContentType("text/plain");
		        response.setContentLength(respString.length());
		        PrintWriter out = response.getWriter();
		        out.println(respString);
		        in.close();
		        out.close();
		        out.flush();
		        
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
}
