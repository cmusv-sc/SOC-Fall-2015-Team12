package models;
import static org.junit.Assert.*;

import models.User;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/**
 * Created by XinHong on 12/18/15.
 */
public class FollowTest {
    private static long TEST_ID = 0;
    private static Follow follow;

    private static long FOLLOWER = 1;
    private static long FOLLOWEE = 2;


    @Test
    public void testFollow() {
        Date TIME = new Date();
        Follow follow = new Follow(FOLLOWER, FOLLOWEE, TIME);
        assertEquals(FOLLOWER, follow.getFollower());
        assertEquals(FOLLOWEE, follow.getFollowee());
    }
}
