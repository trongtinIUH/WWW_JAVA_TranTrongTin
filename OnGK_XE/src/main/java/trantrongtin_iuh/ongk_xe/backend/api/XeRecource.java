package trantrongtin_iuh.ongk_xe.backend.api;

import jakarta.ejb.EJB;
import jakarta.persistence.NoResultException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.Getter;
import trantrongtin_iuh.ongk_xe.backend.buiness.HangXeDAO;
import trantrongtin_iuh.ongk_xe.backend.buiness.XeDAO;
import trantrongtin_iuh.ongk_xe.backend.dtos.XeDTO;
import trantrongtin_iuh.ongk_xe.backend.repository.entity.Xe;

@Path("/xe")
public class XeRecource  {
    @EJB
    private XeDAO xeDAO;

    @EJB
    private HangXeDAO hangXeDAO;

    @GET
    public Response danhSachXe(){
        return Response.ok(xeDAO.danhSachXe()).build();
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addXeMoi(XeDTO xeDTO) {
        try {
            int namSanXuat = xeDTO.getNamSanXuat();
            Xe xe = new Xe(
                    xeDTO.getMaXe(),
                    xeDTO.getTenXe(),
                    xeDTO.getGiaXe(),
                    namSanXuat,
                    null);
            xeDAO.addXeMoiTheoHangXe(xe, xeDTO.getHangXe());
            return Response.status(Response.Status.CREATED).build();
        } catch (NoResultException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Hãng xe không tồn tại: " + xeDTO.getHangXe()).build();
        } catch (Exception e) {
            System.out.println("Error in addXeMoi: " + e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Lỗi khi thêm xe").build();
        }
    }

    //hàm tìm
    @GET
    @Path("/{giaXe}")
    public Response searchXe(@PathParam("giaXe") int giaXe){
        return Response.ok(xeDAO.searchXe(giaXe)).build();
    }

    //xóa xe theo mã xe
    @DELETE
    @Path("/{maXe}")
    public Response deleteXe(@PathParam("maXe") String maXe){
        xeDAO.deleteXe(maXe);
        return Response.ok().build();
    }
}
