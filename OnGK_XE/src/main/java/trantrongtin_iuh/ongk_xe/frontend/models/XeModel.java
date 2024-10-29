package trantrongtin_iuh.ongk_xe.frontend.models;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import trantrongtin_iuh.ongk_xe.backend.dtos.XeDTO;

import java.util.List;

public class XeModel {
    private static final String url = "http://localhost:8080/OnGK_XE-1.0-SNAPSHOT/api/xe";
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


    //hàm ở đây
    //danh sách xe
    public List<XeDTO> danhSachXe() {
        return executeRequest("", new TypeReference<List<XeDTO>>() {});
    }

    //hàm addxe
    public void addXe(XeDTO xeDTO) {
        try (Client client = ClientBuilder.newClient()) {
            client.target(url)
                    .request(MediaType.APPLICATION_JSON)
                    .post(jakarta.ws.rs.client.Entity.entity(xeDTO, MediaType.APPLICATION_JSON));
        } catch (Exception e) {
            String errorMessage = "Error adding new Xe: " + e;
            System.out.println(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
    }

    //hàm tìm kiếm xe theo giá
    public List<XeDTO> searchXe(int giaXe) {
        return executeRequest("/" + giaXe, new TypeReference<List<XeDTO>>() {});
    }

    //hàm xóa xe theo mã xe
    public  void deleteXe(String maXe){
        try (Client client = ClientBuilder.newClient()) {
            client.target(url)
                    .path(maXe)
                    .request(MediaType.APPLICATION_JSON)
                    .delete();
        } catch (Exception e) {
            String errorMessage = "Error deleting Xe: " + e;
            System.out.println(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
    }
}
