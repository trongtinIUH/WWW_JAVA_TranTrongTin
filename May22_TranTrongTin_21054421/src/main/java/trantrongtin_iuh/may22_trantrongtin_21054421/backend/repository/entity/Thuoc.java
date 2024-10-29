package trantrongtin_iuh.may22_trantrongtin_21054421.backend.repository.entity;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "thuoc")
@NamedQueries(
        {
                @NamedQuery(name = "Thuoc.findAll", query = "SELECT t FROM Thuoc t"),
                @NamedQuery(name = "Thuoc.findByLoai", query = "SELECT t FROM Thuoc t WHERE t.maLoai = :maLoai")
        }
)
public class Thuoc implements Serializable {
    @Id
    @Size(max = 10)
    @Column(name = "MATHUOC", nullable = false, length = 10)
    private String maThuoc;

    @Size(max = 50)
    @Column(name = "TENTHUOC", length = 50)
    private String tenthuoc;

    @Column(name = "GIA")
    private Integer giaThuoc;

    @Column(name = "NAMSX")
    private Integer namSX;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MALOAI")
    @JsonbTransient
    private Loaithuoc maLoai;

    public Thuoc() {
    }

    public Thuoc(String maThuoc, String tenthuoc, Integer giaThuoc, Integer namSX, Loaithuoc maLoai) {
        this.maThuoc = maThuoc;
        this.tenthuoc = tenthuoc;
        this.giaThuoc = giaThuoc;
        this.namSX = namSX;
        this.maLoai = maLoai;
    }

    public @Size(max = 10) String getMaThuoc() {
        return maThuoc;
    }

    public void setMaThuoc(@Size(max = 10) String maThuoc) {
        this.maThuoc = maThuoc;
    }

    public @Size(max = 50) String getTenthuoc() {
        return tenthuoc;
    }

    public void setTenthuoc(@Size(max = 50) String tenthuoc) {
        this.tenthuoc = tenthuoc;
    }

    public Integer getGiaThuoc() {
        return giaThuoc;
    }

    public void setGiaThuoc(Integer giaThuoc) {
        this.giaThuoc = giaThuoc;
    }

    public Integer getNamSX() {
        return namSX;
    }

    public void setNamSX(Integer namSX) {
        this.namSX = namSX;
    }

    public Loaithuoc getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(Loaithuoc maLoai) {
        this.maLoai = maLoai;
    }

    @Override
    public String toString() {
        return "Thuoc{" +
                "maThuoc='" + maThuoc + '\'' +
                ", tenthuoc='" + tenthuoc + '\'' +
                ", giaThuoc=" + giaThuoc +
                ", namSX=" + namSX +
                ", maLoai=" + maLoai +
                '}';
    }
}