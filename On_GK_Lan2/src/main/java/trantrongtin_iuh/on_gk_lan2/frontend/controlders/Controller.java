package trantrongtin_iuh.on_gk_lan2.frontend.controlders;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import trantrongtin_iuh.on_gk_lan2.backend.dtos.UserDTO;
import trantrongtin_iuh.on_gk_lan2.frontend.models.UserModel;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "Controller", value = "/controller")
public class Controller extends HttpServlet {
    @Inject
    private UserModel userModel;

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



    private void listUsers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<UserDTO> users = userModel.getAllUsers();
            resp.sendRedirect("http://localhost:8080/On_GK_Lan2-1.0-SNAPSHOT/api/users");
        } catch (Exception e) {
            req.setAttribute("error", e.getMessage());

        }
    }

    private void findUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");
        if (idParam != null && !idParam.isEmpty()) {
            try {
                int id = Integer.parseInt(idParam);
                UserDTO user = userModel.getUserById(id);
                if(user != null) {
                    resp.sendRedirect("http://localhost:8080/On_GK_Lan2-1.0-SNAPSHOT/api/users/"+id);
                    return;
                }else{
                    req.setAttribute("error", "User not found");
                    req.getRequestDispatcher("error.jsp").forward(req, resp);
                }


            } catch (Exception e) {
                req.setAttribute("error", e.getMessage());
                req.getRequestDispatcher("error.jsp").forward(req, resp);
            }
        } listUsers(req, resp);
    }


    private void addUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName(req.getParameter("firstName"));
        userDTO.setLastName(req.getParameter("lastName"));
        userDTO.setUsername(req.getParameter("username"));
        userDTO.setPassword(req.getParameter("password"));
        userDTO.setEmail(req.getParameter("email"));
        userDTO.setFacebook(req.getParameter("facebook"));
        userDTO.setBio(req.getParameter("bio"));
        try {
            userModel.addUser(userDTO);
            resp.sendRedirect("http://localhost:8080/On_GK_Lan2-1.0-SNAPSHOT/api/users");
        } catch (Exception e) {
            req.setAttribute("error", e.getMessage());
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }
    //hàm update
    private void updateUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
String idParam = req.getParameter("id");
if(idParam !=null && !idParam.isEmpty()) {
    try{
        int id = Integer.parseInt(idParam);
        UserDTO userDTO = userModel.getUserById(id);
        if(userDTO != null) {
            userDTO.setFirstName(req.getParameter("firstName"));
            userDTO.setLastName(req.getParameter("lastName"));
            userDTO.setUsername(req.getParameter("username"));
            userDTO.setPassword(req.getParameter("password"));
            userDTO.setEmail(req.getParameter("email"));
            userDTO.setFacebook(req.getParameter("facebook"));
            userDTO.setBio(req.getParameter("bio"));
            userModel.updateUser(userDTO);
            resp.sendRedirect("http://localhost:8080/On_GK_Lan2-1.0-SNAPSHOT/api/users");
        }else{
            req.setAttribute("error", "User not found");
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    } catch (Exception e) {
        req.setAttribute("error", e.getMessage());
        req.getRequestDispatcher("error.jsp").forward(req, resp);
    }
}else {
    req.setAttribute("error", "Id is required");
    req.getRequestDispatcher("error.jsp").forward(req, resp);
}
        listUsers(req, resp);
    }



    //hàm delete
    private  void deleteUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");
        if(idParam != null && !idParam.isEmpty()) {
            try {
                int id = Integer.parseInt(idParam);
                userModel.deleteUser(id);
                resp.sendRedirect("http://localhost:8080/On_GK_Lan2-1.0-SNAPSHOT/api/users");
            } catch (Exception e) {
                req.setAttribute("error", e.getMessage());
                req.getRequestDispatcher("error.jsp").forward(req, resp);
            }
        }
    }

}
