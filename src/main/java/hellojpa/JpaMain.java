package hellojpa;

import jakarta.persistence.*;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        //데이터를 변경하는 모든 작업은 트랜잭션 안에서 해야함
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Member member = new Member();

        member.setId(1L);
        member.setName("HelloA");

        em.persist(member);

        tx.commit();

        em.close();
        emf.close();
    }
}
