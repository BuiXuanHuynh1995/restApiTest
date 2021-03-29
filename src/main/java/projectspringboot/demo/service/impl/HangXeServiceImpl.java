package projectspringboot.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectspringboot.demo.model.HangXe;
import projectspringboot.demo.repository.HangXeRepository;
import projectspringboot.demo.service.HangXeService;

import java.util.List;
import java.util.Optional;

@Service
public class HangXeServiceImpl implements HangXeService {
    private HangXeRepository hangXeRepository;

    @Autowired
    public HangXeServiceImpl(HangXeRepository hangXeRepository) {
        this.hangXeRepository = hangXeRepository;
    }

    @Override
    public List<HangXe> findAll() {
        return hangXeRepository.findAll();
    }

    @Override
    public HangXe save(HangXe hangXe) {
        return hangXeRepository.save(hangXe);
    }

    @Override
    public HangXe findById(long id) {
        Optional<HangXe> hangXeOptional = hangXeRepository.findById(id);
        return hangXeOptional.get();
    }

    @Override
    public void delete(HangXe hangXe) {
        hangXeRepository.save(hangXe);
    }

    @Override
    public void deleteById(long id) {
        hangXeRepository.deleteById(id);
    }
}
