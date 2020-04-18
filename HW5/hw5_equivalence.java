class Department {
    public String name;
    public String address;
}

class School {
    public String name;
    public String address;
}

public class EquivalenceTester {
    public static void main(String[] args) {
        Department d1 = new Department();
        School s1;
        d1.name = "Starbucks";
        d1.address = "1912 Pike Place";

        try {
            s1 = d1;
            System.out.println(s1.name + " " + s1.address);
        } catch(Exception e) {
            System.out.println("Language uses name equivalence.");
        }
    }
}
