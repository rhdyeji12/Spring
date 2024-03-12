package kr.co.ch07.entity.board;

import jakarta.persistence.*;
import kr.co.ch07.entity.User;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name="board_article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    private int no;
    private String title;
    private String content;

    @ManyToOne(fetch=FetchType.LAZY) // 연관 엔티티가 로딩될 때 필요 시점에 로딩되는 지연전략
    @JoinColumn(name="writer")       // 엔티티가 테이블로 생성될 때 컬럼명, 해당 엔티티의 @Id 컬럼타입으로 생성
    private User user;

    @OneToOne(mappedBy = "article")
    private File file;

    @OneToMany(mappedBy = "")
    private List<Comment> comment;

    @CreationTimestamp
    private LocalDateTime rdate;
}
