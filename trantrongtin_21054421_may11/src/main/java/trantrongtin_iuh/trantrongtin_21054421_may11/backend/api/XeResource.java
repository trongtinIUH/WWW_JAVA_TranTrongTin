package trantrongtin_iuh.trantrongtin_21054421_may11.backend.api;

import jakarta.ejb.EJB;
import jakarta.persistence.NoResultException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import trantrongtin_iuh.trantrongtin_21054421_may11.backend.bussiness.HangXeDAO;
import trantrongtin_iuh.trantrongtin_21054421_may11.backend.bussiness.XeDAO;
import trantrongtin_iuh.trantrongtin_21054421_may11.backend.dtos.XeDTO;
import trantrongtin_iuh.trantrongtin_21054421_may11.backend.repositories.entity.Xe;

@Path("/xe")
public class XeResource {

    @EJB
   private XeDAO xeDAO;
    @EJB
    private HangXeDAO hangXeDAO;

    //hàm get all xe
    @GET
    public Response danhSachXe(){
        return Response.ok(xeDAO.danhSachXe()).build();
    }

    //hàm tìm kiếm xe theo giá
    @GET
    @Path("/{giaXe}")
    public Response searchXe(@PathParam("giaXe") int giaXe){
        return Response.ok(xeDAO.searchXe(giaXe)).build();
    }

    //hàm add xe mới theo tên hãng xe
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addXeMoi(XeDTO xeDTO) {
        try {
            // Chuyển đổi năm sản xuất sang Integer nếu cần thiết (không cần nếu đã là int)
            int namSanXuat = xeDTO.getNamSanXuat(); // Đã là kiểu int rồi

            // Tạo đối tượng Xe mới
            Xe xe = new Xe(
                    xeDTO.getMaXe(),
                    xeDTO.getTenXe(),
                    xeDTO.getGiaXe(),
                    namSanXuat,
                    null);

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
