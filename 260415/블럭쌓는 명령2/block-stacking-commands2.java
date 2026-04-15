import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StreamTokenizer st = new StreamTokenizer(br);
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    int n = nextInt();
    int k = nextInt();

    int[] arr = new int[n];
    int max = 0;

    for (int i = 0; i < k; i++) {
      int a = nextInt();
      int b = nextInt();

      for (int p = a - 1; p < b; p++) {
        arr[p]++;

        max = Math.max(max, arr[p]);
      }
    }

    System.out.println(max);
  }

  static int nextInt() throws IOException {
    st.nextToken();
    return (int) st.nval;
  }
}