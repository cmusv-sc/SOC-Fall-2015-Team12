package models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by XinHong on 12/18/15.
 */
public class PostTest {
    private static long TEST_ID = 0;
    private static String USER_ID = "1";
    private static int PRIVACY = 0;
    private static String TEXT = "haha";
    private static String ADDRESS = "Mountain View";

    private static Post post;


    @Before
    public void setUp() throws Exception{
        post = new Post();
    }

    @Test
    public void testUserId() {
        post.setUserId(USER_ID);
        assertEquals(USER_ID, post.getUserId());
    }

    @Test
    public void testText() {
        post.setText(TEXT);
        assertEquals(TEXT, post.getText());
    }

    @Test
    public void testPrivacy() {
       post.setPrivacy(PRIVACY);
        assertEquals(PRIVACY, post.getPrivacy());
    }

    @Test
    public void testAddress() {
        post.setAddress(ADDRESS);
        assertEquals(ADDRESS, post.getAddress());
    }
}
