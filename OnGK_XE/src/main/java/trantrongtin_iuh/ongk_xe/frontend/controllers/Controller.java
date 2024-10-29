package trantrongtin_iuh.ongk_xe.frontend.controllers;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import trantrongtin_iuh.ongk_xe.backend.dtos.XeDTO;
import trantrongtin_iuh.ongk_xe.frontend.models.XeModel;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "Controller", value = "/controller")
public class Controller extends HttpServlet {

    @Inject
    private XeModel xeModel;


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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        switch (action.toLowerCase()) {
            case "add_xe":
                addXe(req, resp);
                break;

            case "delete_xe":
                deleteXeTheoMa(req, resp);
                break;

            default:
                listXe(req, resp);
        }
    }

    //hàm xóa xe
    public void deleteXeTheoMa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String maXe = req.getParameter("maXeXoa");
        xeModel.deleteXe(maXe);
        listXe(req, resp);
    }
    //hàm thêm xe
public  void addXe(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String maXe = req.getParameter("maXe");
        String tenXe = req.getParameter("tenXe");
        String giaXe = req.getParameter("giaXe");
        String namSanXuat = req.getParameter("namSanXuat");
        String hangXe = req.getParameter("hangXe");

    XeDTO xeDTO = new XeDTO(maXe, tenXe, Integer.parseInt(giaXe), Integer.parseInt(namSanXuat), hangXe);
    xeModel.addXe(xeDTO);
    listXe(req, resp);
}

public void findXe(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
String giaXe = req.getParameter("giaXe"); // Lấy tham số từ form
    if(giaXe!=null) {
        try {
            List<XeDTO> xeDTO = xeModel.searchXe(Integer.parseInt(giaXe)); // Tìm kiếm xe theo giá
            req.setAttribute("xe", xeDTO);
            req.getRequestDispatcher("/TimXe.jsp").forward(req, resp); // Chuyển tiếp đến TimXe.jsp

        } catch (Exception e) {
            req.setAttribute("error", "Không tìm thấy xe với giá: " + giaXe);
            req.getRequestDispatcher("/index.jsp").forward(req, resp); // Chuyển tiếp về index.jsp nếu không tìm thấy
        }
    }
    }

    //hàm xuất danh     sách xe
    public void listXe(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("list_xe", xeModel.danhSachXe()); // Đặt thuộc tính cho request
            req.getRequestDispatcher("/index.jsp").forward(req, resp); // Chuyển tiếp đến index.jsp

        } catch (Exception e) {
            req.setAttribute("error", "Không thể lấy danh sách sản phẩm");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }


}
