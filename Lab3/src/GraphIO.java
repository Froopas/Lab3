

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.Vector;

public class GraphIO implements Graph {
	private Vector<Integer[]> m_nodes,m_edges;
	GraphIO() {
		m_nodes=new Vector<Integer[]>();
		m_edges=new Vector<Integer[]>();
	}

	public void addNode(int id, int x, int y) {
		Integer[] newnode= {id,x,y};
		m_nodes.add(id, newnode);
	}

	public void addEdge(int id1, int id2, int weight) {
		Integer[] newedge= {id1,id2,weight};
		m_edges.add(newedge);

	}

	public static void readFile(Graph g, String filename) throws IOException {
		Path filePath = Paths.get(filename);
		Scanner scanner;
		try {
			scanner = new Scanner(filePath);
		} catch(IOException e) {
			throw new IOException();
		}
		int n=scanner.nextInt();
		for(int i=1;i<=n;i++) {
			g.addNode(scanner.nextInt(),scanner.nextInt(),scanner.nextInt());
		}
		while(scanner.hasNextInt()) {
			g.addEdge(scanner.nextInt(),scanner.nextInt(),scanner.nextInt());
		}
		scanner.close();

	}

}
