class Patient{
    String name;
    int age;
    String gender;
    double height, weight, bmi;
    
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
    public static void calculate(Patient object){
        System.out.print(object.name+" BMI: ");
        object.height /= 100;
        object.bmi = object.weight/(object.height*object.height);
        System.out.println(object.bmi);
        calculate(object.age, object.bmi);
        calculate(object.bmi, object.age, object.gender);
    }
    public static void main(String[] args){
        Patient patient1 = new Patient();
        patient1.name = "Bhumika";
        patient1.age = 21;
        patient1.gender = "Female";
        patient1.weight = 48;
        patient1.height = 170;

        Patient patient2 = new Patient();
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