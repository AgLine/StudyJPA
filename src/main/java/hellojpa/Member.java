package hellojpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity//JPA가 관리하는 클래스이다
public class Member {

    @Id//PK(Primary Key)를 지정 (필수)
    private Long id;

    private String name;//일반 컬럼으로 매핑됨

    //JPA 표준에 따른 기본 생성자
    //기본 생성자 접근 제어: 외부에서 아무런 값 없이 객체를 생성하는 것을 막기 위해 protected Member() {} 정도로 선언하는 것이 더 안전
    protected Member(){

    }

    //실제 개발 시 편리함을 위한 생성자
    public Member(long id, String name) {
        this.id =id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
