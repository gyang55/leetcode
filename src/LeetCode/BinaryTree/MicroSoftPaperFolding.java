package LeetCode.BinaryTree;

public class MicroSoftPaperFolding {
    public void printAllNodes(int n) {
        printProcess(1, n, true);
    }

    // 凹 down==true 凸 down==false
    private void printProcess(int level, int n, boolean down) {
        if (level > n) {
            return;
        }
        printProcess(level + 1, n, true);
        System.out.print(down ? "凹" : "凸");
        printProcess(level + 1, n, false);
    }
}
