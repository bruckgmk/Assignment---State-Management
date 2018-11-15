import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebFilter(filterName="AuthFilter")
public class AuthFilter implements Filter {
    List<User> users = new ArrayList<>();


    @Override
    public void init(FilterConfig argo) throws ServletException {
        users = new Userdb().getUserdbms();
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");



        PrintWriter out = resp.getWriter();
        boolean flag = false;
        //out.print("OneThing");
        if(username!=null) {
            for (User usr : users) {
                //out.print(usr.getUsername() + " "+usr.getPassword());
                if (username.equals(usr.getUsername()) && password.equals(usr.getPassword())) {

                    filterChain.doFilter(req, resp);
                    flag = true;
                    break;
                }
            }
        }
        if(!flag){

           out.print("wrong user name/password");
            RequestDispatcher dispatcher = req.getRequestDispatcher("login");
            dispatcher.forward(req,resp);



        }
    }

    @Override
    public void destroy() {

    }
}
