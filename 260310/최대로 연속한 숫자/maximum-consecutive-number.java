import java.util.*;

public class Main {
    // 구간 길이를 TreeMap(멀티셋)에 추가
    // key = 길이, value = 해당 길이 구간 개수
    static void add(TreeMap<Integer, Integer> map, int len) {
        if (len <= 0) return; // 길이가 0이면 구간이 없으므로 무시
        map.put(len, map.getOrDefault(len, 0) + 1);
    }

    // 구간 길이를 TreeMap에서 제거
    static void remove(TreeMap<Integer, Integer> map, int len) {
        if (len <= 0) return;

        int cnt = map.get(len);

        // 마지막 하나였다면 key 자체 삭제
        if (cnt == 1) map.remove(len);
        else map.put(len, cnt - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 마지막 숫자
        int m = sc.nextInt(); // 제거 횟수

        // 삭제된 숫자들을 저장 (경계 역할)
        TreeSet<Integer> set = new TreeSet<>();

        // 현재 존재하는 "연속 구간 길이들"
        TreeMap<Integer, Integer> lenMap = new TreeMap<>();

        // 편하게 계산하기 위해 가짜 경계 추가
        set.add(-1);
        set.add(n + 1);

        // 초기 상태 : [-1, n+1] 사이 전체 구간
        // 실제 숫자 범위 : [0 ~ n]
        add(lenMap, n + 1);

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt(); // 이번에 제거되는 숫자

            // x를 기준으로 왼쪽 경계 찾기
            int left = set.lower(x);

            // x를 기준으로 오른쪽 경계 찾기
            int right = set.higher(x);

            // 기존 구간([left+1 ... right-1])의 길이
            int oldLen = right - left - 1;

            // 기존 구간 제거
            remove(lenMap, oldLen);

            // 기존 구간 제거 후 새로 구간 생성
            // [left+1 ... x-1], [x+1 ... right-1]
            int leftLen = x - left - 1;
            int rightLen = right - x - 1;

            // 새로 생긴 두 구간 추가
            add(lenMap, leftLen);
            add(lenMap, rightLen);

            // x를 삭제된 위치로 기록
            set.add(x);

            // 현재 존재하는 구간 중 가장 긴 길이
            System.out.println(lenMap.lastKey());
        }
    }
}