package get_report_result;

import java.util.*;

public class Main {

    private static int BAN_LIMITED = 0;

    public static void main(String[] args) {

        Main main = new Main();

        main.solution(
                new String[]{"muzi", "frodo", "apeach", "neo"},
                new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"},
                2
        );

    }

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        BAN_LIMITED = k;

        Set<String> set = new HashSet<String>(Arrays.asList(report));

        ArrayList<Data> dataArray = new ArrayList<>();

        for (String user_id : id_list){
            dataArray.add(new Data(user_id));
        }

        for (String reports : set) {
            String[] report_content = reports.split(" ");

            String report_id = report_content[0]; // 신고 한 사람
            String reported_id = report_content[1]; // 신고 당한 사람

            for (Data data : dataArray){

                // 신고 한 사람 넣기
                if (report_id.equals(data.getUser_id())){
                    data.addReported_id(reported_id);
                }

                // 신고 당한 사람 넣기
                if (reported_id.equals(data.getUser_id())){
                    data.addBanned_id(report_id);
                }

            }

        }

        for (int i = 0; i < id_list.length; i++){
            int result = 0;
            Data comparisonData = dataArray.get(i);

            for (String id : comparisonData.reported_list){
                for (Data data : dataArray){
                    if (id.equals(data.getUser_id())){
                        if (data.getReport_cnt() >= BAN_LIMITED){
                            result++;
                            break;
                        }
                    }
                }
            }

            answer[i] = result;

        }

        return answer;
    }

    public class Data{

        private String user_id; // 유저 id
        private int report_cnt; // 신고 당한 횟수
        private List<String> reported_list; // 내가 신고 한 사람
        private List<String> banned_list; // 날 신고 한 사람

        public Data(String user_id){
            this.user_id = user_id;
            report_cnt = 0;
            banned_list = new ArrayList<>();
            reported_list = new ArrayList<>();
        }

        // 신고 한 아이디 추가.
        public void addReported_id(String user_id){
            reported_list.add(user_id);
        }

        public void addBanned_id(String user_id){
            // set 은 중복 허용 안함.
            if(banned_list.contains(user_id)){
                return;
            } else {
                banned_list.add(user_id);
                addReport_cnt();
            }

        }

        public void addReport_cnt(){
            report_cnt++;
        }

        public String getUser_id() {
            return user_id;
        }

        public int getReport_cnt() {
            return report_cnt;
        }

    }

}
