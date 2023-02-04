package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x -> {
            for (String s : x)
                if (Character.isLowerCase(s.charAt(0)) || Character.isDigit(s.charAt(0)))
                    return false;
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return list -> {
            int length = list.size();
            for (int i = 0; i < length; i++) {
                if (list.get(i) % 2 == 0)
                    list.add(list.get(i));
            }
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> list = new ArrayList<>();
            for (String value : values) {
                if (Character.isUpperCase(value.charAt(0))&&value.endsWith(".")&&value.split(" ").length>3)
                    list.add(value);
            }
            return list;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x->{
            Map<String,Integer> map=new HashMap<>();
            for (String str : x) {
                map.put(str,str.length());
            }
            return map;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1,list2)->{
            List<Integer> list=new ArrayList<>();
            list.addAll(list1);
            list.addAll(list2);
            return list;
        };
    }
}
