

class DataBaseExecuter implements IExecuter{

    @Override
    public void executeQuery(String query) {
        System.out.println("Query is getting executed "+query);
    }
}