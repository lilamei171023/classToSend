package com.classroom.vo.response;

import lombok.*;

import java.util.Date;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CommentRelevant {
    private int commentsId;
    private String  content;
    private int agreeCount;
    private Date createAt;
    private String userLoginNumber;
    private int topicId;
    private String userName;
    private String userPhoto;
}
