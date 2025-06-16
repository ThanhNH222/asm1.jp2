package dao;

import database.Connector;
import entity.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class StudentDAOImpl implements RepositoryDAO<Student,Integer> {
    private String table = "students";
    @Override
    public ArrayList<Student> all() {
        ArrayList<Student> list = new ArrayList<>();
        try {
            Connector connector = Connector.getInstance();
            Statement statement = connector.createStatement();
            String sql = "select * from "+table;
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()){
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                String telephone = rs.getString("telephone");
                Integer age = rs.getInt("age");
                Student s = new Student(id,name,age,telephone);
                list.add(s);
            }
        }catch (Exception e){
        }
        return list;
    }

    @Override
    public Student findById(Integer id) {
        try {
            Connector connector = Connector.getInstance();
            Statement statement = connector.createStatement();
            String sql = "select * from "+table+" where id="+id;
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                return new Student(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("telephone")
                );
            }
        }catch (Exception e){
        }
        return null;
    }

    @Override
    public Boolean create(Student s) {
        try {
            Connector connector = Connector.getInstance();
            String sql = "insert into students(name,age,telephone) values(?,?,?)";
            PreparedStatement pstm = connector.preparedStatement(sql);
            pstm.setString(1,s.getName());
            pstm.setInt(2,s.getAge());
            pstm.setString(3,s.getTelephone());
            return pstm.executeUpdate() > 0;
        }catch (Exception e){

        }
        return false;
    }

    @Override
    public Boolean update(Student s) {
        try {
            Connector connector = Connector.getInstance();
            String sql = "update students set name = ?, age = ?, telephone = ? where id = ?";
            PreparedStatement pstm = connector.preparedStatement(sql);
            pstm.setString(1, s.getName());
            pstm.setInt(2, s.getAge());
            pstm.setString(3, s.getTelephone());
            pstm.setInt(4, s.getId());
            return pstm.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean delete(Integer id) {
        try {
            Connector connector = Connector.getInstance();
            String sql = "delete from students where id = ?";
            PreparedStatement pstm = connector.preparedStatement(sql);
            pstm.setInt(1, id);
            return pstm.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}