package models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by XinHong on 12/18/15.
 */
public class UserLikeTest {
    private static long TEST_ID = 0;
    private static long POST_ID = 1;
    private static String USER_ID = "2";

    private static UserLike userLike;



    @Before
    public void setUp() throws Exception{
        userLike = new UserLike();
    }

    @Test
    public void testPostId() {
        userLike.setPostId(POST_ID);
        assertEquals(POST_ID, userLike.getPostId());
    }

    @Test
    public void testUserId() {
        userLike.setUserId(USER_ID);
        assertEquals(USER_ID, userLike.getUserId());
    }
}
