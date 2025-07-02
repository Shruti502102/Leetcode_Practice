class Solution {
    private static final int MOD = 1_000_000_007;
    public int possibleStringCount(String word, int k) {
        List<Integer> groups = new ArrayList<>();
        int cnt = 1;
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                cnt++;
            } else {
                groups.add(cnt);
                cnt = 1;
            }
        }
        groups.add(cnt);
        long total = 1;
        for (int g : groups) {
            total = total * g % MOD;
        }
        if (k <= groups.size()) return (int) total;
        int n = groups.size();
        int[] dp = new int[k]; 
        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            int g = groups.get(i);
            int[] newDp = new int[k];
            long windowSum = 0;
            for (int j = i; j < k; j++) {

                newDp[j] = (int) ((newDp[j] + windowSum) % MOD);
                windowSum = (windowSum + dp[j]) % MOD;
                if (j >= g) {
                    windowSum = (windowSum - dp[j - g] + MOD) % MOD;
                }
            }
            dp = newDp;
        }
        long invalid = 0;
        for (int x : dp) invalid = (invalid + x) % MOD;

        return (int) ((total - invalid + MOD) % MOD);
    }
}
