package kr.co.ch07.repository.board;

import jakarta.transaction.Transactional;
import kr.co.ch07.entity.board.Article;
import kr.co.ch07.entity.board.Comment;
import kr.co.ch07.entity.board.File;
import kr.co.ch07.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
class BoardRepositoryTest {

    @Autowired private ArticleRepository articleRepository;
    @Autowired private CommentRepository commentRepository;
    @Autowired private FileRepository fileRepository;
    @Autowired private UserRepository userRepository;

    @Test
    public void insertUser(){

        User user = User.builder()
                .uid("a101")
                .name("김유신")
                .hp("010-1234-1001")
                .build();

        userRepository.save(user);
    }


    public void insertArticle(){
        User user = User.builder()
                .uid("a101")
                .build();

        Article article = Article.builder()
                .title("제목 1입니다.")
                .content("내용입니다")
                .user(user)
                .build();
        articleRepository.save(article);
    }


    public void insertComment(){
        User user = User.builder()
                .uid("a101")
                .build();

        Article article = Article.builder()
                .no(1)
                .build();

        Comment comment = Comment.builder()
                .content("댓글1입니다")
                .user(user)
                .article(article)
                .build();
        commentRepository.save(comment);
    }


    public void insertFile(){

        Article article = Article.builder()
                .no(2)
                .build();

        File file = File.builder()
                .oName("원래파일명.txt")
                .sName("ADDD121.txt")
                .article(article)
                .build();
        fileRepository.save(file);
    }

    @Transactional
    public void selectArticles(){
        List<Article> articles = articleRepository.findAll();

        for(Article article : articles){
            log.info(article.toString());
        }
    }
}