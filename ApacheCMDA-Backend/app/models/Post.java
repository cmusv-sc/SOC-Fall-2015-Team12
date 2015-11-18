/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package models;

import java.lang.Long;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity public class Post {

    @Id @GeneratedValue(strategy = GenerationType.AUTO) private long id;
    private String postId;
    private String userId;
    private int comment;
    private int like;
    private int privacy;
    private String text;
    private String time;

    public Post() {
    }

    public Post(String postId, String userId, int comment, int like, int privacy, String text,
        String time) {
        super();
        this.id = id;
        this.postId = postId;
        this.userId = userId;
        this.comment = comment;
        this.like = like;
        this.privacy = privacy;
        this.text = text;
        this.time = time;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public long getId() {
        return id;
    }

    public void setUserId(String postId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public int getComment() {
        return comment;
    }

    public String getText() {
        return text;
    }

    public int getLike() {
        return like;
    }

    public int getPrivacy() {
        return privacy;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public void setPrivacy(int privacy) {
        this.privacy = privacy;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override public String toString() {
        return "Posts [id=" + id + ", postId=" + postId + ", userId=" + userId + ", comment="
            + comment + ", like=" + like + ", privacy=" + privacy
            + ", text=" + text + ", time=" + time + "]";
    }


}
