package hellojpa;

import jakarta.persistence.*;

public class JpaMain {

    public static void main(String[] args) {

        //엔티티 매니저 팩토리는 하나만 생성해서 애플리케이션 전체에서 공유
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        //엔티티 매니저는 쓰레드간에 공유하지않음(사용후 버려야함)
        EntityManager em = emf.createEntityManager();

        //데이터를 변경하는 모든 작업은 트랜잭션 안에서 해야함
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        //JPA의 정석코드
        //등록
/*
        try {
            Member member = new Member();
            member.setId(1L);
            member.setName("HelloA");

            em.persist(member);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
*/

        //조회
/*
        try {
            Member findMember = em.find(Member.class, 1L);
            System.out.println("findMember.id = " + findMember.getId());
            System.out.println("findMember.name = " + findMember.getName());

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
*/

        //삭제
/*
        try {
            Member findMember = em.find(Member.class, 1L);

            em.remove(findMember);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
*/
        //수정
        try {
            Member findMember = em.find(Member.class, 1L);
            findMember.setName("HelloJPA");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
