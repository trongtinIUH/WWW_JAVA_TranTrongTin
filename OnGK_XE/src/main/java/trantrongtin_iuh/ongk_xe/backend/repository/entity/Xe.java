package trantrongtin_iuh.ongk_xe.backend.repository.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;



@Entity
@Table(name = "xe")
@NamedQueries(
        {
                @NamedQuery(name = "Xe.findAll", query = "SELECT x FROM Xe x"),
                @NamedQuery(name = "Xe.findByMaXe", query = "SELECT x FROM Xe x WHERE x.maXe = :maXe")
        }
)
public class Xe implements Serializable {
    @Id
    @Size(max = 10)
    @Column(name = "MAXE", nullable = false, length = 10)
    private String maXe;

    @Size(max = 50)
    @Column(name = "TENXE", length = 50)
    private String tenXe;

    @Column(name = "GIAXE")
    private Integer giaXe;

    @Column(name = "NAMSANXUAT")
    private Integer namSanXuat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MAHANGXE")
    private Hangxe maHangxe;

    public Xe() {
    }

    public Xe(String maXe, String tenXe, Integer giaXe, Integer namSanXuat, Hangxe maHangxe) {
        this.maXe = maXe;
        this.tenXe = tenXe;
        this.giaXe = giaXe;
        this.namSanXuat = namSanXuat;
        this.maHangxe = maHangxe;
    }

    public @Size(max = 10) String getMaXe() {
        return maXe;
    }

    public void setMaXe(@Size(max = 10) String maXe) {
        this.maXe = maXe;
    }

    public @Size(max = 50) String getTenXe() {
        return tenXe;
    }

    public void setTenXe(@Size(max = 50) String tenXe) {
        this.tenXe = tenXe;
    }

    public Integer getGiaXe() {
        return giaXe;
    }

    public void setGiaXe(Integer giaXe) {
        this.giaXe = giaXe;
    }

    public Integer getNamSanXuat() {
        return namSanXuat;
    }

    public void setNamSanXuat(Integer namSanXuat) {
        this.namSanXuat = namSanXuat;
    }

    public Hangxe getMaHangxe() {
        return maHangxe;
    }

    public void setMaHangxe(Hangxe maHangxe) {
        this.maHangxe = maHangxe;
    }

    @Override
    public String toString() {
        return "Xe{" +
                "maXe='" + maXe + '\'' +
                ", tenXe='" + tenXe + '\'' +
                ", giaXe=" + giaXe +
                ", namSanXuat=" + namSanXuat +
                ", maHangxe=" + maHangxe +
                '}';
    }
}