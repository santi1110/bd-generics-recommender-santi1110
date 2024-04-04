package com.amazon.ata.generics.recommender.movie;

import com.amazon.ata.generics.recommender.MostRecentlyUsed;
import com.amazon.ata.generics.recommender.ReadOnlyDao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class PrimeVideoRecommenderWatchTest {
    private File kidsMovies = new File("./tst/resources/kidsmovies.csv");

    // PARTICIPANT -- Update the generic types in PrimeVideoRecommender
    private MostRecentlyUsed<PrimeVideo> mostRecentlyViewed;
    private ReadOnlyDao<Long, PrimeVideo> readOnlyDAO;
    private Random random;

    private PrimeVideoRecommender primeVideoRecommender;

    @BeforeEach
    public void setUp() {
        mostRecentlyViewed = new MostRecentlyUsed<>(3);
        readOnlyDAO = new PrimeVideoDao(kidsMovies);
        // Using a seed guarantees us the results of a sequence of calls to nextInt
        random = new Random(1);

        primeVideoRecommender = new PrimeVideoRecommender(mostRecentlyViewed, readOnlyDAO, random);
    }

    @Test
    public void watch_nonExistentPrimeVideo_throwIllegalArgumentsException() {
        // GIVEN
        long nonExistentMovie = 29;

        // WHEN + THEN
        assertThrows(IllegalArgumentException.class, () -> primeVideoRecommender.watch(nonExistentMovie));
    }

    // PARTICIPANTS - Finish writing this unit test.
    @Test
    public void watch_watchPrimeVideo_addToMostRecentlyViewed() {
        // GIVEN
        long movieId = 9;

        //WHEN
        primeVideoRecommender.watch(movieId);
        //THEN
        assertEquals(1,mostRecentlyViewed.getSize(), "Expected size to be 1");
        assertEquals(movieId,mostRecentlyViewed.get(0).getId(), "Expected value to be returned");

     /*   assertTrue(false, "Not yet implemented.");*/
    }
}
