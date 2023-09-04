class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (a, b)->{
            String[] logA = a.split(" ");
            String[] logB = b.split(" ");
            boolean isDigitA = Character.isDigit(logA[1].charAt(0));
            boolean isDigitB = Character.isDigit(logB[1].charAt(0));
            if(!isDigitA && !isDigitB ){
                for(int i=1; i<Math.min(logA.length, logB.length); i++){
                if(!logA[i].equals(logB[i])){
                    return logA[i].compareTo(logB[i]);
                }
            }
            return logA.length == logB.length ? logA[0].compareTo(logB[0]) : logA.length - logB.length;
            }else{
                return isDigitA ? (isDigitB ? 0 : 1) : -1;
            }
            
        });

        return logs;
    }
}