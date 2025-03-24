class ThreadTest {
    public static void main(String[] args){
        ThingDoer thingDoer3000 = new ThingDoer3000();
        ThingDoer thingDoerThreadPool = new ThingDoerThreadPool();
        ThingDoer thingDoerVirtualThreads = new ThingDoerVirtualThreads();

        long noThreadPoolStart = System.currentTimeMillis();
        doThingsALot(thingDoer3000);
        long noThreadPoolFinish = System.currentTimeMillis();

        long threadPoolStart = System.currentTimeMillis();
        doThingsALot(thingDoerThreadPool);
        long threadPoolFinish = System.currentTimeMillis();

        long virtualThreadStart = System.currentTimeMillis();
        doThingsALot(thingDoerVirtualThreads);
        long virtualThreadFinish = System.currentTimeMillis();

        System.out.println("No thread pool time: " + (noThreadPoolFinish - noThreadPoolStart));
        System.out.println("Thread pool time: " + (threadPoolFinish - threadPoolStart));
        System.out.println("Virtual threads time: " + (virtualThreadFinish - virtualThreadStart));

        return;
    }

    private static void doThingsALot(ThingDoer thingDoer){
        for(int i = 0; i < 10_000; i++){
            thingDoer.doThings();
        }
    }

}