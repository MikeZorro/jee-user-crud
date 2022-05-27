package pl.coderslab.users;

import pl.coderslab.utils.User;
import pl.coderslab.utils.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "userDelete", value = "/user/delete")
public class userDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO userDAO= new UserDAO();
        User user = userDAO.read(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("user", user);
        getServletContext().getRequestDispatcher("/users/delete.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO userDAO = new UserDAO();
        String decision = request.getParameter("decision");
        if ("yes".equals(decision)) {
            userDAO.delete(Integer.parseInt(request.getParameter("id")));
            response.sendRedirect("/user/list");
        } else {
            response.sendRedirect("/user/list");

        }

    }
}
