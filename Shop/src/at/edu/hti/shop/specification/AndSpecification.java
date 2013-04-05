package at.edu.hti.shop.specification;

public class AndSpecification<T> extends CompositeSpecification<T> {
    private ISpecification<T> One;
    private ISpecification<T> Other;

    public AndSpecification(ISpecification<T> x, ISpecification<T> y) 
    {
        One = x;
        Other = y;
    }

    public boolean IsSatisfiedBy(T candidate) 
    {
        return One.IsSatisfiedBy(candidate) && Other.IsSatisfiedBy(candidate);
    } //X 
}
