package projectspringboot.demo.service;

import projectspringboot.demo.model.PhienBan;
import projectspringboot.demo.model.Xe;

import java.util.List;

public interface PhienBanService{
    List<PhienBan> findAll();
    PhienBan save(PhienBan phienBan);
    PhienBan findById(long id);
    void delete(PhienBan phienBan);
    void deleteById(long id);;
    List<PhienBan> findAllByXeId(Long id);
}
