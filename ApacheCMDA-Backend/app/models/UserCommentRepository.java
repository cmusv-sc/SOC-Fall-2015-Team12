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

@Named
@Singleton
public interface UserCommentRepository extends CrudRepository<UserComment, Long> {
    @Query(value = "select c.* from UserComment c where c.postId=?1 order by c.time desc", nativeQuery = true)
    List<UserComment> findAllByPostId(Long id);

    @Query(value = "select c.* from UserComment c where c.postId = ?1 order by c.time desc", nativeQuery = true)
    List<UserComment> findCommentWithPostId(Long postId);
}
