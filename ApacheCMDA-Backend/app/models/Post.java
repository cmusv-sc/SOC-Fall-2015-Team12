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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Post {

    @Id @GeneratedValue(strategy = GenerationType.AUTO) private long id;
    private String userId;
    private int privacy;
    private String text;
    private String address;

    @Temporal(TemporalType.TIMESTAMP) private Date time;


    public Post() {
    }

    public Post(String userId, int privacy, String text, Date time, String address) {
        super();
        this.userId = userId;
        this.privacy = privacy;
        this.text = text;
        this.time = time;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public String getText() {
        return text;
    }

    public int getPrivacy() {
        return privacy;
    }


    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setPrivacy(int privacy) {
        this.privacy = privacy;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

//    @Override public String toString() {
//        return "Posts [id=" + id + ", postId=" + postId + ", userId=" + userId + ",  privacy="
//            + privacy + ", text=" + text + ", time=" + time + "]";
//    }

    @Override public String toString() {
        return "Post [id=" + id + ", userId=" + userId + ",  privacy=" + privacy + ", text=" + text
                + ", time=" + time + ", address=" + address + "]";
    }


}
