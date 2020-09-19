

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class FileServlet
 */
@WebServlet("/FileServ")
public class FileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ServletConfig sc;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		sc = config;

	}	

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doProcess(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		doProcess(request, response);
	}
	
	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		int len = contextPath.length();
		String command = uri.substring(len);
		
		if(command.equals("/FileServ")) {
			
		MultipartRequest mr = null;
		
		String uploadDir = sc.getServletContext().getRealPath("file");
		System.out.println("uploadDir: "+uploadDir);
		
		int maxSize = 1024  * 1024 * 5;
		String encType = "UTF-8";
		
		mr = new MultipartRequest(request,uploadDir, maxSize, encType);
		
		Enumeration<String> files = mr.getFileNames();
		String file = (String)files.nextElement();
		String fn = mr.getFilesystemName(file);
		String requestFolder = request.getContextPath()+"/file";
		String fullPath = requestFolder + "\\" + fn;
		String name = mr.getParameter("name");
		
		PrintWriter pw = response.getWriter();
		pw.println("¿Ã∏ß : "+name+"<br>");
		pw.println("<img src='"+fullPath+"'/>");
		pw.close();
		
		}
		
	}

}
