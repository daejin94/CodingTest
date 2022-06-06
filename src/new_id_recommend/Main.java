package new_id_recommend;

/*

1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
     만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.

*/

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        String testText = "=.="	;
        main.solution(testText);
    }

    public String solution(String new_id) {
        String answer = "";
        StringBuilder builder = new StringBuilder();

        // 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        for (char a : new_id.toLowerCase().toCharArray()) {
            // 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
            if (!(a >= 'a' && a <= 'z') && !(a >= '0' && a <= '9') && a != '-' && a != '_' && a != '.') {
                continue;
            }
            builder.append(a);
        }

        System.out.println(builder.toString());

        // 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.

        while (builder.indexOf("..") != -1) {
            replaceAll(builder, "..", ".");
        }

        System.out.println("test: " + builder.toString());

        // 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        while (builder.length() != 0 ) {

            if (builder.charAt(0) == '.') {
                builder.deleteCharAt(0);
            } else if (builder.charAt(builder.length() - 1) == '.') {
                builder.deleteCharAt(builder.length() - 1);
            } else {
                break;
            }

        }

        System.out.println(builder.toString());

        // 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.

        if (builder.length() == 0) {
            return "aaa";
        }
        System.out.println(builder.toString());

        // 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        //     만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.

        if (builder.length() >= 16) {
            builder.delete(15, builder.length());

            if (builder.charAt(14) == '.') {
                builder.deleteCharAt(14);
            }
        }
        System.out.println(builder.toString());

        // 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.

        while (builder.length() < 3) {
            builder.append(builder.charAt(builder.length() - 1));
        }
        System.out.println(builder.toString());

        answer = builder.toString();

        return answer;
    }

    private void replaceAll(StringBuilder builder, String from, String to) {
        int index = builder.indexOf(from);
        while (index != -1) {
            builder.replace(index, index + from.length(), to);
            index += to.length(); // Move to the end of the replacement
            index = builder.indexOf(from, index);
        }
    }
}
