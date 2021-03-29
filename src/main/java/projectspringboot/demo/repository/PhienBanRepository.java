package projectspringboot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import projectspringboot.demo.model.PhienBan;

import java.util.List;

public interface PhienBanRepository extends JpaRepository<PhienBan,Long> {
    @Query(nativeQuery = true,value = "select * from  phien_ban join xe on phien_ban.xe_id = xe.id where xe.id = :id")
    List<PhienBan> findAllByXeId(Long id);
}
