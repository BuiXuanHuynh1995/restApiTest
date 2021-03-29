package projectspringboot.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectspringboot.demo.model.PhienBan;
import projectspringboot.demo.service.GenericService;
import projectspringboot.demo.service.PhienBanService;

import java.util.List;

@RestController
@RequestMapping("/api/phienban")
public class PhienBanController {
    private PhienBanService phienBanService;

    @Autowired
    public PhienBanController(PhienBanService phienBanService) {
        this.phienBanService = phienBanService;
    }

    @GetMapping("")
    public ResponseEntity<List<PhienBan>> findAll(){
        List<PhienBan> list = phienBanService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PhienBan> findOneById(@PathVariable("id")Long id){
        PhienBan phienBan = phienBanService.findById(id);
        return new ResponseEntity<>(phienBan,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PhienBan> update(@RequestBody PhienBan phienBan,@PathVariable("id")Long id){
        PhienBan currentPhienBan = phienBanService.findById(id);
        currentPhienBan.setId(id);
        currentPhienBan.setTenPhienBan(phienBan.getTenPhienBan());
        phienBanService.save(currentPhienBan);
        return new ResponseEntity<>(currentPhienBan,HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<PhienBan> save(@RequestBody PhienBan phienBan){
        PhienBan phienBanSave = phienBanService.save(phienBan);
        return new ResponseEntity<>(phienBanSave,HttpStatus.OK);
    }

    @GetMapping("/xe/{id}")
    public ResponseEntity<List<PhienBan>> findAllByXeId(@PathVariable("id")Long id){
        List<PhienBan> phienBanList = phienBanService.findAllByXeId(id);
        return new ResponseEntity<>(phienBanList,HttpStatus.OK);
    }



}
