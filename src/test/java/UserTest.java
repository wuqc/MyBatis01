import model.Person;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import utils.MybatisUtil;

public class UserTest {
    SqlSession sqlSession ;
    @Test
    public void insertPerson(){
        sqlSession = MybatisUtil.getSqlSession();
        int id = 10001;
        String userName = "test1";
        int age = 12;
        String mobilePhone = "28000000000";
        Person person = new Person();
        person.setId(id);
        person.setAge(age);
        person.setUserName(userName);
        person.setMobilePhone(mobilePhone);
        try{
            sqlSession.insert("insertPerson",person);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MybatisUtil.closeSession(sqlSession);
        }

    }

    @Test
    public void queryById(){
        sqlSession = MybatisUtil.getSqlSession();
        int id = 1;
        try{
            Person person = sqlSession.selectOne("queryById",id);

            sqlSession.commit();
            System.out.println(person.getUserName());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MybatisUtil.closeSession(sqlSession);
        }

    }
}
