public class Counter implements AutoCloseable {
    private int count;

    public Counter() {
        this.count = 0; 
    }

    public void add() {
        count++; // Увеличение значения счетчика на 1
        System.out.println("Animal added. Current count: " + count);
    }

    public int getCount() {
        return count; // Получение текущего значения счетчика
    }

    @Override
    public void close() {
        System.out.println("Counter is closed.");
    }
}
