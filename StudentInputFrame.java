import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentInputFrame extends JFrame
        implements ActionListener {

    JLabel titleLabel;

    JLabel nameLabel;
    JLabel idLabel;
    JLabel maxLabel;

    JTextField nameField;
    JTextField idField;
    JTextField maxField;

    JButton addButton;

    Container contentPane;

    University uni;

    public StudentInputFrame(University uni) {

        this.uni = uni;

        contentPane = getContentPane();
        contentPane.setLayout(null);

        setTitle("University Registration System");
        setSize(500,350);
        setLocation(300,200);
        setResizable(false);

        titleLabel =
                new JLabel("Student Registration");

        titleLabel.setFont(new Font("Arial",1,24));

        titleLabel.setBounds(110,20,300,40);

        contentPane.add(titleLabel);

        nameLabel = new JLabel("Student Name:");

        nameLabel.setBounds(50,90,120,30);

        contentPane.add(nameLabel);

        nameField = new JTextField();

        nameField.setBounds(180,90,200,30);

        contentPane.add(nameField);

        idLabel =new JLabel("Student ID:");


        idLabel.setBounds(50,140,120,30);

        contentPane.add(idLabel);

        idField = new JTextField();

        idField.setBounds(180,140,200,30);

        contentPane.add(idField);

        maxLabel = new JLabel("Max Courses:");


        maxLabel.setBounds(50,190,120,30);

        contentPane.add(maxLabel);

        maxField = new JTextField();

        maxField.setBounds(180,190,200,30);

        contentPane.add(maxField);

        addButton = new JButton("Add Student");

        addButton.setBounds(150,250,170,40);

        addButton.setBackground(new Color(57,130,184));

        addButton.setForeground(Color.WHITE);

        addButton.setFont(new Font("Arial",1,15));


        contentPane.add(addButton);

        addButton.addActionListener(this);

    }

    public void actionPerformed(ActionEvent event) {

        if(event.getSource().equals(addButton)) {

            try {

                String name = nameField.getText();

                String id =  idField.getText();

                int maxCourses = Integer.parseInt(maxField.getText());

                if(maxCourses > 6 || maxCourses <= 0) {

                    JOptionPane.showMessageDialog(this,"Max courses must be between 1 and 6");

                    return;
                }

                if(id.length() != 9) {

                    throw new InvalidStudentIDException("ID must be 9 digits");




                }

                Student s = new Student(name,id,maxCourses);


                               

                uni.addStudent(s);

                JOptionPane.showMessageDialog(this,"Student added successfully");
                        
                nameField.setText("");
                idField.setText("");
                maxField.setText("");

            }

            catch(InvalidStudentIDException e) {

                JOptionPane.showMessageDialog(this,e.getMessage());

                        
            }

            catch(UniversityFullException e) {

                JOptionPane.showMessageDialog(this,e.getMessage());
                       

            }

            catch(NumberFormatException e) {

                JOptionPane.showMessageDialog(this,"Enter valid number");

                      
            }

        }

    }

}