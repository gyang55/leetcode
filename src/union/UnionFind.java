package union;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class UnionFind {
    //进来包一层，叫做元素
    public static class Element<V> {
        public V value;

        public Element(V value) {
            this.value = value;
        }
    }

    public static class UnionFindSet<V> {
        public HashMap<V, Element<V>> elementMap; //key 元素自己 value 包装后的元素
        public HashMap<Element<V>, Element<V>> fatherMap; //key 某个元素 value 该元素的父

        public HashMap<Element<V>, Integer> sizeMap; // key 某个集合的代表元素 value 该集合的大小

        public UnionFindSet(List<V> list) {
            this.elementMap = new HashMap<>();
            this.fatherMap = new HashMap<>();
            this.sizeMap = new HashMap<>();

            for (V value : list
            ) {
                Element<V> element = new Element<V>(value);
                elementMap.put(value, element);
                fatherMap.put(element, element);
                sizeMap.put(element, 1);
            }
        }

        public boolean isSameSet(V a, V b) {
            if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
                return findHead(elementMap.get(a)) == findHead(elementMap.get(b));
            }
            return false;
        }

        //给定一个element，往上找，把代表元素返回
        private Element<V> findHead(Element<V> element) {
            Stack<Element<V>> path = new Stack<>();
            while (element != fatherMap.get(element)) {
                path.push(element);
                element = fatherMap.get(element);
            }

            while (!path.isEmpty()) {
                fatherMap.put(path.pop(), element);
            }
            return element;
        }

        public void union(V a, V b) {
            if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
                Element<V> aFather = findHead(elementMap.get(a));
                Element<V> bFather = findHead(elementMap.get(b));
                if (aFather != bFather) {
                    Element<V> big = sizeMap.get(aFather) >= sizeMap.get(bFather) ? aFather : bFather;
                    Element<V> small = big == aFather ? bFather : aFather;
                    fatherMap.put(small, big);
                    sizeMap.put(big, sizeMap.get(aFather) + sizeMap.get(bFather));
                    sizeMap.remove(small);
                }
            }
        }
    }
}
