package lab4;

import java.util.ArrayList;
import java.util.List;

public class Tree<T extends Comparable<T>> {

    private T value;
    private Tree left;
    private Tree right;
    private Tree parent;
    int number;

    private List<T> printList = new ArrayList<>();

    public T getValue() {
        return value;
    }
    public Tree getLeft() {
        return left;
    }
    public Tree getRight() {
        return right;
    }
    public Tree getParent() {
        return parent;
    }
    public Tree(T val, Tree parent) {
        this.value = val;
        this.parent = parent;
    }
    public void addElement(T...values){
        for(T v : values){
            addElement(v);
        }
    }
    public void addElement(T value){
        if(value.compareTo(this.value) < 0){
            if(this.left == null){
                this.left = new Tree(value, this);
                this.number++;
            }
            else if(this.left != null)
                this.left.addElement(value);
            this.number++;
        }
        else{
            if(this.right == null){
                this.right = new Tree(value, this);
                this.number++;
            }
            else if(this.right != null)
                this.right.addElement(value);
            this.number++;
        }
    }
    private void print(Tree<T> node){
        if(node == null) return;
        print(node.left);
        printList.add(node.value);
        System.out.print(node + " ");
        if(node.right!=null)
            print(node.right);
    }
    public void printList(){
        printList.clear();
        print(this);
        System.out.println();
    }
    @Override
    public String toString() {
        return value.toString();
    }

    public void size(){
        System.out.println("Высота: " + this.number);
    }

    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>(70, null);
        tree.addElement(10, 7, 15, 13, 20, 9, 17, 4, 8, 1, 6, 5);
        tree.printList();
        tree.size();

    }
}