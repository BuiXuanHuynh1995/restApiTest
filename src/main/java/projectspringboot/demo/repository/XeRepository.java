package projectspringboot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import projectspringboot.demo.model.Xe;

import java.util.List;

public interface XeRepository extends JpaRepository<Xe,Long> {
    @Query(nativeQuery = true, value = "select * from  xe join hang_xe on xe.hangxe_id = hang_xe.id where hang_xe.id = :id")
    List<Xe> findAllByHangXeId(Long id);
}
