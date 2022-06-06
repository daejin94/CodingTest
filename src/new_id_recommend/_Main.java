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

public class _Main {

    public static void main(String[] args) {
        _Main main = new _Main();
        main.solution("abcdefghijklmn.p");

    }

    public String solution(String new_id) {
        String answer = "";

        // 대문자 소문자 치환
        answer = new_id.toLowerCase();

        System.out.println(answer);

        // 알파벳 소문자, 숫자, 빼기, 밑줄, 마침표를 제외한 모든 문자 제거.
        char[] cArray = answer.toCharArray();

        for (int i = 0; i < cArray.length; i++){
            if (!(cArray[i] >= 'a' && cArray[i] <= 'z') && !(cArray[i] >= '1' && cArray[i] <= '9') && cArray[i] != '-' && cArray[i] != '_' && cArray[i] != '.' ) {
                cArray[i] = ' ';
            }
        }

        answer = new String(cArray);
        answer = answer.replaceAll(" ", "");

        System.out.println(answer);

        // .. 가 두번 이상이면 하나로 바꿈
        while (true){
            if(!answer.contains("..")) {
                break;
            } else {
                answer = answer.replace("..", ".");
            }
        }

        System.out.println(answer);

        // 시작과 끝이 . 이면 삭제
        cArray = answer.toCharArray();

        if( cArray[0] == '.' ) cArray[0] = ' ';
        if( cArray[cArray.length-1] == '.' ) cArray[cArray.length-1] = ' ';
        answer = new String(cArray);
        answer = answer.replaceAll(" ", "");

        System.out.println(answer);

        // 빈 문자열이면 a 대입

        if (answer.length() == 0) {
            answer = "a";
        }

        System.out.println(answer);

        // 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        //     만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.

        if (answer.length() > 15) {
            cArray = answer.toCharArray();

            for (int i = 15; i < cArray.length; i++) {
                cArray[i] = ' ';
            }

            answer = new String(cArray);
            answer = answer.replaceAll(" ", "");
            cArray = answer.toCharArray();

            if( cArray[cArray.length-1] == '.' ) cArray[cArray.length-1] = ' ';

            answer = new String(cArray);
            answer = answer.replaceAll(" ", "");
        }

        System.out.println(answer);

        // 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.

        cArray = answer.toCharArray();

        if (cArray.length == 2) {
            answer += cArray[cArray.length-1];
        } else if (cArray.length == 1){
            answer = answer + cArray[cArray.length-1] + cArray[cArray.length-1];
        }

        System.out.println(answer);

        return answer;
    }
}