package 独特的电子邮件地址;

import java.util.HashSet;

public class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();
        for(String email : emails){
            int index = email.indexOf('@');
            String sub1 = email.substring(0, index);
            String sub2 = email.substring(index+1, email.length());
            StringBuffer sb = new StringBuffer();
            for(int i = 0; i < sub1.length(); ++i){
                char ch = sub1.charAt(i);
                if(ch == '.'){
                    continue;
                }
                if(ch == '+'){
                    break;
                }
                sb.append(ch);
            }
            sb.append('@');
            sb.append(sub2);
            set.add(sb.toString());
        }
        return set.size();
    }
    public static void main(String[] args) {
        String s = "ab.cde.fg";
        String[] s1 = s.split("\\.");
        System.out.println(s1[0]);
        System.out.println(s1[1]);
        System.out.println(s1[2]);
    }
}


