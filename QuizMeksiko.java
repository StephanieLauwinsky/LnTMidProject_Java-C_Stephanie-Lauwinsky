package Binus.BNCC.Project;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class QuizMeksiko {

    Scanner scan = new Scanner(System.in);
    Vector<String> ids = new Vector<>();
    Vector<String> names = new Vector<>();
    Vector<String> genders = new Vector<>();
    Vector<String> positions = new Vector<>();
    Vector<Integer> salaries = new Vector<>();
    

    int test123 = 0;
    int test1234 = 0;
    int test12345 = 0;

    int test123456 = 3;

    int tempo = 3;

    int tempo1 = 3;

    public void inputs(){

        String name;
        String gender;
        String position;
        Integer salary;

        String id = "";

        Random rand = new Random();
        for (int i = 0; i < 2; i++){
            id += (char) (rand.nextInt(26) + 'A');
        }

        for (int i = 0; i < 3; i++){
            id += (rand.nextInt(10));
        }
        do {
            System.out.print("Input nama karyawan [>= 3]: ");
            name = scan.nextLine();
        }while (name.length() < 3);

        do {
            System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
            gender = scan.nextLine();
        }while (!gender.equals("Laki-laki") && !gender.equals("Perempuan"));

        do {
            System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
            position = scan.nextLine();
        }while (!position.equals("Manager") && !position.equals("Supervisor") && !position.equals("Admin") );

        if (position.equals("Manager")){
            salary = 8000000;
            test123++;

        } else if (position.equals("Supervisor")) {
            salary = 6000000;
            test1234++;
        } else {
            salary = 4000000;
            test12345++;
        }

        ids.add(id);
        names.add(name);
        genders.add(gender);
        positions.add(position);
        salaries.add(salary);

        System.out.println("Berhasil menambahkan karyawan dengan id " + id);


        if (test123 >= test123456 ){
            for (int i = 0; i < names.size(); i++){
                if (positions.get(i).equals("Manager")){
                    salaries.set(i, salaries.get(i) * 10/100 + salaries.get(i));

                }
            }
            test123456 = test123456 + 3;
        } else if (test1234 >= tempo) {
            for (int i = 0; i < names.size(); i++) {
                if (positions.get(i).equals("Supervisor")) {
                    salaries.set(i, salaries.get(i) * 75 / 100 + salaries.get(i));
                }
            }
            tempo += 3;
        } else if (test12345 >= tempo1) {
            for (int i = 0; i < names.size(); i++) {
                if (positions.get(i).equals("Admin")) {
                    salaries.set(i, salaries.get(i) * 5 / 100 + salaries.get(i));
                }
            }
            tempo1 += 3;
        } else {
            System.out.println("Enter to return");
            scan.nextLine();
        }

    }

    public void view (){

        if (names.size() == 0){
            System.out.println("Anda belum menginput karyawan!");
        }
        else {
            for (int i = 0; i < names.size(); i++){
                for (int j = 0; j < names.size()-1; j++){
                    if (names.get(j).compareToIgnoreCase(names.get(j+1)) > 0){
                        String tempId = ids.get(j);
                        ids.set(j, ids.get(j+1));
                        ids.set(j+1, tempId);

                        String tempName = names.get(j);
                        names.set(j, names.get(j+1));
                        names.set(j+1, tempName);

                        String tempGender = genders.get(j);
                        genders.set(j, genders.get(j+1));
                        genders.set(j+1, tempGender);

                        String tempPosition = positions.get(j);
                        positions.set(j, positions.get(j+1));
                        positions.set(j+1, tempPosition);

                        Integer tempSalary = salaries.get(j);
                        salaries.set(j, salaries.get(j+1));
                        salaries.set(j+1, tempSalary);
                    }
                }
            }

            int no = 1;
           
            System.out.println( "No "+ "Kode Karyawan   "+ "    Nama Karyawan    "+ "Jenis Kelamin    "+ "Jabatan   "+"   Gaji Karyawan");
          
            for (int i = 0; i< names.size(); i++){
                System.out.println(  ids.get(i)+ names.get(i)+ genders.get(i)+ positions.get(i)+ salaries.get(i));
                no++;
            }

           
        }
    }

    public void update(){
        view();
        int no;
        do {
            System.out.print("Input nomor urutan karyawan yang ingin diupdate: ");
            no = scan.nextInt(); scan.nextLine();
        } while (no == 0 || no > names.size());
        no = no -1;

        // scan ulang
        String name;
        String gender;
        String position;
        Integer salary;

        do {
            System.out.print("Input nama karyawan [>= 3]: ");
            name = scan.nextLine();
        }while (name.length() < 3);

        do {
            System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
            gender = scan.nextLine();
        }while (!gender.equals("Laki-laki") && !gender.equals("Perempuan"));

        do {
            System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
            position = scan.nextLine();
        }while (!position.equals("Manager") && !position.equals("Supervisor") && !position.equals("Admin") );

        if (position.equals("Manager")){
            salary = 8000000;
            test123++;

        } else if (position.equals("Supervisor")) {
            salary = 6000000;
            test1234++;
        } else {
            salary = 4000000;
            test12345++;
        }

        if (test123 >= test123456 ){
            for (int i = 0; i < names.size(); i++){
                if (positions.get(i).equals("Manager")){
                    salaries.set(i, salaries.get(i) * 10/100 + salaries.get(i));
                }
            }
            test123456 = test123456 + 3;
            System.out.println("Berhasil mengupdate karyawan dengan id " + ids.get(no));

            names.set(no,name);
            genders.set(no,gender);
            positions.set(no,position);
            salaries.set(no,salary);
        } else if (test1234 >= tempo) {
            for (int i = 0; i < names.size(); i++) {
                if (positions.get(i).equals("Supervisor")) {
                    salaries.set(i, salaries.get(i) * 75 / 100 + salaries.get(i));
                }
            }
            tempo += 3;
            System.out.println("Berhasil mengupdate karyawan dengan id " + ids.get(no));

            names.set(no,name);
            genders.set(no,gender);
            positions.set(no,position);
            salaries.set(no,salary);
        } else if (test12345 >= tempo1) {
            for (int i = 0; i < names.size(); i++) {
                if (positions.get(i).equals("Admin")) {
                    salaries.set(i, salaries.get(i) * 5 / 100 + salaries.get(i));
                }
            }
            tempo1 += 3;
            System.out.println("Berhasil mengupdate karyawan dengan id " + ids.get(no));

            names.set(no,name);
            genders.set(no,gender);
            positions.set(no,position);
            salaries.set(no,salary);
        } else {
            System.out.println("Berhasil mengupdate karyawan dengan id " + ids.get(no));
            names.set(no,name);
            genders.set(no,gender);
            positions.set(no,position);
            salaries.set(no,salary);
            System.out.println("Enter to return");
            scan.nextLine();
        }
    }

    public void delete(){
        view();
        int no;
        do {
            System.out.print("Input nomor urutan karyawan yang ingin didelete: ");
            no = scan.nextInt(); scan.nextLine();
        } while (no == 0 || no > names.size());
        no = no - 1;

        names.remove(no);
        genders.remove(no);
        positions.remove(no);
        salaries.remove(no);
        ids.remove(no);
    ;

}

public QuizMeksiko(){
    int choose;
    while (true){
        do {
            System.out.println("1. scan karyawan");
            System.out.println("2. view karyawan");
            System.out.println("3. update karyawan");
            System.out.println("4. delete karyawan");
            System.out.println("5. exit");
            System.out.print(">> ");
            choose = scan.nextInt(); scan.nextLine();
        }while (choose != 1 && choose != 2 && choose != 3 && choose != 4 && choose != 5);
    
        if (choose == 1){
            inputs();
        } else if (choose == 2) {
           view();
        } else if (choose == 3) {
           update();
        } else if (choose == 4) {
            delete();
        } else {
            break;
        }
    }
}
public static void main(String[] args) {
    
    new QuizMeksiko();
}
}
