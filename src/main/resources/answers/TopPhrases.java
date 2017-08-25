import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class TopPhrases {
    public static void main(String args[]) {

        try {
            List<String> phrases = findPhrases("phrase.txt", 10);

            for(String ph:phrases){
                System.out.println(ph);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        ;
    }

    public static List<String> findPhrases(String fileName, int limit) throws IOException {
        HashMap<String, Integer> wordCountMap = new HashMap<String, Integer>();
        FileInputStream inputStream = null;
        Scanner sc = null;
        try {
            inputStream = new FileInputStream(fileName);
            sc = new Scanner(inputStream, "UTF-8");
            while (sc.hasNextLine()) {
                String line = sc.nextLine();

                String[] phrases = line.split("\\|");

                for (String word : phrases) {
                    //if word is already present in wordCountMap, updating its count

                    if (wordCountMap.containsKey(word)) {
                        wordCountMap.put(word, wordCountMap.get(word) + 1);
                    }

                    //otherwise inserting the word as key and 1 as its value
                    else {
                        wordCountMap.put(word, 1);
                    }
                }
            }
            // note that Scanner suppresses exceptions
            if (sc.ioException() != null) {
                throw sc.ioException();
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (sc != null) {
                sc.close();
            }
        }
        Map<String, Integer> sortedMap = sortByComparator(wordCountMap);

        List<String> topPhrases = new ArrayList<String>(sortedMap.keySet()); // put the elements into a list
        return topPhrases.subList(0, limit); // get a subList with 100 elements
    }

    private static Map<String, Integer> sortByComparator(Map<String, Integer> unsortMap) {

        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(unsortMap.entrySet());

        // Sorting the list based on values
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {

                return o2.getValue().compareTo(o1.getValue());
            }
        });

        // Maintaining insertion order with the help of LinkedList
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }

}
