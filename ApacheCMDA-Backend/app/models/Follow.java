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

import java.util.Date;
import java.lang.String;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity public class Follow {

    @Id @GeneratedValue(strategy = GenerationType.AUTO) private long id;
    private long follower;
    private long followee;

    @Temporal(TemporalType.TIMESTAMP) private Date time;


    public Follow() {
    }

    public Follow(long follower, long followee, Date time) {

        super();
        this.follower = follower;
        this.followee = followee;
        this.time = time;
    }

    public Date getTime() {
        return time;
    }

    public long getFollowee() {
        return followee;
    }

    public long getFollower() {
        return follower;
    }

    public long getId() {
        return id;
    }

    @Override public String toString() {
        return "UserComment [id=" + id + ", follower=" + follower + ", followee=" + followee
            + ", time=" + time + "]";
    }


}
