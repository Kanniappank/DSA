public class DataBaseExecuterProxy implements IExecuter {

    boolean isAdmin;
    DataBaseExecuter executer;

    public DataBaseExecuterProxy(String name, String password){
        if("Admin".equals(name) && "Admin@123".equals(password)){
            isAdmin=true;
        }
        executer=new DataBaseExecuter();
    }

    @Override
    public void executeQuery(String query) throws Exception {

        if(isAdmin){
            executer.executeQuery(query);
        }
        else{
            if(query.equals("DELETE")){
                throw new Exception("Admins only have delete access");
            }
            else{
                executer.executeQuery(query);
            }
        }
     
    }  
}
