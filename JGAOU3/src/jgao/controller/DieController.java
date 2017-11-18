package jgao.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.beans.editors.LongEditor;

import jgao.dao.DieDAO;
import jgao.dao.DieDAOImpl;
import jgao.model.Die;



/**
 * Servlet implementation class DieController
 */
@WebServlet("/DieController")
public class DieController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Die die;
	private List<Die> dies;
	private DieDAOImpl dieDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DieController() {
        super();
        die = new Die();
        dies = new ArrayList<Die>();
        dieDAO = new DieDAOImpl();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
if (request.getParameter("btn_save")!= null) {
			
			die.setAge(Long.parseLong(request.getParameter("age")));
			die.setService(request.getParameter("service"));
			die.setEnter_date(request.getParameter("enter_date"));
			die.setDie_date(request.getParameter("die_date"));
			die.setResult(request.getParameter("result"));
				
				
			if(die.getId()==0L) {
				dieDAO.createDie(die);
				}else {
				dieDAO.updateDie(die);
			}
			
			dies = dieDAO.readAllDies();
			request.setAttribute("dies", dies);
			request.getRequestDispatcher("die_list.jsp").forward(request, response);
			
		}else if (request.getParameter("btn_new")!=null) {
			die = new Die();
			request.getRequestDispatcher("die_form.jsp").forward(request, response);
			
		
		}else if(request.getParameter("btn_edit")!=null) {	
			try {
				Long id = Long.parseLong(request.getParameter("id"));
				die = dieDAO.readDie(id);
				
			}catch (Exception e) {
				
				die = new Die();
			}
			request.setAttribute("die", die);
			
			request.getRequestDispatcher("die_form.jsp").forward(request, response);
			
			
			
		}else if(request.getParameter("btn_delete")!=null) {
		
			
			try {
			Long id = Long.parseLong(request.getParameter("id"));
			dieDAO.deleteDie(id);
			dies = dieDAO.readAllDies();
			
			}catch(Exception e) {
				e.printStackTrace();
				
				
			}
			request.setAttribute("dies", dies);
			request.getRequestDispatcher("die_list.jsp").forward(request, response);
		}else {
			dies = dieDAO.readAllDies();
			request.setAttribute("dies", dies);
			request.getRequestDispatcher("die_list.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
