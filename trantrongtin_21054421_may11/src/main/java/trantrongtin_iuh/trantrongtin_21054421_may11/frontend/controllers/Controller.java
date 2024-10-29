package trantrongtin_iuh.trantrongtin_21054421_may11.frontend.controllers;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import trantrongtin_iuh.trantrongtin_21054421_may11.backend.dtos.XeDTO;
import trantrongtin_iuh.trantrongtin_21054421_may11.frontend.Models.XeModels;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "Controller", value = "/controller")
public class Controller extends HttpServlet {
    @Inject
    private XeModels xeModels;


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

    //list all xe
    public void listXe(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<XeDTO> xeDTOList = xeModels.danhSachXe(); // Lấy danh sách xe
            req.setAttribute("list_xe", xeDTOList); // Đặt thuộc tính cho request
            req.getRequestDispatcher("/index.jsp").forward(req, resp); // Chuyển tiếp đến index.jsp

        } catch (Exception e) {
            req.setAttribute("error", "Không thể lấy danh sách sản phẩm");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }


    //hàm find xe theo giá
    public void findXe(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String giaXe = req.getParameter("giaXe"); // Lấy tham số từ form
        if (giaXe != null && !giaXe.isEmpty()) {
            try {
                List<XeDTO> xeDTO = xeModels.searchXe(Integer.parseInt(giaXe)); // Tìm kiếm xe theo giá
               // req.setAttribute("xe", xeModels.searchXe(Integer.parseInt(giaXe))); // Đặt thuộc tính cho request
                req.setAttribute("xe", xeDTO);
                req.getRequestDispatcher("/TimXe.jsp").forward(req, resp); // Chuyển tiếp đến TimXe.jsp
            } catch (Exception e) {
                req.setAttribute("error", "Không tìm thấy xe với giá: " + giaXe);
                req.getRequestDispatcher("/index.jsp").forward(req, resp); // Chuyển tiếp về index.jsp nếu không tìm thấy
            }
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
    //add xe
    public void addXe(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String maXe = req.getParameter("maXe");
        String tenXe = req.getParameter("tenXe");
        int namSanXuat = Integer.parseInt(req.getParameter("namSanXuat"));
        int giaXe = Integer.parseInt(req.getParameter("giaXe"));
        String tenHangXe = req.getParameter("tenHangXe");

        XeDTO xeDTO = new XeDTO(maXe, tenXe,giaXe, namSanXuat,  tenHangXe);
        xeModels.addXeMoi(xeDTO);
        listXe(req, resp);
    }


}
