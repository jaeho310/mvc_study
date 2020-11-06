package com.example.study.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

//@Data // 게터세터
//테이블이름과 같다면 안써도 된다.
//@Table(name ="user")
@Entity
@NoArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 전략옵션 설정
    private Long id;


//    @Column(name = "account")
    // 컬럼의 이름이 같으므로 적어주지 않아도 JPA가 매칭시켜준다.
    private String account;

    private String email;

    private String phoneNumber;

    // JPA가 알아서 매칭해주기에 created_at으로 만들어주지 않아도 된다.
    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;

    // 1 : N
    // 변수명은 user
    // LAZY = 지연로딩 , EAGER = 즉시로딩
    // LAZY = SELECT * FROM item WHERE id = ?
    // 따로 변수에 겟 메서드를 호출하지 않는이상 연관관계에 대해서 select하지 않겠다.
    // 연관관계에 대해서는 LAZY를 사용하는것이 좋다.

    // EAGER = 1:1
    // item_id = order_detail.item_id
    // user_id = order_detail.user_id
    // where item.id = ?
    // join하여 가져오므로 데이터가 커지면 느려진다.
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<OrderDetail> orderDetailList;

}
