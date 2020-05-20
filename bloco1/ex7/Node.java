package bloco1.ex7;

public class Node {
     type tipo;
     String value;
     Node left, right;

    public Node(String val, type tipo){ 
        value = val; 
        left =  right = null;
        this.tipo = tipo;
    }
    
    public type tipo(){return tipo;}

    public String value(){return value;}

    public Node left(){return left;}

    public Node right(){return right;}

    public void setLeft(String val, type tipo){
        left = new Node(val, tipo);
    }

    public void setRight(String val, type tipo){
        left = new Node(val, tipo);
    }

    public boolean hasLeaves(){
        if(left == null && right == null){
            return false;
        }
        else{
            return true;
        }
    }

    @Override
    public String toString(){
        if(left == null && right == null && tipo == type.NUM){
            return String.format("%s",value);
        }
        else{
            return String.format("(%s %s %s)", right.toString(), value, left.toString());
        }     
    }
}