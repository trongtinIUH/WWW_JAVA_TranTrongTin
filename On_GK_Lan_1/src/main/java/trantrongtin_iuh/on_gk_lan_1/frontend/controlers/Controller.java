package trantrongtin_iuh.on_gk_lan_1.frontend.controlers;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import trantrongtin_iuh.on_gk_lan_1.backend.dtos.UserDTO;
import trantrongtin_iuh.on_gk_lan_1.frontend.models.UserModel;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "Controller", value = "/controller")
public class Controller extends HttpServlet {
    @Inject
    private UserModel userModel;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action.toLowerCase()) {
            case "add_user":
                addUser(req, resp);
                break;
            case "delete_user":
                deleteUser(req, resp);
                break;
            case "update_user":
                updateUser(req, resp);
                break;
            default:
                listUsers(req, resp);
        }
    }

    private void addUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String facebook = req.getParameter("facebook");
        String bio = req.getParameter("bio");
        UserDTO user = new UserDTO(firstName, lastName, username, password, email, facebook, bio);
        userModel.addUser(user);
        resp.sendRedirect("http://localhost:8080/On_GK_Lan_1-1.0-SNAPSHOT/api/users");
    }

    private void deleteUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idparam = req.getParameter("id");
        if (idparam != null && !idparam.isEmpty()) {
            try {
                int id = Integer.parseInt(idparam);
                userModel.deleteUser(id);
                return;
            } catch (Exception e) {
                req.setAttribute("error", e.getMessage());
                req.getRequestDispatcher("/error.jsp").forward(req, resp);
            }
        }
        listUsers(req, resp);
    }

    private void updateUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idparam = req.getParameter("id");
        if (idparam != null && !idparam.isEmpty()) {
            try {
                int id = Integer.parseInt(idparam);
                UserDTO userDTO = userModel.getUserById(id);
                if (userDTO != null) {

                    String firstName = req.getParameter("firstName");
                    String lastName = req.getParameter("lastName");
                    String username = req.getParameter("username");
                    String email = req.getParameter("email");
                    String password = req.getParameter("password");
                    String facebook = req.getParameter("facebook");
                    String bio = req.getParameter("bio");

userDTO.setFirstName(firstName);
userDTO.setLastName(lastName);
userDTO.setUsername(username);
userDTO.setEmail(email);
userDTO.setPassword(password);
userDTO.setFacebook(facebook);
userDTO.setBio(bio);


                    userModel.updateUser(userDTO);
                    resp.sendRedirect("http://localhost:8080/On_GK_Lan_1-1.0-SNAPSHOT/api/users/" + id);
                }else {
                    req.setAttribute("error", "Không tìm thấy user với ID đã nhập.");
                }
            } catch (Exception e) {
                req.setAttribute("error", e.getMessage());
                req.getRequestDispatcher("/error.jsp").forward(req, resp);
            }
        }
        listUsers(req, resp);
    }




    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
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
            List<UserDTO> users = userModel.getAllUsers();
            resp.sendRedirect("http://localhost:8080/On_GK_Lan_1-1.0-SNAPSHOT/api/users");
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", e.getMessage());
            req.getRequestDispatcher("/error.jsp").forward(req, resp);
        }
    }
        //findUser
    private void findUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idparam = req.getParameter("id");
        if (idparam != null && !idparam.isEmpty()) {

            try {
                int id = Integer.parseInt(idparam);
                UserDTO user = userModel.getUserById(id);
                if (user!=null) {
                   resp.sendRedirect("http://localhost:8080/On_GK_Lan_1-1.0-SNAPSHOT/api/users/"+id);
                   return;
                } else {
                    req.setAttribute("error", "User not found");
                }
            } catch (Exception e) {
                e.printStackTrace();
                req.setAttribute("error", e.getMessage());
                req.getRequestDispatcher("/error.jsp").forward(req, resp);
            }
        }listUsers(req, resp);
    }
}