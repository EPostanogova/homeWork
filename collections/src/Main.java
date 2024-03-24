import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        //задание 1
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");
        System.out.println("Задание 1\nисходный HashMap  "+map);
        System.out.println("метод, который поменял ключи и значения в HashMap местами "+swap_places(map));

        //задание 2
        comparison();

        //задание 3
        ArrayList<String> strings =new ArrayList<>();
        strings.add("1");
        strings.add("1");
        strings.add("1");
        strings.add("3");
        strings.add("3");
        strings.add("5");
        removing_duplicates(strings);

    }
    //метод для задания 1
    public static HashMap<String,Integer> swap_places(HashMap<Integer,String> dictionary) {
        HashMap<String,Integer> dictionary2 = new HashMap<>();
        for (HashMap.Entry<Integer, String> entry : dictionary.entrySet()) {
            dictionary2.put(entry.getValue(),entry.getKey());
        }
        return dictionary2;
    }
    //метод для задания 2
    public static void comparison() throws InterruptedException {
        Random random = new Random();
        ArrayList<Integer> myArrayList = new ArrayList<>();
        LinkedList<Integer> myLinkedList = new LinkedList<>();
        for (int i = 0; i < 1000000; i++) {
            myArrayList.add(random.nextInt(10000));
            myLinkedList.add(random.nextInt(10000));
        }
        long start = System.currentTimeMillis();
        for(int i=0; i < 1000; i++){
            myArrayList.get(random.nextInt(myArrayList.size()));
        }
        Thread.sleep(1000);
        long finish = System.currentTimeMillis();
        long elapsed = finish - start;
        System.out.println("время для ArrayList, мс: " + elapsed);
        long start2 = System.currentTimeMillis();
        for(int i=0; i < 1000; i++){
            myLinkedList.get(random.nextInt(myLinkedList.size()));
        }
        Thread.sleep(1000);
        long finish2 = System.currentTimeMillis();
        long elapsed2 = finish2 - start2;
        System.out.println("\nЗадание 2\nвремя для LinkedList, мс: " + elapsed2);
        System.out.println("Вывод по заданию 2: LinkedList реализован в виде связного списка: набора отдельных элементов,\n" +
                "каждый из которых хранит ссылку на следующий и предыдущий элементы. Чтобы получить элемент с номером 100, нужно пройтись последовательно\n" +
                "по всем объектам от 0 до 100. Другими словами операции set и get тут реализованы очень медленно.\n" +
                "ArrayList реализован внутри в виде обычного массива.В нем быстро реализованы взятие и\n" +
                "изменение элемента – операции get, set, так как в них мы просто обращаемся к соответствующему элементу массива. ");
    }

    //метод для задания 3
    public static void removing_duplicates(ArrayList<String> list)  {
        System.out.println("\nЗадание 3\nБыло: " + list);
        HashSet<String> set = new HashSet<String>();
        set.addAll(list);
        System.out.println("После удаления дубликатов: " + set);
    }

}