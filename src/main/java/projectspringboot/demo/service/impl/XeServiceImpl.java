package projectspringboot.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectspringboot.demo.model.HangXe;
import projectspringboot.demo.model.Xe;
import projectspringboot.demo.repository.HangXeRepository;
import projectspringboot.demo.repository.XeRepository;
import projectspringboot.demo.service.XeService;

import java.util.List;
import java.util.Optional;

@Service
public class XeServiceImpl implements XeService {
    private XeRepository xeRepository;
    private HangXeRepository hangXeRepository;
    @Autowired
    public XeServiceImpl(XeRepository xeRepository,HangXeRepository hangXeRepository) {
        this.xeRepository = xeRepository;
        this.hangXeRepository = hangXeRepository;
    }

    @Override
    public List<Xe> findAll() {
        List<Xe> xeList = xeRepository.findAll();
        if (xeList.isEmpty()){
            return null;
        }
        return xeList;
    }

    @Override
    public Xe save(Xe xe) {
        Optional<HangXe> hangXeOptional = hangXeRepository.findById(xe.getHangXeId());
        if (hangXeOptional.isPresent()){
            HangXe hangXe = hangXeOptional.get();
            xe.setHangXe(hangXe);
            xeRepository.save(xe);
        }
        return null;
    }

    @Override
    public Xe findById(long id) {
        Optional<Xe> xeOptional = xeRepository.findById(id);
        if (xeOptional.isPresent())
            return xeOptional.get();
        return null;
    }

    @Override
    public void delete(Xe xe) {
        xeRepository.delete(xe);
    }

    @Override
    public void deleteById(long id) {
        xeRepository.deleteById(id);
    }

    @Override
    public List<Xe> findAllByHangXeId(Long id) {
        List<Xe> xeList = xeRepository.findAllByHangXeId(id);
        if (xeList.isEmpty()){
            return null;
        }
        return xeList;
    }
}
