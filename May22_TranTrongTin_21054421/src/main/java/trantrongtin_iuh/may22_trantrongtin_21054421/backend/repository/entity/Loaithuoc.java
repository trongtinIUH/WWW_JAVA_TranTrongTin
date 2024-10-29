package trantrongtin_iuh.may22_trantrongtin_21054421.backend.repository.entity;

import jakarta.json.bind.annotation.JsonbTransient;
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
@Table(name = "loaithuoc")
@NamedQueries(
        {
                @NamedQuery(name = "Loaithuoc.findAll", query = "SELECT l FROM Loaithuoc l"),
        }
)
public class Loaithuoc implements Serializable {
    @Id
    @Size(max = 10)
    @Column(name = "MALOAI", nullable = false, length = 10)
    private String maLoai;

    @Size(max = 50)
    @Column(name = "TENLOAI", length = 50)
    private String tenLoai;

    @OneToMany(mappedBy = "maLoai")
    @JsonbTransient
    private List<Thuoc> thuocs = new ArrayList<>();

    public Loaithuoc() {
    }

    public Loaithuoc(String maLoai, String tenLoai) {
        this.maLoai = maLoai;
        this.tenLoai = tenLoai;
    }

    @Override
    public String toString() {
        return "Loaithuoc{" +
                "maLoai='" + maLoai + '\'' +
                ", tenLoai='" + tenLoai + '\'' +
                ", thuocs=" + thuocs +
                '}';
    }
}