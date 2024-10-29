package trantrongtin_iuh.gk_xe_payara.backend.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class XeDTO implements Serializable {
    private  String maXe;
    private String tenXe;
    private int namSanXuat;
    private String hangXe;

    public XeDTO() {
    }

    public XeDTO(String maXe, String tenXe, int namSanXuat, String hangXe) {
        this.maXe = maXe;
        this.tenXe = tenXe;
        this.namSanXuat = namSanXuat;
        this.hangXe = hangXe;
    }

    @Override
    public String toString() {
        return "XeDTO{" +
                "maXe='" + maXe + '\'' +
                ", tenXe='" + tenXe + '\'' +
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
