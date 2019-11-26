package cloud.jony.hello;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * 有一个数字和一句描述的Item类.
 */
public class Item implements Comparable<Item>{
    private String description;
    private int partNumber;

    /**
     * 生成一个Item.
     * @param description 描述
     * @param partNumber 编号
     */
    public Item(String description, int partNumber) {
        this.description=description;
        this.partNumber=partNumber;
    }

    public String getDescription() {
        return description;
    }

    public int getPartNumber() {
        return partNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return partNumber == item.partNumber &&
                Objects.equals(description, item.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, partNumber);
    }

    @Override
    public int compareTo(@NotNull Item o) {
        int diff = Integer.compare(partNumber, o.partNumber);
        return diff != 0 ? diff : description.compareTo(o.description);
    }

    @Override
    public String toString() {
        return "Item{" +
                "description='" + description + '\'' +
                ", partNumber=" + partNumber +
                '}';
    }
}
