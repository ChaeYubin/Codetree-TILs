import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StreamTokenizer st = new StreamTokenizer(br);
  static StringBuilder sb = new StringBuilder();

  static final int OFFSET = 101;

  public static void main(String[] args) throws Exception {
    int n = nextInt();

    int[] arr = new int[200];
    int max = 0;

    for (int i = 0; i < n; i++) {
      int a = nextInt() + OFFSET;
      int b = nextInt() + OFFSET;

      for (int p = a - 1; p < b - 1; p++) {
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