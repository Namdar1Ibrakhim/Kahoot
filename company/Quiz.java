package com.company;

import java.io.File;
import java.net.SocketOption;
import java.util.*;

public class Quiz {
    private String name;
    private final static List<Question> question = new ArrayList<>();

    public Quiz() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addQuestion(Question q) {
        question.add(q);

    }

    public Quiz loadFromFile(String f) throws InvalidQuizFormatException, Exception{
        List<String> ques = new ArrayList<>();
        Quiz quiz = new Quiz();

        try {
            if(f==null || f=="")throw new InvalidQuizFormatException();
            File aqw = new File(f);
            if(!aqw.isFile())throw new InvalidQuizFormatException();
            setName(aqw.getName());
            Scanner in = new Scanner(aqw);
            String pr = "";

            if(!in.hasNextLine())throw new InvalidQuizFormatException();

            while (in.hasNextLine()) {
                String dd = in.nextLine();
                pr += (dd + "\n");
            }
            in.close();
            if(pr==""||pr==null)throw new InvalidQuizFormatException();

            ques = Arrays.asList(pr.split("\n\n"));
            Collections.shuffle(ques);



            for (int i = 0; i < ques.size(); i++) {
                String[] qe = ques.get(i).split("\n");

                if (qe[0].contains("{blank}")) {
                    Fillin fill = new Fillin();
                    fill.setDescription(qe[0]);
                    fill.setAnswer(qe[1]);
                    quiz.addQuestion(fill);

                } else {
                    Test test = new Test(qe.length - 1);

                    test.setDescription(qe[0]);
                    test.setAnswer(qe[1]);

                    String yy = "";
                    for (int j = 1; j < qe.length; j++) {
                        yy += qe[j] + "\n";
                    }
                    String[] op = yy.split("\n");
                    test.setOptions(op);
                    quiz.addQuestion(test);
                }
            }

        }catch(InvalidQuizFormatException e){
            System.out.println("Error");
        }
        return quiz;
    }

    public String toString() {
        if (question.size() != 0) {
            String quizname = "";
            quizname = getName();
            quizname = quizname.replace(".txt", "");
            return quizname;
        } else {
            return null;
        }
    }

    public void start() throws Exception {
        Scanner s = new Scanner(System.in);

        int point =0;
        for (int i = 0; i < question.size(); i++) {
            String otv = question.get(i).getDescription();

            if (otv.contains("{blank}")) {
               Fillin fillin = (Fillin)question.get(i);
               System.out.println(i+1 +". " + fillin.toString()+"\n");
               System.out.print("Type your answer: ");
                 while (true) {
                   try {
                       String ot = s.next();
                       if (ot.equals(fillin.getAnswer())){
                           System.out.println("Correct\n");
                           point++;
                       }else{
                           System.out.println("Incorrect\n");
                       }
                       break;
                   }catch (Exception e){
                       System.out.print("Type your answer. Try again: ");
                   }
                 }

            } else {
                Test test = (Test) question.get(i);
                System.out.println(i+1 +". " + test.toString());

                System.out.print("Enter the correct choice: ");
                while (true) {
                    try {
                        char usan = s.next().charAt(0);
                        int ind = (usan - 'A');
                        if (test.getOptionAt(ind).equals(test.getAnswer())) {
                            System.out.println("Correct\n");
                            point++;
                        } else {
                            System.out.println("Incorrect\n");
                        }
                        break;
                    } catch (Exception e) {
                        System.out.print("Invalid choice Try again: (Ex A, B, ...): ");
                    }
                }
            }
        }
            System.out.println("Correct answer: " + point +"/" + question.size() + " ("+ ((double)point/(double)question.size()*100)+ "%)");
        }
}



















