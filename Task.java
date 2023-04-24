/*
 * Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.

Пусть дан список сотрудников:

Иван Иванов
Светлана Петрова
Кристина Белова
Анна Мусина
Анна Крутова
Иван Юрин
Петр Лыков
Павел Чернов
Петр Чернышов
Мария Федорова
Марина Светлова
Мария Савина
Мария Рыкова
Марина Лугова
Анна Владимирова
Иван Мечников
Петр Петин
Иван Ежов

* Написать программу, которая найдёт и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности.

* Реализовать алгоритм пирамидальной сортировки (HeapSort).
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;

public class Task {

    public static void addContact (String key, int value, Map<String, ArrayList<Integer>> map){
        if (map.containsKey(key)) {
            map.get(key).add(value);
        } 
        else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(value);
            map.put(key, list);
        }
    }
   
    
    /**
     * @param map
     * @return
     */
    public static ArrayList<String> getName(Map<String, ArrayList<Integer>> map){
        Set<String> keys = map.keySet();
        ArrayList<String> people = new ArrayList<String>();
        Iterator <String> iter =  keys.iterator();
        while (iter.hasNext()) {
            String item = iter.next();
            String [] names = item.split(" ");
            people.add(names[0]);
        }
        return people;
    }

    public static Map<String, Integer> getMap(ArrayList<String> name) {
        Map<String, Integer> mapName = new HashMap<>();
        for (int i = 0; i < name.size(); i++) {
            int count = 1;
            for (int j = i + 1; j < name.size(); j++){
                if (name.get(i).equals(name.get(j))) count += 1;
            }
            if (mapName.containsKey(name.get(i)) == false) mapName.put(name.get(i), count);
        }
        return mapName;
    }
    public static void nameRepeat(Map<String, Integer> map){
        for(var item: map.entrySet()){
            if (item.getValue() > 1) System.out.printf("%s: %d \n", item.getKey(), item.getValue());
        }
    }
    public static void sortName(Map<String, Integer> map){
        ArrayList<Integer> countName = new ArrayList<>();
        for(var item: map.entrySet()) {
            if (countName.contains(item.getValue()) == false) countName.add(item.getValue());
        }
        countName.sort(null);
        for (int i = countName.size()-1; i > -1; i--){
            for (var item: map.entrySet()){
                if (countName.get(i) == item.getValue()) System.out.printf("%s : %d \n", item.getKey(), item.getValue());
            }
        }
    }

    public static void main(String[] args) {
        Map<String, ArrayList<Integer>> phoneBook = new HashMap<>();
        addContact("Иван Иванов", 123456, phoneBook);
        addContact("Светлана Петрова", 654321, phoneBook);
        addContact("Кристина Белова", 456789, phoneBook);
        addContact("Иван Иванов", 987654, phoneBook);
        addContact("Анна Мусина", 987654, phoneBook);
        addContact("Анна Крутова", 987654, phoneBook);
        addContact("Иван Юрин", 987654, phoneBook);
        addContact("Петр Лыков", 987654, phoneBook);
        addContact("Павел Чернов", 987654, phoneBook);
        addContact("Петр Чернышов", 987654, phoneBook);
        addContact("Мария Федорова", 987654, phoneBook);
        addContact("Марина Светлова", 987654, phoneBook);
        addContact("Мария Савина", 987654, phoneBook);
        addContact("Мария Рыкова", 987654, phoneBook);
        addContact("Марина Лугова", 987654, phoneBook);
        addContact("Анна Владимирова", 987654, phoneBook);
        addContact("Иван Мечников", 987654, phoneBook);
        addContact("Петр Петин", 987654, phoneBook);
        addContact("Иван Ежов", 987654, phoneBook);
    
        ArrayList<String> name = getName(phoneBook);
        Map<String, Integer> mapName =  getMap(name);
        System.out.println("Повторяющиеся имена: ");
        nameRepeat(mapName);
        System.out.println("Имена по убыванию популярности: ");
        sortName(mapName);
    }
    
}