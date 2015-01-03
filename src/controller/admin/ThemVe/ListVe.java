package controller.admin.ThemVe;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.DuongDan;
import model.NhanVien;
import model.ThongTinVe;
import DAO.VeDAO;
import DAO.VeDAOImpl;

/**
 * Servlet implementation class ListVe
 */
public class ListVe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListVe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		NhanVien nv = (NhanVien) session.getAttribute("admin");
		if(nv!=null){
			VeDAO ve = new VeDAOImpl();
//			List<Ve> listVe = ve.getAllVe();
//			request.setAttribute("listVe", listVe);
			request.getRequestDispatcher(DuongDan.THEM_VE_SVL).forward(request, response);
		}else{
			request.setAttribute("pageFoward", DuongDan.LIST_VE_SV);
			request.getRequestDispatcher(DuongDan.DANG_NHAP_ADMIN_SVL).forward(request, response);
		}
	}

}
