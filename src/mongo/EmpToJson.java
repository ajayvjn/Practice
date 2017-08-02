package mongo;

import java.io.*;
import java.util.*;

/**
 * Created by ajay on 14-Jun-17.
 */
public class EmpToJson {

    String accountType[] = {"Savings", "Current", "Salary", "Student"};
    String currency[] = {"INR", "USD", "EUR"};

    public static void main(String[] args) {

        EmpToJson empToJson = new EmpToJson();
        empToJson.init();

    }

    private void init() {
        BufferedReader br = null;

        try {

            String sCurrentLine;
            List<String[]> names = new ArrayList<String[]>();

            br = new BufferedReader(new FileReader("F:/emp.txt"));

            while ((sCurrentLine = br.readLine()) != null) {
                names.add(sCurrentLine.split(" "));
            }

            File file = new File("F:/emp_json.txt");
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            //bw.write("[\n");
            for (int j = 0; j < names.size(); j++) {
                sCurrentLine = createJson(names.get(j));
                System.out.println(sCurrentLine);
                if (j != names.size() - 1) {
                    sCurrentLine += " \n";
                }
                bw.write(sCurrentLine);
            }
            //bw.write("]");
            bw.close();


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private String createJson(String[] a) {

        Person p = new Person();
        p.setFirst_name(a[0]);
        p.setEmp_number(Integer.parseInt(a[a.length - 1]));

        if (a.length - 1 > 2) {
            p.setMiddle_name(a[1]);
            p.setLast_name(a[2]);
        } else {
            p.setLast_name(a[1]);
        }

        Collections.shuffle(Arrays.asList(accountType));

        List<Account> accounts = new ArrayList<Account>();
        p.setAccounts(accounts);
        Account acc;
        int r = (int) (Math.random() * 4) + 1;

        Random rr = new Random();

        for (int i = 0; i < r; i++) {

            //acc = new Account(accountType[i], ((long) (Math.random() * 9999999) + 100), currency[(int) (Math.random() * 3) + 0]);
            acc = new Account(accountType[i], (int) (rr.nextInt(9999999)), currency[(int) (Math.random() * 3) + 0]);
            accounts.add(acc);
        }

        //System.out.println(p.toString());


        //convert to JSON
        //return new Gson().toJson(p);
        return "{}";
    }
}
