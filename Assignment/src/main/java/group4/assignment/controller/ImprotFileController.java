package group4.assignment.controller;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import group4.assignment.dao.ImportDAO;
import group4.assignment.dao.UserDAO;
import group4.assignment.model.FileUpload;
import group4.assignment.model.User;

@Controller
public class ImprotFileController {

	private static final String UPLOAD_DIRECTORY ="/files";  

	@RequestMapping(value="/importdata",method=RequestMethod.GET)
	protected ModelAndView displayImportData(HttpSession session){
		UserDAO userDAO = new UserDAO();
		ArrayList<User>  listUser = userDAO.getUser();
		session.setAttribute("listUser", listUser);
		return new ModelAndView("import_screen");
	}
	@RequestMapping(value="/handlingFiles",method=RequestMethod.POST)
	public String handlingFiles(@ModelAttribute("fileUpload") FileUpload upload,
			HttpSession session,RedirectAttributes redirectAttributes){
		MultipartFile[] files = upload.getFiles();
		ServletContext context = session.getServletContext();  
	    String path = context.getRealPath(UPLOAD_DIRECTORY); 
	    for (MultipartFile multipartFile : upload.getFiles()) {
	    	String fileName = multipartFile.getOriginalFilename();
			//Handle file content - multipartFile.getInputStream()
			BufferedOutputStream stream = null;
		    byte[] bytes;
		    String pathFile= path + File.separator + fileName;
		    
		    try {
		    	
				bytes = multipartFile.getBytes();
			    stream =new BufferedOutputStream(new FileOutputStream(new File(pathFile)));  
			    stream.write(bytes);  
			    
			    //doc file
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		    finally {
		    	try {
					stream.flush();
					stream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
		    
		    ArrayList<String[]> alString =  readFilesCSV(pathFile);
		    ArrayList<User> alUser = new ArrayList<User>();
		    for (String[] str : alString) {
				User u = new User(str[0], str[1], str[2], str[3], str[4]);
				new ImportDAO().insertDataFormFile(u);
			}
		    //System.out.println("size "+alUser.size());
		}

		return "redirect:importdata";
	}
	private ArrayList<String[]> readFilesCSV(String path){
		ArrayList<String[]> alString = new ArrayList<String[]>();
		BufferedReader br=null;
		try {
			br = new BufferedReader(new FileReader(path));
			String line;
			while((line = br.readLine()) !=null){
				System.out.println("ssss"+line);
				String[] b= line.split(",");
	             System.out.println(b[0]);
	             alString.add(b);
	        }
			
			return alString;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} 
        finally {
        	try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
        return null;
	}
}
