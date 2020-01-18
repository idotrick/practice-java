/*
 * https://leetcode.com/discuss/interview-question/373202
 */

import java.util.*;

class Element {
    int id, value;

    Element() {
    }

    Element(int id, int value) {
        this.id = id;
        this.value = value;
    }

    public String toString() {
        return "[" + this.id + ", " + this.value + "]";
    }
}

class AmazonOptimalUtilization {
    static List<Element> solution(List<Element> a, List<Element> b, int target) {
        List<Element> result = new ArrayList<>();

        for (int t = target; t >= 0 && result.size() == 0; t--) {
            for (Element ae : a) {
                int aComp = t - ae.value;
                for (Element be : b) {
                    if (aComp == be.value) {
                        result.add(new Element(ae.id, be.id));
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        tc1();
        tc2();
        tc3();
        tc4();
    }

    static void tc1() {
        List<Element> a = Arrays.asList(new Element(1, 2), new Element(2, 4), new Element(3, 6));
        List<Element> b = Arrays.asList(new Element(1, 2));
        int t = 7;
        List<Element> e = Arrays.asList(new Element(2, 1));
        List<Element> r = solution(a, b, t);
        System.out.println("---- TC1 --- \nInputs a:" + a + ", b:" + b + ", t:" + t + "\nExpected:" + e + "\nActual:" + r);

    }

    static void tc2() {
        List<Element> a = Arrays.asList(new Element(1, 3), new Element(2, 5), new Element(3, 7), new Element(4, 10));
        List<Element> b = Arrays.asList(new Element(1, 2), new Element(2, 3), new Element(3, 4), new Element(4, 5));
        int t = 10;
        List<Element> e = Arrays.asList(new Element(2, 4), new Element(3, 2));
        List<Element> r = solution(a, b, t);
        System.out.println("---- TC2 --- \nInputs a:" + a + ", b:" + b + ", t:" + t + "\nExpected:" + e + "\nActual:" + r);

    }

    static void tc3() {
        List<Element> a = Arrays.asList(new Element(1, 8), new Element(2, 7), new Element(3, 14));
        List<Element> b = Arrays.asList(new Element(1, 5), new Element(2, 10), new Element(3, 14));
        int t = 20;
        List<Element> e = Arrays.asList(new Element(3, 1));
        List<Element> r = solution(a, b, t);
        System.out.println("---- TC3 --- \nInputs a:" + a + ", b:" + b + ", t:" + t + "\nExpected:" + e + "\nActual:" + r);

    }

    static void tc4() {
        List<Element> a = Arrays.asList(new Element(1, 8), new Element(2, 15), new Element(3, 9));
        List<Element> b = Arrays.asList(new Element(1, 8), new Element(2, 11), new Element(3, 12));
        int t = 20;
        List<Element> e = Arrays.asList(new Element(1, 3), new Element(3, 2));
        List<Element> r = solution(a, b, t);
        System.out.println("---- TC3 --- \nInputs a:" + a + ", b:" + b + ", t:" + t + "\nExpected:" + e + "\nActual:" + r);

    }
}
