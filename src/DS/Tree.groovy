package Utils.DS

public class Tree {

    static Node rootnode;
    public static int x, y;

    public static class Node {

        Node left;
        Node right;
        Node parent;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        rootnode = new Node(25);
        System.out.println("Building tree with root value " + rootnode.value);
        System.out.println("=================================");

        insert(rootnode, 11);
        insert(rootnode, 79);
        insert(rootnode, 80);
        insert(rootnode, 17);
        insert(rootnode, 9);
        insert(rootnode, 18);
        insert(rootnode, 19);
        insert(rootnode, 72);
        insert(rootnode, 12);

        System.out.println("INORDER: "); InorderDisplay(rootnode); System.out.println();
        //delete(rootnode,19)
        /*deleteNode(rootnode,79)
        System.out.println("Preorder: "); InorderDisplay(rootnode); System.out.println();*/

        /*System.out.println("Inorder: "); PreorderDisplay(rootnode); System.out.println();
        System.out.println("Postorder: "); PostorderDisplay(rootnode); System.out.println();

        System.out.println("Parent of 9 is: " +getParentValue(rootnode, 9));

        System.out.println("Depth is: " + getDepth(rootnode));

        System.out.println("Level of the element:" + getLevelOfNode(rootnode,12,1));
        System.out.println("Parent of the element 19:" + findParent(rootnode, 19));

        String isBalanced = Math.abs(isBalanced(rootnode.right)-(isBalanced(rootnode.right)))<=1?"Yes":"No";
        System.out.println("Is the Binary tree Balanced:" + isBalanced)


        System.out.println("Tree size is: " + treeSize(rootnode));
        System.out.println("Height of the Node is: " + (heightOfANode(79,rootnode)-1));

        System.out.println("BFS: ");
        bfs();println()
        System.out.println("Printing Leaf Nodes:: ")
        leafNodes(rootnode,1);*/
    }

    /* This will have O(log n) time complexity*/
    public static int getParentValue(Node node, int valueToSearch) {
        if (node.left != null && node.value > valueToSearch) {
            if (node.left.value == valueToSearch) {
                x = node.left.parent.value;
            } else {
                getParentValue(node.left, valueToSearch);
            }
        } else if (node.right != null && node.value < valueToSearch) {
            if (node.right.value == valueToSearch) {
                x = node.right.parent.value;
            } else {
                getParentValue(node.right, valueToSearch);
            }
        }
        return x;
    }

    /* Number of elements in the Tree*/
    public static int treeSize(Node node) {
        if (node == null)
            return 0;
        return 1 + treeSize(node.left) + treeSize(node.right);
    }

    /*Number of maximum edges between the node and the leaf*/
    public static int heightOfANode(Node node) {
        if (node == null)
            return 0;
        return 1 + Math.max(heightOfANode(node.left),heightOfANode(node.right));
    }

    public static heightOfANode(int object, Node node) {
        if (node.value == object){
            heightOfANode(node);
        }
        else if(node.left != null && object <=node.value){
            heightOfANode(object,node.left);
        }
        else if(node.right != null && object >= node.value){
            heightOfANode(object,node.right);
        }
    }

    public static int isBalanced(Node node) {
        if(node==null){
            return 0;
        }
        else {
            return  1 + isBalanced(node.left) + isBalanced(node.right);
        }
    }

    public static int height(Node node) {

        if (node == null)
            return 0;
        return 1 + Math.max((height(node.left)), height(node.right));
    }

    public static void InorderDisplay(Node node) {
        if (node.left != null) {
            InorderDisplay(node.left);
        }
        System.out.print(node.value + "-");

        if (node.right != null) {
            InorderDisplay(node.right);
        }
    }

    public static void PreorderDisplay(Node node) {
        System.out.print(node.value + "-");

        if (node.left != null) {
            PreorderDisplay(node.left);
        }
        if (node.right != null) {
            PreorderDisplay(node.right);
        }
    }

