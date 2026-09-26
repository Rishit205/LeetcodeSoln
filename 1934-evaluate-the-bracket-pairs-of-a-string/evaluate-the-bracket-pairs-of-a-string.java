
class Solution {

    public String evaluate(String s, List<List<String>> ll) {

        StringBuilder abc = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        HashMap<String, String> h = new HashMap<>();

        for (int i = 0; i < ll.size(); i++) {
            String x = ll.get(i).get(0);
            String y = ll.get(i).get(1);

            h.put(x, y);
        }

        for (int i = 0; i < s.length(); i++) {
            char q = s.charAt(i);
            if (q == '(') {

                i++;
                temp.setLength(0);

                while (s.charAt(i) != ')') {
                    temp.append(s.charAt(i));
                    i++;
                }

                String key = temp.toString();

                if (h.containsKey(key)) {
                    abc.append(h.get(key));
                } else {
                    abc.append("?");
                }

            } else {
                abc.append(q);
            }
        }

        return abc.toString();
    }
}