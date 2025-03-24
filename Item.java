import java.util.List;
import java.util.stream.IntStream;

public class Item {
    public Item(String name){
        this.name = name;
    }

    public static List<Item> getItemList(){
        return IntStream
            .range(0, 51)
            .mapToObj(i -> new Item(String.valueOf(i)))
            .toList();
    }

    private String name;

    public void updateName(){
        this.name += "a";
    }
}
