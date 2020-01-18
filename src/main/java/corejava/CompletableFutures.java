package corejava;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Order processing flow has following events
 * -> create -> enrich -> confirm -> pay -> package -> deliver
 * Design a system to allow process orders concurrently
 */

enum Item {
    IPHONE_6, IPHONE_8_PLUS, GALAXY_S9;
}

enum Status {
    CREATED, ENRICHED, CONFIRMED, PAYED, DELIVERED;
}

class Order {
    long id;
    List<Item> itemlList;
    Status status;

    public Order(long id) {
        this.id = id;
        this.itemlList = new ArrayList<>();
        init();
    }

    private void process(String event) {
        Logger.getGlobal().info(this + " Start processing -> " + event);
        try {
            Thread.sleep(1000 * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Logger.getGlobal().info(this + "Finish processing -> " + event);
    }

    public void init() {
        this.status = Status.CREATED;
    }

    public void enrich() {
        process("enrich");
        this.status = status.ENRICHED;
    }

    public void confirm() {
        process("confirm");
        this.status = Status.CONFIRMED;
    }

    public void pay() {
        process("pay");
        this.status = Status.PAYED;
    }

    public void deliver() {
        process("deliver");
        this.status = Status.DELIVERED;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", itemlList=" + itemlList +
                ", status=" + status +
                '}';
    }
}

public class CompletableFutures {
    private static final ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {

        List<Order> orderList = IntStream.range(0, 10).mapToObj(i -> new Order(i)).collect(Collectors.toList());

        orderProcess(orderList);
        concurrentOrderProcessNonBlocking(orderList);
        concurrentOrderProcessBlocking(orderList);

        executorService.shutdown();
    }

    /**
     * Sequentially process the orders in the main thread.
     * Note the slowness
     *
     * @param orders
     */
    private static void orderProcess(List<Order> orders) {
        Logger.getGlobal().info("---------------------- \nStart processing orders..");
        orders.stream().forEach(order -> processOrder(order));
        Logger.getGlobal().info("---------------------- \nOrders:" + orders + "\nFinish processing orders..");
    }

    /**
     * Concurrently process the orders in non-blocking way using Runnable tasks.
     * Note the main thread finishes before all the orders are processed hence, unable to see the final
     * status of all the orders.
     *
     * @param orders
     */
    private static void concurrentOrderProcessNonBlocking(List<Order> orders) {
        Logger.getGlobal().info("---------------------- \nStart processing orders..");
        orders.stream().forEach(order -> executorService.execute(new RunnableTask(order)));
        Logger.getGlobal().info("---------------------- \nOrders:" + orders + "\nFinish processing orders..");
    }

    /**
     * Concurrently process the orders my blocking the main thread using Callable tasks.
     * Note the main thread waits until all the orders are processed and then prints
     * status of all the orders.
     *
     * @param orders
     */
    private static void concurrentOrderProcessBlocking(List<Order> orders) {
        Logger.getGlobal().info("---------------------- \nStart processing orders..");
        orders.stream()
                .map(order -> executorService.submit(new RunnableTask(order)))
                .collect(Collectors.toList())
                .stream()
                .forEach(future -> {
                    try {
                        future.get();
                    } catch (InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                    }
                });
        Logger.getGlobal().info("---------------------- \nOrders:" + orders + "\nFinish processing orders..");
    }

    public static Order processOrder(Order order) {
        order.enrich();
        order.confirm();
        order.pay();
        order.deliver();
        return order;
    }

    static class CallableTask implements Callable<Order> {
        private Order order;

        public CallableTask(Order order) {
            this.order = order;
        }

        @Override
        public Order call() {
            return processOrder(order);
        }
    }

    static class RunnableTask implements Runnable {
        private Order order;

        public RunnableTask(Order order) {
            this.order = order;
        }

        @Override
        public void run() {
            processOrder(order);
        }

    }
}
