package sort;

public class CountingSort {
    public static void countingSortFront(int[] arr) {
        // 判空及防止数组越界
        if (arr == null || arr.length <= 1) return;
        // 找到最大值，最小值
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
            else if (arr[i] < min) min = arr[i];
        }
        // 确定计数范围
        int range = max - min + 1;
        // 建立长度为 range 的数组，下标 0~range-1 对应数字 min~max
        int[] counting = new int[range];
        // 遍历 arr 中的每个元素
        for (int element : arr) {
            // 将每个整数出现的次数统计到计数数组中对应下标的位置，这里需要将每个元素减去 min，才能映射到 0～range-1 范围内
            counting[element - min]++;
        }
        // 记录前面比自己小的数字的总数
        int preCounts = 0;
        for (int i = 0; i < range; i++) {
            // 当前的数字比下一个数字小，累计到 preCounts 中
            preCounts += counting[i];
            // 将 counting 计算成当前数字在结果中的起始下标位置。位置 = 前面比自己小的数字的总数。
            counting[i] = preCounts - counting[i];
        }
        int[] result = new int[arr.length];
        for (int element : arr) {
            // counting[element - min] 表示此元素在结果数组中的下标
            result[counting[element - min]] = element;
            // 更新 counting[element - min]，指向此元素的下一个下标
            counting[element - min]++;
        }
        // 将结果赋值回 arr
        for (int i = 0; i < arr.length; i++) {
            arr[i] = result[i];
        }
    }

    public static void countingSortBack(int[] arr) {
        // 防止数组越界
        if (arr == null || arr.length <= 1) return;
        // 找到最大值，最小值
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
            else if (arr[i] < min) min = arr[i];
        }
        // 确定计数范围
        int range = max - min + 1;
        // 建立长度为 range 的数组，下标 0~range-1 对应数字 min~max
        int[] counting = new int[range];
        // 遍历 arr 中的每个元素
        for (int element : arr) {
            // 将每个整数出现的次数统计到计数数组中对应下标的位置，这里需要将每个元素减去 min，才能映射到 0～range-1 范围内
            counting[element - min]++;
        }
        // 每个元素在结果数组中的最后一个下标位置 = 前面比自己小的数字的总数 + 自己的数量 - 1。我们将 counting[0] 先减去 1，后续 counting 直接累加即可
        counting[0]--;
        for (int i = 1; i < range; i++) {
            // 将 counting 计算成当前数字在结果中的最后一个下标位置。位置 = 前面比自己小的数字的总数 + 自己的数量 - 1
            // 由于 counting[0] 已经减了 1，所以后续的减 1 可以省略。
            counting[i] += counting[i - 1];
        }
        int[] result = new int[arr.length];
        // 从后往前遍历数组，通过 counting 中记录的下标位置，将 arr 中的元素放到 result 数组中
        for (int i = arr.length - 1; i >= 0; i--) {
            // counting[arr[i] - min] 表示此元素在结果数组中的下标
            result[counting[arr[i] - min]] = arr[i];
            // 更新 counting[arr[i] - min]，指向此元素的前一个下标
            counting[arr[i] - min]--;
        }
        // 将结果赋值回 arr
        for (int i = 0; i < arr.length; i++) {
            arr[i] = result[i];
        }
    }


}
