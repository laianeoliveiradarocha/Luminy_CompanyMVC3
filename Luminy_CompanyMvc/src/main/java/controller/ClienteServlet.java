Package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

import dao.ClienteDAO;
import modelos.Clientes



Import java.io.IOException;
Import java.util.List;
 
Import javax.servlet.RequestDispatcher;
 
 
@WebServlet(urlPatterns = {"/cliente", "/cliente-create", "/cliente-edit", "/cliente-update", "/usuario-delete"})
Public class ClienteServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  ClienteDAO cdao = new ClienteDAO();
  Clientes cliente = new Clientes();
       
    Public ClienteServlet() {
        Super();
    }
 
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    String action = request.getServletPath();
    
    switch (action) {
    case "/cliente”:
      read(request, response);
      break;
    case "/cliente-create”:
      create(request, response);
      break;
    case "/cliente-delete”:
      delete(request, response);
      break;
    default:
      response.sendRedirect("index.html”);
      break;
    }
    
  }
  
  protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    List lista = cdao.read();
    
    request.setAttribute("listaClientes”, lista);
    
    RequestDispatcher rd = request.getRequestDispatcher("./views/clientes/index.jsp");
    rd.forward(request, response);
    
  }
  
  protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    cliente.setNome(request.getParameter("nome"));
    cliente.setEmail(request.getParameter("email"));
    cliente.setSenha(request.getParameter("senha"));
    
    cdao.create(cliente);
    response.sendRedirect("cliente");
  }
  
 
  protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int id = Integer.parseInt(request.getParameter(“id”));
    cdao.delete(id);
    response.sendRedirect("cliente");  
  }
 
}
