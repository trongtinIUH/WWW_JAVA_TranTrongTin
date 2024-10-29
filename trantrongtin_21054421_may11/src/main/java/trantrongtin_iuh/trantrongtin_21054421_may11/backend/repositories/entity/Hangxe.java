package trantrongtin_iuh.trantrongtin_21054421_may11.backend.repositories.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "hangxe")
public class Hangxe implements Serializable {
    @Id
    @Size(max = 10)
    @Column(name = "MAHANGXE", nullable = false, length = 10)
    private String maHangXe;

    @Size(max = 50)
    @Column(name = "TENHANG", length = 50)
    private String tenHang;

    @Size(max = 50)
    @Column(name = "QUOCGIA", length = 50)
    private String quocGia;

    @Size(max = 50)
    @Column(name = "MOTA", length = 50)
    private String moTa;

    @OneToMany(mappedBy = "maHangXe")
    private List<Xe> xes = new ArrayList<>();

    public Hangxe() {
    }

    public Hangxe(String mota, String quocgia, String tenhang, String mahangxe) {
        this.moTa = mota;
        this.quocGia = quocgia;
        this.tenHang = tenhang;
        this.maHangXe = mahangxe;
    }

    @Override
    public String toString() {
        return "Hangxe{" +
                "maHangXe='" + maHangXe + '\'' +
                ", tenHang='" + tenHang + '\'' +
                ", quocGia='" + quocGia + '\'' +
                ", moTa='" + moTa + '\'' +
                ", xes=" + xes +
                '}';
    }

    public @Size(max = 10) String getMaHangXe() {
        return maHangXe;
    }

    public void setMaHangXe(@Size(max = 10) String maHangXe) {
        this.maHangXe = maHangXe;
    }

    public @Size(max = 50) String getTenHang() {
        return tenHang;
    }

    public void setTenHang(@Size(max = 50) String tenHang) {
        this.tenHang = tenHang;
    }

    public @Size(max = 50) String getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(@Size(max = 50) String quocGia) {
        this.quocGia = quocGia;
    }

    public @Size(max = 50) String getMoTa() {
        return moTa;
    }

    public void setMoTa(@Size(max = 50) String moTa) {
        this.moTa = moTa;
    }

    public List<Xe> getXes() {
        return xes;
    }

    public void setXes(List<Xe> xes) {
        this.xes = xes;
    }
}