import javafx.application.Application;  
import javafx.event.* ;
import javafx.scene.*;
import javafx.geometry.*;
import javafx.scene.control.*;  
import javafx.scene.layout.*;  
import javafx.stage.Stage;   
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;  
import javafx.scene.control.Alert.AlertType; 
import java.util.*;
import java.io.*;
import java.io.IOException;
public class LabelTest extends Application {  
    static int cur=0;
    static int i=0;
    static ArrayList<HBox> temp=new ArrayList<HBox>();
    static ArrayList<Button> b1=new ArrayList<Button>();
    static ArrayList<String> list =new ArrayList<String>();
    public void start(Stage primaryStage) throws Exception {
        FileReader fr=new FileReader("filename.txt");   
          //int i;    
          String str="";
          while((i=fr.read())!=-1)
          {
            //System.out.println((char)i);
            char temp= (char)i;
          if(temp==' ')
          {
              //System.out.println(str);
              list.add(str);
              //cur++;
              str="";
          }
          else
          {  
            str+=String.valueOf((char)i);
          }
          }    
          fr.close();
        for(int i=0;i<list.size();i++)
          {
              System.out.println(list.get(i));
          }    
        Label my_label=new Label("List Of Task");
        Label task_label=new Label("task");
        TextField tf1=new TextField(); 
        tf1.setPrefWidth(100);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        Label task_date=new Label("date and time");
        TextField tf2=new TextField(dtf.format(now)); 
        tf2.setPrefWidth(100);
        tf1.setPrefWidth(100);
        Button b=new Button("ADD") ;
        task_label.setStyle("-fx-text-fill: BLACK; -fx-font-size: 22;");
        task_date.setStyle("-fx-text-fill: BLACK; -fx-font-size: 22;");
        my_label.setStyle("-fx-text-fill: RED; -fx-font-size: 20;"+"-fx-font-weight: bold");
        VBox root1=new VBox();
        HBox root = new HBox();
        HBox foot=new HBox();
        VBox task=new VBox();
        HBox head=new HBox();
        Label l1=new Label("Task");
        Label l2=new Label("Item");
        l1.setStyle("-fx-text-fill: black; -fx-font-size: 15;"+"-fx-font-weight: bold");
        l2.setStyle("-fx-text-fill: black; -fx-font-size: 15;"+"-fx-font-weight: bold");
        head.getChildren().addAll(l1,l2);
        task.getChildren().add(head);
        head.setSpacing(60);
        task.setSpacing(3.5);
        int t=0;
          while(t<list.size())
          {
            temp.add(new HBox()); 
            //System.out.println(temp.size());

            Label l11=new Label(list.get(t));
            b1.add(new Button("remove"));
            Label l12=new Label(list.get((t+1)));
            temp.get(cur).setSpacing(60);
            l11.setStyle("-fx-text-fill: black; -fx-font-size: 15;");
            l12.setStyle("-fx-text-fill: black; -fx-font-size: 15;");
            temp.get(cur).setStyle("-fx-border-style: solid;"+"-fx-margin-top: 2px"
            + "-fx-border-width: 1;");
            //temp.add(temp.get(cur));
            System.out.println(b1.get(cur) instanceof Button);
            temp.get(cur).getChildren().addAll(l11,l12,b1.get(cur)) ; 
            task.getChildren().add(temp.get(cur));
            cur++;
            t=t+2;
            for(int j=0; j<b1.size(); j++) {

                final Button myButton = b1.get(j);
                final HBox hi=temp.get(j);
                myButton.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent event) {
                        //System.out.println(hi);
                        for(int k=0; k<b1.size(); k++) {
                        if(event.getSource()==b1.get(k))
                        {
                            b1.remove(k);
                            temp.remove(k);
                            if(k==0)
                            {
                                list.remove(k);
                                list.remove(k);
                            }
                            else
                            {
                                int index=k*2;
                                list.remove(index);
                                list.remove(index);
                                System.out.println("the list ");
                                for(int o=0;o<list.size();o++)
                                {
                                    System.out.println(list.get(o));
                                }
                            }
                        }
                    }
                        task.getChildren().remove(hi);
                        cur--;
                    }
                });
            }
          } 
        b.setOnAction(new EventHandler<ActionEvent>() {  
            
            public void handle(ActionEvent event) {
                if(tf1.getText().equals("") || tf2.getText().equals(""))
                {

                }   
                else
                { 
            try{
                System.out.println("value of cur"+cur);
                temp.add(new HBox()); 
                System.out.println(temp.size());
                Label l1=new Label(tf1.getText());
                list.add(tf1.getText());
                list.add(tf2.getText());
                b1.add(new Button("remove"));
                Label l2=new Label(tf2.getText());
                temp.get(cur).setSpacing(60);
                l1.setStyle("-fx-text-fill: black; -fx-font-size: 15;");
                l2.setStyle("-fx-text-fill: black; -fx-font-size: 15;");
                temp.get(cur).setStyle("-fx-border-style: solid;"+"-fx-margin-top: 2px"
                + "-fx-border-width: 1;");
                //temp.add(temp.get(cur));
                System.out.println(b1.get(cur) instanceof Button);
                temp.get(cur).getChildren().addAll(l1,l2,b1.get(cur)) ; 
                task.getChildren().add(temp.get(cur));
                final Button myButton = b1.get(cur);
                final HBox hi=temp.get(cur);
                myButton.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent event) {
                        //System.out.println(hi);
                        for(int k=0; k<b1.size(); k++) {
                        if(event.getSource()==b1.get(k))
                        {
                            b1.remove(k);
                            temp.remove(k);
                            if(k==0)
                            {
                                list.remove(k);
                                list.remove(k);
                            }
                            else
                            {
                                int index=k*2;
                                list.remove(index);
                                list.remove(index);
                                System.out.println("the list ");
                                for(int o=0;o<list.size();o++)
                                {
                                    System.out.println(list.get(o));
                                }
                            }
                        }
                    }
                        task.getChildren().remove(hi);
                        cur--;
                    }
                });
                cur++;
                System.out.println("hello");
                for(String str: list)
                {
                    System.out.print(str+" ");
                }  
                System.out.println();
                }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
            }  
        } );
          
        foot.setPrefHeight(60);
        foot.setSpacing(10);
        root1.setSpacing(4);
        task.setPrefHeight(390);
        task.setStyle("-fx-border-style: solid;"+"-fx-margin-top: 10px"
                + "-fx-border-width: 1;"+"-fx-background-color: white;");   
        
        root.setAlignment(Pos.CENTER);
        root.setPrefHeight(55);
        foot.setStyle("-fx-border-style: solid;"
                + "-fx-border-width: 0.5;"+"-fx-background-color: white;"); 
                root.setStyle("-fx-border-style: solid;"
                + "-fx-border-width: 0.5;"+"-fx-background-color: white;");   
        //root.setCenter(my_label);
        Scene scene=new Scene(root1,600,500);  
        root.getChildren().add(my_label);
        foot.getChildren().addAll(task_label,tf1,task_date,tf2,b);
        root1.getChildren().addAll(root,task,foot);  
        primaryStage.setScene(scene);  
        primaryStage.setTitle("To DO List");  
        primaryStage.show();  
          
    }  
    public void stop(){
        try {
            String ans="";
            FileWriter myWriter = new FileWriter("filename.txt");
            //int count=0;
            for(int i=0;i<list.size();i++)
            {
                ans+=list.get(i);
                ans+=" ";
                //count++;
            }
            System.out.println("the answer is "+ans);
            myWriter.write(ans);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }
    public static void main(String[] args) {  
        launch(args);  
    }  
}  