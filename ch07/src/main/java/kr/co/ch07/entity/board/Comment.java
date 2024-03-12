package kr.co.ch07.entity.board;
import jakarta.persistence.*;
import kr.co.ch07.entity.User;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "article")
@Builder
@Entity
@Table(name="board_comment")
public class Comment {

    @Id
    @GeneratedValue
    private int cno;
    private String content;
    @CreationTimestamp
    private LocalDateTime rdate;

    @ManyToOne
    @JoinColumn(name = "writer")
    private User user;

    @ManyToOne
    @JoinColumn(name = "parent")
    private Article article;
}
