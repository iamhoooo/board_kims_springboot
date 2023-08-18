package com.example.demo.controller;

import com.example.demo.dao.CommentDAO;
import com.example.demo.model.CommentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.StringUtils;

import java.util.List;

@RestController
public class CommentRestController {
    @Autowired
    private CommentDAO commentDAO;

    @GetMapping(value = "/test")
    public String testRequest() {

        List<CommentModel> commentList = commentDAO.selectAllCommentList();
        CommentModel cmt = commentList.get(0); // 테스트로 하나만 꺼내서 찍어보자

        return String.format("번호: %s, 작성자: %s, 댓글: %s, 날짜: %s",
                cmt.getNo(),
                cmt.getAuthor(),
                cmt.getComment(),
                StringUtils.toString(cmt.getDate())
        );
    }
}
