package LeetCode.BinaryTree;

import java.util.List;

public class MaximumHappiness {

    public static int maxHappy(Employee boss) {
        Info headInfo = process(boss);
        return Math.max(headInfo.comeMaxHappy, headInfo.notComeMaxHappy);
    }

    public static class Employee {
        public int happy;// 这名员工可以带来的快乐值
        public List<Employee> nexts;// 这名员工有哪些直接下级
    }

    public static class Info {
        public int comeMaxHappy;
        public int notComeMaxHappy;

        public Info(int comeMaxHappy, int notComeMaxHappy) {
            this.comeMaxHappy = comeMaxHappy;
            this.notComeMaxHappy = notComeMaxHappy;
        }
    }

    public static Info process(Employee x) {
        if (x.nexts.isEmpty()) {
            return new Info(x.happy, 0);
        }
        int come = x.happy; //来的话最大快乐值
        int notCome = 0; //不来的话最大快乐值
        for (Employee next : x.nexts
        ) {
            Info nextInfo = process(next);
            come += nextInfo.notComeMaxHappy; //此员工上级来，那么此员工不来
            notCome += Math.max(nextInfo.comeMaxHappy, nextInfo.notComeMaxHappy);//上级不来，那么员工可以来也可以不来，选最好的
        }
        return new Info(come, notCome);
    }
}
