import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThingDoerThreadPool implements ThingDoer {
    public ThingDoerThreadPool(){
        this.items = Item.getItemList();
        this.executorService = Executors.newFixedThreadPool(items.size());
    }

    private final ExecutorService executorService;
    private List<Item> items;

    public void doThings(){
        CountDownLatch countDownLatch = new CountDownLatch(items.size());

        for(Item item : items) {
            executorService.submit(() -> {
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