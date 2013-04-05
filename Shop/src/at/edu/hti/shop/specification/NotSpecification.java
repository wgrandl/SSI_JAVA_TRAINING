package at.edu.hti.shop.specification;

public class NotSpecification<T> extends CompositeSpecification<T> {
    private ISpecification<T> Wrapped;
    
    public NotSpecification(ISpecification<T> x) 
    {
        Wrapped = x;
    }

    public boolean IsSatisfiedBy(T candidate) 
    {
        return !Wrapped.IsSatisfiedBy(candidate);
    }
}
