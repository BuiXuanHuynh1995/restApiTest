package projectspringboot.demo.service;

import projectspringboot.demo.model.HangXe;
import projectspringboot.demo.model.PhienBan;

import java.util.List;

public interface HangXeService {
    List<HangXe> findAll();
    HangXe save(HangXe hangXe);
    HangXe findById(long id);
    void delete(HangXe hangXe);
    void deleteById(long id);;
}
