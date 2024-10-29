package trantrongtin_iuh.may22_trantrongtin_21054421.frontend.models;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import trantrongtin_iuh.may22_trantrongtin_21054421.backend.dtos.ThuocDTO;
import trantrongtin_iuh.may22_trantrongtin_21054421.backend.repository.entity.Loaithuoc;
import trantrongtin_iuh.may22_trantrongtin_21054421.backend.repository.entity.Thuoc;

import java.util.List;

public class ThuocModel {
    private static final String url = "http://localhost:8080/May22_TranTrongTin_21054421-1.0-SNAPSHOT/api/thuoc";
    private final ObjectMapper mapper = new ObjectMapper();
    @FunctionalInterface
    private interface ThrowingFunction<T, R> {
        R apply(T t) throws Exception;
    }
    private <T> T executeRequest(String path, Class<T> responseType) {
        return executeRequestInternal(path, json -> mapper.readValue(json, responseType));
    }

    private <T> T executeRequest(String path, TypeReference<T> typeReference) {
        return executeRequestInternal(path, json -> mapper.readValue(json, typeReference));
    }

    private <T> T executeRequestInternal(String path, ThrowingFunction<String, T> jsonParser) {
        WebTarget target = null;
        try (Client client = ClientBuilder.newClient()) {
            target = client.target(url).path(path);
            String json = target
                    .request(MediaType.APPLICATION_JSON)
                    .get(String.class);
            return jsonParser.apply(json);
        } catch (Exception e) {
            String errorMessage = "Error fetching data from path: " + e;
            System.out.println(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
    }

    //hàm xuất danh sách thuốc
    public List<Thuoc> danhSachThuoc() {
        return executeRequest("dsthuoc", new TypeReference<List<Thuoc>>() {});
    }

    //hàm xuất danh sách loại thuốc
    public List<Loaithuoc> danhSachLoaiThuoc() {
        return executeRequest("loaithuoc", new TypeReference<List<Loaithuoc>>() {});
    }

    //hàm xuất danh sách thuốc theo  từng loại
    public List<ThuocDTO> danhSachThuocTheoLoai() {
        return executeRequest("thuoctheoloai", new TypeReference<List<ThuocDTO>>() {});
    }

    //hàm add thuốc mới
    public void addThuoc(ThuocDTO thuocDTO) {
        try (Client client = ClientBuilder.newClient()) {
            client.target(url)
                    .request(MediaType.APPLICATION_JSON)
                    .post(jakarta.ws.rs.client.Entity.entity(thuocDTO, MediaType.APPLICATION_JSON));
        } catch (Exception e) {
            String errorMessage = "Error adding new Thuoc: " + e;
            System.out.println(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
    }
}
