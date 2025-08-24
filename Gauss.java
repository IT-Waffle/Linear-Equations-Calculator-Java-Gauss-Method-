;import java.util.InputMismatchException;
import java.util.Scanner;

public class Gauss {

    public static Scanner input = new Scanner(System.in);
    public static String[] Var = new String[3];

    public static double[] R1 = new double[4];
    public static double[] R2 = new double[4];
    public static double[] R3 = new double[4];

    public static double[] R1_OriginalSave = new double[4];
    public static double[] R2_OriginalSave = new double[4];
    public static double[] R3_OriginalSave = new double[4];

    public static double[] R1_BackupSave = new double[4];
    public static double[] R2_BackupSave = new double[4];
    public static double[] R3_BackupSave = new double[4];

    public static double Result_R1;
    public static double Result_R2;
    public static double Result_R3;    

    public static double Var1_Answer;
    public static double Var2_Answer;
    public static double Var3_Answer;

    public static boolean StopWorking = false;

        public static void Default()
        {
            R1[0] = 1.06;
            R1[1] = -0.28;
            R1[2] = 0.84;
            R1[3] = 0.57;

            R2[0] = 0.43;
            R2[1] = 0.62;
            R2[2] = -0.35;
            R2[3] = 0.66;

            R3[0] = 0.37;
            R3[1] = -0.75;
            R3[2] = -0.64;
            R3[3] = -0.38;
        }
        public static void OriginalSave()
        {
            for(int i = 0; i<4; i++)
            {
                R1_OriginalSave[i] = R1[i];
                R2_OriginalSave[i] = R2[i];
                R3_OriginalSave[i] = R3[i];
            }         

        }

        public static void XYZ_Var_Name()
        {
            Var[0] = "X";
            Var[1] = "Y";
            Var[2] = "Z";
        }
        public static void X1X2X3_Var_Name()
        {
            Var[0] = "X1";
            Var[1] = "X2";
            Var[2] = "X3";
        }

        public static void Action_One()
        {
            System.out.println("\n1. vien-mu izdala ar ši vien-ma nezinama x koeficientu.");
            System.out.println("  "+"("+R1[0]+")" + Var[0] + "+" + "("+R1[1]+")" + Var[1] + "+" + "("+R1[2]+")" + Var[2] + " = " + R1[3] + "| /"+ R1[0]);
            System.out.println("{ "+"("+R2[0]+")" + Var[0] + "+" + "("+R2[1]+")" + Var[1] + "+" + "("+R2[2]+")" + Var[2] + " = " + R2[3]);
            System.out.println("  "+"("+R3[0]+")" + Var[0] + "+" + "("+R3[1]+")" + Var[1] + "+" + "("+R3[2]+")" + Var[2] + " = " + R3[3]);
            double tmp = R1[0];
            for(int i = 0; i<4; i++)
            {
                R1[i] = R1[i] / tmp;
            }
            System.out.println("\nPec dalisanas 1. vien-ms izkatas: \n"+"  "+"("+R1[0]+")" + Var[0] + "+" + "("+R1[1]+")" + Var[1] + "+" + "("+R1[2]+")" + Var[2] + " = " + R1[3]);

            for (int i = 0; i < 4; i++) 
            {
                R1_BackupSave[i] = R1[i];
            }
            System.out.println("\n");
        }

        public static void Two_1()
        {
            for (int i = 0; i < 4; i++) 
            {
                R1[i] = R1_BackupSave[i];
            }
            System.out.println("\n");

            for(int i = 0; i<R1.length; i++)
            {
                R1[i] *= -R2[0];
            }                System.out.println( "Pec reizinasanas ar 2. vien-ma "+ Var[0] + " pretejo skaitli 1. vien-ms izkatas: \n"+"  "+"("+R1[0]+")" + Var[0] + "+" + "("+R1[1]+")" + Var[1] + "+" + "("+R1[2]+")" + Var[2] + " = " + R1[3]);
            for(int i = 0; i<R1.length; i++)
            {
                R2[i] += R1[i];
            }
        }

