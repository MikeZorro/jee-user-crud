package pl.coderslab.users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import pl.coderslab.utils.*;

@WebServlet(name = "user/list", value = "/user/list")
public class userlist extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserDAO userDao = new UserDAO();
        request.setAttribute("users", userDao.findAll());
        getServletContext().getRequestDispatcher("/users/list.jsp")
                .forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("id");
        if(name != null ){
            request.setAttribute("id", name);
            getServletContext().getRequestDispatcher("/users/show.jsp").forward(request, response);

        }
    }
}
