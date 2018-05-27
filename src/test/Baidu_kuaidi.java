package test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Baidu_kuaidi {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int numCities = scanner.nextInt();
        int numRoads = scanner.nextInt();
        int[][] path = new int[numCities+1][numCities+1];
        for(int i=0; i<numRoads; i++){
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            path[m][n] = scanner.nextInt();
        }
        int numD = scanner.nextInt();
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0; i<numD; i++){
            int m = scanner.nextInt();
            int n  = scanner.nextInt();
            hm.put(m,n);
        }

        floyd(path, numCities, hm);

    }

    public static void floyd(int[][] dist, int numCities, HashMap<Integer, Integer> hm) {
        // 初始化
        for (int i = 1; i <= numCities; i++) {
            for (int j = 1; j <= numCities; j++) {
                if(dist[i][j] > 0 ){
                    dist[j][i] = dist[i][j];
                }else if(dist[j][i]>0){
                    dist[i][j] = dist[j][i];
                }else {
                    dist[j][i] = Integer.MAX_VALUE;
                }

            }
        }

        // 计算最短路径
        for (int k = 1; k <= numCities; k++) {
            for (int i = 1; i <= numCities; i++) {
                for (int j = 1; j <= numCities; j++) {

                    // 如果经过下标为k顶点路径比原两点间路径更短，则更新dist[i][j]和path[i][j]
                    int tmp = (dist[i][k]==Integer.MAX_VALUE || dist[k][j]==Integer.MAX_VALUE) ? Integer.MAX_VALUE : (dist[i][k] + dist[k][j]);
                    if (dist[i][j] > tmp) {
                        // "i到j最短路径"对应的值设，为更小的一个(即经过k)
                        dist[i][j] = tmp;
                    }
                }
            }
        }

        int[] res = new int[hm.size()];
        int i = 0;
        for (Integer key : hm.keySet()) {
            int spend = dist[1][key];
            int result = hm.get(key)-spend*2;
            if(result>0){
                res[i++] = result;
            }else{
                res[i++] = 0;
            }
        }
        System.out.println(Arrays.toString(res));
    }
}
