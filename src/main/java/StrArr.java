class Main {

    public static void main(String[] args) {
        //First challenge. Return the maximum difference of two Integers int[x] and int[y] for x<y if exists, else give back -1.
        int[] array1 = new int[]{1, 7, 8, 16, 21, 74};
        int[] array2 = new int[]{1, 7, 6, 6, 1, 7};
        int[] array3 = new int[]{1, 3, 5, 6, 2, 2};
        int[] array4 = new int[]{7};
        int[] array5 = new int[]{};
        System.out.println(ArrayChallenge(array1));
        System.out.println(ArrayChallenge(array2));
        System.out.println(ArrayChallenge(array3));
        System.out.println(ArrayChallenge(array4));
        System.out.println(ArrayChallenge(array5));
        System.out.println();

        //Second challenge. Count repeated letters in String and give back compressed version of String.
        String str1 = "abbcd";
        String str2 = "aaabbcdeee";
        String str3 = "aaaaaaaaaa";
        String str4 = "abcdefgh";
        String str5 = "a";
        System.out.println(StringChallenge(str1));
        System.out.println(StringChallenge(str2));
        System.out.println(StringChallenge(str3));
        System.out.println(StringChallenge(str4));
        System.out.println(StringChallenge(str5));
        System.out.println();
        //Third challenge. Count amount of minutes between two times separated with hyphen.
        String s = "11:20pm-11:30am";
        StringCh(s);
    }
    public static int ArrayChallenge(int[] array){

        //Setting default value for option int[x] < int[y] for x<y.

        int result = -1;
        //Making sure that there are at least two arguments to compare.
        if (array.length>1){

            //Setting first loop to compare every argument....
            for (int i = 0; i< array.length-1; i++) {

                //Setting second loop to compare with every other arguments.
                for (int j = 1; j < array.length; j++) {

                    //Making sure that our condition (x<y) is met and setting difference as the result.
                    if (i < j) {
                        int diff = array[i] - array[j];
                        if (diff > 0 && result < diff) {
                        result = diff;
                        }
                    }
                }
            }
        } return result;
    }
    public static String StringChallenge(String str) {
        //Adding extra sign to our String, because of problem of counting last letter without it...
        String word = str +"@";

        //Setting first index, counter of repeats and empty String for result to be able to add to it in loops.
        int index1 = 0;
        String result = "";
        int count = 0;

        //Loop over all letters in given String.
        for (int index2 = 0; index2 < word.length(); index2++) {

            //When next letter is different, then is created substring from char at current index1 and value of counter
            //which is added to previous result. Indexes are changed and counter is reset.
            if (word.charAt(index2) != word.charAt(index1)) {
                String substring = word.charAt(index1)+String.valueOf(count);
                result += substring;
                index1 = index2;
                count=1;
            }
            //When next letter is same as current, then counter is increased.
            else {
                count+=1;
            }
        }
       // System.out.println(result);
        return result;
    }
    public static void StringCh(String s) {

        //Creating two empty Strings which will represent two given times.
        String time1 = "";
        String time2 = "";

        //Extracting two substrings from given String with hyphen sign between.
        for (int i = 0; i <= s.length(); i++) {
            if (s.charAt(i) == '-') {
                time2 = s.substring(i + 1);
                break;
            }
            time1 += s.charAt(i);
        }
        //Taking into consider repeatability of calculations, it is decided to extract separated method CountingMinutes.
        int timeValue1 = CountingMinutes(time1);
        int timeValue2 = CountingMinutes(time2);
        int result = 0;

        //The problem of skipping the date is solved in this way.
        if (timeValue1>timeValue2){

            //When first time is further than second time according to 24 hours clock values,
            //there are counted minutes left of previous day and added minutes of given day.
            result = 24*60 - timeValue1 + timeValue2;
        }
        else {
            //Otherwise, the difference between second time and first is counted.
            result = timeValue2 - timeValue1;
        }
        System.out.println(result);
    }
    public static int CountingMinutes(String time){
        //Setting index of AM/PM in given String to extract information about AM/PM.
        final int indexAmPm = time.length() - 2;
        String amPm = time.substring(indexAmPm);

        //Setting default value of AM/PM times
        int am = 0;
        final int pm = 12;

        //Checking and changing AM into PM if true.
        if (amPm.equalsIgnoreCase("pm")){
            am = pm;
        }
        //Initializing minutes to be able to add to them inside loop.
        int minutes = 0;

        for (int i = 0; i<3; i++){
            if (time.charAt(i) == ':'){

                //Taking value of hours with awareness of AM/PM.
                final int hours1 = Integer.parseInt(time.substring(0,i)) + am;
                //Summing hours into minutes with minutes taken from String.
                minutes= hours1*60 + Integer.parseInt(time.substring(i+1,i+3));
            }
        }
        //Total amount of minutes are returned.
        return minutes;
    }
}