package models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by XinHong on 12/18/15.
 */
public class UserCommentTest {
    private static long TEST_ID = 0;
    private static long POST_ID = 1;
    private static String USER_ID = "2";
    private static String TEXT = "haha";
    private UserComment userComment;

    @Before
    public void setUp() throws Exception{
        userComment = new UserComment();
    }

    @Test
    public void testPostId() {
        userComment.setPostId(POST_ID);
        assertEquals(POST_ID, userComment.getPostId());
    }

    @Test
    public void testUserId() {
        userComment.setUserId(USER_ID);
        assertEquals(USER_ID, userComment.getUserId());
    }

    @Test
    public void testText() {
        userComment.setText(TEXT);
        assertEquals(TEXT, userComment.getText());
    }
}
