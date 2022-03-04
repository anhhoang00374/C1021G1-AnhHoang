import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<html>");
        if(("admin".equals(userName))&&("admin".equals(password))){
            printWriter.println("<h1> Welcome "+userName+ " to webSide </h1>");
        }else{
            printWriter.println("<h1>login error </h1>");
        }
        printWriter.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<html>");
        if(("admin".equals(userName))&&("admin".equals(password))){
            printWriter.println("<h1> Welcome "+userName+ " to webSide </h1>");
        }else{
            printWriter.println("<h1>Login Error </h1>");
        }
        printWriter.println("</html>");
    }
}
