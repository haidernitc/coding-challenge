public class Main {
    
    static BreakIterator boundary = BreakIterator.getCharacterInstance();
    
    public static void main(String[] args) {
        System.out.println("Welcome to the SAP Community Coding Challenge #3");
        //removeJoiner("\uD83D\uDC68\u200D\uD83D\uDC69\u200D\uD83D\uDC67\u200D\uD83D\uDC66"); O/P: [👨, 👩, 👧, 👦]
        //addJoiner("\uD83D\uDC69\uD83D\uDCBB"); O/P: 👩‍💻 
    }

    public String removeJoiner(String emoji) {
        boundary.setText(emoji);
        int start = boundary.first();
        List<String> result = new ArrayList();
        for (int end = boundary.next(); end != BreakIterator.DONE; end = boundary.next()) {
            if(emoji.substring(start, end).length()>1) {
                result.add(emoji.substring(start, end));
            }
            start = end;
        }
    return result.toString();
   }

   public String addJoiner(String emojis) {
         StringBuffer result = new StringBuffer(  );
            boundary.setText(emoji);
            int start = boundary.first();
            for (int end = boundary.next(); end != BreakIterator.DONE; end = boundary.next()) {
                if(emoji.substring(start, end).length()>1) {
                    result.append(emoji.substring(start, end)+"\u200D");
                }
                start = end;
            }
       result.deleteCharAt(result.length()-1);
       return result.toString();
    }
}
