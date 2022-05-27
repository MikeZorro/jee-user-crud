package pl.coderslab.users;

import pl.coderslab.utils.User;
import pl.coderslab.utils.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "userShow", value = "/user/show")
public class userShow extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO userDAO= new UserDAO();
        try {
            User user = userDAO.read(Integer.parseInt(request.getParameter("id")));
            request.setAttribute("user", user);
            getServletContext().getRequestDispatcher("/users/details.jsp").forward(request, response);
        } catch (NumberFormatException e){
            response.sendRedirect("/user/list");
        }
    }

}
