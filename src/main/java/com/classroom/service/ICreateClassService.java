package com.classroom.service;


public interface ICreateClassService {
   int  createClass( String classroomName, String invitationCode);
   int  searchClassroomId(String invitationCode);
}
