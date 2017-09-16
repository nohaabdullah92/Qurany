package nohaaubdalh.qurany1;

/**
 * Created by USER on 8/26/2017.
 */
public class QuestionLibrary {
    private  String mQuestion []={"التجويد لغة هو_____؟",
            "أوجه الاستعاده مع البسمله هي......",
            "من أحكام النون الساكنة والتنوين ",
            "الإقلاب لغة هو؟"};
    private String  mChoise [] []={{"الصوت الحسن","إخراج كل حرف من مخرجه مع إعطائه حقه ومستحقه.","الخطاء والميل عن الصواب"},
            {"كلتا الاجابتين صحيحتين","وصل الجميع","قطع الجميع"},
            {"الادغام والاخفاء والاطهار والاقلاب","الادغام ولاطهار والاخفاء","الادغام والاطهار"}};
    private String mCorectAnswer []={"إخراج كل حرف من مخرجه مع إعطائه حقه ومستحقه.","كلتا الاجابتين صحيحتين","الادغام والاطهار والاخفاءوالاقلاب"};


    public String  getQuestion(int a){
        String question =mQuestion[a];
        return question;
    }

    public  String getChoise1(int a){
        String  choise1=mChoise[a][0];
        return  choise1;
    }
    public  String getChoise2(int a){
        String  choise2=mChoise[a][1];
        return  choise2;
    }

    public  String getChoise3(int a){
        String  choise3=mChoise[a][2];
        return  choise3;
    }
    public  String getCorectAnswer(int a){
        String answer=mCorectAnswer[a];
        return answer;
    }

}
