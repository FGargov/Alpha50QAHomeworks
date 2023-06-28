public class ComparingStrings {
    public static void main(String[] args) {
        // String equality
        String str1 = "telerik";
        String str2 = "Telerik";
        System.out.println(str1.equals(str2));               // false
        System.out.println(str1.equals(str2.toLowerCase())); // true

        // String comparison
        String str3 = "telerik";
        String str4 = "Telerik";
        System.out.println(str3.compareTo(str4));               // (positive)
        System.out.println(str3.compareTo(str4.toLowerCase())); // 0
    }
}
