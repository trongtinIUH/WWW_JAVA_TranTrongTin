package trantrongtin_iuh.trantrongtin_21054421_may11.backend.repositories.entity;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "xe")
@NamedQueries(
        {
                @NamedQuery(name = "Xe.findAll", query = "SELECT x FROM Xe x "),
                @NamedQuery(name = "Xe.findByMaxe", query = "SELECT x FROM Xe x WHERE x.maXe = :maXe")
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
    @JsonbTransient
    private Hangxe maHangXe;

    public Xe() {
    }

    public Xe(String maXe, String tenXe, Integer giaXe, Integer namSanXuat, Hangxe maHangXe) {
        this.maXe = maXe;
        this.tenXe = tenXe;
        this.giaXe = giaXe;
        this.namSanXuat = namSanXuat;
        this.maHangXe = maHangXe;
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

    public Hangxe getMaHangXe() {
        return maHangXe;
    }

    public void setMaHangXe(Hangxe maHangXe) {
        this.maHangXe = maHangXe;
    }

    @Override
    public String toString() {
        return "Xe{" +
                "maXe='" + maXe + '\'' +
                ", tenXe='" + tenXe + '\'' +
                ", giaXe=" + giaXe +
                ", namSanXuat=" + namSanXuat +
                ", maHangXe=" + maHangXe+
                '}';
    }
}