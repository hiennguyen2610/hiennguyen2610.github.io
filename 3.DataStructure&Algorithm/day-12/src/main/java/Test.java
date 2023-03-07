public class Test {
    public static void main(String[] args) {
        TreeNode node0 = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node5.left = node1;
        node5.right = node6;

        node1.left = node0;
        node1.right = node3;

        node6.left = node2;
        node6.right = node4;

        System.out.println("Done");
    }
}
