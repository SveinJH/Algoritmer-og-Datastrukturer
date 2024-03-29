import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import java.util.StringTokenizer;

public class EdmondKarp {
    private int N, K;
    private int sluk;
    private Node[] node;



    public void edmondKarp(String path) {
        readGraph(path);
        System.out.println("Maksimum flyt fra 0 til " + sluk + " med Edmond-Karp");
        System.out.println("Økning : Flytøkende vei");

        int maxFlow = 0;

        while(true) {

            Vkant[] vei = new Vkant[N];

            ArrayList<Node> queue = new ArrayList<>();
            queue.add(node[0]);

            // Bredde-Først Søk
            while (!queue.isEmpty()) {
                Node n = queue.remove(0);

                for (Vkant vk : n.vkanter) {
                    if (vei[vk.to] == null && vk.to != 0 && vk.distance > vk.flyt) {
                        vei[vk.to] = vk;
                        queue.add(node[vk.to]);
                    }
                }
            }

            if(vei[sluk] == null) {
                break;
            }

            // Finner minste flyt
            int restKap = Integer.MAX_VALUE;
            for(Vkant vk = vei[sluk]; vk != null; vk = vei[vk.from]) {
                restKap = Math.min(restKap, vk.distance - vk.flyt);
            }

            // Justerer flyten i eksisterende kanter og deres revers.
            for(Vkant vk = vei[sluk]; vk != null; vk = vei[vk.from]) {
                vk.flyt += restKap;
                vk.reverse.flyt -= restKap;
            }
            System.out.print(" " + restKap + " : ");



            ArrayList<Integer> nodes = new ArrayList<>();

            for(Vkant vk = vei[sluk]; vk != null; vk = vei[vk.from]) {
                nodes.add(vk.from);
            }

            for(int i = nodes.size() - 1; i >= 0; i--)
                System.out.print(" " + nodes.get(i));

            System.out.print(" " + sluk);

            System.out.print("\n");
            maxFlow += restKap;
        }
        System.out.println("Maximum float was: " + maxFlow);
    }

    public void readGraph(String path) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            node = new Node[N];
            sluk = 1;

            for(int i = 0; i < N; i++) {
                node[i] = new Node();
            }

            K = Integer.parseInt(st.nextToken());

            for(int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                // Hjelpekant reverseVK
                Vkant vk = new Vkant(from, to, 0, weight);
                Vkant reverseVK = new Vkant(to, from, 0, 0);

                vk.setReverse(reverseVK);
                reverseVK.setReverse(vk);

                node[from].vkanter.add(vk);
                node[to].vkanter.add(reverseVK);


                /*for(int j = 0; j < node.length; j++) {
                    if(node[j].vkanter.size() > 0) {
                        for(int k = 0; k < node[j].vkanter.size(); k++) {
                            System.out.println(" " + j + " : " + node[j].vkanter.get(k).from + " til " + node[j].vkanter.get(k).to);
                        }
                    }
                }*/

            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}


