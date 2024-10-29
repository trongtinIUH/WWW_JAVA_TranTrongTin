package trantrongtin_iuh.trantrongtin_21054421_may11.backend.dtos;

import com.sun.jna.WString;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public class XeDTO implements Serializable {
    private String maXe;
    private String tenXe;
    private int giaXe;
    private int namSanXuat;
    private String hangXe;

    public XeDTO() {
    }

    public XeDTO(String maXe, String tenXe, int giaXe, int namSanXuat, String hangXe) {
        this.maXe = maXe;
        this.tenXe = tenXe;
        this.giaXe = giaXe;
        this.namSanXuat = namSanXuat;
        this.hangXe = hangXe;
    }



    @Override
    public String toString() {
        return "XeDTO{" +
                "maXe='" + maXe + '\'' +
                ", tenXe='" + tenXe + '\'' +
                ", giaXe=" + giaXe +
                ", namSanXuat=" + namSanXuat +
                ", hangXe='" + hangXe + '\'' +
                '}';
    }

    public String getMaXe() {
        return maXe;
    }

    public void setMaXe(String maXe) {
        this.maXe = maXe;
    }

    public String getTenXe() {
        return tenXe;
    }

    public void setTenXe(String tenXe) {
        this.tenXe = tenXe;
    }

    public int getGiaXe() {
        return giaXe;
    }

    public void setGiaXe(int giaXe) {
        this.giaXe = giaXe;
    }

    public int getNamSanXuat() {
        return namSanXuat;
    }

    public void setNamSanXuat(int namSanXuat) {
        this.namSanXuat = namSanXuat;
    }

    public String getHangXe() {
        return hangXe;
    }

    public void setHangXe(String hangXe) {
        this.hangXe = hangXe;
    }
}
