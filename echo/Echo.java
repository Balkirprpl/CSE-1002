public class Echo {
        public static void main(String[] args)
    {
        String s1 = "abc", s2 = "a", s3 = "bc", s4 = s2 + s3;
        System.out.println(s1 == s4);
        System.out.println(s1.equals(s4));

        m(s1);
        System.out.println(s1 == "xyz");
        System.out.println(s1.equals("xyz"));
    }

    public static void m(String s)
    {
        s = "xyz";
    }
}