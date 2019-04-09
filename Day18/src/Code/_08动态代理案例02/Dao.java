package Code._08动态代理案例02;

public interface Dao<T> {
    public void save(T t);
    public void delete(int id);
    public void update(T t);
    public T find(int id);

}
