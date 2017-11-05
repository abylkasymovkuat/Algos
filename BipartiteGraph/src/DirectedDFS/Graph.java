package DirectedDFS;
import java.util.*;
 

   
    public class Graph
    {
        int V; 
         
        LinkedList<Integer>[] list; 
        int cnt ; 
      
        Graph(int V)
        {
        	cnt =0;
            this.V = V;
            list = new LinkedList[V+1];
             
            for (int i = 1; i <=V; i++)
                list[i] = new LinkedList<Integer>();
             
        }
        
        public int getV() {
        	return V;
        }
        
        public int getCnt() 
        {
        	return cnt;
        }
      
        void addEdge(int v, int w)
        {
            list[v].addFirst(w); // Add w to v’s list.
        }
         
   
        void DFS(int s)
        {
            // Initially mark all vertices as not visited
            Vector<Boolean> visited = new Vector<Boolean>(V+1);
            for (int i = 0; i <= V; i++)
            {
            	
                visited.add(i, false);
               
            }   
          
         
           
            Stack<Integer> stack = new Stack<>();
             
          
            stack.push(s);
             
            cnt = 0;
            while(stack.empty() == false)
            {
              
                s = stack.peek();
                stack.pop();
                 
               if(visited.get(s) == false)
                {
                    System.out.print(s + " ");
                    visited.set(s, true);
                    cnt++;
                }
                 
               
                Iterator<Integer> itr = list[s].iterator();
                int i=0;
                while (i<list[s].size()) 
                {
                    int v = itr.next();
                    if(!visited.get(v))
                    {   stack.push(v);}
                    i++;
                }
                
                
                
            
                 
            
            }
        }
        public static void main(String[] args) 
        {
           
            Graph graph = new Graph(5);
            
            graph.addEdge(2, 1);
            graph.addEdge(1, 3);
            graph.addEdge(2, 3);
            graph.addEdge(1, 4);
            graph.addEdge(2, 5);
                 
            graph.DFS(1);
            System.out.println(graph.getCnt()!=graph.getV()? "Not reachable": "Reachable");
            
        }
    
     
   
}