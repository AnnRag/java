package collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class CollectionText {

    public static void main(String[] args)throws IOException {

        InputStream file = CollectionText.class.getResourceAsStream("/text.txt");
        BufferedReader text = new BufferedReader(new InputStreamReader(file));
        String line;
        Comparator<String> comparator = new Comparator<String>() {
            public int compare(String str1, String str2) {
                return Integer.compare(str1.length(), str2.length());
            }
        };
        SortedSet<String> diffwords = new TreeSet<String>();
        SortedSet<String> diffwordslength = new TreeSet<String>(comparator);
        HashMap<String, Integer> count = new HashMap<String, Integer>();
        Collection<String> words = new ArrayList<String>();
        LinkedList<String> lines = new LinkedList<String>();
        while ((line = text.readLine()) != null) {
            lines.add(line);
            for (String word : line.split(" ")) {
                if (!count.containsKey(word)) count.put(word, 1);
                else count.put(word, (count.get(word) + 1));
                words.add(word);
                diffwords.add(word);
            }
        }
        diffwordslength.addAll(diffwords);
        System.out.println(words.size() + " слов в файле");
        System.out.println("Отсортированные по длине:" + diffwordslength);
        System.out.println("Отсортированные по тексту:" + diffwords);
        Iterator<String> keys = diffwords.iterator();
        while (keys.hasNext()) {
            String wordname = keys.next();
            System.out.println(wordname + " встречается в тексте " + count.get(wordname));
        }
        Iterator<String> linesdesc = lines.descendingIterator();
        while(linesdesc.hasNext()) {
            System.out.println(linesdesc.next());
        }
    }

}
