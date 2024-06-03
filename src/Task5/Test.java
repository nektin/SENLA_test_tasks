package Task5;

//Есть набор предметов, задаваемый заранее, предметы могут повторяться. Предмет имеет 2 параметра
//(обязательных, остальные добавлять на усмотрение): объем (целое значение) и ценность (целое значение). Предметы неделимы.
//Также задаётся сейф с обязательным параметром его объёма (целое значение).
//Нужно написать программу, которая наполняет сейф набором предметов таким образом, чтобы ценность этого набора была максимальной.

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<Item> itemList=new ArrayList<>();
        itemList.add(new Item(3,1,"Планшет"));
        itemList.add(new Item(4,6,"Телефон"));
        itemList.add(new Item(5,4,"Наушники"));
        itemList.add(new Item(8,7,"Документы"));
        itemList.add(new Item(9,6,"Слиток"));

        int maxSafeWeight =13;
        ConfigurationSafe.fillingByMaxValue(itemList,maxSafeWeight);
    }
}
