//POJO / Entity class / Model Class / Business Class
class Patient2{
    String name;
    int age;
    String gender;
    double height;
    double weight;
    private double bmi;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public double getBmi() {
        return bmi;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }
}
public class HealthMetrics2{
    public static void calculate(int age, double bmi){
        System.out.print("Body Age: ");
        if(bmi<18.5)
            System.out.println(age+2);
        else if(bmi>25)
            System.out.println(age+5);
        else
            System.out.println(age);
    }
    public static void calculate(double bmi, int age, String gender){
        System.out.print("Fat Rate: ");
        if(gender.equals("male"))
            System.out.println((1.2*bmi)+(0.23*age)-16.2);
        else
            System.out.println((1.2*bmi)+(0.23*age)-5.4);
    }
    public static void calculate(Patient2 object){
        System.out.print(object.getName()+" BMI: ");
        object.setHeight(object.getHeight()/100);
        object.setBmi(object.getWeight() / object.getHeight()*object.getHeight());
        System.out.println(object.getBmi());
        calculate(object.getAge(), object.getBmi());
        calculate(object.getBmi(), object.getAge(), object.getGender());
    }
    public static void main(String[] args){
        Patient2 patient1 = new Patient2();
        patient1.name = "Bhumika";
        patient1.age = 21;
        patient1.gender = "Female";
        patient1.weight = 48;
        patient1.height = 170;

        Patient2 patient2 = new Patient2();
        patient2.name = "Rakshi";
        patient2.age = 24;
        patient2.gender = "Male";
        patient2.weight = 56;
        patient2.height = 175;

        calculate(patient1);
        System.out.println();
        calculate(patient2);
    }
}

//Cannot access non static members of class without object
//Accessing private members via public methods is called Encapsulation