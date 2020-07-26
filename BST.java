public class BST {
    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    static void insert(int val, Node root) {
        while(root != null) {
            if(root.val >= val) {
                if(root.left != null) {
                    root = root.left;
                } else {
                    root.left = new Node(val);
                    return;
                }
            }

            if(root.val < val) {
                if(root.right != null) {
                    root = root.right;
                } else {
                    root.right = new Node(val);
                    return;
                }
            }
        }
    }

    static void print(Node root) {
        if(root.left != null) {
            print(root.left);
        }
        System.out.println(" " + root.val);

        if(root.right != null) {
            print(root.right);
        }
    }

    static Node find(Node root, int val) {
        while(root != null) {
            if(root.val == val) {
                break;
            }

            if(root.val > val) {
                if(root.left != null){
                    root = root.left;
                }
            }

            if(root.val < val) {
                if(root.right != null) {
                    root = root.right;
                }
            }
        }
        return root;
    }

    static int minVal(Node root) {
        while(root.left != null) {
            root = root.left;
        }
        return root.val;
    }

    static void delete(int val, Node root, Node parent) {
       Node parentNode = parent;
       Node currentNode = root;
       while(currentNode != null) {
           if(currentNode.val > val) {
               parentNode = currentNode;
               currentNode = currentNode.left;
           } else if(currentNode.val < val) {
               parentNode = currentNode;
               currentNode = currentNode.right;
           } else {
               if(currentNode.left != null && currentNode.right != null) {
                    currentNode.val = minVal(currentNode);
                   delete(currentNode.val,currentNode.right, currentNode);
               }
              else if(parentNode == null) {
                   if(currentNode.left != null) {
                       currentNode.left = currentNode.left.left;
                       currentNode.right = currentNode.left.right;
                   }
                   else if(currentNode.right != null) {
                       currentNode.left = currentNode.right.left;
                       currentNode.right = currentNode.right.right;
                   } else {

                   }
               } else if(parentNode.left == currentNode) {
                   parentNode.left = currentNode.left != null ? currentNode.left : currentNode.right;
               } else if(parentNode.right == currentNode) {
                   parentNode.right = currentNode.left != null ? currentNode.left : currentNode.right;
               }
               break;
           }
       }


    }


    public static void main(String[] args) {
        System.out.println("Hello World");
        Node root = new Node(5);
        insert(5, root);
        insert(1, root);
        insert(2, root);
        insert(7, root);
        insert(10, root);
        insert(15, root);
        insert(13, root);
        insert(22, root);
        insert(12, root);
        print(root);
        System.out.println();
        delete(15,root,null);
        print(root);
    }
}
