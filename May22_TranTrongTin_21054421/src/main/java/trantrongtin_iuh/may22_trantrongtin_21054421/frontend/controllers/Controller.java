package trantrongtin_iuh.may22_trantrongtin_21054421.frontend.controllers;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import trantrongtin_iuh.may22_trantrongtin_21054421.backend.dtos.ThuocDTO;
import trantrongtin_iuh.may22_trantrongtin_21054421.backend.repository.entity.Loaithuoc;
import trantrongtin_iuh.may22_trantrongtin_21054421.frontend.models.ThuocModel;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "Controller", value = "/controller")
public class Controller  extends HttpServlet {
    @Inject
    private ThuocModel thuocModel;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "list_thuoc"; // Default action
        }
        switch (action.toLowerCase()) {
            case "list_thuoc":
                dsThuoc(req, resp);
                break;
            case "list_loaithuoc":
                dsloaiThuoc(req, resp);
                break;
            case "list_thuoctheotungloai":
                dsThuocTheoLoai(req, resp);
                break;
            default:
                dsThuocTheoLoai(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        switch (action.toLowerCase()) {
            case "add_thuoc":
                addThuoc(req, resp);
                break;

            case "delete_thuoc":
              //  deleteThuocTheoMa(req, resp);
                break;

            default:
                dsThuocTheoLoai(req, resp);
        }
    }

    //add thuốc
    public void addThuoc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String maThuoc = req.getParameter("maThuoc");
        String tenThuoc = req.getParameter("tenThuoc");
        int gia = Integer.parseInt(req.getParameter("giaThuoc"));
        int namSX = Integer.parseInt(req.getParameter("namSX"));
        String maLoai = req.getParameter("maLoai"); // Đổi từ loaiThuoc thành maLoai


        ThuocDTO thuocDTO = new ThuocDTO(maThuoc, tenThuoc, gia, namSX, maLoai);
        thuocModel.addThuoc(thuocDTO);
        dsThuocTheoLoai(req, resp);
    }

    public  void dsThuoc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     try{
         req.setAttribute("dsThuoc", thuocModel.danhSachThuoc());
         req.getRequestDispatcher("/dsThuoc.jsp").forward(req, resp);
     }catch (Exception e){
         e.printStackTrace();
     }
    }

    //ds loại thuốc
    public void dsloaiThuoc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            req.setAttribute("dsLoaiThuoc", thuocModel.danhSachLoaiThuoc());
            req.getRequestDispatcher("/dsloaiThuoc.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }}

    //ds thuốc theo  từng loại
    public void dsThuocTheoLoai(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("dsThuocTheoLoai", thuocModel.danhSachThuocTheoLoai());
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();}}

    //hàm thêm thuốc

}
