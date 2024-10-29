package trantrongtin_iuh.gk_xe_payara.frontend.models;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Request;
import trantrongtin_iuh.gk_xe_payara.backend.dtos.XeDTO;

import java.util.List;

public class XeMoldel {
    private static  final  String URL = "http://localhost:8080/GK_Xe_Payara-1.0-SNAPSHOT/api/xe";
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
            target = client.target(URL).path(path);
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



            //hàm hiển thị danh sách xe
    public List<XeDTO> danhSachXe() {
        return executeRequest("", new TypeReference<List<XeDTO>>() {
        });
    }


    //hàm tìm kiếm theo tên
    public XeDTO findByName(String name) {
        return executeRequest("/" + name, XeDTO.class);
    }


    //hàm add xe mới theo tên hãng xe
    public Request addXeMoi(XeDTO xeDTO) {
        try (Client client = ClientBuilder.newClient()) {
            WebTarget target = client.target(URL).path("");
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