        public static void Two_2()
        {
            for (int i = 0; i < 4; i++) 
            {
                R1[i] = R1_BackupSave[i];
            }
            System.out.println("\n");

            for(int i = 0; i<R1.length; i++)
            {
                R1[i] *= -R3[0];
            }                
            System.out.println( "Pec reizinasanas ar 3. vien-ma " + Var[0] + " pretejo skaitli 1. vien-ms izkatas: \n"+"  "+"("+R1[0]+")" + Var[0] + "+" + "("+R1[1]+")" + Var[1] + "+" + "("+R1[2]+")" + Var[2] + " = " + R1[3]);
            
            for(int i = 0; i<R1.length; i++)
            {
                R3[i] += R1[i];
            }
            System.out.println("\n");
        }
    
        public static void Action_Two()
        {
            System.out.println("Jaunas sistemas 1.vien-mu vispirms reizina ar 2.vien-ma koeficienta " + Var[0] + " pretejo skaitli un pieskaita 2.vien-mam, \nbet pec tam, ar 3.vien-ma koeficienta " + Var[0] + " pretejo skaitli un pieskaita 3. vien-mam.\n");
            System.out.println("  "+"("+R1[0]+")" + Var[0] + "+" + "("+R1[1]+")" + Var[1] + "+" + "("+R1[2]+")" + Var[2] + " = " + R1[3] + "| *"+ "(" + -R2[0] + "); " + "*(" + -R3[0] + ")");
            Two_1();
            Two_2();
            R1 = R1_BackupSave;
            System.out.println("Jauna sistema:");
            System.out.println("  "+"("+R1[0]+")" + Var[0] + "+" + "("+R1[1]+")" + Var[1] + "+" + "("+R1[2]+")" + Var[2] + " = " + R1[3]);
            System.out.println("{ "+"("+R2[0]+")" + Var[0] + "+" + "("+R2[1]+")" + Var[1] + "+" + "("+R2[2]+")" + Var[2] + " = " + R2[3]);
            System.out.println("  "+"("+R3[0]+")" + Var[0] + "+" + "("+R3[1]+")" + Var[1] + "+" + "("+R3[2]+")" + Var[2] + " = " + R3[3]);
            System.out.println("\n");

        }

        public static void Action_Three()
        {
            System.out.println("Jaunas sistemas 2. vien-mu izdala ar ši vien-ma nezinama " + Var[1] + " koeficientu.");
            
            System.out.println("  "+"("+R1[0]+")" + Var[0] + "+" + "("+R1[1]+")" + Var[1] + "+" + "("+R1[2]+")" + Var[2] + " = " + R1[3]);
            System.out.println("{ "+"("+R2[0]+")" + Var[0] + "+" + "("+R2[1]+")" + Var[1] + "+" + "("+R2[2]+")" + Var[2] + " = " + R2[3] + " | /(" + R2[1]+ ")");
            System.out.println("  "+"("+R3[0]+")" + Var[0] + "+" + "("+R3[1]+")" + Var[1] + "+" + "("+R3[2]+")" + Var[2] + " = " + R3[3]);
            System.out.println("\n");
            double tmp = R2[1];
            for(int i = 0; i<R2.length; i++)
            {
                R2[i] = R2[i] / tmp;
            }
            for (int i = 0; i < 4; i++) 
            {
                R2_BackupSave[i] = R2[i];
            }
            System.out.println("\n");
            System.out.println( "Pec dalisanas 2. vien-ms izkatas: \n"+"  "+"("+R2[0]+")" + Var[0] + "+" + "("+R2[1]+")" + Var[1] + "+" + "("+R2[2]+")" + Var[2] + " = " + R2[3]);
            System.out.println("\n");
            
        }

