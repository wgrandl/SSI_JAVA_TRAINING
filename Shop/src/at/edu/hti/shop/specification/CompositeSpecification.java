package at.edu.hti.shop.specification;

public abstract class CompositeSpecification<T> implements ISpecification<T>  {
	
    public abstract boolean IsSatisfiedBy(T candidate);
    
    public ISpecification<T> And(ISpecification<T> T) 
    {
        return new AndSpecification<T>(this, T);
    }

    public ISpecification<T> Or(ISpecification<T> T) 
    {
        return new OrSpecification<T>(this, T);
    }

    public ISpecification<T> Not() 
    {
       return new NotSpecification<T>(this);
    }
}
