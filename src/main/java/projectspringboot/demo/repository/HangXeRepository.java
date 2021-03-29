package projectspringboot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projectspringboot.demo.model.HangXe;

public interface HangXeRepository extends JpaRepository<HangXe,Long> {
}
