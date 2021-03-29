package projectspringboot.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Xe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tenXe;
    private String namSanXuat;
    private String gia;
    private String dongCo;
    private String heThongTruyenLuc;
    private String gheNgoi;
    private String chieuDai;
    private String chieuRong;
    private String chieuCao;
    private String maLuc;
    private String moMenXoan;
    private String dungTich;
    private String heSoKeo;
    private String trongLuong;
    private String anh;

    @JsonIgnore
    @ManyToOne(targetEntity = HangXe.class)
    @JoinColumn(name = "hangxe_id")
    private HangXe hangXe;

    @OneToMany(targetEntity = PhienBan.class,mappedBy = "xe",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<PhienBan> phienBanList;

    private transient Long hangXeId;

    public Long getHangXeId() {
        return hangXeId;
    }

    public void setHangXeId(Long hangXeId) {
        this.hangXeId = hangXeId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenXe() {
        return tenXe;
    }

    public void setTenXe(String tenXe) {
        this.tenXe = tenXe;
    }

    public String getNamSanXuat() {
        return namSanXuat;
    }

    public void setNamSanXuat(String namSanXuat) {
        this.namSanXuat = namSanXuat;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getDongCo() {
        return dongCo;
    }

    public void setDongCo(String dongCo) {
        this.dongCo = dongCo;
    }

    public String getHeThongTruyenLuc() {
        return heThongTruyenLuc;
    }

    public void setHeThongTruyenLuc(String heThongTruyenLuc) {
        this.heThongTruyenLuc = heThongTruyenLuc;
    }

    public String getGheNgoi() {
        return gheNgoi;
    }

    public void setGheNgoi(String gheNgoi) {
        this.gheNgoi = gheNgoi;
    }

    public String getChieuDai() {
        return chieuDai;
    }

    public void setChieuDai(String chieuDai) {
        this.chieuDai = chieuDai;
    }

    public String getChieuRong() {
        return chieuRong;
    }

    public void setChieuRong(String chieuRong) {
        this.chieuRong = chieuRong;
    }

    public String getChieuCao() {
        return chieuCao;
    }

    public void setChieuCao(String chieuCao) {
        this.chieuCao = chieuCao;
    }

    public String getMaLuc() {
        return maLuc;
    }

    public void setMaLuc(String maLuc) {
        this.maLuc = maLuc;
    }

    public String getMoMenXoan() {
        return moMenXoan;
    }

    public void setMoMenXoan(String moMenXoan) {
        this.moMenXoan = moMenXoan;
    }

    public String getDungTich() {
        return dungTich;
    }

    public void setDungTich(String dungTich) {
        this.dungTich = dungTich;
    }

    public String getHeSoKeo() {
        return heSoKeo;
    }

    public void setHeSoKeo(String heSoKeo) {
        this.heSoKeo = heSoKeo;
    }

    public String getTrongLuong() {
        return trongLuong;
    }

    public void setTrongLuong(String trongLuong) {
        this.trongLuong = trongLuong;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public HangXe getHangXe() {
        return hangXe;
    }

    public void setHangXe(HangXe hangXe) {
        this.hangXe = hangXe;
    }

    public Set<PhienBan> getPhienBanList() {
        return phienBanList;
    }

    public void setPhienBanList(Set<PhienBan> phienBanList) {
        this.phienBanList = phienBanList;
    }
}
