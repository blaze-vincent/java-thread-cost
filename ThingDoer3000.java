import java.util.List;
import java.util.concurrent.CountDownLatch;

public class ThingDoer3000 implements ThingDoer {
    public ThingDoer3000(){
        this.items = Item.getItemList();
    }

    private List<Item> items;
    
    public void doThings(){
        CountDownLatch countDownLatch = new CountDownLatch(items.size());

        for(Item item : items) {
            Thread thread = new Thread(() -> {
                item.updateName();
                countDownLatch.countDown();
            });
            thread.start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}