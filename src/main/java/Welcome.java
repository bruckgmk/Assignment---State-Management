import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.*;

@WebServlet("/Welcome")
public class Welcome extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean flag = (request.getParameter("rememberme")!=null?true:false);

        User user= new User(username,password,flag);
        HttpSession session = request.getSession();
        session.setAttribute("user",user);
        Cookie cookie = new Cookie("Name",username);
        if(request.getParameter("rememberme")!=null){
            System.out.println("Yes Cookie");
            cookie.setMaxAge(30*24*60*60);
            response.addCookie(cookie);
        }
        else{
            System.out.println("No Cookie");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }

        PrintWriter out = response.getWriter();

        out.print("<html><head><title>ViewPage</title></head>");
        out.print("<body><p>Welcome " + username);
        out.print("</p>");
        out.print("<form action='Logout' method='GET'>");
        out.print("<input type='submit' value='Logout' />");
        out.print("</form></body></html>");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
