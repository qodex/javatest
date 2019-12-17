package au.com.qodex.javatest.utils;

import org.springframework.stereotype.Component;

@Component
public class TruncatorImpl implements Truncator {

    private String msgHalf1 = " ... (trun";
    private String msgHalf2 = "cated) ... ";

    public String truncate(String str, int len) {
        System.out.println("Truncating '"+str+"', length "+str.length()+", max length "+len);
        str = str == null ? "" : str;
        String result = str;
        boolean needsTruncated = str.length()>len && (msgHalf1+msgHalf2).length()<str.length();
        if(needsTruncated) {
            Halves halves = new Halves(str);
            int excess = str.length() - len;
            int firstHalfExcess = excess/2;
            int secondHalfExcess = excess - firstHalfExcess;
            halves.firstHalfExcess(firstHalfExcess + msgHalf1.length());
            halves.secondHalfExcess(secondHalfExcess + msgHalf2.length());
            halves.firstHalfAppend(msgHalf1);
            halves.secondHalfPreppend(msgHalf2);
            result = halves.join();
        }
        System.out.println("Result: '"+result+"', length "+result.length());
        return result;
    }

}

class Halves {

    String firstHalf;
    String secondHalf;

    public Halves(String str) {
        int halfLength = str.length()/2;
        this.firstHalf = str.substring(0, halfLength);
        this.secondHalf = str.substring(firstHalf.length(), str.length());
        System.out.println("First half: "+this.firstHalf);
        System.out.println("Second half: "+this.secondHalf);
    }

    public void firstHalfExcess(int excess) {
        this.firstHalf = this.firstHalf.substring(0, this.firstHalf.length() - 1 - excess);
    }

    public void secondHalfExcess(int excess) {
        System.out.println("excess "+excess+", string length "+this.secondHalf.length());
        this.secondHalf = this.secondHalf.substring(excess-1);
    }

    public void firstHalfAppend(String str) {
        this.firstHalf = this.firstHalf + str;
    }

    public void secondHalfPreppend(String str) {
        this.secondHalf = str + this.secondHalf;
    }

    public String join() {
        return this.firstHalf+this.secondHalf;
    }
}