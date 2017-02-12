package com.clubos;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class SolutionTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void main() throws Exception {
        final Solution solution = new Solution();
        Solution.Request request = new Solution.Request(generateData());
        solution.execute(request);
    }

    private List<String> generateData() {
        final List<String> data = new ArrayList<>();
        final Integer topics = ThreadLocalRandom.current().nextInt(1, 5000);
        final Integer questions = ThreadLocalRandom.current().nextInt(1, 500);
        final Integer queries = ThreadLocalRandom.current().nextInt(1, 2500);

        data.add(topics + " " + questions + " " + queries * 2);

        for (int i = 0; i < topics; i++) {
            data.add(i + " " + (ThreadLocalRandom.current().nextInt(0, 1000000000) / 10000.0) + " " + (ThreadLocalRandom.current().nextInt(0, 1000000000) / 10000.0));
        }

        for (int i = 0; i < questions; i++) {
            final Integer numTopics = ThreadLocalRandom.current().nextInt(1, 10);
            String topicForQuestion = "";
            if (numTopics > 0) {
                for (int j = 0; j < numTopics; j++) {

                    topicForQuestion = topicForQuestion + " " + ThreadLocalRandom.current().nextInt(0, topics);
                }

                data.add(i + " " + numTopics + topicForQuestion);
            }
        }
        for (int j = 0; j < queries; j++) {
            data.add("q " + ThreadLocalRandom.current().nextInt(1, 100) + " " + (ThreadLocalRandom.current().nextInt(1, 1000000000) / 10000.0) + " " + (ThreadLocalRandom.current().nextInt(1, 1000000000) / 10000.0));
            data.add("t " + ThreadLocalRandom.current().nextInt(1, 100) + " " + (ThreadLocalRandom.current().nextInt(1, 1000000000) / 10000.0) + " " + (ThreadLocalRandom.current().nextInt(1, 1000000000) / 10000.0));
        }

        return data;
    }


}