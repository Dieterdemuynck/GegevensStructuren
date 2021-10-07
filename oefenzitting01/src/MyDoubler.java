import java.util.HashMap;

public class MyDoubler implements Doubler{
    @Override
    public boolean isDouble(String str) {
        str = str.toLowerCase();
        HashMap<Character, Integer> charCount = new HashMap<>();
        for (int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if (charCount.containsKey(c)){
                charCount.put(c, charCount.get(c) + 1);
            } else {
                charCount.put(c, 1);
            }
        }

        for (int i: charCount.values()){
            if (i != 2){
                return false;
            }
        }

        return true;
    }
}
