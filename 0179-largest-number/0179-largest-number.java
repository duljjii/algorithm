class Solution {
    public String largestNumber(int[] nums) {
        List<String> numStr = Arrays.stream(nums).mapToObj(String::valueOf).collect(Collectors.toList());
        Collections.sort(numStr, (a, b) -> (b+a).compareTo(a+b));
        if(numStr.get(0).equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for(String str : numStr){
            sb.append(str);
        }
        return sb.toString();

    }
}