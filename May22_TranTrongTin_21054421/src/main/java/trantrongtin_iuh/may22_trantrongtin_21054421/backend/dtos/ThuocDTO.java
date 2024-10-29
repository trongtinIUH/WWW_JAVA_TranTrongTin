package trantrongtin_iuh.may22_trantrongtin_21054421.backend.dtos;

public class ThuocDTO {
    private  String maThuoc;
    private String tenThuoc;
    private int giaThuoc;
    private  int namSX;
    private  String maLoai;


    public ThuocDTO() {
    }

    public ThuocDTO(String maThuoc, String tenThuoc, int giaThuoc, int namSX, String maLoai) {
        this.maThuoc = maThuoc;
        this.tenThuoc = tenThuoc;
        this.giaThuoc = giaThuoc;
        this.namSX = namSX;
        this.maLoai = maLoai;
    }

    public String getMaThuoc() {
        return maThuoc;
    }

    public void setMaThuoc(String maThuoc) {
        this.maThuoc = maThuoc;
    }

    public String getTenThuoc() {
        return tenThuoc;
    }

    public void setTenThuoc(String tenThuoc) {
        this.tenThuoc = tenThuoc;
    }

    public int getGiaThuoc() {
        return giaThuoc;
    }

    public void setGiaThuoc(int giaThuoc) {
        this.giaThuoc = giaThuoc;
    }

    public int getNamSX() {
        return namSX;
    }

    public void setNamSX(int namSX) {
        this.namSX = namSX;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    @Override
    public String toString() {
        return "ThuocDTO{" +
                "maThuoc='" + maThuoc + '\'' +
                ", tenThuoc='" + tenThuoc + '\'' +
                ", giaThuoc=" + giaThuoc +
                ", namSX=" + namSX +
                ", maLoai='" + maLoai + '\'' +
                '}';
    }
}
