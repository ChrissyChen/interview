// version 2: Union Find
public class Solution {
      class UnionFind{
        HashMap<Integer, Integer> father = new HashMap<Integer, Integer>();
        UnionFind(int n){
            for(int i = 0 ; i < n; i++) {  //map里的value存parent,初始存自己，表示每个都是独立的。
                father.put(i, i); 
            }
        }

        //这个方法是找到x的终极root
        int compressed_find(int x){
            int parent =  father.get(x);
            while(parent!=father.get(parent)) { //如果x的parent的value里存的不是自身，说明xd的parent不是root,就继续往root回溯
                parent = father.get(parent);   // 就继续往root回溯,直到找到终极root
            }
            int temp = -1;
            int fa = father.get(x);
            while(fa!=father.get(fa)) {    //使得每个x的上级parent的value都赋值为终极root
                temp = father.get(fa);
                father.put(fa, parent) ;
                fa = temp;
            }
            return parent;
                
        }
        
        void union(int x, int y){
            int fa_x = compressed_find(x);
            int fa_y = compressed_find(y);
            if(fa_x != fa_y)
                father.put(fa_x, fa_y);
        }
    }
    /**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // tree should have n nodes with n-1 edges
        if (n - 1 != edges.length) {
            return false;
        }
        
        UnionFind uf = new UnionFind(n);
        

        //这种思路是： 每个点初始都是自己孤立的存在一个集合，一共n个集合，每次取一条边，如果这条边的两端不在同一个集合中，
        //就将其所在的集合合并成一个，如果在一个集合中，那么就说明存在环。在取完所有的n-1条边之后，应该所有的点都在一个集合中了，
        //否则就不是树。

        for (int i = 0; i < edges.length; i++) {
            if (uf.compressed_find(edges[i][0]) == uf.compressed_find(edges[i][1])) {
                return false;
            }
            uf.union(edges[i][0], edges[i][1]);
        }
        return true;
    }
}