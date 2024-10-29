package trantrongtin_iuh.gk_xe_payara.backend.api;

import jakarta.ejb.EJB;
import jakarta.persistence.NoResultException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import trantrongtin_iuh.gk_xe_payara.backend.bussiness.HangXeDAO;
import trantrongtin_iuh.gk_xe_payara.backend.bussiness.XeDAO;
import trantrongtin_iuh.gk_xe_payara.backend.dtos.XeDTO;
import trantrongtin_iuh.gk_xe_payara.backend.responsitories.entity.Xe;

import java.util.List;

@Path("/xe")
public class XeResource {
    @EJB
    private XeDAO xeDAO;

    @EJB
    private HangXeDAO hangXeDAO;


    @GET
    public Response danhSachXe(){
return Response.ok(xeDAO.danhSachXe()).build();
    }

    //tìm kiếm theo tên
    @GET
    @Path("/{name}")
    public Response findByName(@PathParam("name") String name){
        return Response.ok(xeDAO.findByName(name)).build();
    }


    //thêm xe mới theo tên hãng xe
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addXeMoi(XeDTO xeDTO) {
        try {
            // Chuyển đổi năm sản xuất sang Integer nếu cần thiết (không cần nếu đã là int)
            int namSanXuat = xeDTO.getNamSanXuat(); // Đã là kiểu int rồi

            // Tạo đối tượng Xe mới
            Xe xe = new Xe(xeDTO.getMaXe(), xeDTO.getTenXe(), namSanXuat, null);

            // Thêm xe mới theo tên hãng xe
            xeDAO.addXeMoiTheoHangXe(xe, xeDTO.getHangXe());

            return Response.status(Response.Status.CREATED).build();
        } catch (NoResultException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Hãng xe không tồn tại: " + xeDTO.getHangXe()).build();
        } catch (Exception e) {
            System.out.println("Error in addXeMoi: " + e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Lỗi khi thêm xe").build();
        }
    }


}
