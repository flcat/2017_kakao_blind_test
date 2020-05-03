public class question_1 {

    public static void main(String[] args) {

        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        //["#####","# # #", "### #", "#  ##", "#####"]

        String[] result = new String[n];

        //type #1
        for (int i = 0; i < n; i++) {
            int arr = arr1[i] | arr2[i];
            System.out.println(""+Integer.toBinaryString(arr).replace("1","#").replace("0"," "));

        }
        System.out.println("");


        //type #2
        for (int i = 0; i < n; i++) {
            String resultString = "";
            int targetBit = 1;
            int arr = arr1[i] | arr2[i];
            for(int j = 0; j < n; j++) {
                resultString = ((arr & targetBit) > 0 ? "#" : " ") + resultString;

                // << 는 왼쪽으로 1비트 이동하라는 것 ex) 0010 << 1 은 [0010] -> [0100] 로 비트 이동하라는 뜻
                targetBit = targetBit << 1;
            }
            result[i] = resultString;
            System.out.println(result[i]);
        }
    }
}
