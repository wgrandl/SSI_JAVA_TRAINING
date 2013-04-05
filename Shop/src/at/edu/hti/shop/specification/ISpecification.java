package at.edu.hti.shop.specification;

public interface ISpecification<T> {

    boolean IsSatisfiedBy(T candidate);
    ISpecification<T> And(ISpecification<T> other);
    ISpecification<T> Or(ISpecification<T> other);
    ISpecification<T> Not();
}
