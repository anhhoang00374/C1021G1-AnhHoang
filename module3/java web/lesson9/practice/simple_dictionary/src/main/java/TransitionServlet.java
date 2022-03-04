import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "TransitionServlet", value = "/translate")
public class TransitionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String,String> dictionary = new HashMap<>();
        dictionary.put("hello","xin chào");
        dictionary.put("book","quyển vở");
        dictionary.put("how","thế nào");
        dictionary.put("computer","máy tính");

        String wordE = request.getParameter("txtSearch");
        String wordV = dictionary.get(wordE);

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        if(wordE.length()>0){
           if(dictionary.containsKey(wordE)){

               writer.println("Word: " + wordE);
               writer.println("Result: " + wordV);
           } else {
               writer.println("Not found");
           }
        } else {
            writer.println("Please input value");
        }

        writer.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String,String> dictionary = new HashMap<>();
        dictionary.put("hello","xin chào");
        dictionary.put("book","quyển vở");
        dictionary.put("how","thế nào");
        dictionary.put("computer","máy tính");

        String wordE = request.getParameter("txtSearch");
        String wordV = dictionary.get(wordE);

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        if(wordE.length()>0){
            if(dictionary.containsKey(wordE)){

                writer.println("Word: " + wordE);
                writer.println("Result: " + wordV);
            } else {
                writer.println("Not found");
            }
        } else {
            writer.println("Please input value");
        }

        writer.println("</html>");

    }
}
