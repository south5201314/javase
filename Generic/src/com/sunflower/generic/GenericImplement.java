package com.sunflower.generic;

public class GenericImplement<T,E,V> implements CustomGenericInterface<T,E>{
    private T t;
    private E e;
    private V v;
   public GenericImplement(){ }
   public GenericImplement(T t,E e,V v){
       this.t = t;
       this.e = e;
       this.v = v;
   }
    @Override
    public T getT() {
        return this.t;
    }

    @Override
    public E getE() {
        return this.e;
    }
    public static <G extends CustomGenericInterface> String show(G g){
       return g.getT()+" "+g.getE();
    }

    @Override
    public String toString() {
        return "GenericImplement{" +
                "t=" + t +
                ", e=" + e +
                ", v=" + v +
                '}';
    }
}
