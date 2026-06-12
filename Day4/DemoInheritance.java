import java.util.Arrays;

class Store{
    String[] feedbacks = {};
    public void viewAllFeedbacks(){
        System.out.println(Arrays.toString(feedbacks));
    }
}
class JavaBatch extends Store{
    String expertname = "";
    public JavaBatch(int size){
        feedbacks = new String[size];
    }
    public void addFeedback(String comments){
        for(int index = 0; index<feedbacks.length ; index++)
            if(feedbacks[index]==null || feedbacks[index]==""){
                feedbacks[index] = comments;
                System.out.println("Feedback noted");
                return;
            }
        System.out.println("Buffer is full cannot add your feedback");
    }
}
class SoftSkillsBatch extends Store{
    public SoftSkillsBatch(){
        feedbacks = new String[]{"Training is good", "Body Language learned", "Need to slow the pace"};
    }
    public void read(int index){
        if(index<0 || index>=feedbacks.length)
            System.out.println("Invalid Feedback");
        else
            System.out.println(feedbacks[index]);
    }
}
public class DemoInheritance{
    public static void main(String[] args){
        JavaBatch java = new JavaBatch(2);
        java.expertname = "Bhumika Salian";
        java.addFeedback("Expected foundations, not advance");
        java.addFeedback("Need more time to write code");
        java.addFeedback("Array quite dificult");
        java.viewAllFeedbacks();
        SoftSkillsBatch soft = new SoftSkillsBatch();
        soft.read(9);
        soft.viewAllFeedbacks();
    }
} 