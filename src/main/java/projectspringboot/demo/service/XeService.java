package projectspringboot.demo.service;

import projectspringboot.demo.model.Xe;

import java.util.List;

public interface XeService{
    List<Xe> findAll();
    Xe save(Xe xe);
    Xe findById(long id);
    void delete(Xe xe);
    void deleteById(long id);
    public List<Xe> findAllByHangXeId(Long id);
}
