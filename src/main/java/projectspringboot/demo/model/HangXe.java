package projectspringboot.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class HangXe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String tenHangXe;

    @JsonIgnore
    @OneToMany(targetEntity = Xe.class,mappedBy = "hangXe",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Xe> xelist;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenHangXe() {
        return tenHangXe;
    }

    public void setTenHangXe(String tenHangXe) {
        this.tenHangXe = tenHangXe;
    }

    public Set<Xe> getXelist() {
        return xelist;
    }

    public void setXelist(Set<Xe> xelist) {
        this.xelist = xelist;
    }
}
