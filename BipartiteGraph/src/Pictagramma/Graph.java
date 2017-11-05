    package Pictagramma;
import java.util.LinkedList;
        import java.util.List;

public class Graph {


    LinkedList<Integer> list[];
    private int V;
    private boolean pressed;
    private boolean []bArr;
    public Graph(int V){
        this.pressed = false;
        this.V = V;
        bArr = new boolean[V];
        list = new LinkedList[V];
        for ( int i=0;i<V;i++){
            list[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int u, int v){

        int temp1 = --u, temp2 = --v;
        list[temp1].addFirst(temp2);
        list[temp2].addFirst(temp1);
    }
    public void addEdge1(int u, int v){

        int temp1 = u, temp2 = v;
        list[temp1].addFirst(temp2);
        list[temp2].addFirst(temp1);
    }

  
    public boolean isConnected(Integer u, Integer v){

        if(list[u].contains(v) && list[v].contains(u))
            return true;

        return false;
    }


    public void removeEdge(Integer u, Integer v)
    {
        if(!isConnected(u,v)) return;

        this.list[u].remove(v);
        this.list[v].remove(u);
    }


    public void print(){
        for ( int i =0;i<V;i++){
            System.out.print(i + ":" + " [");
            for ( int j : list[i]){
               int k = j+1;
             System.out.print(k+" ");}
            System.out.print("]");
            System.out.println();
        }
    }


   


    

    public void DFS(int i){
        bArr[i]= true;
        for (int v : list[i]){
            if(!bArr[v]){
                DFS(v);
            }
        }
    }

    public static void main(String args[])
    {
        Graph adList = new Graph(8);

        adList.addEdge(1, 2);
        adList.addEdge(3,2);
        adList.addEdge(1, 3);
        adList.addEdge(1,4);
        adList.addEdge(5, 6);
        adList.addEdge(4,5);
        adList.addEdge(7, 4);
        adList.addEdge(7,6);
        adList.addEdge(6, 4);
        adList.addEdge(8,7);


//        adList.addEdge(1,2);
//        adList.addEdge(1,3);
//        adList.addEdge(4,3);
//        adList.addEdge(5,3);


//        System.out.println(adList.isBridge(0,5));
//        System.out.println(adList.isBridge(2,3));
//        System.out.println(adList.isBridge(0,1));

//        System.out.println(adList.getNumberOfConnected());
        


    }




}