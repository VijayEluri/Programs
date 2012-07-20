/*
ID: kasturisa1
LANG: JAVA
TASK: packrec
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class packrec {
	public static void main(String[] args) throws Exception {
		packrec p = new packrec();
		// long tim = System.currentTimeMillis();
		p.readInput();
		p.process();
		// System.out.println(System.currentTimeMillis() - tim);

	}

	private int[] len, brd;
	public HashMap<Integer[], Integer> lenBrdToArea;

	public packrec() {
		len = new int[4];
		brd = new int[4];
		lenBrdToArea = new HashMap<Integer[], Integer>();
	}

	public void readInput() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("packrec.in"));
		StringTokenizer st;
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			len[i] = Integer.parseInt(st.nextToken());
			brd[i] = Integer.parseInt(st.nextToken());
		}
	}

	public void process() throws Exception {
		int n = 0;
		for (int i = 0; i < 4; ++i) {
			for (int j = 0; j < 4; ++j) {
				if (i == j)
					continue;
				for (int k = 0; k < 4; ++k) {
					if (j == k || i == k)
						continue;
					for (int l = 0; l < 4; ++l) {
						if (l == k || l == j || l == i)
							continue;
						process(i, j, k, l);
						++n;
					}
				}
			}
		}
		getResult();
	}

	private void process(int i, int j, int k, int l) {
		int l1, b1, l2, b2, l3, b3, l4, b4;
		l1 = l2 = l3 = l4 = b1 = b2 = b3 = b4 = 0;
		for (int a = 0; a < 2; ++a) {
			for (int b = 0; b < 2; ++b) {
				for (int c = 0; c < 2; ++c) {
					for (int d = 0; d < 2; ++d) {
						l1 = a == 0 ? len[i] : brd[i];
						b1 = a == 1 ? len[i] : brd[i];

						l2 = b == 0 ? len[j] : brd[j];
						b2 = b == 1 ? len[j] : brd[j];

						l3 = c == 0 ? len[k] : brd[k];
						b3 = c == 1 ? len[k] : brd[k];

						l4 = d == 0 ? len[l] : brd[l];
						b4 = d == 1 ? len[l] : brd[l];

						go(l1, b1, l2, b2, l3, b3, l4, b4);
					}
				}
			}
		}
	}

	private void go(int l1, int b1, int l2, int b2, int l3, int b3, int l4,
			int b4) {
		Integer lb[] = new Integer[2];
		int area = 0;
		for (int layout = 0; layout < 6; ++layout) {
			switch (layout) {
			case 0:
				// layout 1
				lb[0] = b1 + b2 + b3 + b4;
				lb[1] = (int) Math.max(l1, Math.max(l2, Math.max(l3, l4)));
				// lb[0] = b1 + b2 + b3 + b4;
				// lb[1] = l3;
				area = lb[0] * lb[1];
				// if(area == 36) {
				// System.out.println("layout=" + layout + " " + l1 + " " + b1+
				// " " + l2+ " " + b2+ " " + l3+ " " + b3+ " " + l4+ " " + b4);
				// }
				lenBrdToArea.put(lb, area);
				break;
			case 1:
				lb = new Integer[2];
				// layout 2
				lb[0] = (int) Math.max(l1, b2 + b3 + b4);
				lb[1] = b1 + (int) Math.max(l2, Math.max(l3, l4));
				// lb[0] = l1;
				// lb[1] = b1 + l4;
				area = lb[0] * lb[1];
				// if(area == 36) {
				// System.out.println("layout=" + layout + " " + l1 + " " + b1+
				// " " + l2+ " " + b2+ " " + l3+ " " + b3+ " " + l4+ " " + b4);
				// }
				lenBrdToArea.put(lb, area);
				break;
			case 2:
				lb = new Integer[2];
				// layout 3
				lb[0] = (int) Math.max(l1 + b4, b2 + b3 + b4);
				lb[1] = (int) Math.max(b1 + l2, Math.max(b1 + l3, l4));
				// lb[0] = b2 + b3 + b4;
				// lb[1] = l4;
				area = lb[0] * lb[1];
				// if(area == 36) {
				// System.out.println("layout=" + layout + " " + l1 + " " + b1+
				// " " + l2+ " " + b2+ " " + l3+ " " + b3+ " " + l4+ " " + b4);
				// }
				lenBrdToArea.put(lb, area);
				break;
			case 3:
				lb = new Integer[2];
				// layout 4
				lb[0] = b1 + Math.max(b2, b3) + b4;
				lb[1] = Math.max(l1, Math.max(l2 + l3, l4));
				// lb[0] = b1 + b3 + b4;
				// lb[1] = l2 + l3;
				area = lb[0] * lb[1];
				// if(area == 36) {
				// System.out.println("layout=" + layout + " " + l1 + " " + b1+
				// " " + l2+ " " + b2+ " " + l3+ " " + b3+ " " + l4+ " " + b4);
				// }
				lenBrdToArea.put(lb, area);
				break;
			case 4:
				lb = new Integer[2];
				// layout 5
				lb[0] = Math.max(b1, b2) + b3 + b4;
				lb[1] = Math.max(l1 + l2, Math.max(l3, l4));
				// lb[0] = b2 + b3 + b4;
				// lb[1] = l4;
				area = lb[0] * lb[1];
				// if(area == 36) {
				// System.out.println("layout=" + layout + " " + l1 + " " + b1+
				// " " + l2+ " " + b2+ " " + l3+ " " + b3+ " " + l4+ " " + b4);
				// }
				lenBrdToArea.put(lb, area);
				break;
			case 5:
				lb = new Integer[2];
				// layout 6
				if (b2 < b1) {
					if (l3 < l2) {
						if (l3 + l4 < l2) {
							lb[0] = Math.max(b2 + Math.max(b3, b4), b1);
							lb[1] = l1 + l2;
						} else {
							lb[0] = Math.max(b2 + b3, b1 + b4);
							lb[1] = Math.max(l1 + l2, l3 + l4);
						}
					} else {
						lb[0] = b1 + Math.max(b3, b4);
						lb[1] = Math.max(l1 + l2, l3 + l4);
					}
				} else {
					if (l3 < l2) {
						if (l3 + l4 < l2) {
							lb[0] = b2 + Math.max(b3, b4);
							lb[1] = l1 + l2;
						} else {
							lb[0] = b2 + Math.max(b3, b4); 
							lb[1] = Math.max(l1 + l2, l3 + l4);
						}
					} else {
						lb[0] = b2 + Math.max(b3, b4);
						lb[1] = Math.max(l1 + l2, l3 + l4);
					}
				}
//				lb[0] = Math.max(b1, b2) + Math.min(b3, b4);
//				lb[1] = Math.max(l1 + l2, l3 + l4);
				// lb[0] = b2+b3;
				// lb[1] = l3+b4;
				area = lb[0] * lb[1];
				// if(area == 36) {
				// System.out.println("layout=" + layout + " " + l1 + " " + b1+
				// " " + l2+ " " + b2+ " " + l3+ " " + b3+ " " + l4+ " " + b4);
				// }
				lenBrdToArea.put(lb, area);
			}
		}
	}

	private void getResult() throws Exception {
		int min = Integer.MAX_VALUE;
		for (Integer area : lenBrdToArea.values()) {
			if (area < min) {
				min = area;
			}
		}
		PrintWriter w = new PrintWriter(new BufferedWriter(new FileWriter(
				"packrec.out")));
		// System.out.println(min);
		w.append(min + "\n");

		HashMap<Integer, Integer> lbt = new HashMap<Integer, Integer>();
		for (Integer[] key : lenBrdToArea.keySet()) {
			if (lenBrdToArea.get(key) == min) {
				int a = key[0], b = key[1];
				lbt.put(Math.min(a, b), Math.max(a, b));
			}
		}

		while (!lbt.isEmpty()) {
			min = Integer.MAX_VALUE;
			for (Integer key : lbt.keySet()) {
				if (key < min)
					min = key;
			}
			// System.out.println(min + " " + lbt.get(min));
			w.append(min + " " + lbt.get(min) + "\n");
			lbt.remove(min);
		}
		w.close();
	}

}
