package projectspringboot.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectspringboot.demo.model.Xe;
import projectspringboot.demo.service.GenericService;
import projectspringboot.demo.service.XeService;

import java.util.List;

@RestController
@RequestMapping("/api/xe")
public class XeController {
    private XeService xeService;

    @Autowired
    public XeController(XeService xeService) {
        this.xeService = xeService;
    }

    @GetMapping("")
    public ResponseEntity<List<Xe>> findAll(){
        List<Xe> xeList = xeService.findAll();
        return new ResponseEntity<>(xeList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Xe> findOneById(@PathVariable("id")Long id){
        Xe xe = xeService.findById(id);
        return new ResponseEntity<>(xe,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Xe> delete(@PathVariable("id")Long id){
        xeService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Xe> save(@RequestBody Xe xe){
        Xe xeSave = xeService.save(xe);
        return new ResponseEntity<>(xeSave,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Xe> update(@RequestBody Xe xe, @PathVariable("id")Long id){
        Xe currentXe = xeService.findById(id);
        currentXe.setTenXe(xe.getTenXe());
        xeService.save(currentXe);
        return new ResponseEntity<>(currentXe,HttpStatus.OK);
    }

    @GetMapping("/hangxe/{id}")
    public ResponseEntity<List<Xe>> findAllByHangXeId(@PathVariable("id")Long id){
        List<Xe> xeList = xeService.findAllByHangXeId(id);
        return new ResponseEntity<>(xeList,HttpStatus.OK);
    }
}
