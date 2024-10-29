package trantrongtin_iuh.ongk_xe.backend.repository.entity;

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

    @OneToMany(mappedBy = "maHangxe")
    private List<Xe> xes = new ArrayList<>();

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

    public Hangxe() {
    }

    public Hangxe(String maHangXe, String tenHang, String quocGia, String moTa) {
        this.maHangXe = maHangXe;
        this.tenHang = tenHang;
        this.quocGia = quocGia;
        this.moTa = moTa;
    }
}