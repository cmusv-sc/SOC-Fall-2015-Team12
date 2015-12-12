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

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;

import javax.inject.Named;
import javax.inject.Singleton;
import java.lang.Long;
import java.util.List;
import java.util.Set;

@Named
@Singleton
public interface FollowRepository extends CrudRepository<Follow, Long> {

    @Query(value = "select l.* from Follow l where l.follower=?1", nativeQuery = true)
    Set<Follow> findAllByFollower(Long id);

    @Query(value = "select l.* from Follow l where l.follower=?1 and l.followee=?2", nativeQuery = true)
    List<Follow> check(Long id, Long id2);

    @Query(value = "select followee from (select followee, count(*) as cnt from Follow group by followee order by cnt desc limit ?1) a", nativeQuery = true)
    List<Object> getTopFollwee(Long cnt);

    @Query(value = "select l.* from Follow l where l.followee=?1", nativeQuery = true)
    List<Follow> getFollowerById(Long id);

    @Query(value = "select count(*) from Follow where followee=?1", nativeQuery = true)
    Long countFollwer(String id);
}
