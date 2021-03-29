package projectspringboot.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectspringboot.demo.model.PhienBan;
import projectspringboot.demo.model.Xe;
import projectspringboot.demo.repository.PhienBanRepository;
import projectspringboot.demo.repository.XeRepository;
import projectspringboot.demo.service.PhienBanService;

import java.util.List;
import java.util.Optional;

@Service
public class PhienBanServiceImpl implements PhienBanService {
    private PhienBanRepository phienBanRepository;
    private XeRepository xeRepository;

    @Autowired
    public PhienBanServiceImpl(PhienBanRepository phienBanRepository, XeRepository xeRepository) {
        this.phienBanRepository = phienBanRepository;
        this.xeRepository = xeRepository;
    }

    @Override
    public List<PhienBan> findAll() {
        List<PhienBan> phienBanList = phienBanRepository.findAll();
        if (phienBanList.isEmpty()){
            return null;
        }
        return phienBanList;
    }

    @Override
    public PhienBan save(PhienBan phienBan) {
        Optional<Xe> xeOptional = xeRepository.findById(phienBan.getXeId());
        if (xeOptional.isPresent()){
            Xe xe = xeOptional.get();
            phienBan.setXe(xe);
            return phienBanRepository.save(phienBan);
        }
        return null;
    }

    @Override
    public PhienBan findById(long id) {
        Optional<PhienBan> phienBanOptional = phienBanRepository.findById(id);
        if (phienBanOptional.isPresent()){
            return phienBanOptional.get();
        }
        return null;
    }

    @Override
    public void delete(PhienBan phienBan) {
        phienBanRepository.delete(phienBan);
    }

    @Override
    public void deleteById(long id) {
        phienBanRepository.deleteById(id);
    }

    @Override
    public List<PhienBan> findAllByXeId(Long id) {
        List<PhienBan> phienBanList = phienBanRepository.findAllByXeId(id);
        if (phienBanList.isEmpty()){
            return null;
        }
        return phienBanList;
    }
}
