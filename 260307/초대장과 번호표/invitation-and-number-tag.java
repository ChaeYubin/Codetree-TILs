import java.util.Scanner;
import java.util.HashSet;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int g = sc.nextInt();

        HashSet<Integer>[] group = new HashSet[g];
        for (int i = 0; i < g; i++) {
            group[i] = new HashSet<>();

            int groupSize = sc.nextInt();
            for (int j = 0; j < groupSize; j++) {
                group[i].add(sc.nextInt());
            }
        }

        // 확실하게 초대장을 받는 사람
        HashSet<Integer> mustInvited = new HashSet<>();
        mustInvited.add(1);

        // 1을 제외한 인원의 수를 기준으로 오름차순 정렬
        Arrays.sort(group, (h1, h2) -> {
            int count1 = h1.size() - (h1.contains(1) ? 1 : 0);
            int count2 = h2.size() - (h2.contains(1) ? 1 : 0);

            return count1 - count2;
        });

        for (HashSet<Integer> curGroup : group) {
            int count = 0;  // 현재 그룹 내에서 확실하게 초대장을 받는 사람의 수

            for (int invited : mustInvited) {
                if (curGroup.contains(invited)) count++;
            }

            // 만약 한 명을 제외하고 모두 초대장을 받는다면 나머지 한 명도 받아야 함
            if (count == curGroup.size() - 1) {
                for (int num : curGroup) {
                    mustInvited.add(num);
                }
            }
        }

        System.out.println(mustInvited.size());
    }
}