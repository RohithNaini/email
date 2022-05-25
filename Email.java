package email_app;
import java.util.*;
import java.io.*;

public class Email {
    Scanner sc = new Scanner(System.in);
    private String first_name;
    private String last_name;
    private String Dept;
    private String email;
    private String password;
    private int mail_capacity=1000;
    private String alt_email;

    public Email(String first_name,String last_name){
        this.first_name=first_name;
        this.last_name=last_name;

    }

    private String generate_email(){
        return this.first_name.toLowerCase()+"."+this.last_name.toLowerCase()+"@"+this.Dept.toLowerCase()+"company.com";
    }

    private String setDept() {
        System.out.println("Department \n 1 for accounting \n 2 for engineering \n 3 for IT \n 0 for none");
        int choice = sc.nextInt();
        boolean flag = false;
        do {
            switch (choice) {
                case 1:
                    return "accounting";
                case 2:
                    return "engineering";
                case 3:
                    return "IT";
                case 0:
                    return "none";
                default:
                    System.out.println("please enter a proper value");
            }

        }
        while (!flag);
        return null;
    }
    private String generate_password(int length){
        Random r = new Random();
        String cap_letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String small_letters = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String special_char = "!@#$%&*";
        String values = cap_letters+small_letters+numbers+special_char;
        String password="";
        for (int i=0;i<=length;i++){
            password=password+values.charAt(r.nextInt(values.length()));
        }
        return password;
    }

    public void setpass(){
        boolean flag = false;
        do {
            System.out.println("do you want to change your password Y/N");
            char choice = sc.next().charAt(0);
            if (choice=='Y'||choice=='y'){
                System.out.println("enter current password");
                String temp = sc.next();
                if (temp.equals(this.password)){
                    System.out.println("enter new pawword");
                    this.password=sc.next();
                    System.out.println("password changed successfully");
                }
                else{
                    System.out.println("incorrect password");
                }

            }
            else if(choice=='N'|| choice=='n'){
                flag=true;
                System.out.println("password not changed");
            }
            else{
                System.out.println("enter a valid choice");
            }




        }
        while (!flag);
    }

}
