package cloud.jony.hello;

enum Size{
    SMALL("S"),MEDIUM("M"),LARGE("L"), EXTRA_LARGE("XL");

    private String abbreviation;
    private Size(String abbreviation) {
        this.abbreviation=abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }
}

public class EnumTest {
    public static void main(String[] args) {
        Size size = Enum.valueOf(Size.class, "SMALL");

        System.out.println("size = " + size);
        System.out.println("size.getAbbreviation() = " + size.getAbbreviation());

        Size[] sizes=Size.values();
        for (Size s :
                sizes) {
            System.out.println(s.getAbbreviation()+s);
        }

        System.out.println(size.compareTo(Size.EXTRA_LARGE));
        System.out.println(size.ordinal());
    }


}
