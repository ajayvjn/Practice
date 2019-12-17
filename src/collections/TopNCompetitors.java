package collections;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Amazon Echo has lots of competitors
 * Web crawler got list of reviews
 * <p>
 * Given list of reviews, list of competitors, N, return most frequently mentioned top N competitors in the reviews.
 * <p>
 * Clarifying questions:
 * 1) why are numCompetitors and numReviews inputs? we don't seem to use them for any useful comparison
 * 2) should a repeated mention in the same review count as one, or multiple mentions?
 * 3) are the Strings for each review we are expecting to be long, or fairly standard short sentences left for reviews?
 * 4) can we get a lower and upper bounds for inputs such as reviews and competitors?
 * 5) is case-sensitivity needed? (can two companies exist with the same name but different case?)
 * 6) what if a review positively mentions one competitor, and negatively mentions another? which one do we count?
 * do we need to add detections for this?
 */
public class TopNCompetitors {

    public static void main(String[] args) {
        List<String> competitors = new ArrayList<>();
        competitors.add("newshop");
        competitors.add("shopnow");
        competitors.add("afshion");
        competitors.add("fashionbeats");
        competitors.add("mymarket");
        competitors.add("tcellular");

        List<String> reviews = new ArrayList<>();
        reviews.add("newshop is a providing good services in the city, everyone; everyone should use newshop");
        reviews.add("best services by newshop");
        reviews.add("fashionbeats has great services in the city");
        reviews.add("I am proud to have fashionbeats");
        reviews.add("mymarket has awesome services");
        reviews.add("mymarket 2 has awesome services");
        reviews.add("Thanks Newshop for the quick delivery");

        // numCompetitors=6
        // topNCompetitors=2

        process(6, 2, 6, competitors, reviews).forEach(System.out::println);
    }

    /**
     * @param numCompetitors  number of competitors
     * @param topNCompetitors the number of Top competitors we are interested in after processing (if this is greater
     *                        than the number mentioned in reviews, show all reviewed(
     * @param numReviews      number of reviews
     * @param competitors     list of competitors
     * @param reviews         list of reviews
     * @return list of answers
     * <p>
     * Space Complexity:
     * space here is O(c), where c the number of competitors, since we are only storing 'known' competitors. We do
     * stream this Map to a list, but only of the Keys which is still O(2c) = O(c)
     * <p>
     * Time Complexity:
     * O(r+c) - > for each review, check to see if any of the 'known competitors' is mentioned. We MUST loop over
     * all reviews, and worst case we loop over all competitors and find none.
     * <p>
     * Then to Stream the Map,
     * sort it by value -> O(log(n)) we just assume since this is abstracted away
     * <p>
     * O(r+c) + O(log(n))
     */
    /*private static List<String> process(int numCompetitors,
                                        int topNCompetitors,
                                        int numReviews,
                                        List<String> competitors,
                                        List<String> reviews) {
        Map<String, Integer> compCount = new HashMap<>();

        // loop over each review, and for each review check if its in the string
        // contains is fast enough, it uses .indexOf() under the hood
        for (String review: reviews) {
            for (String comp: competitors) {
                if (review.toLowerCase().contains(comp.toLowerCase())) {
                    int count = compCount.getOrDefault(comp, 0);
                    compCount.put(comp, count + 1);

                    break; // we found one, if we can assume single count per review and only one mentioned we're done
                }
            }
        }

        return compCount.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue())) // first sort each Map.Entry in Descending Order (greatest -> least mentions
                .limit(topNCompetitors) //limit the stream to only the elements we need
                .map(Map.Entry::getKey) // map each value back to its original key
                .collect(Collectors.toList()); // collect and return the list
    }*/
    private static List<String> process(int numCompetitors, int topNCompetitors, int numReviews, List<String> competitors, List<String> reviews) {
        Map<String, Integer> competitorsMap = new HashMap<>();
        List<String> result = new ArrayList<>();
        for (String s : reviews) {
            String[] words = s.split(" ");
            for (String word : words) {
                if (competitors.contains(word.toLowerCase())) {
                    competitorsMap.put(word, competitorsMap.getOrDefault(word, 0) + 1);
                }
            }
        }

        List<Competitor> competitorList = new ArrayList<>();
        competitorsMap.forEach((k, v) -> competitorList.add(new Competitor(k, v)));

        competitorList.sort((a, b) -> {
            if (a.occurrences.equals(b.occurrences)) {
                return a.name.compareTo(b.name);
            } else {
                return b.occurrences - a.occurrences;
            }
        });

        for (int i = 0; i < topNCompetitors; i++) {
            result.add(competitorList.get(i).name);
        }
        return result;
    }
}

class Competitor {
    Competitor(String name, Integer occurrences) {
        this.name = name;
        this.occurrences = occurrences;
    }

    String name;
    Integer occurrences;
}
