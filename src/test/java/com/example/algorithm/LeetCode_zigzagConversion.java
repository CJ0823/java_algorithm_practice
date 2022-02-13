package com.example.algorithm;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LeetCode_zigzagConversion {

        public String convert(String s, int numRows) {

            //nR=3 -> 4
            //nR=4 -> 6
            //nR=5 -> 8 ...
            //length of unit = 2(nR -1)
            //s.length % lou = 1, (7) = k
            //sl % lou = 2,6
            // = 3, 5
            // = 4

            //nR = 3
            //k = 1, (5)
            //k = 2, 4
            //k = 3

            // i , j
            // 1~nR, lou+1~nR

            //lou = 2(nR-1)
            //result = s;
            //while result.legnth < s.length and k <= nR
            //for s, ((s.get(idx)) % lou) == k or == lou + 1 -> result.append

            int lou = 2 * (numRows - 1);
            StringBuffer resultSb = new StringBuffer();
            int k = 1;
            int sl = s.length();
            while(k <= numRows) {
                while(resultSb.length() < sl) {
                    for(int i = 0; i < sl; i++) {
                        if((i+1) % lou == k) {
                            resultSb.append(s.charAt(k - 1));
                        } else if((i+1) % lou == 2*numRows - 1 - k) {
                            resultSb.append(s.charAt(2*numRows - 1 - k - 1));
                        }
                    }
                }
                k += 1;
            }
            return resultSb.toString();

        }

    @Test
    void contextLoads() {

        String s = "PAYPALISHIRING";
        int numRows = 4;

        String result = convert(s, numRows);
        System.out.println("result = " + result);
    }

}