        public static void Action_Four()
        {
            System.out.println("Jaunas sistemas 2.vien-mu reizina ar 3.vien-ma koeficienta " + Var[1] + " pretejo skaitli un pieskaita 3.vien-mam.");
            
            System.out.println("  "+"("+R1[0]+")" + Var[0] + "+" + "("+R1[1]+")" + Var[1] + "+" + "("+R1[2]+")" + Var[2] + " = " + R1[3]);
            System.out.println("{ "+"("+R2[0]+")" + Var[0] + "+" + "("+R2[1]+")" + Var[1] + "+" + "("+R2[2]+")" + Var[2] + " = " + R2[3] + " | *(" + -R3[1]+ ")");
            System.out.println("  "+"("+R3[0]+")" + Var[0] + "+" + "("+R3[1]+")" + Var[1] + "+" + "("+R3[2]+")" + Var[2] + " = " + R3[3]);
            
            System.out.println("\n");

            for(int i = 0; i<R2.length; i++)
            {
                R2[i] *= -R3[1];
            }
            for(int i = 0; i<R2.length; i++)
            {
                R3[i] += R2[i];
            }
            for (int i = 0; i < 4; i++) 
            {
                R2[i] = R2_BackupSave[i];
            }
            System.out.println("\n");
            System.out.println("Jauna sistema:");
            System.out.println("  "+"("+R1[0]+")" + Var[0] + "+" + "("+R1[1]+")" + Var[1] + "+" + "("+R1[2]+")" + Var[2] + " = " + R1[3]);
            System.out.println("{ "+"("+R2[0]+")" + Var[0] + "+" + "("+R2[1]+")" + Var[1] + "+" + "("+R2[2]+")" + Var[2] + " = " + R2[3]);
            System.out.println("  "+"("+R3[0]+")" + Var[0] + "+" + "("+R3[1]+")" + Var[1] + "+" + "("+R3[2]+")" + Var[2] + " = " + R3[3]);
            System.out.println("\n");
            
        }

        public static void Action_Five_Checker()
        {
            if(R3[2] == 0 && R3[3] !=0){
                System.out.println("LVS Ir nesaderiga jo pedeja vien-ma koeficients ir 0,\nbet vienadojuma koeficient nav 0!!!");
                StopWorking = true;
            }

            else if(R3[2] == 0 && R1[3] != 0 && R2[3] != 0 && R3[3] == 0){
                System.out.println("LVS Ir bezgaligi daudz atrisinajumu jo pedeja vien-ma koeficients ir 0,\nun vienadojuma koeficient ari ir 0!!!");
                StopWorking = true;
            }

            else if(R3[2] != 0 && R1[3] == 0 && R2[3] == 0 && R3[3] == 0){
                System.out.println("LVS Ir tikai trivials atrisinajums, jo pedeja vienadojuma nezinama koeficients nav 0,\nbet LVS ir homogena!!!\n|ATBILDE: (0;0;0)|"); 
                StopWorking = true;
            }

            else if(R3[2] == 0 && R1[3] == 0 && R2[3] == 0 && R3[3] == 0){
                System.out.println("LVS Ir bezgaligi daudz atrisinajumu jo pedeja vien-ma koeficients ir 0,\nun LVS ir homogena!!!");
                StopWorking = true;
            }
        }

        public static void Action_Five()
        {
            System.out.println("Jaunas sistemas pedejo vien-mu izdala ar nezinama lieluma " + Var[2] + " koeficientu.");

            System.out.println("  "+"("+R1[0]+")" + Var[0] + "+" + "("+R1[1]+")" + Var[1] + "+" + "("+R1[2]+")" + Var[2] + " = " + R1[3]);
            System.out.println("{ "+"("+R2[0]+")" + Var[0] + "+" + "("+R2[1]+")" + Var[1] + "+" + "("+R2[2]+")" + Var[2] + " = " + R2[3]);
            System.out.println("  "+"("+R3[0]+")" + Var[0] + "+" + "("+R3[1]+")" + Var[1] + "+" + "("+R3[2]+")" + Var[2] + " = " + R3[3] +" | / (" + R3[2] + ")");
            System.out.println("\n");
            double tmp = R3[2];
            for(int i = 1; i < R3.length; i++)
            {
                R3[i] = R3[i] / tmp;
            }

            System.out.println( "Pec dalisanas 3. vien-ms izkatas: \n"+"  "+"("+R3[0]+")" + Var[0] + "+" + "("+R3[1]+")" + Var[1] + "+" + "("+R3[2]+")" + Var[2] + " = " + R3[3]);
            System.out.println("\n");
        }

