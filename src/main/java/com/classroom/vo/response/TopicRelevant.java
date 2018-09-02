package com.classroom.vo.response;

import lombok.*;

import java.util.Date;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TopicRelevant {
    private int topicId;
    private String topicTitle;
    private String topicContent;
    private String userLoginNumber;
    private String userName;
    private String userPhoto;
    private int agreeCount;
    private int scanTimes;
    private int commentsTimes;
    private Date createAt;


}
