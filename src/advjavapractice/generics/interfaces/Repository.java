package advjavapractice.generics.interfaces;
//CRUD methodlari olan generic bir interface tanimlayiniz
public interface Repository<T> {

    void add(T t);
    void get(T t);
    void update(T t);
    void delete(T t);
}