        public static void Action_Six()
        {
            System.out.println("Jauna sistema:");
            System.out.println("  "+"("+R1[0]+")" + Var[0] + "+" + "("+R1[1]+")" + Var[1] + "+" + "("+R1[2]+")" + Var[2] + " = " + R1[3]);
            System.out.println("{ "+"("+R2[0]+")" + Var[0] + "+" + "("+R2[1]+")" + Var[1] + "+" + "("+R2[2]+")" + Var[2] + " = " + R2[3]);
            System.out.println("  "+"("+R3[0]+")" + Var[0] + "+" + "("+R3[1]+")" + Var[1] + "+" + "("+R3[2]+")" + Var[2] + " = " + R3[3]);
            System.out.println("\n");

            Var3_Answer = R3[3];
            
            Var2_Answer = R2[3] - (R2[2] * R3[3]);

            Var1_Answer = R1[3] - (R1[1] * Var2_Answer) - (R1[2] * R3[3]);
            System.out.println("Pedeja sistema tiek ieguts nezinamais " + Var[2] + " = " + Var3_Answer);
            System.out.println("Nezinama "+ Var[2] +" vertiba tiek ievietota 2.vien-ma un tiek ieguta nezinama "+ Var[1]+ " vertiba = " + Var2_Answer);
            System.out.println("Pec tam atrastas "+ Var[2] +" un "+ Var[1] +" vertibas ievieto 1.vien-ma un atrod " + Var[0] + " = " + Var1_Answer);
        }

        public static void Action_Check()
        {
            R1 = R1_OriginalSave;
            R2 = R2_OriginalSave;
            R3 = R3_OriginalSave;

            System.out.println("\n");
            System.out.println("Parbaude: \n");

            System.out.println("(" + R1[0] + ") * (" + Var1_Answer + ") + (" + R1[1] + ") * (" + Var2_Answer + ") + (" + R1[2] + ") * (" + Var3_Answer + ") = " + R1[3]);
            System.out.println("(" + R2[0] + ") * (" + Var1_Answer + ") + (" + R2[1] + ") * (" + Var2_Answer + ") + (" + R2[2] + ") * (" + Var3_Answer + ") = " + R2[3]);
            System.out.println("(" + R3[0] + ") * (" + Var1_Answer + ") + (" + R3[1] + ") * (" + Var2_Answer + ") + (" + R3[2] + ") * (" + Var3_Answer + ") = " + R3[3]);
            
            System.out.println("\n");

            Result_R1 = R1[0] * Var1_Answer + R1[1] * Var2_Answer + R1[2] * Var3_Answer;
            Result_R2 = R2[0] * Var1_Answer + R2[1] * Var2_Answer + R2[2] * Var3_Answer;
            Result_R3 = R3[0] * Var1_Answer + R3[1] * Var2_Answer + R3[2] * Var3_Answer;

            double scale1 = Math.pow(10, 2);
            double scale2 = Math.pow(10, 4);

            double RoundedResult_R1 = Math.ceil(Result_R1 * scale1) / scale1;
            double RoundedResult_R2 = Math.ceil(Result_R2 * scale1) / scale1;
            double RoundedResult_R3 = Math.ceil(Result_R3 * scale1) / scale1;

            double RoundedVar1_Answer = Math.ceil(Var1_Answer * scale2) / scale2;
            double RoundedVar2_Answer = Math.ceil(Var2_Answer * scale2) / scale2;
            double RoundedVar3_Answer = Math.ceil(Var3_Answer * scale2) / scale2;

            if (R1[3] == RoundedResult_R1 && R2[3] == RoundedResult_R2 && R3[3] == RoundedResult_R3){
                System.out.println("LVS ir atrisinata pareizi, parbaude izpildita sekmigi!!!");
                System.out.println(RoundedResult_R1 + " = " + R1[3] +"\n" + RoundedResult_R2 + " = " + R2[3] + "\n" + RoundedResult_R3 + " = " + R3[3]);
                System.out.println("Atbilde: (" + RoundedVar1_Answer + "; " + RoundedVar2_Answer + "; " + RoundedVar3_Answer + ")");
            }
            else{
                System.out.println("LVS ir atrisinata nepareizi, parbaude iziplidita nevejksmigi :(");
                System.out.println(Result_R1 + " = " + R1[3] +"\n" + Result_R2 + " = " + R2[3] + "\n" + Result_R3 + " = " + R3[3]);
            }
        }

