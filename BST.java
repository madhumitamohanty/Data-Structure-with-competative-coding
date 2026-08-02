import java.util.Scanner;
class Node{
int data;
Node left,right;
Node(int value){
data=value;
left=right=null;
}
}
class BST{
Node root;
Node insert(Node root,int key){
if(root==null){
return new Node(key);
}
if(key<root.data){
root.left=insert(root.left,key);
}
else if(key>root.data){
root.right=insert(root.right,key);
}
return root;
}
}