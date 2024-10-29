package trantrongtin_iuh.on_gk_lan_1.frontend.models;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Request;
import jakarta.ws.rs.core.Response;
import trantrongtin_iuh.on_gk_lan_1.backend.dtos.UserDTO;

import java.util.List;

public class UserModel {
    private static final String URL = "http://localhost:8080/On_GK_Lan_1-1.0-SNAPSHOT/api/users";
    private final ObjectMapper mapper = new ObjectMapper();

    @FunctionalInterface
    public interface ThrowingFunction<T, R> {
        R apply(T t) throws Exception;

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

    private <T> T executeRequest(String path, Class<T> responseType) {
        return executeRequestInternal(path, json -> mapper.readValue(json, responseType));
    }

    private <T> T executeRequest(String path, TypeReference<T> typeReference) {
        return executeRequestInternal(path, json -> mapper.readValue(json, typeReference));
    }


    public List<UserDTO> getAllUsers() {
        return executeRequest("", new TypeReference<List<UserDTO>>() {
        });
    }

    public UserDTO getUserById(int id) {
        return executeRequest("/" + id, UserDTO.class);
    }

    public Request addUser(UserDTO userDTO) {
        try (Client client = ClientBuilder.newClient()) {
            WebTarget target = client.target(URL).path("");
           return target
                    .request(MediaType.APPLICATION_JSON)
                    .post(Entity.entity(userDTO, MediaType.APPLICATION_JSON), Request.class);
        } catch (Exception e) {
            String errorMessage = "Error adding user: " + e;
            System.out.println(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
    }

    public Response updateUser(UserDTO userDTO) {
        try (Client client = ClientBuilder.newClient()) {
            WebTarget target = client.target(URL).path("/" + userDTO.getId());
            return target
                    .request(MediaType.APPLICATION_JSON)
                    .put(Entity.entity(userDTO, MediaType.APPLICATION_JSON), Response.class);
        } catch (Exception e) {
            String errorMessage = "Error updating user: " + e;
            System.out.println(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
    }

    public Response deleteUser(int id) {
        try (Client client = ClientBuilder.newClient()) {
            WebTarget target = client.target(URL).path("/" + id);
            return target
                    .request(MediaType.APPLICATION_JSON)
                    .delete(Response.class);
        } catch (Exception e) {
            String errorMessage = "Error deleting user: " + e;
            System.out.println(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
    }



}