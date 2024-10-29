package trantrongtin_iuh.gk_xe_payara.backend.responsitories.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "hangxe")
@NamedQueries(
        {
                @NamedQuery(name = "Hangxe.findAll", query = "SELECT h FROM Hangxe h"),
                @NamedQuery(name = "Hangxe.findByMahangxe", query = "SELECT h FROM Hangxe h WHERE h.mahangxe = :mahangxe")
        }
)
public class Hangxe implements Serializable {
    @Id
    @Size(max = 10)
    @Column(name = "MAHANGXE", nullable = false, length = 10)
    private String mahangxe;

    @Size(max = 50)
    @Column(name = "TENHANG", length = 50)
    private String tenhang;

    @Size(max = 50)
    @Column(name = "QUOCGIA", length = 50)
    private String quocgia;

    @Size(max = 50)
    @Column(name = "MOTA", length = 50)
    private String mota;

    @OneToMany(mappedBy = "mahangxe")
    private List<Xe> xes = new ArrayList<>();

    public String getMahangxe() {
        return mahangxe;
    }

    public void setMahangxe(String mahangxe) {
        this.mahangxe = mahangxe;
    }

    public String getTenhang() {
        return tenhang;
    }

    public void setTenhang(String tenhang) {
        this.tenhang = tenhang;
    }

    public String getQuocgia() {
        return quocgia;
    }

    public void setQuocgia(String quocgia) {
        this.quocgia = quocgia;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public List<Xe> getXes() {
        return xes;
    }

    public void setXes(List<Xe> xes) {
        this.xes = xes;
    }

    public Hangxe() {
    }

    public Hangxe(String mahangxe, String tenhang, String quocgia, String mota) {
        this.mahangxe = mahangxe;
        this.tenhang = tenhang;
        this.quocgia = quocgia;
        this.mota = mota;

    }

    @Override
    public String toString() {
        return "Hangxe{" +
                "mahangxe='" + mahangxe + '\'' +
                ", tenhang='" + tenhang + '\'' +
                ", quocgia='" + quocgia + '\'' +
                ", mota='" + mota + '\'' +
                ", xes=" + xes +
                '}';
    }
}