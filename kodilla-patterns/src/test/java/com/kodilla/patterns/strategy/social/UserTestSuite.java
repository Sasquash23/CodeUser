package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publisher.SnapchatPublisher;
import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {
    @Test
    public void testDefaultSharingStrategies() {
        //Given
        User sandra = new YGeneration("Sandra", "Links", "Sandra_13242");
        User basia = new Millenials("Basia", "Weniecka", "sweety20");
        User zuzia = new ZGeneration("Zuzanna", "Kowolik", "Zuzik13");

        //When
        String sandraShouldPost = sandra.sharePost();
        System.out.println("Sandra use portal: " + sandraShouldPost);
        String basiaShouldPost = basia.sharePost();
        System.out.println("Basia use portal: " + basiaShouldPost);
        String zuziaShouldPost = zuzia.sharePost();
        System.out.println("Zuzia use portal: " + zuziaShouldPost);

        //Then
        Assert.assertEquals("[Twitter] Post ZYX", sandraShouldPost);
        Assert.assertEquals("[Facebook] Post XYZ", basiaShouldPost);
        Assert.assertEquals("[Snapchat] Post YZX", zuziaShouldPost);
    }

    @Test
    public void testIndividualSharingStrategy() {
        //Given
        User sandra = new YGeneration("Sandra", "Links", "Sandra_13242");

        //When
        String sandraShouldPost = sandra.sharePost();
        System.out.println("Sandra should use portal: " + sandraShouldPost);
        sandra.setPublisherStrategy(new SnapchatPublisher());
        sandraShouldPost = sandra.sharePost();
        System.out.println("Sandra now should use portal: " + sandraShouldPost);

        //Then
        Assert.assertEquals("[Snapchat] Post YZX", sandraShouldPost);
    }

}
