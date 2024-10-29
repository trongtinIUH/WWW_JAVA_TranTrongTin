package trantrongtin_iuh.gk_xe_payara.frontend.controllers;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import trantrongtin_iuh.gk_xe_payara.backend.dtos.XeDTO;
import trantrongtin_iuh.gk_xe_payara.frontend.models.XeMoldel;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "Controller", value = "/controller")
public class Controller extends HttpServlet {
    @Inject
    private XeMoldel xeMoldel;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "list_xe"; // Default action
        }

        switch (action.toLowerCase()) {
            case "list_xe":
                listXe(req, resp);
                break;
            case "find_xe":
                findXe(req, resp);
                break;
            default:
                listXe(req, resp);
        }
    }

    public void listXe(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<XeDTO> xeDTOList = xeMoldel.danhSachXe(); // Lấy danh sách xe từ XeMoldel
            req.setAttribute("list_xe", xeDTOList); // Đặt thuộc tính cho request
            req.getRequestDispatcher("/index.jsp").forward(req, resp); // Chuyển tiếp đến index.jsp
        } catch (Exception e) {
            req.setAttribute("error", "Không thể lấy danh sách sản phẩm");   }
    }

    public void findXe(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nameParam = req.getParameter("tenXe"); // Lấy tham số từ form
        if (nameParam != null && !nameParam.isEmpty()) {
            try {
                XeDTO xeDTO = xeMoldel.findByName(nameParam); // Tìm kiếm xe theo tên
                if (xeDTO != null) { // Kiểm tra nếu tìm thấy xe
                    req.setAttribute("xe", xeDTO); // Đặt xe tìm thấy vào request
                    req.getRequestDispatcher("/TimXe.jsp").forward(req, resp); // Chuyển tiếp đến trang hiển thị xe
                } else {
                    req.setAttribute("error", "Không tìm thấy xe với tên: " + nameParam);
                    req.getRequestDispatcher("/index.jsp").forward(req, resp); // Chuyển tiếp về index.jsp nếu không tìm thấy
                }
            } catch (Exception e) {
                req.setAttribute("error", "Không thể tìm xe: " + e.getMessage());
                req.getRequestDispatcher("/index.jsp").forward(req, resp); // Chuyển tiếp về index.jsp nếu có lỗi
            }
        } else {
            req.setAttribute("error", "Tên xe không hợp lệ.");
            req.getRequestDispatcher("/index.jsp").forward(req, resp); // Chuyển tiếp về index.jsp nếu không có tên xe
        }
    }







    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action.toLowerCase()) {
            case "add_xe":
                addXe(req, resp);
                break;
            case "delete_xe":
              //  deleteXe(req, resp);
                break;
            case "update_xe":
                //updateXe(req, resp);
                break;
            default:
                listXe(req, resp);
        }
    }


    //hàm add
    public void addXe(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String maxe = req.getParameter("maXe");
        String tenxe = req.getParameter("tenXe");
        int namsanxuat = Integer.parseInt(req.getParameter("namSanXuat"));
        String mahangxe = req.getParameter("hangXe");

        XeDTO xeDTO = new XeDTO(maxe, tenxe, namsanxuat, mahangxe);
        xeMoldel.addXeMoi(xeDTO);
        listXe(req, resp);
    }
}