    public static void main(String[] args){
        try{
        System.out.println("Ievadiet 1 lai ievaditu jusu datus LVS risinasanai | Ievadiet 2 lai paskatitu XXIX varianta LVS risinašanu");
        int workingScenario = input.nextInt();
        
        if(workingScenario == 1){
            System.out.println("Ievadiet 1 lai nezinamas nosaukumi butu X, Y un Z | Ievadiet 2 lai nezinamas nosaukumi butu X1, X2 un X3");
            int varName = input.nextInt();
            System.out.println("SVARIGI! Ievadiet decimaldalas ka ir paradits piemera!\nPiemers: 1,06 (izmantojiet komatu nevis punktu!!!)");

            if(varName == 1){
                XYZ_Var_Name();
            }
            else if(varName == 2){
                X1X2X3_Var_Name();
            }
            else{
                System.out.println("Ievadiet tikai 1 vai 2!!!");
                return;
            }

            System.out.println("Ievadiet 1. vienadojuma " + Var[0] + " mainiga koefficientu:");
            if (input.hasNextDouble()) {
            R1[0] = input.nextDouble();
            System.out.println("Ievadiet 1. vienadojuma " + Var[1] + " mainiga koefficientu:");
            R1[1] = input.nextDouble();
            System.out.println("Ievadiet 1. vienadojuma " + Var[2] + " mainiga koefficientu:");
            R1[2] = input.nextDouble();
            System.out.println("Ievadiet 1. vienadojuma atbildi:");
            R1[3] = input.nextDouble();

            System.out.println("Ievadiet 2. vienadojuma " + Var[0] + " mainiga koefficientu:");
            R2[0] = input.nextDouble();
            System.out.println("Ievadiet 2. vienadojuma " + Var[1] + " mainiga koefficientu:");
            R2[1] = input.nextDouble();
            System.out.println("Ievadiet 2. vienadojuma " + Var[2] + " mainiga koefficientu:");
            R2[2] = input.nextDouble();
            System.out.println("Ievadiet 2. vienadojuma atbildi:");
            R2[3] = input.nextDouble();

            System.out.println("Ievadiet 3. vienadojuma " + Var[0] + " mainiga koefficientu:");
            R3[0] = input.nextDouble();
            System.out.println("Ievadiet 3. vienadojuma " + Var[1] + " mainiga koefficientu:");
            R3[1] = input.nextDouble();
            System.out.println("Ievadiet 3. vienadojuma " + Var[2] + " mainiga koefficientu:");
            R3[2] = input.nextDouble();
            System.out.println("Ievadiet 3. vienadojuma atbildi:");
            R3[3] = input.nextDouble();
            }
            else {
                System.out.println("No input found. Please try again.");
                return;
            }

            input.close();
            OriginalSave();

            System.out.println("  "+"("+R1[0]+")" + Var[0] + "+" + "("+R1[1]+")" + Var[1] + "+" + "("+R1[2]+")" + Var[2] + " = " + R1[3]);
            System.out.println("{ "+"("+R2[0]+")" + Var[0] + "+" + "("+R2[1]+")" + Var[1] + "+" + "("+R2[2]+")" + Var[2] + " = " + R2[3]);
            System.out.println("  "+"("+R3[0]+")" + Var[0] + "+" + "("+R3[1]+")" + Var[1] + "+" + "("+R3[2]+")" + Var[2] + " = " + R3[3]);

                Action_One();
                Action_Two();
                Action_Three();
                Action_Four();
                Action_Five_Checker();
                if(StopWorking == true){
                    return;
                }
                else{
                Action_Five();
                Action_Six();
                Action_Check();
            
                return; 
         }
        }   

        else if(workingScenario == 2){
            Default();
            OriginalSave();
            X1X2X3_Var_Name();

            System.out.println("  "+"("+R1[0]+")" + Var[0] + "+" + "("+R1[1]+")" + Var[1] + "+" + "("+R1[2]+")" + Var[2] + " = " + R1[3]);
            System.out.println("{ "+"("+R2[0]+")" + Var[0] + "+" + "("+R2[1]+")" + Var[1] + "+" + "("+R2[2]+")" + Var[2] + " = " + R2[3]);
            System.out.println("  "+"("+R3[0]+")" + Var[0] + "+" + "("+R3[1]+")" + Var[1] + "+" + "("+R3[2]+")" + Var[2] + " = " + R3[3]);

                Action_One();
                Action_Two();
                Action_Three();
                Action_Four();
                Action_Five_Checker();
                if(StopWorking == true){
                    return;
                }
                else{
                Action_Five();
                Action_Six();
                Action_Check();
            
            return;
            }    
        }
        else{
            System.out.println("Ievadiet tikai 1 vai 2!!!");
            return;
        }
    }
    catch(InputMismatchException e){
        System.out.println("Ievadiet tikai skaitlus !!!");
    }
    }
}