import java.util.List;
import java.util.concurrent.CountDownLatch;

public class ThingDoerVirtualThreads implements ThingDoer {
    public ThingDoerVirtualThreads(){
        this.items = Item.getItemList();
    }

    private List<Item> items;
    
    public void doThings(){
        CountDownLatch countDownLatch = new CountDownLatch(items.size());

        for(Item item : items) {
            Thread.startVirtualThread(() -> {
                item.updateName();
                countDownLatch.countDown();
            });
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
