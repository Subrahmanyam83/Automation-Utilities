package test.groovy.Utils.MyUtils

/**
 * Created by subrahmanyamr on 11/4/2015.
 */
class BST {

    int data;
    BST left;
    BST right;

    public static BST rootnode;

    BST(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }

    public static void main(String[] args) {
        rootnode = new BST(15);
        add(rootnode,20);
        add(rootnode,7);
        add(rootnode,27);
        add(rootnode,97);
        add(rootnode,3);
        add(rootnode,2);
        add(rootnode,32);
        add(rootnode,19);
        add(rootnode,16);
        add(rootnode,13);
        add(rootnode,73);
        add(rootnode,79);

        inOrder(rootnode);System.out.println();
        //preOrder(rootnode);System.out.println();
        //postOrder(rootnode);System.out.println();
        findParent(rootnode,16);
    }

    public static void add(BST node,int data){
        if(data<=node.data){
            if(node.left==null){
               node.left = new BST(data);
                System.out.println("  Inserted " + data + " to left of Node " + node.data);
            }
            else{
                add(node.left,data);
            }
        }
        else{
            if(node.right==null){
                node.right = new BST(data);
                System.out.println("  Inserted " + data + " to right of Node " + node.data);
            }
            else{
                add(node.right,data)
            }
        }
    }

    public static void inOrder(BST node){
        if(node.left!=null){
            inOrder(node.left)
        }

        print(node.data+"--");
        if((node.left==null && node.right!=null) || (node.left!=null) && (node.right==null)){
            print("THIS IS THE NUMBER ":+node.data)
        }

        if(node.right!=null){
            inOrder(node.right)
        }
    }

    public static void preOrder(BST node){
        print(node.data+"--");

        if(node.left!=null){
            preOrder(node.left)
        }

        if(node.right!=null){
            preOrder(node.right)
        }
    }

    public static void postOrder(BST node){
        if(node.left!=null){
            postOrder(node.left)
        }

        if(node.right!=null){
            postOrder(node.right)
        }

        print(node.data+"--");
    }

    public static void findParent(BST node, int data){
        if(rootnode.data==data){
            println("There is no Parent for "+data);
        }

        if( (data<node.data) && (node.left!=null)){
            if(node.left.data==data){
                 println("Parent of "+data+" is "+ node.data);
            }
            else findParent(node.left,data)
        }

        if( (data>node.data) && (node.right!=null)){
            if(node.right.data==data){
                println("Parent of "+data+" is "+ node.data);
            }
            else findParent(node.right,data)
        }
    }


}
