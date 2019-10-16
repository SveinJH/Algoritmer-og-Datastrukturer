import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Topologisk {
    int N, K;
    Node node[];

    public String findNumb(Node n) {
        String numb = "";
        for(int i = 0; i < node.length; i++) {
            if(node[i] == n) {
                return numb + i;
            }
        }
        return numb + " ";
    }

    public void ts() {
        Node n = topologisort();
        Topo_lst t = (Topo_lst) n.d;
        while(n != null) {
            System.out.println(findNumb(n));
            if(t.neste != null) {
                n = t.neste;
                t = (Topo_lst) n.d;
            } else {
                return;
            }
        }
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

    public Node df_topo(Node n, Node l) {
        Topo_lst nd = (Topo_lst)n.d;
        if(nd.funnet) return l;
        nd.funnet = true;
        for(Kant k = n.kant1; k != null; k = k.neste) {
            l = df_topo(k.til, l);
        }
        nd.neste = l;
        return n;
    }

    public Node topologisort() {
        Node l = null;
        for(int i = N; i-- > 0;) {
            node[i].d = new Topo_lst();
        }
        for(int i = N; i-- > 0;) {
            l = df_topo(node[i], l);
        }
        return l;
    }
}
