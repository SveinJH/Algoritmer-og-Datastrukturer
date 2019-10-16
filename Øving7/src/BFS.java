import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BFS {
    private int N, K;
    private Node[] node;


    public void printGraph() {
        System.out.println("Node | Forgjenger | Distanse");
        for(int i = 0; i < node.length; i++) {
            System.out.println(i + "    |    " + findNumb(((Forgj)node[i].d).finn_forgj()) + "       |  " + ((Forgj)node[i].d).finn_dist());
        }
    }

    public void findDist(int start, int end) {
        Node s = node[start];
        initforgj(s);
        Queue queue = new Queue(N - 1);
        queue.put(s);
        while(!queue.empty()) {
            Node n = (Node) queue.next();
            for(Kant k = n.kant1; k != null; k = k.neste) {
                Forgj f = (Forgj) k.til.d;
                if(f.dist == f.uendelig) {
                    f.dist = ((Forgj)n.d).dist + 1;
                    f.forgj = n;
                    queue.put(k.til);
                }
            }
        }

        System.out.println("Distance between " + start + " and " + end + ": " + (((Forgj)node[end].d).finn_dist() - 1));
    }

    public String findNumb(Node n) {
        String numb = "";
        for(int i = 0; i < node.length; i++) {
            if(node[i] == n) {
                return numb + i;
            }
        }
        return numb + " ";
    }

    public void createGraph(String path) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            node = new Node[N];

            for(int i = 0; i < N; i++) {
                node[i] = new Node();
            }

            K = Integer.parseInt(st.nextToken());

            for(int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                Kant k = new Kant(node[to], node[from].kant1);
                node[from].kant1 = k;
            }

        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void initforgj(Node s) {
        for(int i = N; i-- > 0;) {
            node[i].d = new Forgj();
        }
        ((Forgj)s.d).dist = 0;
    }

    public void bfs(int start) {
        Node s = node[start];
        initforgj(s);
        Queue queue = new Queue(N - 1);
        queue.put(s);
        while(!queue.empty()) {
            Node n = (Node) queue.next();
            for(Kant k = n.kant1; k != null; k = k.neste) {
                Forgj f = (Forgj) k.til.d;
                if(f.dist == f.uendelig) {
                    f.dist = ((Forgj)n.d).dist + 1;
                    f.forgj = n;
                    queue.put(k.til);
                }
            }
        }
    }

}
