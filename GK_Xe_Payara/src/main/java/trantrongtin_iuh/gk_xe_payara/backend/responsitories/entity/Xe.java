package trantrongtin_iuh.gk_xe_payara.backend.responsitories.entity;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.io.Serializable;


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

    @Column(name = "NAMSANXUAT")
    private Integer namSanXuat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MAHANGXE")
    @JsonbTransient
    private Hangxe mahangxe;

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

    public Integer getNamSanXuat() {
        return namSanXuat;
    }

    public void setNamSanXuat(Integer namSanXuat) {
        this.namSanXuat = namSanXuat;
    }

    public Hangxe getMahangxe() {
        return mahangxe;
    }

    public void setMahangxe(Hangxe mahangxe) {
        this.mahangxe = mahangxe;
    }

    public Xe() {
    }

    public Xe(String maXe, String tenXe, Integer namSanXuat, Hangxe mahangxe) {
        this.maXe = maXe;
        this.tenXe = tenXe;
        this.namSanXuat = namSanXuat;
        this.mahangxe = mahangxe;
    }

    @Override
    public String toString() {
        return "Xe{" +
                "maXe='" + maXe + '\'' +
                ", tenXe='" + tenXe + '\'' +
                ", namSanXuat=" + namSanXuat +
                ", mahangxe=" + mahangxe +
                '}';
    }
}