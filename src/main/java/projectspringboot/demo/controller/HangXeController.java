package projectspringboot.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectspringboot.demo.model.HangXe;
import projectspringboot.demo.service.GenericService;
import projectspringboot.demo.service.HangXeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/hangxe")
public class HangXeController {
    private HangXeService hangXeService;

    @Autowired
    public HangXeController(HangXeService hangXeService) {
        this.hangXeService = hangXeService;
    }

    @GetMapping("")
    public ResponseEntity<List<HangXe>> findAll(){
        List<HangXe> hangXeList = hangXeService.findAll();
        if (hangXeList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(hangXeList,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HangXe> findOneById(@PathVariable("id")Long id){
        HangXe hangXe = hangXeService.findById(id);
        return new ResponseEntity<>(hangXe,HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<HangXe> save(@RequestBody HangXe hangXe){
        HangXe saveHangXe = hangXeService.save(hangXe);
        return new ResponseEntity<>(saveHangXe,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody HangXe hangXe,@PathVariable("id")Long id){
        HangXe currentHangXe =hangXeService.findById(id);
        currentHangXe.setId(id);
        currentHangXe.setTenHangXe(hangXe.getTenHangXe());
        hangXeService.save(currentHangXe);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id")Long id){
        hangXeService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
