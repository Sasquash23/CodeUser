package com.kodilla.testing.forum.statistics;

import org.junit.Assert;
import org.junit.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ForumStatisticsTestSuite {

    private static int testCounter = 0;
    private Statistics statisticsMock;
    private ForumStatistics forumStatistics;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);

        statisticsMock = mock(Statistics.class);
        List<String> listMock = new ArrayList<>();
        for(int i=0; i<20; i++){
            listMock.add("User");
        }
        when(statisticsMock.usersNames()).thenReturn(listMock);
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.commentsCount()).thenReturn(200);
        forumStatistics = new ForumStatistics();
    }

    @Test
    public void testCalculateAdvStatisticsZeroPosts(){
        //Given
        when(statisticsMock.postsCount()).thenReturn(0);
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        Assert.assertEquals(0, forumStatistics.getPostsNumber());
        Assert.assertEquals(0, forumStatistics.getPostsAvgNumPerUser(),0.01);
        Assert.assertEquals(0, forumStatistics.getCommentsAvgNumPerPost(), 0.01);
        forumStatistics.showStatistics();
    }

    @Test
    public void testCalculateAdvStatisticsThousandPosts(){
        //Given
        when(statisticsMock.postsCount()).thenReturn(1000);
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        Assert.assertEquals(1000, forumStatistics.getPostsNumber());
        Assert.assertEquals(50, forumStatistics.getPostsAvgNumPerUser(),0.01);
        Assert.assertEquals(0.2, forumStatistics.getCommentsAvgNumPerPost(), 0.01);
    }

    @Test
    public void testCalculateAdvStatisticsZeroComments(){
        //Given
        when(statisticsMock.commentsCount()).thenReturn(0);
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        Assert.assertEquals(0, forumStatistics.getCommentsNumber());
        Assert.assertEquals(0, forumStatistics.getCommentsAvgNumPerUser(),0.01);
        Assert.assertEquals(0, forumStatistics.getCommentsAvgNumPerPost(), 0.01);
    }

    @Test
    public void testCalculateAdvStatisticsLessCommentsThanPosts(){
        //Given
        when(statisticsMock.commentsCount()).thenReturn(100);
        when(statisticsMock.postsCount()).thenReturn(1000);
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        Assert.assertEquals(100, forumStatistics.getCommentsNumber());
        Assert.assertEquals(1000, forumStatistics.getPostsNumber());
        Assert.assertEquals(5, forumStatistics.getCommentsAvgNumPerUser(),0.01);
        Assert.assertEquals(0.1, forumStatistics.getCommentsAvgNumPerPost(), 0.01);
    }

    @Test
    public void testCalculateAdvStatisticsMoreCommentsThanPosts(){
        //Given
        when(statisticsMock.commentsCount()).thenReturn(1000);
        when(statisticsMock.postsCount()).thenReturn(100);
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        Assert.assertEquals(1000, forumStatistics.getCommentsNumber());
        Assert.assertEquals(100, forumStatistics.getPostsNumber());
        Assert.assertEquals(50, forumStatistics.getCommentsAvgNumPerUser(),0.01);
        Assert.assertEquals(10, forumStatistics.getCommentsAvgNumPerPost(), 0.01);
    }

    @Test
    public void testCalculateAdvStatisticsZeroUsers(){
        //Given
        List<String> listMock = new ArrayList<>();
        when(statisticsMock.usersNames()).thenReturn(listMock);
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        Assert.assertEquals(0, forumStatistics.getUsersNumber());
        Assert.assertEquals(0, forumStatistics.getPostsAvgNumPerUser(),0.01);
        Assert.assertEquals(0, forumStatistics.getCommentsAvgNumPerUser(), 0.01);
    }

    @Test
    public void testCalculateAdvStatisticsHundredUsers(){
        //Given
        List<String> listMock = new ArrayList<>();
        for(int i=0; i<100; i++){
            listMock.add("User");
        }
        when(statisticsMock.usersNames()).thenReturn(listMock);
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        Assert.assertEquals(100, forumStatistics.getUsersNumber());
        Assert.assertEquals(1.0, forumStatistics.getPostsAvgNumPerUser(),0.01);
        Assert.assertEquals(2.0, forumStatistics.getCommentsAvgNumPerUser(), 0.01);
    }
}
