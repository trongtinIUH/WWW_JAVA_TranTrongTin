package trantrongtin_iuh.trantrongtin_21054421_may11.frontend.Models;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Request;
import jakarta.ws.rs.core.Response;
import trantrongtin_iuh.trantrongtin_21054421_may11.backend.dtos.XeDTO;

import java.util.List;

public class XeModels {
    private static  final String url = "http://localhost:8080/trantrongtin_21054421_may11-1.0-SNAPSHOT/api/xe";
    private  final ObjectMapper mapper = new ObjectMapper();

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
    public List<XeDTO> danhSachXe() {
        return executeRequest("", new TypeReference<List<XeDTO>>() {});
    }


    //tìm kiếm theo giá xe
    public List<XeDTO> searchXe(int giaXe) {
        return executeRequest("/" + giaXe, new TypeReference<List<XeDTO>>() {});
    }

//hàm add xe mới theo tên hãng
    public Request addXeMoi(XeDTO xeDTO) {
        try (Client client = ClientBuilder.newClient()) {
            WebTarget target = client.target(url).path("");
            return  target
                    .request(MediaType.APPLICATION_JSON)
                    .post(Entity.entity(xeDTO, MediaType.APPLICATION_JSON), Request.class);
        } catch (Exception e) {
            String errorMessage = "Error adding product: " + e;
            System.out.println(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
    }
}
