package trantrongtin_iuh.may22_trantrongtin_21054421.backend.api;

import jakarta.ejb.EJB;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import trantrongtin_iuh.may22_trantrongtin_21054421.backend.bussiness.QuanLyThuocDAO;
import trantrongtin_iuh.may22_trantrongtin_21054421.backend.dtos.ThuocDTO;
import trantrongtin_iuh.may22_trantrongtin_21054421.backend.repository.entity.Thuoc;

@Path( "/thuoc" )
public class ThuocResource {
    @EJB
    private QuanLyThuocDAO quanLyThuocDAO;


    //danh sách thuốc
    @GET
    @Path("/dsthuoc")
    public Response danhSachThuoc() {
       return Response.ok(quanLyThuocDAO.danhSachThuoc()).build();
    }

    // danh sách loại thuốc
    @GET
    @Path("/loaithuoc")
    public Response danhSachLoaiThuoc() {
        return Response.ok(quanLyThuocDAO.danhSachLoaiThuoc()).build();
    }

    //danh sách thuốc theo loại
    @GET
    @Path("/thuoctheoloai")
    public Response danhSachThuocTheoLoai() {
        return Response.ok(quanLyThuocDAO.danhSachThuocTheoLoai()).build();
    }

    //thêm thuốc
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addThuoc(ThuocDTO thuocDTO) {
        try {
            int namSX = thuocDTO.getNamSX();
            int giaThuoc = thuocDTO.getGiaThuoc();
            Thuoc thuoc = new Thuoc(
                    thuocDTO.getMaThuoc(),
                    thuocDTO.getTenThuoc(),
                    giaThuoc,
                    namSX,
                    null);
            quanLyThuocDAO.addThuoc(thuoc, thuocDTO.getMaLoai());
            return Response.status(Response.Status.CREATED).build();
        } catch (Exception e) {
            System.out.println("Error in addThuoc: " + e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Lỗi khi thêm thuốc").build();
        }
    }
}
