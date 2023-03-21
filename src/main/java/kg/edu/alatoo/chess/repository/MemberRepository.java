package kg.edu.alatoo.chess.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import kg.edu.alatoo.chess.entity.Member;;

public interface MemberRepository extends JpaRepository<Member, String> {

}