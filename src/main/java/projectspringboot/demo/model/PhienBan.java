package projectspringboot.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class PhienBan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tenPhienBan;

    @JsonIgnore
    @ManyToOne(targetEntity = Xe.class)
    @JoinColumn(name = "xe_id")
    private Xe xe;

    public Long getXeId() {
        return xeId;
    }

    public void setXeId(Long xeId) {
        this.xeId = xeId;
    }

    private transient Long xeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenPhienBan() {
        return tenPhienBan;
    }

    public void setTenPhienBan(String tenPhienBan) {
        this.tenPhienBan = tenPhienBan;
    }

    public Xe getXe() {
        return xe;
    }

    public void setXe(Xe xe) {
        this.xe = xe;
    }
}
