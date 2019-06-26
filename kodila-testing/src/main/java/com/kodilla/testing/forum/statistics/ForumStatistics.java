package com.kodilla.testing.forum.statistics;

public class ForumStatistics {

    private int usersNumber;
    private int postsNumber;
    private int commentsNumber;
    private double postsAvgNumPerUser;
    private double commentsAvgNumPerUser;
    private double commentsAvgNumPerPost;

    public void calculateAdvStatistics(Statistics statistics){
        usersNumber = statistics.usersNames().size();
        postsNumber = statistics.postsCount();
        commentsNumber = statistics.commentsCount();
        postsAvgNumPerUser = calculateAvg(postsNumber, usersNumber);
        commentsAvgNumPerUser = calculateAvg(commentsNumber, usersNumber);
        commentsAvgNumPerPost = calculateAvg(commentsNumber, postsNumber);
    }

    private double calculateAvg(int a, int b) {
        if( (a>0) && ( b!=0) ){
            return (double)a/b;
        } else {
            return 0;
        }
    }

    public void showStatistics(){
        System.out.println("Forum advanced user statistics:");
        System.out.println("Number of users: " + usersNumber);
        System.out.println("Number of posts: " + postsNumber);
        System.out.println("Number of comments: " + commentsNumber);
        System.out.println("Average number of posts per user: " + postsAvgNumPerUser);
        System.out.println("Average number of comments per user: " + commentsAvgNumPerUser);
        System.out.println("Average number of comments per post: " + commentsAvgNumPerPost);
    }

    public int getUsersNumber() {
        return usersNumber;
    }

    public int getPostsNumber() {
        return postsNumber;
    }

    public int getCommentsNumber() {
        return commentsNumber;
    }

    public double getPostsAvgNumPerUser() {
        return postsAvgNumPerUser;
    }

    public double getCommentsAvgNumPerUser() {
        return commentsAvgNumPerUser;
    }

    public double getCommentsAvgNumPerPost() {
        return commentsAvgNumPerPost;
    }
}
