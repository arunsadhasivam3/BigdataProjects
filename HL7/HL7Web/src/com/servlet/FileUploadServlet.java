package com.servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.hl7.domain.Mainroot;
import com.hl7.domain.entity.PersonName;
import com.hl7.util.HL7ParserUtils;
/**
 * Servlet to read Multipart file.
 * @author arunkumar sadhasivam
 *
 */
@WebServlet(name = "hl7UploadServlet", urlPatterns = { "/hl7UploadServlet" })
@MultipartConfig
public class FileUploadServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
    private static final HL7ParserUtils parserutils = HL7ParserUtils.getInstance(); 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doProcess(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doProcess(req, resp);
	}

	protected void doProcess(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("doProcess");
		Mainroot root = null;
		// Create path components to save the file
		final Part filePart = request.getPart("file");
		final InputStream in = filePart.getInputStream();
		String message = ""; 
		String patient = "";
		int loadstatus=1;		
		try {
			 root = parserutils.unMarshall(in);
			 PersonName name = root.getDemographicEntity().getPatient().getPerson().getPersonName();
			 patient = name.getFirstName() + name.getMiddleName() + name.getLastName();
		} catch (Exception e) {
			message = patient+ "<font color='red'>Hl7 Patient - " + patient +" uploading Failed</font>";
			loadstatus = 0;
		}
		message ="<font color='green'>Hl7 Patient -" + patient +" uploaded Sucessfully...</font>";
		RequestDispatcher rd = request.getRequestDispatcher("/savePatientDetails.htm");
		request.setAttribute("load", loadstatus);
		request.setAttribute("status", message);
		request.setAttribute("message", message);
		request.setAttribute("root", root);

		rd.forward(request,response);
	}
}