    public static void PostorderDisplay(Node node) {
        if (node.left != null) {
            PostorderDisplay(node.left);
        }
        if (node.right != null) {
            PostorderDisplay(node.right);
        }
        System.out.print(node.value+ "  :: ");
    }

    public static void bfs() {
        /*Queue.add - throws an exception if the operation fails,
        Queue.offer- returns a special value (either null or false, depending on the operation).*/
        Queue<Node> q = new LinkedList<Node>();
        q.offer(rootnode);

        while (!q.isEmpty()) {
            Node node = q.poll();
            System.out.print(node.value + "-");
            if (node.left != null)
                q.offer(node.left);
            if (node.right != null)
                q.offer(node.right);
        }
    }

    public static int getDepth(Node node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + Math.max(getDepth(node.left),getDepth(node.right))
        }
    }

    public static int getLevelOfNode(Node node, int val, int level) {
        if (node.value == val){
            return level;
        }
        else if (node.left != null && val <= node.value){
            getLevelOfNode(node.left,val,level+1)
        }
        else if (node.right != null && val >= node.value){
            getLevelOfNode(node.right,val,level+1)
        }
    }
    /*Inserts a Node to the Tree*/
    public static void insert(Node node, int value) {
        if (value <= node.value) {
            if (node.left != null) {
                insert(node.left, value);
            } else {
                System.out.println("  Inserted " + value + " to left of Node " + node.value);
                node.left = new Node(value);
                node.left.parent = node;
            }
        } else if (value > node.value) {
            if (node.right != null) {
                insert(node.right, value);
            } else {
                System.out.println("  Inserted " + value + " to right of Node " + node.value);
                node.right = new Node(value);
                node.right.parent = node;
            }
        }
    }

    public static void leafNodes(Node node,int level){
        if((node.left == null) && (node.right == null) ){
            println(node.value+"--"+level)
        }
        if(node.left!=null){leafNodes(node.left,level+1);}
        if(node.right!=null){leafNodes(node.right,level+1);}
    }

    public static int getLowestNumberFromThatNode(Node node) {
        if(node.left.left == null){
            x = node.left.value;
            node.left=null;
        }
        else (getLowestNumberFromThatNode(node.left))

        return x;

    }

    public static void deleteNode(Node node, int val) {
        if (node.left!=null && val <= node.value){
            if(node.left.value==val){
                if (node.left.left==null && node.left.right==null){
                    node.left = null;
                }
                else if(node.left.left != null){
                    if(node.left.right==null) {
                        node.left = node.left.left;
                        node.left.parent = node;
                    }
                    else if(node.left.right.left==null){
                        node.left.right.left=node.left.left;
                        node.left=node.left.right;
                        node.left.parent=node;
                    }
                    else if (node.left.right.left!=null){
                        node.left.value=getLowestNumberFromThatNode(node.left.right)
                    }
                }
            }
            else{
                deleteNode(node.left,val)
            }
        }

        else if (node.right!=null && val > node.value){
            if(node.right.value==val){
                if (node.right.left==null && node.right.right==null){
                    node.right = null;
                }
                else if(node.right.left != null){
                    if(node.right.right==null) {
                        node.right = node.right.left;
                        node.right.parent = node;
                    }
                    else if(node.right.right.left==null){
                        node.right.right.left=node.right.left;
                        node.right=node.right.right;
                        node.right.parent=node;
                    }
                    else if (node.right.right.left!=null){
                        node.right.value=getLowestNumberFromThatNode(node.right.right)
                    }
                }
            }
            else{
                deleteNode(node.right,val)
            }
        }
    }

    public static void delete(Node node, int val){
        if(node.value==val){
            if(node.left==null && node.right==null){
                  node.parent=null;
            }
            else{
            //node.left==null?(if (node.parent.value>node.value){node.parent.left=node.right} else{node.parent.right=}):
            }
            //else if ( both LHS and RHS have child)
        }
        if(val < node.value && (node.left!=null))
        {
            delete(node.left,val)
        }
        else if(node.right!=null){
            delete(node.right,val)
        }
    }
}
