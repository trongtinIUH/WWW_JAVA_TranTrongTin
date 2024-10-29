package trantrongtin_iuh.ongk_lan3_tomcat.controllders;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import trantrongtin_iuh.ongk_lan3_tomcat.entity.User;
import trantrongtin_iuh.ongk_lan3_tomcat.service.UserService;

import java.io.IOException;

@WebServlet(name = "Controller", urlPatterns = "/Controller")
public class Controller extends HttpServlet {

    private UserService userService = new UserService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null) {
            action = "list_users";
        }
        switch (action.toLowerCase()) {
            case "list_users":
                listUsers(req, resp);
                break;
            case "find_user":
                findUser(req, resp);
                break;
            default:
                listUsers(req, resp);
        }
    }


    private void listUsers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // Lấy danh sách người dùng từ service và gán vào request attribute
            req.setAttribute("users", userService.getAllUser());
            // Chuyển tiếp tới trang JSP để hiển thị danh sách người dùng
            req.getRequestDispatcher("list_users.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void findUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            req.setAttribute("user", userService.findUserById(id));
            req.getRequestDispatcher("find_user.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action.toLowerCase()) {
            case "add_user":
                addUser(req, resp);
                break;

            default:
                listUsers(req, resp);
        }
    }

    private void addUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String username = req.getParameter("username");
            String firstName = req.getParameter("firstName");
            String lastName = req.getParameter("lastName");
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            String facebook = req.getParameter("facebook");
            String bio = req.getParameter("bio");

            // Validate input parameters
            if (username == null || firstName == null || lastName == null || email == null || password == null) {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing required parameters");
                return;
            }

            User user = new User(firstName, lastName, username, password, email, facebook, bio);
            userService.addUser(user);
            resp.sendRedirect("Controller?action=list_users");
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while adding the user");
        }
    }
}